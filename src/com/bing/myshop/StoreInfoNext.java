package com.bing.myshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.adapter.StoreAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.widget.ListView;

public class StoreInfoNext extends Activity {

	private ListView storeinfoList;
	private StoreAdapter storeAdapter;
	private String[] storestr={"所有宝贝","店铺荣誉","店铺掌柜","最新到货"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_store_info_next);
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.store_info_next, menu);
		return true;
	}

	private void initView(){
		storeinfoList=(ListView)findViewById(R.id.store_info_next_all_go_list);
		storeAdapter=new StoreAdapter(this, getlist());
		storeinfoList.setAdapter(storeAdapter);
		
	}
	
	private List<Map<String, Object>> getlist(){
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		int length=storestr.length;
		for (int i = 0; i < length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();   
			map.put("morename", storestr[i]);
			list.add(map);
		}
		return list;
	}
	
}
