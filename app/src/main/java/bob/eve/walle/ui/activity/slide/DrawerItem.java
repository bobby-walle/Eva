/*
 * Create by BobEve on 17-12-18 下午5:39
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午12:37
 */

package bob.eve.walle.ui.activity.slide;

import android.view.ViewGroup;

public abstract class DrawerItem<T extends DrawerAdapter.ViewHolder> {

	protected boolean isChecked;

	public abstract T createViewHolder(ViewGroup parent);

	public abstract void bindViewHolder(T holder);

	public DrawerItem setChecked(boolean isChecked) {
		this.isChecked = isChecked;
		return this;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public boolean isSelectable() {
		return true;
	}
}
