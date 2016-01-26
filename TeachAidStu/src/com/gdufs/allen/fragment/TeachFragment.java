package com.gdufs.allen.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.allen.teachaidstu.R;

/**
 * @author Allen Lin
 * @date 2016-1-26
 * @desc 我的教辅
 */
public class TeachFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment1, null);
	}

}
