package com.gdufs.allen.teachaidtch;

import com.gdufs.allen.teachaidtch.R;
import com.gdufs.allen.teachaidtch.util.ToastUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author Allen Lin
 * @date 2016-1-22
 * @desc 登录界面
 */
public class LoginActivity extends Activity implements OnClickListener {

	private Button mBtnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		mBtnLogin = (Button) findViewById(R.id.bt_login);
		mBtnLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_login:
			ToastUtil.showLongToast(this, "正在登录");

			Intent intent = null;
			intent = new Intent(LoginActivity.this, MainActivity.class);
			startActivity(intent);
			LoginActivity.this.finish();
			break;

		default:
			break;
		}
	}

}
