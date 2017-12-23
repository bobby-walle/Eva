/*
 * Create by BobEve on 17-12-11 上午12:15
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 上午12:15
 */

package bob.eve.mvp.mapper;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Bob on 17/12/11.
 * {@link #transform(Object)}实现Data to Model具体方式,对Model中数据安全业务等方面检查以方便UI展示Model
 *
 * 提供2中转换方式{@link Collection<Model>}和{@link Model}
 */

public abstract class AbsEntityToModelMapper<Entity, Model>
		implements IEntityToModelMapper<Entity, Model> {
	private static final String LOG_TAG = "DataToModelMapper";

	@Override
	public Collection<Model> transform(Collection<Entity> dataCollection) {
		Collection<Model> modelCollection;
		if (dataCollection != null && !dataCollection.isEmpty()) {
			modelCollection = new ArrayList<>();
			for (Entity data : dataCollection) {
				modelCollection.add(transform(data));
			}
		} else {
			modelCollection = new ArrayList<>();
		}
		return modelCollection;
	}
}
