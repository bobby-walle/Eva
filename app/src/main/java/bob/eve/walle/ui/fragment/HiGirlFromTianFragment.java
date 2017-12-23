/*
 * Create by BobEve on 17-12-19 上午10:51
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午10:51
 */

package bob.eve.walle.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import bob.eve.comm.lib.layout.state.StateLayout;
import bob.eve.walle.R;
import bob.eve.walle.app.EveDiBaseFragment;
import bob.eve.walle.app.Navigation;
import bob.eve.walle.di.component.FragmentComponent;
import bob.eve.walle.mvp.contract.HiGirlFromTianContract;
import bob.eve.walle.mvp.model.bean.tian.TianGirl;
import bob.eve.walle.mvp.presenter.HiGirlFromTianPresenter;
import bob.eve.walle.ui.adapter.HiGirlTianAdapter;
import butterknife.BindView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import java.util.List;

import static bob.eve.walle.ui.fragment.tab.ITCircleTabFragment.GANK_CATEGORY_TYPE_KEY;

/**
 * Created by Bob on 17/12/19.
 */

public class HiGirlFromTianFragment extends EveDiBaseFragment<HiGirlFromTianPresenter>
		implements HiGirlFromTianContract.View, OnRefreshListener, OnRefreshLoadmoreListener,
							 BaseQuickAdapter.OnItemClickListener {
	private static final int LAYOUT_COUNT = 2;
	public static final int WITH_IMAGE = 1;
	public static final int WITHOUT_IMAGE = 2;
	public static final int WITH_GIRL = 3;

	@BindView(R.id.refreshLayout)
	SwipeRefreshLayout refreshLayout;
	@BindView(R.id.recyclerView)
	RecyclerView recyclerView;
	@BindView(R.id.stateLayout)
	StateLayout stateLayout;

	private String category;
	private HiGirlTianAdapter adapter;
	private StaggeredGridLayoutManager staggeredGridLayoutManager;
	private boolean isLoadingMore = false;

	public static HiGirlFromTianFragment newInstance(String category) {
		Bundle args = new Bundle();
		args.putString(GANK_CATEGORY_TYPE_KEY, category);
		HiGirlFromTianFragment fragment = new HiGirlFromTianFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int layoutResID() {
		return R.layout.fragment_higirl_gank_layout;
	}

	@Override
	public void attachView() {
		mPresenter.attach(this);
	}

	@Override
	public void initView(View view) {
		refreshLayout.setProgressBackgroundColorSchemeResource(R.color.colorPrimary);
		refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				mPresenter.getGirls();
			}
		});

		adapter = new HiGirlTianAdapter(this, R.layout.item_hi_girl_layout);
		adapter.openLoadAnimation();
		adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
		adapter.setOnItemClickListener(this);
		adapter.isUseEmpty(false);

		staggeredGridLayoutManager =
				new StaggeredGridLayoutManager(LAYOUT_COUNT, StaggeredGridLayoutManager.VERTICAL);
		staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
		staggeredGridLayoutManager.setItemPrefetchEnabled(false);

		recyclerView.setLayoutManager(staggeredGridLayoutManager);
		recyclerView.setAdapter(adapter);
		recyclerView.addOnScrollListener(mScrollListener);
	}

	private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
		@Override
		public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
			super.onScrollStateChanged(recyclerView, newState);
			if (RecyclerView.SCROLL_STATE_IDLE == newState) {
				staggeredGridLayoutManager.invalidateSpanAssignments();
			}
		}

		@Override
		public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
			super.onScrolled(recyclerView, dx, dy);
			int[] visibleItems = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
			int lastItem = Math.max(visibleItems[0], visibleItems[1]);
			if (lastItem > adapter.getItemCount() - 5 && !isLoadingMore && dy > 0) {
				isLoadingMore = true;
				mPresenter.getMoreGirls();
			}
		}
	};

	@Override
	public void initLazyView(View view) {
		Bundle bundle = getArguments();
		if (bundle != null) {
			category = bundle.getString(GANK_CATEGORY_TYPE_KEY);
		}

		stateLayout.showLoading();
		mPresenter.getGirls();
	}

	@Override
	public void showGirls(List<TianGirl> items) {
		if (items.size() <= 0) {
			stateLayout.showEmpty();
		} else {
			stateLayout.showContent();
		}
		if (refreshLayout.isRefreshing()) {
			refreshLayout.setRefreshing(false);
		}
		adapter.setNewData(items);
	}

	@Override
	public void showMoreGirls(List<TianGirl> items) {
		isLoadingMore = false;
		adapter.addData(items);
	}

	@Override
	public void start() {
	}

	@Override
	public void complete() {

	}

	@Override
	public void error(Throwable error) {
		if (adapter.getData()
							 .size() <= 0) {
			stateLayout.showError();
		} else {
			stateLayout.showContent();
		}
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if (recyclerView != null) {
			recyclerView.removeOnScrollListener(mScrollListener);
		}
	}

	@Override
	protected void inject(FragmentComponent fragmentComponent) {
		fragmentComponent.inject(this);
	}

	@Override
	public void onRefresh(RefreshLayout refreshlayout) {
		mPresenter.getGirls();
	}

	@Override
	public void onLoadmore(RefreshLayout refreshlayout) {
		mPresenter.getMoreGirls();
	}

	@Override
	public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
		TianGirl item = (TianGirl) adapter.getItem(position);
		Navigation.Builder builder =
				new Navigation.Builder().setAnimConfig(getActivity(), view.findViewById(R.id.ig_image))
																.setId(item.getCtime())
																.setContext(mContext)
																.setTitle(item.getTitle())
																.setImgUrl(item.getPicUrl())
																.setCategorye(category)
																.builder();
		Navigation.navToImageDetail(builder);
	}
}