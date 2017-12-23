/*
 * Create by BobEve on 17-12-19 上午9:52
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-19 上午9:52
 */

package bob.eve.walle.mvp.model.gank;

import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.entity.gank.GankItemEntity;
import bob.eve.walle.mvp.entity.tian.TianGirlEntity;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.rx_cache2.Reply;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */

public class DateGanksModel extends EveBaseModel<Reply<GankItemEntity>, DateGanksModel.Params> {

	@Inject
	protected DateGanksModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<Reply<GankItemEntity>> buildModelDataObservable(Params params) {
		return null;
	}

	public static final class Params {
		private int day;
		private int year;
		private int month;

		private Params(int day, int year, int month) {
			this.day = day;
			this.year = year;
			this.month = month;
		}

		public static Params forDateGanks(int day, int year, int month) {
			return new Params(day, year, month);
		}
	}
}
