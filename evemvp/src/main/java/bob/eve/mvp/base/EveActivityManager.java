/*
 * Create by BobEve on 17-12-11 下午4:39
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-11 下午4:39
 */

package bob.eve.mvp.base;

import android.app.Activity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Bob on 17/12/11.
 */

@Singleton
public class EveActivityManager {
	private static final String TAG = "ActivityManager";
	private List<Activity> mActivityList;

	@Inject
	public EveActivityManager() {
		checkNull();
	}

	public List<Activity> getActivityList() {
		checkNull();
		return mActivityList;
	}

	public void addActivity(Activity activity) {
		checkNull();
		if (!mActivityList.contains(activity)) {
			mActivityList.add(activity);
		}
	}

	public void removeActivity(Activity activity) {
		checkNull();
		if (mActivityList.contains(activity)) {
			mActivityList.remove(activity);
		}
	}

	public void exit() {
		Iterator<Activity> iterator = getActivityList().iterator();
		while (iterator.hasNext()) {
			Activity next = iterator.next();
			iterator.remove();
			next.finish();
		}
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(0);
	}

	public void release() {
		if (mActivityList != null) {
			mActivityList.clear();
		}
	}

	private void checkNull() {
		if (mActivityList == null) {
			mActivityList = new LinkedList<>();
		}
	}
}
