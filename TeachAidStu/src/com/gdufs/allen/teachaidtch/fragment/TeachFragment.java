package com.gdufs.allen.teachaidtch.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.gdufs.allen.teachaidtch.R;
import com.gdufs.allen.teachaidtch.util.LogUtil;

/**
 * @author Allen Lin
 * @date 2016-1-26
 * @desc 我的教辅
 */
public class TeachFragment extends Fragment {
	private static final String TAG = "TeachFragment";
	// viewpager
	private ViewPager viewPager;
	// fragment对象集合
	private ArrayList<Fragment> fragmentsList;
	// 指示器
	private ImageView down_line;
	private int currentIndex = 0;
	// 指示器的偏移量
	private int offset = 0;
	// 屏幕宽度的四分之一
	private int screen1_4;
	private LinearLayout.LayoutParams lp;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_teach, null);
		viewPager = (ViewPager) v.findViewById(R.id.viewpager);
		down_line = (ImageView) v.findViewById(R.id.down_line);
		lp = (LayoutParams) down_line.getLayoutParams();
		initViewPager();
		return v;
	}

	/** 初始化viewPager */
	private void initViewPager() {

		LogUtil.d("initViewPager2");
		// viewPager = (ViewPager) findViewById(R.id.viewpager);
		fragmentsList = new ArrayList<Fragment>();

		RollcallFragment mRollcallFragment = new RollcallFragment();
		AskFragment mAskFragment = new AskFragment();
		HomeworkFragment mHomeworkFragment = new HomeworkFragment();
		DataFragment mDataFragment = new DataFragment();
		fragmentsList.add(mRollcallFragment);
		fragmentsList.add(mAskFragment);
		fragmentsList.add(mHomeworkFragment);
		fragmentsList.add(mDataFragment);

		viewPager.setAdapter(new FragmentAdapter(getActivity()
				.getSupportFragmentManager(), fragmentsList));

		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {

				if (position == 0) {// 0<->1
					lp.leftMargin = (int) (positionOffsetPixels / 4) + offset;
				} else if (position == 1) {// 1<->2
					lp.leftMargin = (int) (positionOffsetPixels / 4)
							+ screen1_4 + offset;
				} else if (position == 2) {// 1<->2
					lp.leftMargin = (int) (positionOffsetPixels / 4) + 2
							* screen1_4 + offset;
				}
				down_line.setLayoutParams(lp);
				currentIndex = position;
			}

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

			}

		});
		LogUtil.d("initViewPager ok");
	}
}
