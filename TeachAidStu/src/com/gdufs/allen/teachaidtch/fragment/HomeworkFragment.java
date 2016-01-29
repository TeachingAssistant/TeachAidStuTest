package com.gdufs.allen.teachaidtch.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gdufs.allen.teachaidtch.R;

/**
 * @author Allen Lin
 * @date 2016-1-26
 * @desc 主页
 */
public class HomeworkFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_teach, null);
	}

}
