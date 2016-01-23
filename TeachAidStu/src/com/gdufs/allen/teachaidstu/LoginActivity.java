package com.gdufs.allen.teachaidstu;

import com.gdufs.allen.teachaidstu.R;
import com.gdufs.allen.teachaidstu.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/**
 * @author Allen Lin
 * @date 2016-1-22
 * @desc
 */
public class LoginActivity extends Activity {

	private Button mBtnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

}
