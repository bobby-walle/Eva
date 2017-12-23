/*
 * Create by BobEve on 17-12-21 下午4:46
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 下午12:42
 */

package bob.eve.pm.ui.adapter;

import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import bob.eve.pm.R;
import bob.eve.pm.mvp.model.bean.gank.GankItem;
import bob.eve.pm.util.DateUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.text.ParseException;

/**
 * Created by Bob on 17/12/19.
 */

public class MovieGankAdapter extends BaseQuickAdapter<GankItem, BaseViewHolder> {
	private Fragment fragment;

	public MovieGankAdapter(Fragment fragment, @LayoutRes int layoutResId) {
		super(layoutResId);
		this.fragment = fragment;
	}

	@Override
	protected void convert(BaseViewHolder helper, GankItem item) {
		helper.setText(R.id.icc_title, item.getDesc());
		try {
			helper.setText(R.id.icc_time, DateUtils.subStandardTime(item.getPublishedAt()));
		} catch (ParseException e) {
			helper.setText(R.id.icc_time, "N/A");
		}
		helper.setText(R.id.icc_user, item.getWho());
		helper.setText(R.id.icc_tag, item.getType());
	}
}

