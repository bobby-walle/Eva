/*
 * Create by BobEve on 17-12-22 下午11:40
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-22 下午11:39
 */

package bob.eve.pm.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Bob on 17/12/22.
 */

public class WelcomeActivity extends AppCompatActivity {
	private Handler handler = new Handler();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				toMain();
			}
		}, 700);
	}

	private void toMain() {
		Intent intent = new Intent();
		intent.setClass(this, MainActivity.class);
		startActivity(intent);
		finish();
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}
}
