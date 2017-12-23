/*
 * Create by BobEve on 17-12-19 上午10:49
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午10:49
 */

package bob.eve.walle.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import bob.eve.comm.lib.layout.state.StateLayout;
import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.walle.R;
import bob.eve.walle.app.EveDiBaseFragment;
import bob.eve.walle.app.Navigation;
import bob.eve.walle.di.component.FragmentComponent;
import bob.eve.walle.mvp.contract.MovieFromDoubanTop250Contract;
import bob.eve.walle.mvp.model.bean.douban.MovieSubject;
import bob.eve.walle.mvp.presenter.MovieFromDoubanTop250Presenter;
import bob.eve.walle.ui.adapter.MovieDoubanAdapter;
import butterknife.BindView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ramotion.foldingcell.FoldingCell;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import java.util.List;

import static bob.eve.walle.ui.fragment.tab.MovieTabFragment.MOVIE_TYPE_KEY;

/**
 * Created by Bob on 17/12/19.
 */

@PreFragment
public class MovieFromDoubanTop250Fragment extends EveDiBaseFragment<MovieFromDoubanTop250Presenter>
		implements MovieFromDoubanTop250Contract.View, OnRefreshListener, OnRefreshLoadmoreListener,
							 BaseQuickAdapter.OnItemClickListener {
	public static final int WITH_IMAGE = 1;
	public static final int WITHOUT_IMAGE = 2;
	public static final int WITH_GIRL = 3;

	@BindView(R.id.refreshLayout)
	SmartRefreshLayout refreshLayout;
	@BindView(R.id.recyclerView)
	RecyclerView recyclerView;
	@BindView(R.id.stateLayout)
	StateLayout stateLayout;
	private String type;
	private MovieDoubanAdapter movieDoubanAdapter;

	public static MovieFromDoubanTop250Fragment newInstance(String type) {
		Bundle args = new Bundle();
		args.putString(MOVIE_TYPE_KEY, type);
		MovieFromDoubanTop250Fragment fragment = new MovieFromDoubanTop250Fragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int layoutResID() {
		return R.layout.fragment_common_recycler_layout;
	}

	@Override
	public void attachView() {
		mPresenter.attach(this);
	}

	@Override
	public void initView(View view) {
		refreshLayout.setRefreshHeader(
				new ClassicsHeader(mContext).setSpinnerStyle(SpinnerStyle.Translate)
																		.setPrimaryColorId(R.color.backgroundColor)
																		.setAccentColorId(R.color.textColorSecondary));
		refreshLayout.setOnRefreshLoadmoreListener(this);

		movieDoubanAdapter = new MovieDoubanAdapter(this, R.layout.item_movie_douban_layout);
		movieDoubanAdapter.openLoadAnimation();
		movieDoubanAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
		movieDoubanAdapter.setOnItemClickListener(this);
		movieDoubanAdapter.isUseEmpty(false);
		final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(linearLayoutManager);
		recyclerView.setAdapter(movieDoubanAdapter);
	}

	@Override
	public void initLazyView(View view) {
		Bundle bundle = getArguments();
		if (bundle != null) {
			type = bundle.getString(MOVIE_TYPE_KEY);
		}

		stateLayout.showLoading();
		mPresenter.getMovies();
	}

	@Override
	public void showMovies(List<MovieSubject> items) {
		if (items.size() <= 0) {
			stateLayout.showEmpty();
		} else {
			stateLayout.showContent();
		}
		movieDoubanAdapter.setNewData(items);
	}

	@Override
	public void showMoreMovies(List<MovieSubject> items) {
		movieDoubanAdapter.addData(items);
	}

	@Override
	public void start() {
	}

	@Override
	public void complete() {
		refreshLayout.finishRefresh();
		refreshLayout.finishLoadmore();
	}

	@Override
	public void error(Throwable error) {
		if (movieDoubanAdapter.getData()
													.size() <= 0) {
			stateLayout.showError();
		} else {
			stateLayout.showContent();
		}

		refreshLayout.finishRefresh();
		refreshLayout.finishLoadmore();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		movieDoubanAdapter.clearRegisterToggle();
	}

	@Override
	protected void inject(FragmentComponent fragmentComponent) {
		fragmentComponent.inject(this);
	}

	@Override
	public void onRefresh(RefreshLayout refreshlayout) {
		mPresenter.getMovies();
	}

	@Override
	public void onLoadmore(RefreshLayout refreshlayout) {
		mPresenter.getMoreMovies();
	}

	@Override
	public void onItemClick(final BaseQuickAdapter adapter, final View view, final int position) {
		FoldingCell cell = view.findViewById(R.id.folding_cell);
		cell.toggle(false);
		movieDoubanAdapter.registerToggle(position);

		if (cell.isUnfolded()) {
			MovieSubject item = (MovieSubject) adapter.getItem(position);
			Navigation.Builder builder = new Navigation.Builder().setAnimConfig(getActivity(), view)
																													 .setId(item.getId())
																													 .setContext(mContext)
																													 .setTitle(item.getTitle())
																													 .setUrl(item.getAlt())
																													 .setCategorye(
																															 item.getSubtype() + "from_douban")
																													 .builder();
			Navigation.NavToTencentWeb(builder);
		}
	}
}
