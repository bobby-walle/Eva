/*
 * Create by BobEve on 17-12-21 上午2:24
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-21 上午2:24
 */

package bob.eve.walle.ui.adapter;

import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import bob.eve.comm.lib.view.TagGroup;
import bob.eve.walle.R;
import bob.eve.walle.mvp.model.bean.douban.MovieSubject;
import bob.eve.walle.ui.widget.imageloader.GlideImageLoader;
import bob.eve.walle.util.SpannableStringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ramotion.foldingcell.FoldingCell;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Bob on 17/12/21.
 */

public class MovieDoubanAdapter extends BaseQuickAdapter<MovieSubject, BaseViewHolder> {
	private HashSet<Integer> unfoldedIndexes = new HashSet<>();
	private Fragment fragment;

	public MovieDoubanAdapter(Fragment fragment, int layoutResId) {
		super(layoutResId);
		this.fragment = fragment;
	}

	@Override
	protected void convert(BaseViewHolder helper, MovieSubject item) {
		// outer
		helper.setText(R.id.movie_title_name, item.getTitle());
		GlideImageLoader.getInstance()
										.displayImage(fragment, item.getImages()
																								.getMedium(),
																	(ImageView) helper.getView(R.id.movie_title_image));

		// inner
		helper.setText(R.id.movie_content_name, item.getTitle() + "\n" + item.getOriginalTitle());
		setLinkCasts(helper, item);
		MovieSubject.RatingBean rating = item.getRating();
		if (rating != null) {
			helper.setRating(R.id.movie_content_rating, rating.getAverage(), rating.getMax());
		}

		TagGroup tagGroup = helper.getView(R.id.movie_content_tags);
		List<String> tags = new ArrayList<>();
		tags.add(item.getYear());
		tags.addAll(item.getGenres());
		for (MovieSubject.DirectorsBean directorsBean : item.getDirectors()) {
			tags.add(directorsBean.getName());
		}
		tagGroup.setTags(tags);

		GlideImageLoader.getInstance()
										.displayImage(fragment, item.getImages()
																								.getMedium(),
																	(ImageView) helper.getView(R.id.movie_content_small_image));
		GlideImageLoader.getInstance()
										.displayImage(fragment, item.getImages()
																								.getMedium(),
																	(ImageView) helper.getView(R.id.movie_content_image));

		// cell state
		FoldingCell cell = helper.itemView.findViewById(R.id.folding_cell);

		if (unfoldedIndexes.contains(helper.getLayoutPosition())) {
			cell.unfold(true);
		} else {
			cell.fold(true);
		}
	}

	private void setLinkCasts(BaseViewHolder helper, MovieSubject item) {
		((TextView) helper.getView(R.id.movie_content_casts)).setMovementMethod(
				LinkMovementMethod.getInstance());
		helper.getView(R.id.movie_content_casts)
					.setFocusable(false);
		helper.getView(R.id.movie_content_casts)
					.setClickable(false);
		helper.getView(R.id.movie_content_casts)
					.setLongClickable(false);
		List<MovieSubject.CastsBean> casts = item.getCasts();
		SpannableStringUtils.Builder builder =
				SpannableStringUtils.getBuilder(fragment.getContext(), "");
		builder.append("演员:\n")
					 .setBold();
		for (MovieSubject.CastsBean cast : casts) {
			builder.append(cast.getName())
						 .setUrl(cast.getAlt())
						 .append(" ")
						 .setItalic();
		}
		helper.setText(R.id.movie_content_casts, builder.create());
	}

	public void registerToggle(int position) {
		if (unfoldedIndexes.contains(position)) {
			registerFold(position);
		} else {
			registerUnfold(position);
		}
	}

	public void registerFold(int position) {
		unfoldedIndexes.remove(position);
	}

	public void registerUnfold(int position) {
		unfoldedIndexes.add(position);
	}

	public void clearRegisterToggle() {
		if (unfoldedIndexes != null && unfoldedIndexes.size() > 0) {
			unfoldedIndexes.clear();
		}
	}
}
