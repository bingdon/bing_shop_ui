package com.bing.myshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.adapter.MoreAdapter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MoreFra extends Fragment{

	private ListView morelist;
	private MoreAdapter moreAdapter;
	private String[] morstr={"版本信息","意见反馈","使用帮助","清空缓存"
			};
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initView();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View fr0v=inflater.inflate(R.layout.moretab, null, false);
		
		return fr0v;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	
	private void initView(){
		morelist=(ListView)getActivity().findViewById(R.id.morelist);
		moreAdapter=new MoreAdapter(getActivity(), getlist());
		morelist.setAdapter(moreAdapter);
	}
	
	private List<Map<String, Object>> getlist(){
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		int length=morstr.length;
		for (int i = 0; i < length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();   
			map.put("morename", morstr[i]);
			list.add(map);
		}
		return list;
	}
	

}
