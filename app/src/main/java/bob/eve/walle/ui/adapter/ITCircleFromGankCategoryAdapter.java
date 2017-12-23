/*
 * Create by BobEve on 17-12-19 下午9:09
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 下午9:09
 */

package bob.eve.walle.ui.adapter;

import android.support.v4.app.Fragment;
import android.widget.ImageView;
import bob.eve.walle.R;
import bob.eve.walle.mvp.model.bean.gank.GankItem;
import bob.eve.walle.ui.fragment.ITCircleFromGankCategoryFragment;
import bob.eve.walle.ui.widget.imageloader.GlideImageLoader;
import bob.eve.walle.util.DateUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.text.ParseException;

import static bob.eve.walle.ui.fragment.tab.ITCircleTabFragment.GANK_CATEGORY_Android;
import static bob.eve.walle.ui.fragment.tab.ITCircleTabFragment.GANK_CATEGORY_IOS;
import static bob.eve.walle.ui.fragment.tab.ITCircleTabFragment.GANK_CATEGORY_WEB;

/**
 * Created by Bob on 17/12/19.
 */

public class ITCircleFromGankCategoryAdapter
		extends BaseMultiItemQuickAdapter<GankItem, BaseViewHolder> {
	private Fragment fragment;

	public ITCircleFromGankCategoryAdapter(Fragment fragment) {
		super(null);
		this.fragment = fragment;
		addItemType(ITCircleFromGankCategoryFragment.WITH_GIRL,
								R.layout.item_it_cicle_category_girl_layout);
		addItemType(ITCircleFromGankCategoryFragment.WITH_IMAGE,
								R.layout.item_it_cicle_category_have_image_layout);
		addItemType(ITCircleFromGankCategoryFragment.WITHOUT_IMAGE,
								R.layout.item_it_cicle_category_no_image_layout);
	}

	@Override
	protected void convert(BaseViewHolder helper, GankItem item) {
		final int type = helper.getItemViewType();
		if (type == ITCircleFromGankCategoryFragment.WITH_GIRL) {
			helper.setText(R.id.icc_user, item.getWho());
			try {
				helper.setText(R.id.icc_time, DateUtils.subStandardTime(item.getPublishedAt()));
			} catch (ParseException e) {
				helper.setText(R.id.icc_time, "");
			}

			GlideImageLoader.getInstance()
											.displayImageWithoutCrop(fragment, item.getUrl(),
																							 (ImageView) helper.getView(R.id.icc_scroll_image));
		} else {
			helper.setText(R.id.icc_title, item.getDesc());
			try {
				helper.setText(R.id.icc_time, DateUtils.subStandardTime(item.getPublishedAt()));
			} catch (ParseException e) {
				helper.setText(R.id.icc_time, "N/A");
			}
			helper.setText(R.id.icc_user, item.getWho());
			helper.setText(R.id.icc_tag, item.getType());
			if (type == ITCircleFromGankCategoryFragment.WITH_IMAGE) {
				GlideImageLoader.getInstance()
												.displayImage(fragment, item.getUrl(),
																			(ImageView) helper.getView(R.id.icc_image));
			} else {
				final String sourceType = item.getType();
				final int typeImageRes;
				if (GANK_CATEGORY_Android.equals(sourceType)) {
					typeImageRes = R.drawable.ic_item_categroy_android;
				} else if (GANK_CATEGORY_IOS.equals(sourceType)) {
					typeImageRes = R.drawable.ic_item_categroy_ios;
				} else if (GANK_CATEGORY_WEB.equals(sourceType)) {
					typeImageRes = R.drawable.ic_item_categroy_web;
				} else {
					typeImageRes = R.drawable.ic_item_categroy_expand;
				}

				GlideImageLoader.getInstance()
												.displayImage(fragment, typeImageRes,
																			(ImageView) helper.getView(R.id.icc_image));
			}
		}
	}
}
