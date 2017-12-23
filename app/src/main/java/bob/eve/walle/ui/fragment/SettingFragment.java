/*
 * Create by BobEve on 17-12-18 下午9:42
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-18 下午9:42
 */

package bob.eve.walle.ui.fragment;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import bob.eve.comm.lib.util.SystemShareUtils;
import bob.eve.walle.R;
import bob.eve.walle.app.EveDiBaseFragment;
import bob.eve.walle.config.ImplPreferencesHelper;
import bob.eve.walle.di.component.FragmentComponent;
import bob.eve.walle.mvp.presenter.SettingPresenter;
import bob.eve.walle.ui.activity.MainActivity;
import bob.eve.walle.util.SnackbarUtil;
import butterknife.BindView;
import butterknife.OnClick;
import javax.inject.Inject;

/**
 * Created by Bob on 17/12/18.
 */

public class SettingFragment extends EveDiBaseFragment<SettingPresenter>
		implements CompoundButton.OnCheckedChangeListener {

	@Inject
	ImplPreferencesHelper preferencesHelper;

	@BindView(R.id.setting_night)
	AppCompatCheckBox night;
	@BindView(R.id.setting_feedback)
	LinearLayout feedback;
	@BindView(R.id.setting_clean)
	LinearLayout clean;
	@BindView(R.id.setting_clean_size)
	TextView cleanSize;
	@BindView(R.id.setting_update)
	LinearLayout update;
	@BindView(R.id.setting_update_version)
	TextView updateVersion;

	private boolean isNull = true;

	public static SettingFragment newInstance() {
		Bundle args = new Bundle();
		SettingFragment fragment = new SettingFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		isNull = savedInstanceState == null;
		super.onCreate(savedInstanceState);
	}

	@Override
	public int layoutResID() {
		return R.layout.fragment_setting_layout;
	}

	@Override
	public void attachView() {

	}

	@Override
	public void initView(View view) {
		night.setChecked(preferencesHelper.getNightModeState());
		night.setOnCheckedChangeListener(this);
	}

	@Override
	public void initLazyView(View view) {
		cleanSize.setText("110kb");
		setCurVersion();
	}

	@OnClick(R.id.setting_feedback)
	protected void toSendMail() {
		SystemShareUtils.sendEmail(mContext, getString(R.string.feedback_email_message));
	}

	@OnClick(R.id.setting_clean)
	protected void toCleanCache() {
		cleanSize.setText("0kb");
		SnackbarUtil.show(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0),
											"干净了，信不信～");
	}

	@OnClick(R.id.setting_update)
	protected void toCheckUpdate() {
		SnackbarUtil.show(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0),
											"检查更新失败");
	}

	@Override
	public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
		switch (compoundButton.getId()) {
			case R.id.setting_night:
				//				if (isNull) {
				boolean isNight = preferencesHelper.getNightModeState();
				if ((getActivity()) != null && getActivity() instanceof MainActivity) {
					((MainActivity) getActivity()).changeDayNight(!isNight);
				}
				//				}

				break;
			default:
				break;
		}
	}

	private void setCurVersion() {
		try {
			PackageManager pm = getActivity().getPackageManager();
			PackageInfo pi =
					pm.getPackageInfo(getActivity().getPackageName(), PackageManager.GET_ACTIVITIES);
			String versionName = pi.versionName;
			updateVersion.setText(String.format(getString(R.string.cur_version), versionName));
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void inject(FragmentComponent fragmentComponent) {
		fragmentComponent.inject(this);
	}
}
