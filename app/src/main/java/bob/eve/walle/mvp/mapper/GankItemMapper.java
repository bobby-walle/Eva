/*
 * Create by BobEve on 17-12-19 下午2:26
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 下午2:26
 */

package bob.eve.walle.mvp.mapper;

import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.mvp.mapper.AbsEntityToModelMapper;
import bob.eve.walle.mvp.entity.gank.GankItemEntity;
import bob.eve.walle.mvp.model.bean.gank.GankItem;
import bob.eve.walle.mvp.model.gank.GankCategoryType;
import bob.eve.walle.ui.fragment.ITCircleFromGankCategoryFragment;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/19.
 */
@PreFragment
public class GankItemMapper
		extends AbsEntityToModelMapper<GankItemEntity.ResultsBean, GankItem> {

	@Inject
	public GankItemMapper() {
	}

	@Override
	public GankItem transform(GankItemEntity.ResultsBean data) {
		GankItem item = null;
		if (data != null) {
			item = new GankItem();
			item.set_id(data.getId());
			item.setCreatedAt(data.getCreatedAt());
			item.setDesc(data.getDesc());
			item.setPublishedAt(data.getPublishedAt());
			item.setSource(data.getSource());
			item.setUrl(data.getUrl());
			item.setUsed(data.isUsed());
			item.setWho(data.getWho());
			List<String> images = data.getImages();
			item.setImages(images);
			String type = data.getType();
			item.setType(type);

			if (GankCategoryType.GANK_CATEGORY_GIRLS.equals(type)) {
				item.setItemType(ITCircleFromGankCategoryFragment.WITH_GIRL);
			} else {
				if (images == null || images.size() <= 0) {
					item.setItemType(ITCircleFromGankCategoryFragment.WITHOUT_IMAGE);
				} else {
					item.setItemType(ITCircleFromGankCategoryFragment.WITH_IMAGE);
				}
			}
		}
		return item;
	}
}
