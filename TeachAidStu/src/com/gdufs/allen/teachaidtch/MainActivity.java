package com.gdufs.allen.teachaidtch;

import com.gdufs.allen.teachaidtch.fragment.HomeFragment;
import com.gdufs.allen.teachaidtch.fragment.OwnerFragment;
import com.gdufs.allen.teachaidtch.fragment.TeachFragment;
import com.gdufs.allen.teachaidtch.util.LogUtil;
import com.gdufs.allen.teachaidtch.util.ToastUtil;
import com.gdufs.allen.teachaidtch.R;

import android.R.id;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

/**
 * @author Allen Lin
 * @date 2016-1-26
 * @desc app主界面
 */
public class MainActivity extends FragmentActivity implements
		OnTabChangeListener {
	private FragmentTabHost mTabHost;
	/** 选项卡文字数组 */
	private String[] mTabTextArray;

	private Class mFragmentArray[] = { HomeFragment.class, TeachFragment.class,
			OwnerFragment.class };
	/** 存放图片数组 */
	private int mImageArray[] = { R.drawable.tab_home_sl,
			R.drawable.tab_teach_sl, R.drawable.tab_owner_sl };

	private TextView mTextViewTitle;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 从XML获取 选项卡文字
		mTabTextArray = this.getResources().getStringArray(R.array.tab_text);LogUtil.d("initViewPager ok");
		initView();
		LogUtil.d("onCreate ok");
	}

	/**
	 * 初始化组件
	 */
	private void initView() {

		mTextViewTitle = (TextView) findViewById(R.id.tv_title);
		initTabHost();
	}

	private void initTabHost() {
		// 找到TabHost

		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		mTabHost.setOnTabChangedListener(this);
		// 得到fragment的个数

		int count = mFragmentArray.length;
		for (int i = 0; i < count; i++) {
			// 给每个Tab按钮设置图标、文字和内容
			TabSpec tabSpec = mTabHost.newTabSpec(mTabTextArray[i])
					.setIndicator(getTabItemView(i));
			// 将Tab按钮添加进Tab选项卡中
			mTabHost.addTab(tabSpec, mFragmentArray[i], null);
			// 设置Tab按钮的背景
			mTabHost.getTabWidget().getChildAt(i)
					.setBackgroundResource(R.drawable.tab_bg_sl);
		}
	}

	/**
	 * 给每个Tab按钮设置图标和文字
	 */
	private View getTabItemView(int index) {
		LayoutInflater mLayoutInflater = LayoutInflater.from(this);
		View view = mLayoutInflater.inflate(R.layout.tab_item_view, null);

		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageArray[index]);
		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTabTextArray[index]);

		return view;
	}

	@Override
	public void onTabChanged(String tabId) {
		mTextViewTitle.setText(tabId);
	}
}
