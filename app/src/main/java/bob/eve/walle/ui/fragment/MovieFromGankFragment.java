/*
 * Create by BobEve on 17-12-19 上午10:50
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午10:50
 */

package bob.eve.walle.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bob.eve.comm.lib.layout.state.StateLayout;
import bob.eve.comm.lib.util.DeviceUtils;
import bob.eve.walle.R;
import bob.eve.walle.app.EveDiBaseFragment;
import bob.eve.walle.app.Navigation;
import bob.eve.walle.di.component.FragmentComponent;
import bob.eve.walle.mvp.contract.MovieFromGankContract;
import bob.eve.walle.mvp.model.bean.gank.GankItem;
import bob.eve.walle.mvp.presenter.MovieFromGankPresenter;
import bob.eve.walle.ui.adapter.MovieGankAdapter;
import bob.eve.walle.ui.widget.imageloader.GlideImageLoader;
import butterknife.BindView;
import com.chad.library.adapter.base.BaseQuickAdapter;
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

public class MovieFromGankFragment extends EveDiBaseFragment<MovieFromGankPresenter>
		implements MovieFromGankContract.View, OnRefreshListener, OnRefreshLoadmoreListener,
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
	@BindView(R.id.mg_image)
	ImageView image;
	@BindView(R.id.mg_user)
	TextView user;
	@BindView(R.id.mg_appbar)
	AppBarLayout appbar;

	private String category;

	private MovieGankAdapter adapter;

	public static MovieFromGankFragment newInstance(String type) {
		Bundle args = new Bundle();
		args.putString(MOVIE_TYPE_KEY, type);
		MovieFromGankFragment fragment = new MovieFromGankFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int layoutResID() {
		return R.layout.fragment_movie_gank_layout;
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

		adapter = new MovieGankAdapter(this, R.layout.item_movie_gank_image_layout);
		adapter.openLoadAnimation();
		adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
		adapter.setOnItemClickListener(this);
		adapter.isUseEmpty(false);
		final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(linearLayoutManager);
		recyclerView.setAdapter(adapter);

		initAppbarWithRefresh();
	}

	private void initAppbarWithRefresh() {
		final int topbarHeight = DeviceUtils.dp2px(mContext, 256);
		appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
			@Override
			public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
				if (verticalOffset >= 0) {
					refreshLayout.setEnabled(true);
				} else {
					refreshLayout.setEnabled(false);
				}
				float rate = (float) (topbarHeight + verticalOffset) / topbarHeight;
				if (rate < 0) {
					rate = 0;
				}
				if (rate > 1) {
					rate = 1;
				}
				image.setAlpha(rate);
			}
		});
	}

	@Override
	public void initLazyView(View view) {
		Bundle bundle = getArguments();
		if (bundle != null) {
			category = bundle.getString(MOVIE_TYPE_KEY);
		}

		stateLayout.showLoading();
		mPresenter.getMovies(category);
		mPresenter.getTopGirl();
	}

	@Override
	public void showMovies(List<GankItem> items) {
		if (items.size() <= 0) {
			stateLayout.showEmpty();
		} else {
			stateLayout.showContent();
		}

		adapter.setNewData(items);
	}

	@Override
	public void showMoreMovies(List<GankItem> items) {
		adapter.addData(items);
	}

	@Override
	public void showTopGirl(GankItem girl) {
		GlideImageLoader.getInstance()
										.displayImageWithoutPlace(this, girl.getUrl(), image);
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
		if (adapter.getData()
							 .size() <= 0) {
			stateLayout.showError();
		} else {
			stateLayout.showContent();
		}

		refreshLayout.finishRefresh();
		refreshLayout.finishLoadmore();
	}

	@Override
	protected void inject(FragmentComponent fragmentComponent) {
		fragmentComponent.inject(this);
	}

	@Override
	public void onRefresh(RefreshLayout refreshlayout) {
		mPresenter.getMovies(category);
	}

	@Override
	public void onLoadmore(RefreshLayout refreshlayout) {
		mPresenter.getMoreMovies(category);
	}

	@Override
	public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
		GankItem item = (GankItem) adapter.getItem(position);
		Navigation.Builder builder = new Navigation.Builder().setAnimConfig(getActivity(), view)
																												 .setId(item.get_id())
																												 .setContext(mContext)
																												 .setTitle(item.getDesc())
																												 .setUrl(item.getUrl())
																												 .setCategorye(category)
																												 .builder();
		Navigation.NavToTencentWeb(builder);
	}
}
