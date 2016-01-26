package com.gdufs.allen.teachaidstu;

import com.gdufs.allen.fragment.HomeFragment;
import com.gdufs.allen.fragment.OwnerFragment;
import com.gdufs.allen.fragment.TeachFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

/**
 * @author Allen Lin
 * @date 2016-1-26
 * @desc app主界面
 */
public class MainActivity extends FragmentActivity {
	private FragmentTabHost mTabHost;
	private Class mFragmentArray[] = { HomeFragment.class, OwnerFragment.class,
			TeachFragment.class };
	/** 存放图片数组 */
	private int mImageArray[] = { R.drawable.tab_home_sl,
			R.drawable.tab_teach_sl, R.drawable.tab_owner_sl };
	/** 选项卡文字 */
	private String mTextArray[] = { "首页", "我的教辅", "个人中心" };

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	/**
	 * 初始化组件
	 */
	private void initView() {
		LayoutInflater mLayoutInflater = LayoutInflater.from(this);
		// 找到TabHost
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		// 得到fragment的个数

		int count = mFragmentArray.length;
		for (int i = 0; i < count; i++) {
			// 给每个Tab按钮设置图标、文字和内容
			TabSpec tabSpec = mTabHost.newTabSpec(mTextArray[i]).setIndicator(
					getTabItemView(i));
			// 将Tab按钮添加进Tab选项卡中
			mTabHost.addTab(tabSpec, mFragmentArray[i], null);
			// 设置Tab按钮的背景
			// mTabHost.getTabWidget().getChildAt(i)
			// .setBackgroundResource(R.drawable.selector_tab_background);
		}
	}

	/**
	 * 
	 * 给每个Tab按钮设置图标和文字
	 */
	private View getTabItemView(int index) {
		LayoutInflater mLayoutInflater = LayoutInflater.from(this);
		View view = mLayoutInflater.inflate(R.layout.tab_item_view, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageArray[index]);
		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTextArray[index]);

		return view;
	}
}
