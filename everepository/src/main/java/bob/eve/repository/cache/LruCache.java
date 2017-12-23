package bob.eve.repository.cache;

/**
 * Created by Bob on 17/12/9.
 */

import android.support.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * A general purpose size limited cache that evicts items using an LRU algorithm. By default every
 * item is assumed to have a size of one. Subclasses can override {@link #getSize(Object)}} to
 * change the size on a per item basis.
 *
 * @param <T>
 * 		The type of the keys.如需要可以定义Key接口，自定义key相等更新等策略
 * @param <Y>
 * 		The type of the values.
 */
public class LruCache<T, Y> implements IEveCache<T, Y> {
	private final LinkedHashMap<T, Y> cache = new LinkedHashMap<>(100, 0.75f, true);
	private final int initialMaxSize;
	private int maxSize;
	private int currentSize = 0;

	/**
	 * Constructor for LruCache.
	 *
	 * @param size
	 * 		The maximum size of the cache, the units must match the units used in {@link
	 * 		#getSize(Object)}.
	 */
	public LruCache(int size) {
		this.initialMaxSize = size;
		this.maxSize = size;
	}

	/**
	 * Sets a size multiplier that will be applied to the size provided in the constructor to put the
	 * new size of the cache. If the new size is less than the current size, entries will be evicted
	 * until the current size is less than or equal to the new size.
	 *
	 * @param multiplier
	 * 		The multiplier to apply.
	 */
	public synchronized void setSizeMultiplier(float multiplier) {
		if (multiplier < 0) {
			throw new IllegalArgumentException("Multiplier must be >= 0");
		}
		maxSize = Math.round(initialMaxSize * multiplier);
		evict();
	}

	/**
	 * Returns the size of a given item, defaulting to one. The units must match those used in the
	 * size passed in to the constructor. Subclasses can override this method to return sizes in
	 * various units, usually bytes.
	 *
	 * @param item
	 * 		The item to get the size of.
	 * 		缓存数据单位与{@link #maxSize}一致，如果是个数缓存则返回1，
	 * 		如果是图片缓存则可返回{#bitmap.getByteCount()}
	 */
	protected int getSize(Y item) {
		return 1;
	}

	/**
	 * Returns the number of entries stored in cache.
	 */
	protected synchronized int getCount() {
		return cache.size();
	}

	/**
	 * A callback called whenever an item is evicted from the cache. Subclasses can override.
	 *
	 * @param key
	 * 		The key of the evicted item.
	 * @param item
	 * 		The evicted item.
	 */
	protected void onItemEvicted(T key, Y item) {
		// optional override
	}

	/**
	 * Returns the current maximum size of the cache in bytes.
	 */
	@Override
	public synchronized int getMaxSize() {
		return maxSize;
	}

	@Override
	public Set<T> keySet() {
		return cache.keySet();
	}

	/**
	 * Returns the sum of the sizes of all items in the cache.
	 */
	public synchronized int getCurrentSize() {
		return currentSize;
	}

	/**
	 * Returns true if there is a value for the given key in the cache.
	 *
	 * @param key
	 * 		The key to check.
	 */
	@Override
	public synchronized boolean contains(T key) {
		return cache.containsKey(key);
	}

	/**
	 * Returns the item in the cache for the given key or null if no such item exists.
	 *
	 * @param key
	 * 		The key to check.
	 */
	@Nullable
	@Override
	public synchronized Y get(T key) {
		return cache.get(key);
	}

	/**
	 * Adds the given item to the cache with the given key and returns any previous entry for the
	 * given key that may have already been in the cache.
	 *
	 * <p> If the size of the item is larger than the total cache size, the item will not be added to
	 * the cache and instead {@link #onItemEvicted(Object, Object)} will be called synchronously with
	 * the given key and item. </p>
	 *
	 * @param key
	 * 		The key to add the item at.
	 * @param item
	 * 		The item to add.
	 */
	@Nullable
	@Override
	public synchronized Y put(T key, Y item) {
		final int itemSize = getSize(item);
		/* 如果缓存数据所占空间(单位)大于最大允许空间，缓存失败并回调{@link #onItemEvicted(Object, Object)} */
		if (itemSize >= maxSize) {
			onItemEvicted(key, item);
			return null;
		}

		final Y result = cache.put(key, item);
		/* resule为LinkedHashMap中缓存的数据，如为null则是新数据，否则已经存在 */

		/* item resule的关系导致一下 += -= 很有趣 */
		if (item != null) {
			currentSize += getSize(item);
		}
		if (result != null) {
			// TODO: should we call onItemEvicted here? 不关心数据更新可以不通知
			currentSize -= getSize(result);
		}
		evict();

		return result;
	}

	/**
	 * Removes the item at the given key and returns the removed item if present, and null otherwise.
	 *
	 * @param key
	 * 		The key to remove the item at.
	 */
	@Nullable
	@Override
	public synchronized Y remove(T key) {
		final Y value = cache.remove(key);
		if (value != null) {
			currentSize -= getSize(value);
		}
		return value;
	}

	/**
	 * 返回当前缓存已占用的总 size
	 */
	@Override
	public synchronized int size() {
		return currentSize;
	}

	/**
	 * Clears all items in the cache.
	 */
	@Override
	public void clear() {
		trimToSize(0);
	}

	/**
	 * Removes the least recently used items from the cache until the current size is less than the
	 * given size.
	 *
	 * @param size
	 * 		The size the cache should be less than.
	 */
	protected synchronized void trimToSize(int size) {
		Map.Entry<T, Y> last;
		while (currentSize > size) {
			last = cache.entrySet().iterator().next();
			final Y toRemove = last.getValue();
			currentSize -= getSize(toRemove);
			final T key = last.getKey();
			cache.remove(key);
			onItemEvicted(key, toRemove);
		}
	}

	@Override
	public void evict() {
		trimToSize(maxSize);
	}
}
