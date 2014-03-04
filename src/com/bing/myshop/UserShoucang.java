package com.bing.myshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.adapter.ShoucangAdapter;

import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import android.app.Activity;

public class UserShoucang extends Activity {

	private ListView shoucangListView;
	
	private ShoucangAdapter shoucangAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_user_shoucang);
		
		initView();
	}

	private void initView(){
		shoucangListView=(ListView)findViewById(R.id.user_shoucang_listview);
		
		shoucangAdapter=new ShoucangAdapter(this, getlist());
		
		shoucangListView.setAdapter(shoucangAdapter);
	}
	
	private List<Map<String, Object>> getlist(){
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();   
			
			map.put("goodsname", "bing");
			list.add(map);
		}
		return list;
	}
	
}
