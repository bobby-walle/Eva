/*
 * Create by BobEve on 17-12-18 下午2:53
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午2:53
 */

package bob.eve.comm.lib.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by Bob on 17/12/18.
 *
 * TODO attrs
 */

public class ScrollImageView extends AppCompatImageView {
	public ScrollImageView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	private int mDx;
	private int mMinDx;

	public void setDx(int dx) {
		if (getDrawable() == null) {
			return;
		}
		mDx = dx - mMinDx;
		if (mDx <= 0) {
			mDx = 0;
		}
		int height = getDrawable().getBounds()
															.height();
		if (mDx > height - mMinDx) {
			mDx = height - mMinDx;
		}

		postInvalidate();
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		mMinDx = h;
	}

	public int getDx() {
		return mDx;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Drawable drawable = getDrawable();
		if (drawable != null) {
			int w = getWidth();
			int h =
					(int) (getWidth() * 1.0f / drawable.getIntrinsicWidth() * drawable.getIntrinsicHeight());
			drawable.setBounds(0, 0, w, h);
			canvas.save();
			canvas.translate(0, -getDx());
			super.onDraw(canvas);
			canvas.restore();
		}
	}
	/**
	 * eg.
	 *
	 * mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
	 * * @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
	 * * * super.onScrolled(recyclerView, dx, dy);
	 * * * int fPos = mLinearLayoutManager.findFirstVisibleItemPosition();
	 * * * int lPos = mLinearLayoutManager.findLastCompletelyVisibleItemPosition();
	 * * * for (int i = fPos; i <= lPos; i++) {
	 * * * * View view = mLinearLayoutManager.findViewByPosition(i);
	 * * * * ScrollImageView adImageView = view.findViewById(R.id.id_iv_ad);
	 * * * * if (adImageView.getVisibility() == View.VISIBLE) {
	 * * * * * * adImageView.setDy(mLinearLayoutManager.getHeight() - view.getTop());
	 * * * * * }
	 * * * * }
	 * * * }
	 * });
	 */
}