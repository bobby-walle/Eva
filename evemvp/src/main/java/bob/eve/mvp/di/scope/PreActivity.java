/*
 * Create by BobEve on 17-12-11 下午10:57
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午10:57
 */

package bob.eve.mvp.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Bob on 17/12/11.
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface PreActivity {
}
