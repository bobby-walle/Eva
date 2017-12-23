/*
 * Create by BobEve on 17-12-19 上午10:48
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午10:48
 */

package bob.eve.pm.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import bob.eve.comm.lib.layout.state.StateLayout;
import bob.eve.comm.lib.view.ScrollImageView;
import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.pm.R;
import bob.eve.pm.app.EveDiBaseFragment;
import bob.eve.pm.app.Navigation;
import bob.eve.pm.di.component.FragmentComponent;
import bob.eve.pm.mvp.contract.ITCircleFromGankCategoryContract;
import bob.eve.pm.mvp.model.bean.gank.GankItem;
import bob.eve.pm.mvp.presenter.ITCircleFromCategoryPresenter;
import bob.eve.pm.ui.adapter.ITCircleFromGankCategoryAdapter;
import butterknife.BindView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import java.util.List;

import static bob.eve.pm.ui.fragment.tab.ITCircleTabFragment.GANK_CATEGORY_Android;
import static bob.eve.pm.ui.fragment.tab.ITCircleTabFragment.GANK_CATEGORY_TYPE_KEY;

/**
 * Created by Bob on 17/12/19.
 */
@PreFragment
public class ITCircleFromGankCategoryFragment
		extends EveDiBaseFragment<ITCircleFromCategoryPresenter>
		implements ITCircleFromGankCategoryContract.View, OnRefreshListener, OnRefreshLoadmoreListener,
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

	private ITCircleFromGankCategoryAdapter adapter;
	private LinearLayoutManager linearLayoutManager;
	private String category;

	public static ITCircleFromGankCategoryFragment newInstance(String category) {
		Bundle args = new Bundle();
		args.putString(GANK_CATEGORY_TYPE_KEY, category);
		ITCircleFromGankCategoryFragment fragment = new ITCircleFromGankCategoryFragment();
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
		Bundle bundle = getArguments();
		if (bundle != null) {
			category = bundle.getString(GANK_CATEGORY_TYPE_KEY);
		}

		refreshLayout.setRefreshHeader(
				new ClassicsHeader(mContext).setSpinnerStyle(SpinnerStyle.Translate)
																		.setPrimaryColorId(R.color.backgroundColor)
																		.setAccentColorId(R.color.textColorSecondary));
		refreshLayout.setOnRefreshLoadmoreListener(this);

		adapter = new ITCircleFromGankCategoryAdapter(this);
		adapter.openLoadAnimation();
		adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
		adapter.setOnItemClickListener(this);
		adapter.isUseEmpty(false);
		linearLayoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(linearLayoutManager);
		recyclerView.setAdapter(adapter);
	}

	@Override
	public void initLazyView(View view) {
		if (GANK_CATEGORY_Android.equals(category)) {
			recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
				@Override
				public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
					super.onScrolled(recyclerView, dx, dy);
					int firstPosition = linearLayoutManager.findFirstVisibleItemPosition();
					int lastCompletePosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
					for (int position = firstPosition; position <= lastCompletePosition; position++) {
						View view = linearLayoutManager.findViewByPosition(position);
						ScrollImageView scrollIv = view.findViewById(R.id.icc_scroll_image);
						if (scrollIv != null && scrollIv.getVisibility() == View.VISIBLE) {
							scrollIv.setDx(linearLayoutManager.getHeight() - view.getTop());
						}
					}
				}
			});
		}

		stateLayout.showLoading();
		mPresenter.getTechs(category);
	}

	@Override
	public void showTechs(List<GankItem> items) {
		adapter.setNewData(items);
		mPresenter.getTopGirl();
	}

	@Override
	public void showMoreTechs(List<GankItem> items) {
		adapter.addData(items);
		mPresenter.getTopGirl();
	}

	@Override
	public void showTopGirl(GankItem girl) {
		int index = (int) (Math.random() + adapter.getData()
																							.size());
		adapter.addData(index, girl);
	}

	@Override
	public void start() {
	}

	@Override
	public void complete() {
		if (adapter.getData()
							 .size() <= 0) {
			stateLayout.showEmpty();
		} else {
			stateLayout.showContent();
		}

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
		mPresenter.getTechs(category);
	}

	@Override
	public void onLoadmore(RefreshLayout refreshlayout) {
		mPresenter.getMoreTechs(category);
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
