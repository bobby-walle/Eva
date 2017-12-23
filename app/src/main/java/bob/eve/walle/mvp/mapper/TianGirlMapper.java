/*
 * Create by BobEve on 17-12-22 下午5:37
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 下午4:34
 */

package bob.eve.walle.mvp.mapper;

import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.mvp.mapper.AbsEntityToModelMapper;
import bob.eve.walle.mvp.entity.tian.TianGirlEntity;
import bob.eve.walle.mvp.model.bean.tian.TianGirl;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/19.
 */
@PreFragment
public class TianGirlMapper extends AbsEntityToModelMapper<TianGirlEntity.NewslistBean, TianGirl> {

	@Inject
	public TianGirlMapper() {
	}

	@Override
	public TianGirl transform(TianGirlEntity.NewslistBean data) {
		TianGirl tianGirl = null;
		if (data != null) {
			tianGirl = new TianGirl();
			tianGirl.setCtime(data.getCtime());
			tianGirl.setDescription(data.getDescription());
			tianGirl.setPicUrl(data.getPicUrl());
			tianGirl.setTitle(data.getTitle());
		}
		return tianGirl;
	}
}
