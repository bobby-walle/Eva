/*
 * Create by BobEve on 17-12-10 下午10:55
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-10 下午10:55
 */

package bob.eve.mvp.mapper;

import java.util.Collection;

/**
 * Created by Bob on 17/12/10.
 */

public interface IEntityToModelMapper<Entity, Model> {
	Model transform(Entity data);

	Collection<Model> transform(Collection<Entity> data);
}
