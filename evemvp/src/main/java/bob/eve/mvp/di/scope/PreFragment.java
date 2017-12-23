/*
 * Create by BobEve on 17-12-12 上午10:01
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-10 上午2:29
 */

package bob.eve.mvp.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by Bob on 17/12/9.
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PreFragment {
}
