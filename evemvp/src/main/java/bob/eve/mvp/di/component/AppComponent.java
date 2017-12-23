/*
 * Create by BobEve on 17-12-11 下午4:46
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午4:46
 */

package bob.eve.mvp.di.component;

import android.app.Application;
import bob.eve.mvp.base.EveActivityManager;
import bob.eve.mvp.base.proxy.ApplicationProxy;
import bob.eve.mvp.di.module.ApplicationModule;
import bob.eve.repository.EveLogInterceptor;
import bob.eve.repository.IEveRepositoryManager;
import bob.eve.repository.di.module.EveRepositoryConfigModule;
import bob.eve.repository.di.module.EveRepositoryModule;
import com.google.gson.Gson;
import dagger.Component;
import java.io.File;
import javax.inject.Singleton;

/**
 * Created by Bob on 17/12/11.
 */

@Singleton
@Component(modules = {
		ApplicationModule.class, EveRepositoryModule.class, EveRepositoryConfigModule.class
})
public interface AppComponent {

	void inject(ApplicationProxy proxy);

	Application application();

	EveActivityManager eveActivityManager();

	EveLogInterceptor eveLogInterceptor();

	IEveRepositoryManager eveRepositoryManager();

	Gson gson();

	/* 总缓存目录，包括RxCache、图片等其他都应该在该缓存目录下 */
	File cacheFile();
}
