/*
 * Create by BobEve on 17-12-19 下午5:08
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 下午5:08
 */

package bob.eve.comm.lib.layout.state;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import bob.eve.comm.lib.R;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bob on 17/12/19.
 */

public class StateLayout extends FrameLayout {
	public interface OnInflateListener {
		void onInflate(View inflated);
	}

	private int mEmptyImage;
	private CharSequence mEmptyText;

	private int mErrorImage;
	private CharSequence mErrorText;
	private CharSequence mRetryText;
	private View.OnClickListener mRetryButtonClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mRetryListener != null) {
				mRetryListener.onClick(v);
			}
		}
	};
	private View.OnClickListener mRetryListener;

	private OnInflateListener mOnEmptyInflateListener;
	private OnInflateListener mOnErrorInflateListener;

	private int mTextColor;
	private int mTextSize;
	private int mRetryTextColor;
	private int mRetryTextSize;
	private Drawable mRetryBackground;
	private int mEmptyResId = NO_ID;
	private int mLoadingResId = NO_ID;
	private int mErrorResId = NO_ID;
	private int mContentId = NO_ID;
	private LayoutInflater mInflater;

	private Map<Integer, View> mLayouts = new HashMap<>();

	public StateLayout(Context context) {
		this(context, null);
	}

	public StateLayout(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public StateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		mInflater = LayoutInflater.from(context);
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StateLayout);
		mEmptyImage = a.getResourceId(R.styleable.StateLayout_slEmptyImage, R.drawable.ic_lovely_blush);
		mEmptyText = a.getString(R.styleable.StateLayout_slEmptyText);
		mEmptyText =
				mEmptyText == null ? getResources().getString(R.string.state_layout_empty_msg) : mEmptyText;

		mErrorImage =
				a.getResourceId(R.styleable.StateLayout_slErrorImage, R.drawable.ic_lovely_cold_sweat);
		mErrorText = a.getString(R.styleable.StateLayout_slErrorText);
		mRetryText = a.getString(R.styleable.StateLayout_slRetryText);
		mRetryText =
				mRetryText == null ? getResources().getString(R.string.state_layout_error_retry_message)
													 : mRetryText;

		mRetryTextColor = a.getColor(R.styleable.StateLayout_slRetryTextColor, 0xff999999);
		mRetryTextSize = a.getDimensionPixelSize(R.styleable.StateLayout_slRetryTextSize, dp2px(16));
		mRetryBackground = a.getDrawable(R.styleable.StateLayout_slRetryBackground);

		mTextColor = a.getColor(R.styleable.StateLayout_slTextColor, 0xff999999);
		mTextSize = a.getDimensionPixelSize(R.styleable.StateLayout_slTextSize, dp2px(16));

		mEmptyResId =
				a.getResourceId(R.styleable.StateLayout_slEmptyResId, R.layout.state_layout_emtpy);
		mLoadingResId =
				a.getResourceId(R.styleable.StateLayout_slLoadingResId, R.layout.state_layout_loading);
		mErrorResId =
				a.getResourceId(R.styleable.StateLayout_slErrorResId, R.layout.state_layout_error);
		a.recycle();
	}

	int dp2px(float dp) {
		return (int) (getResources().getDisplayMetrics().density * dp);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		if (getChildCount() == 0) {
			return;
		}
		if (getChildCount() > 1) {
			removeViews(1, getChildCount() - 1);
		}
		View view = getChildAt(0);
		setContentView(view);
		showLoading();
	}

	private void setContentView(View view) {
		mContentId = view.getId();
		mLayouts.put(mContentId, view);
	}

	public StateLayout setLoading(@LayoutRes int id) {
		if (mLoadingResId != id) {
			remove(mLoadingResId);
			mLoadingResId = id;
		}
		return this;
	}

	public StateLayout setEmpty(@LayoutRes int id) {
		if (mEmptyResId != id) {
			remove(mEmptyResId);
			mEmptyResId = id;
		}
		return this;
	}

	public StateLayout setOnEmptyInflateListener(OnInflateListener listener) {
		mOnEmptyInflateListener = listener;
		if (mOnEmptyInflateListener != null && mLayouts.containsKey(mEmptyResId)) {
			listener.onInflate(mLayouts.get(mEmptyResId));
		}
		return this;
	}

	public StateLayout setOnErrorInflateListener(OnInflateListener listener) {
		mOnErrorInflateListener = listener;
		if (mOnErrorInflateListener != null && mLayouts.containsKey(mErrorResId)) {
			listener.onInflate(mLayouts.get(mErrorResId));
		}
		return this;
	}

	public StateLayout setEmptyImage(@DrawableRes int resId) {
		mEmptyImage = resId;
		image(mEmptyResId, R.id.empty_image, mEmptyImage);
		return this;
	}

	public StateLayout setEmptyText(String value) {
		mEmptyText = value;
		text(mEmptyResId, R.id.empty_text, mEmptyText);
		return this;
	}

	public StateLayout setErrorImage(@DrawableRes int resId) {
		mErrorImage = resId;
		image(mErrorResId, R.id.error_image, mErrorImage);
		return this;
	}

	//	public StateLayout setErrorText(String value) {
	//		mErrorText = value;
	//		text(mErrorResId, R.id.error_text, mErrorText);
	//		return this;
	//	}

	public StateLayout setRetryText(String text) {
		mRetryText = text;
		text(mErrorResId, R.id.retry_button, mRetryText);
		return this;
	}

	public StateLayout setRetryListener(OnClickListener listener) {
		mRetryListener = listener;
		return this;
	}

	public void showLoading() {
		show(mLoadingResId);
	}

	public void showEmpty() {
		show(mEmptyResId);
	}

	public void showError() {
		show(mErrorResId);
	}

	public void showContent() {
		show(mContentId);
	}

	private void show(int layoutId) {
		for (View view : mLayouts.values()) {
			view.setVisibility(GONE);
		}
		layout(layoutId).setVisibility(VISIBLE);
	}

	private void remove(int layoutId) {
		if (mLayouts.containsKey(layoutId)) {
			View vg = mLayouts.remove(layoutId);
			removeView(vg);
		}
	}

	private View layout(int layoutId) {
		if (mLayouts.containsKey(layoutId)) {
			return mLayouts.get(layoutId);
		}
		View layout = mInflater.inflate(layoutId, this, false);
		layout.setVisibility(GONE);
		addView(layout);
		mLayouts.put(layoutId, layout);

		if (layoutId == mEmptyResId) {
			ImageView img = (ImageView) layout.findViewById(R.id.empty_image);
			if (img != null) {
				img.setImageResource(mEmptyImage);
			}
			TextView view = (TextView) layout.findViewById(R.id.empty_text);
			if (view != null) {
				view.setText(mEmptyText);
				view.setTextColor(mTextColor);
				view.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
			}
			if (mOnEmptyInflateListener != null) {
				mOnEmptyInflateListener.onInflate(layout);
			}
		} else if (layoutId == mErrorResId) {
			ImageView img = (ImageView) layout.findViewById(R.id.error_image);
			if (img != null) {
				img.setImageResource(mErrorImage);
			}
			//			TextView txt = (TextView) layout.findViewById(R.id.error_text);
			//			if (txt != null) {
			//				txt.setText(mErrorText);
			//				txt.setTextColor(mTextColor);
			//				txt.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
			//			}
			TextView btn = (TextView) layout.findViewById(R.id.retry_button);
			if (btn != null) {
				btn.setText(mRetryText);
				btn.setTextColor(mRetryTextColor);
				btn.setTextSize(TypedValue.COMPLEX_UNIT_PX, mRetryTextSize);
				btn.setBackground(mRetryBackground);
				btn.setOnClickListener(mRetryButtonClickListener);
			}
			if (mOnErrorInflateListener != null) {
				mOnErrorInflateListener.onInflate(layout);
			}
		}
		return layout;
	}

	private void text(int layoutId, int ctrlId, CharSequence value) {
		if (mLayouts.containsKey(layoutId)) {
			TextView view = (TextView) mLayouts.get(layoutId)
																				 .findViewById(ctrlId);
			if (view != null) {
				view.setText(value);
			}
		}
	}

	private void image(int layoutId, int ctrlId, int resId) {
		if (mLayouts.containsKey(layoutId)) {
			ImageView view = (ImageView) mLayouts.get(layoutId)
																					 .findViewById(ctrlId);
			if (view != null) {
				view.setImageResource(resId);
			}
		}
	}
}