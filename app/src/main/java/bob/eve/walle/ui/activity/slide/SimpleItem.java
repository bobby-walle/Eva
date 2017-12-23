/*
 * Create by BobEve on 17-12-18 下午5:39
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 上午1:19
 */

package bob.eve.walle.ui.activity.slide;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bob.eve.walle.R;

public class SimpleItem extends DrawerItem<SimpleItem.ViewHolder> {

	private int selectedItemIconTint;
	private int selectedItemTextTint;

	private int normalItemIconTint;
	private int normalItemTextTint;

	private Drawable icon;
	private String title;

	public SimpleItem(Drawable icon, String title) {
		this.icon = icon;
		this.title = title;
	}

	@Override
	public ViewHolder createViewHolder(ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View v = inflater.inflate(R.layout.item_slide_left_layout, parent, false);
		return new ViewHolder(v);
	}

	@Override
	public void bindViewHolder(ViewHolder holder) {
		holder.title.setText(title);
		holder.icon.setImageDrawable(icon);

		holder.title.setTextColor(isChecked ? selectedItemTextTint : normalItemTextTint);
		holder.icon.setColorFilter(isChecked ? selectedItemIconTint : normalItemIconTint);
	}

	public SimpleItem withSelectedIconTint(int selectedItemIconTint) {
		this.selectedItemIconTint = selectedItemIconTint;
		return this;
	}

	public SimpleItem withSelectedTextTint(int selectedItemTextTint) {
		this.selectedItemTextTint = selectedItemTextTint;
		return this;
	}

	public SimpleItem withIconTint(int normalItemIconTint) {
		this.normalItemIconTint = normalItemIconTint;
		return this;
	}

	public SimpleItem withTextTint(int normalItemTextTint) {
		this.normalItemTextTint = normalItemTextTint;
		return this;
	}

	static class ViewHolder extends DrawerAdapter.ViewHolder {

		private ImageView icon;
		private TextView title;

		public ViewHolder(View itemView) {
			super(itemView);
			icon = (ImageView) itemView.findViewById(R.id.icon);
			title = (TextView) itemView.findViewById(R.id.title);
		}
	}
}
