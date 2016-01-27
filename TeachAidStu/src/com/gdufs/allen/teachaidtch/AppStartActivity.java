package com.gdufs.allen.teachaidtch;

import com.gdufs.allen.teachaidtch.R;
import com.gdufs.allen.teachaidtch.util.NetworkUtil;
import com.gdufs.allen.teachaidtch.util.ToastUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * @author Allen Lin
 * @date 2016-1-21
 * @desc 启动界面
 */
public class AppStartActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_start);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				if (NetworkUtil.getNetworkState(AppStartActivity.this) == NetworkUtil.NONE) {
					ToastUtil.showShortToast(AppStartActivity.this, "本地网络没有连接");
				}
				Intent intent = null;
				intent = new Intent(AppStartActivity.this, LoginActivity.class);
				startActivity(intent);
				AppStartActivity.this.finish();
			}
		}, 2000);
	}

}
