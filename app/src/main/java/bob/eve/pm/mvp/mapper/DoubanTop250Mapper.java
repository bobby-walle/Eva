/*
 * Create by BobEve on 17-12-21 上午2:55
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-20 下午3:01
 */

package bob.eve.pm.mvp.mapper;

import android.support.annotation.NonNull;
import bob.eve.mvp.di.scope.PreFragment;
import bob.eve.mvp.mapper.AbsEntityToModelMapper;
import bob.eve.pm.mvp.entity.douban.Top250Entity;
import bob.eve.pm.mvp.model.bean.douban.MovieSubject;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/19.
 */
@PreFragment
public class DoubanTop250Mapper
		extends AbsEntityToModelMapper<Top250Entity.SubjectsBean, MovieSubject> {

	@Inject
	public DoubanTop250Mapper() {
	}

	@Override
	public MovieSubject transform(Top250Entity.SubjectsBean data) {
		MovieSubject subject = null;
		if (data != null) {
			subject = new MovieSubject();

			subject.setAlt(data.getAlt());
			subject.setCasts(getCastsBeans(data));
			subject.setId(data.getId());
			subject.setOriginalTitle(data.getOriginalTitle());
			subject.setSubtype(data.getSubtype());
			subject.setTitle(data.getTitle());
			subject.setYear(data.getYear());
			subject.setDirectors(getDirectors(data));
			subject.setGenres(data.getGenres());
			subject.setImages(getImages(data));
			subject.setRating(getRating(data));
		}
		return subject;
	}

	private MovieSubject.RatingBean getRating(Top250Entity.SubjectsBean data) {
		MovieSubject.RatingBean rating = new MovieSubject.RatingBean();
		Top250Entity.SubjectsBean.RatingBean entityRating = data.getRating();
		rating.setAverage(entityRating.getAverage());
		rating.setMax(entityRating.getMax());
		rating.setMin(entityRating.getMin());
		rating.setStars(entityRating.getStars());

		return rating;
	}

	private MovieSubject.ImagesBean getImages(Top250Entity.SubjectsBean data) {
		MovieSubject.ImagesBean images = new MovieSubject.ImagesBean();
		Top250Entity.SubjectsBean.ImagesBean entityImages = data.getImages();
		images.setLarge(entityImages.getLarge());
		images.setMedium(entityImages.getMedium());
		images.setSmall(entityImages.getSmall());
		return images;
	}

	@NonNull
	private List<MovieSubject.DirectorsBean> getDirectors(Top250Entity.SubjectsBean data) {
		List<MovieSubject.DirectorsBean> directors = new ArrayList<>();
		List<Top250Entity.SubjectsBean.DirectorsBean> entityDirectors = data.getDirectors();

		if (entityDirectors != null) {
			for (Top250Entity.SubjectsBean.DirectorsBean entityDirector : entityDirectors) {
				MovieSubject.DirectorsBean director = new MovieSubject.DirectorsBean();
				director.setAlt(entityDirector.getAlt());
				director.setId(entityDirector.getId());
				director.setName(entityDirector.getName());
				Top250Entity.SubjectsBean.DirectorsBean.AvatarsBeanX entityAvatarsBeanX =
						entityDirector.getAvatars();
				MovieSubject.DirectorsBean.AvatarsBeanX avatarsBeanX =
						new MovieSubject.DirectorsBean.AvatarsBeanX();
				avatarsBeanX.setLarge(entityAvatarsBeanX.getLarge());
				avatarsBeanX.setMedium(entityAvatarsBeanX.getMedium());
				avatarsBeanX.setSmall(entityAvatarsBeanX.getSmall());
				director.setAvatars(avatarsBeanX);
			}
		}
		return directors;
	}

	@NonNull
	private List<MovieSubject.CastsBean> getCastsBeans(Top250Entity.SubjectsBean data) {
		List<MovieSubject.CastsBean> casts = new ArrayList<>();
		List<Top250Entity.SubjectsBean.CastsBean> entityCasts = data.getCasts();
		if (entityCasts != null) {
			for (Top250Entity.SubjectsBean.CastsBean entityCast : entityCasts) {
				MovieSubject.CastsBean cast = new MovieSubject.CastsBean();
				cast.setAlt(entityCast.getAlt());
				Top250Entity.SubjectsBean.CastsBean.AvatarsBean entityAvatar = entityCast.getAvatars();
				MovieSubject.CastsBean.AvatarsBean avatar = new MovieSubject.CastsBean.AvatarsBean();
				avatar.setLarge(entityAvatar.getLarge());
				avatar.setMedium(entityAvatar.getMedium());
				avatar.setSmall(entityAvatar.getSmall());
				cast.setAvatars(avatar);
				cast.setId(entityCast.getId());
				cast.setName(entityCast.getName());
				casts.add(cast);
			}
		}
		return casts;
	}
}
