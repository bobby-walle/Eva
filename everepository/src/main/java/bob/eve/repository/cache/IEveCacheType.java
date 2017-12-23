package bob.eve.repository.cache;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by Bob on 17/12/9.
 */

public interface IEveCacheType {
	int RETROFIT_SERVICE_CACHE_TYPE_ID = 0;
	int CACHE_SERVICE_CACHE_TYPE_ID = 1;
	int EXTRAS_TYPE_ID = 2;
	int ACTIVITY_CACHE_TYPE_ID = 3;
	int FRAGMENT_CACHE_TYPE_ID = 4;

	IEveCacheType RETROFIT_SERVICE_CACHE = new IEveCacheType() {
		private static final int MAX_SIZE = 150;
		private static final float MAX_SIZE_MULTIPLIER = 0.002f;

		@Override
		public int getCacheTypeId() {
			return RETROFIT_SERVICE_CACHE_TYPE_ID;
		}

		@Override
		public int calculateCacheSize(Context context) {
			ActivityManager activityManager =
					(ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
			int targetMemoryCacheSize =
					(int) (activityManager.getMemoryClass() * MAX_SIZE_MULTIPLIER * 1024);
			if (targetMemoryCacheSize >= MAX_SIZE) {
				return MAX_SIZE;
			}
			return targetMemoryCacheSize;
		}
	};

	IEveCacheType CACHE_SERVICE_CACHE = new IEveCacheType() {
		private static final int MAX_SIZE = 150;
		private static final float MAX_SIZE_MULTIPLIER = 0.002f;

		@Override
		public int getCacheTypeId() {
			return CACHE_SERVICE_CACHE_TYPE_ID;
		}

		@Override
		public int calculateCacheSize(Context context) {
			ActivityManager activityManager =
					(ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
			int targetMemoryCacheSize =
					(int) (activityManager.getMemoryClass() * MAX_SIZE_MULTIPLIER * 1024);
			if (targetMemoryCacheSize >= MAX_SIZE) {
				return MAX_SIZE;
			}
			return targetMemoryCacheSize;
		}
	};

	IEveCacheType EXTRAS = new IEveCacheType() {
		private static final int MAX_SIZE = 500;
		private static final float MAX_SIZE_MULTIPLIER = 0.005f;

		@Override
		public int getCacheTypeId() {
			return EXTRAS_TYPE_ID;
		}

		@Override
		public int calculateCacheSize(Context context) {
			ActivityManager activityManager =
					(ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
			int targetMemoryCacheSize =
					(int) (activityManager.getMemoryClass() * MAX_SIZE_MULTIPLIER * 1024);
			if (targetMemoryCacheSize >= MAX_SIZE) {
				return MAX_SIZE;
			}
			return targetMemoryCacheSize;
		}
	};

	IEveCacheType ACTIVITY_CACHE = new IEveCacheType() {
		private static final int MAX_SIZE = 80;
		private static final float MAX_SIZE_MULTIPLIER = 0.0008f;

		@Override
		public int getCacheTypeId() {
			return ACTIVITY_CACHE_TYPE_ID;
		}

		@Override
		public int calculateCacheSize(Context context) {
			ActivityManager activityManager =
					(ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
			int targetMemoryCacheSize =
					(int) (activityManager.getMemoryClass() * MAX_SIZE_MULTIPLIER * 1024);
			if (targetMemoryCacheSize >= MAX_SIZE) {
				return MAX_SIZE;
			}
			return targetMemoryCacheSize;
		}
	};

	IEveCacheType FRAGMENT_CACHE = new IEveCacheType() {
		private static final int MAX_SIZE = 80;
		private static final float MAX_SIZE_MULTIPLIER = 0.0008f;

		@Override
		public int getCacheTypeId() {
			return FRAGMENT_CACHE_TYPE_ID;
		}

		@Override
		public int calculateCacheSize(Context context) {
			ActivityManager activityManager =
					(ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
			int targetMemoryCacheSize =
					(int) (activityManager.getMemoryClass() * MAX_SIZE_MULTIPLIER * 1024);
			if (targetMemoryCacheSize >= MAX_SIZE) {
				return MAX_SIZE;
			}
			return targetMemoryCacheSize;
		}
	};

	/**
	 * 返回框架内需要缓存的模块对应的 {@code id}
	 */
	int getCacheTypeId();

	/**
	 * 计算对应模块需要的缓存大小
	 */
	int calculateCacheSize(Context context);
}
