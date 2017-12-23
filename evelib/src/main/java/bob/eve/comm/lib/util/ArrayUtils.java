/*
 * Create by BobEve on 17-12-9 下午10:02
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-9 下午10:02
 */

package bob.eve.comm.lib.util;

/**
 * Created by Bob on 17/12/9.
 */

public class ArrayUtils {

	private ArrayUtils() {
		throw new AssertionError();
	}

	/**
	 * is null or its length is 0
	 */
	public static <V> boolean isEmpty(V[] sourceArray) {
		return (sourceArray == null || sourceArray.length == 0);
	}

	/**
	 * get last element of the target element, before the first one that match the target element
	 * front to back
	 * <ul>
	 * <li>if array is empty, return defaultValue</li>
	 * <li>if target element is not exist in array, return defaultValue</li>
	 * <li>if target element exist in array and its index is not 0, return the last element</li>
	 * <li>if target element exist in array and its index is 0, return the last one in array if
	 * isCircle is true, else
	 * return defaultValue</li>
	 * </ul>
	 *
	 * @param value
	 * 		value of target element
	 * @param defaultValue
	 * 		default return value
	 * @param isCircle
	 * 		whether is circle
	 */
	public static <V> V getLast(V[] sourceArray, V value, V defaultValue, boolean isCircle) {
		if (isEmpty(sourceArray)) {
			return defaultValue;
		}

		int currentPosition = -1;
		for (int i = 0; i < sourceArray.length; i++) {
			if (ObjectUtils.isEquals(value, sourceArray[i])) {
				currentPosition = i;
				break;
			}
		}
		if (currentPosition == -1) {
			return defaultValue;
		}

		if (currentPosition == 0) {
			return isCircle ? sourceArray[sourceArray.length - 1] : defaultValue;
		}
		return sourceArray[currentPosition - 1];
	}

	/**
	 * get next element of the target element, after the first one that match the target element front
	 * to back
	 * <ul>
	 * <li>if array is empty, return defaultValue</li>
	 * <li>if target element is not exist in array, return defaultValue</li>
	 * <li>if target element exist in array and not the last one in array, return the next
	 * element</li>
	 * <li>if target element exist in array and the last one in array, return the first one in array
	 * if isCircle is
	 * true, else return defaultValue</li>
	 * </ul>
	 *
	 * @param value
	 * 		value of target element
	 * @param defaultValue
	 * 		default return value
	 * @param isCircle
	 * 		whether is circle
	 */
	public static <V> V getNext(V[] sourceArray, V value, V defaultValue, boolean isCircle) {
		if (isEmpty(sourceArray)) {
			return defaultValue;
		}

		int currentPosition = -1;
		for (int i = 0; i < sourceArray.length; i++) {
			if (ObjectUtils.isEquals(value, sourceArray[i])) {
				currentPosition = i;
				break;
			}
		}
		if (currentPosition == -1) {
			return defaultValue;
		}

		if (currentPosition == sourceArray.length - 1) {
			return isCircle ? sourceArray[0] : defaultValue;
		}
		return sourceArray[currentPosition + 1];
	}

	/**
	 * @see {@link ArrayUtils#getLast(Object[], Object, Object, boolean)} defaultValue is null
	 */
	public static <V> V getLast(V[] sourceArray, V value, boolean isCircle) {
		return getLast(sourceArray, value, null, isCircle);
	}

	/**
	 * @see {@link ArrayUtils#getNext(Object[], Object, Object, boolean)} defaultValue is null
	 */
	public static <V> V getNext(V[] sourceArray, V value, boolean isCircle) {
		return getNext(sourceArray, value, null, isCircle);
	}

	/**
	 * @see {@link ArrayUtils#getLast(Object[], Object, Object, boolean)} Object is Long
	 */
	public static long getLast(long[] sourceArray, long value, long defaultValue, boolean isCircle) {
		if (sourceArray.length == 0) {
			throw new IllegalArgumentException("The length of source array must be greater than 0.");
		}

		Long[] array = ObjectUtils.transformLongArray(sourceArray);
		return getLast(array, value, defaultValue, isCircle);
	}

	/**
	 * @see {@link ArrayUtils#getNext(Object[], Object, Object, boolean)} Object is Long
	 */
	public static long getNext(long[] sourceArray, long value, long defaultValue, boolean isCircle) {
		if (sourceArray.length == 0) {
			throw new IllegalArgumentException("The length of source array must be greater than 0.");
		}

		Long[] array = ObjectUtils.transformLongArray(sourceArray);
		return getNext(array, value, defaultValue, isCircle);
	}

	/**
	 * @see {@link ArrayUtils#getLast(Object[], Object, Object, boolean)} Object is Integer
	 */
	public static int getLast(int[] sourceArray, int value, int defaultValue, boolean isCircle) {
		if (sourceArray.length == 0) {
			throw new IllegalArgumentException("The length of source array must be greater than 0.");
		}

		Integer[] array = ObjectUtils.transformIntArray(sourceArray);
		return getLast(array, value, defaultValue, isCircle);
	}

	/**
	 * @see {@link ArrayUtils#getNext(Object[], Object, Object, boolean)} Object is Integer
	 */
	public static int getNext(int[] sourceArray, int value, int defaultValue, boolean isCircle) {
		if (sourceArray.length == 0) {
			throw new IllegalArgumentException("The length of source array must be greater than 0.");
		}

		Integer[] array = ObjectUtils.transformIntArray(sourceArray);
		return getNext(array, value, defaultValue, isCircle);
	}
}
