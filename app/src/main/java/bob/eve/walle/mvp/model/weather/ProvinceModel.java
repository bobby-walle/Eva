/*
 * Create by BobEve on 17-12-18 上午11:55
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-14 下午4:48
 */

package bob.eve.walle.mvp.model.weather;

import bob.eve.mvp.di.scope.PreActivity;
import bob.eve.mvp.model.EveBaseModel;
import bob.eve.walle.mvp.entity.cities.Province;
import bob.eve.walle.mvp.cache.CityListCacheService;
import bob.eve.walle.mvp.service.CityListService;
import bob.eve.repository.IEveRepositoryManager;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.Reply;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/12.
 */

@PreActivity
public class ProvinceModel extends EveBaseModel<List<Province>, ProvinceModel.Params> {
	private List<Province> list;
	private Province p;
	//	private City c;

	@Inject
	protected ProvinceModel(IEveRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	protected Observable<List<Province>> buildModelDataObservable(Params params) {
		//		final CityListService cs = repositoryManager.obtainRetrofitService(CityListService.class);
		//
		//		return cs.getProvices()
		//						 .flatMap(new Function<String, ObservableSource<List<Province>>>() {
		//							 @Override
		//							 public ObservableSource<List<Province>> apply(String proviceStr) throws Exception {
		//								 proviceStr = proviceStr.replaceAll("\\{", "");
		//								 proviceStr = proviceStr.replaceAll("\\}", "");
		//
		//								 String[] pArr = proviceStr.split(",");
		//								 List<Province> provinceList = new ArrayList<>();
		//								 for (String c : pArr) {
		//									 String[] cArr = c.split(":");
		//									 Province p = new Province();
		//									 p.setCode(cArr[0].replaceAll("\\\"", ""));
		//									 String name = cArr[1].replaceAll("\\\"", "");
		//									 p.setName(name);
		//									 p.setPinyin(HanziToPinyinUtils.getPinYin(name)
		//																								 .toLowerCase());
		//									 provinceList.add(p);
		//								 }
		//								 list = provinceList;
		//								 return Observable.just(provinceList);
		//							 }
		//						 })
		//						 .flatMap(new Function<List<Province>, ObservableSource<Province>>() {
		//							 @Override
		//							 public ObservableSource<Province> apply(List<Province> provinces) throws Exception {
		//								 return Observable.fromIterable(provinces);
		//							 }
		//						 })
		//						 .flatMap(new Function<Province, ObservableSource<String>>() {
		//							 @Override
		//							 public ObservableSource<String> apply(Province province) throws Exception {
		//								 p = province;
		//								 return cs.getCities(province.getCode());
		//							 }
		//						 })
		//						 .flatMap(new Function<String, ObservableSource<List<City>>>() {
		//							 @Override
		//							 public ObservableSource<List<City>> apply(String cityStr) throws Exception {
		//								 cityStr = cityStr.replaceAll("\\{", "");
		//								 cityStr = cityStr.replaceAll("\\}", "");
		//
		//								 String[] pArr = cityStr.split(",");
		//								 List<City> cityList = new ArrayList<>();
		//								 for (String c : pArr) {
		//									 String[] cArr = c.split(":");
		//									 City city = new City();
		//									 city.setCode(cArr[0].replaceAll("\\\"", ""));
		//									 String name = cArr[1].replaceAll("\\\"", "");
		//									 city.setName(name);
		//									 city.setPinyin(HanziToPinyinUtils.getPinYin(name)
		//																										.toLowerCase());
		//									 cityList.add(city);
		//								 }
		//								 p.setCities(cityList);
		//
		//								 return Observable.just(cityList);
		//							 }
		//						 })
		//						 .flatMap(new Function<List<City>, ObservableSource<List<Province>>>() {
		//							 @Override
		//							 public ObservableSource<List<Province>> apply(List<City> cities) throws Exception {
		//								 return Observable.just(list);
		//							 }
		//						 });
		//						 .flatMap(new Function<City, ObservableSource<String>>() {
		//							 @Override
		//							 public ObservableSource<String> apply(City city) throws Exception {
		////								 c = city;
		//								 return cs.getCounties(p.getCode() + city.getCode());
		//							 }
		//						 })
		//						 .flatMap(new Function<String, ObservableSource<List<County>>>() {
		//							 @Override
		//							 public ObservableSource<List<County>> apply(String countyStr) throws Exception {
		//								 countyStr = countyStr.replaceAll("\\{", "");
		//								 countyStr = countyStr.replaceAll("\\}", "");
		//
		//								 String[] pArr = countyStr.split(",");
		//								 List<County> countyList = new ArrayList<>();
		//								 for (String c : pArr) {
		//									 String[] cArr = c.split(":");
		//									 County county = new County();
		//									 county.setCode(cArr[0].replaceAll("\\\"", ""));
		//									 String name = cArr[1].replaceAll("\\\"", "");
		//									 county.setName(name);
		//									 county.setPinyin(HanziToPinyinUtils.getPinYin(name));
		//									 countyList.add(county);
		//								 }
		//								 return Observable.just(countyList);
		//							 }
		//						 })
		//						 .flatMap(new Function<List<County>, ObservableSource<List<Province>>>() {
		//							 @Override
		//							 public ObservableSource<List<Province>> apply(List<County> counties)
		//									 throws Exception {
		//								 c.setCounties(counties);
		//								 return Observable.just(list);
		//							 }
		//						 });

		//		return repositoryManager.obtainRetrofitService(CityListService.class)
		//														.getProvices()
		//														.flatMap(
		//																new Function<String, ObservableSource<Reply<String>>>() {
		//																	@Override
		//																	public ObservableSource<Reply<String>> apply(
		//																			String provinces) throws Exception {
		//																		return repositoryManager.obtainCacheService(
		//																				CityListCacheService.class)
		//																														.getProvices(Observable.just(provinces),
		//																																				 new DynamicKey("Province"),
		//																																				 new EvictProvider(true));
		//																	}
		//																})
		//														.flatMap(
		//																new Function<Reply<String>, ObservableSource<String>>() {
		//																	@Override
		//																	public ObservableSource<String> apply(
		//																			Reply<String> listReply) throws Exception {
		//																		return Observable.just(listReply.getData());
		//																	}
		//																});

		return repositoryManager.obtainCacheService(CityListCacheService.class)
														.getProvices(
																repositoryManager.obtainRetrofitService(CityListService.class)
																								 .getProvices(), new DynamicKey("Province"),
																new EvictProvider(false))
														.flatMap(
																new Function<Reply<String>, ObservableSource<List<Province>>>() {
																	@Override
																	public ObservableSource<List<Province>> apply(
																			Reply<String> listReply) throws Exception {
																		String proviceStr = listReply.getData();
																		proviceStr = proviceStr.replaceAll("\\{", "");
																		proviceStr = proviceStr.replaceAll("\\}", "");

																		String[] pArr = proviceStr.split(",");
																		List<Province> provinceList = new ArrayList<>();
																		for (String c : pArr) {
																			String[] cArr = c.split(":");
																			Province p = new Province();
																			p.setCode(cArr[0].replaceAll("\\\"", ""));
																			p.setName(cArr[1].replaceAll("\\\"", ""));
																			provinceList.add(p);
																		}
																		return Observable.just(provinceList);
																	}
																});
	}

	public static final class Params {

		private final int userId;

		private Params(int userId) {
			this.userId = userId;
		}

		public static Params forUser(int userId) {
			return new Params(userId);
		}
	}
}
