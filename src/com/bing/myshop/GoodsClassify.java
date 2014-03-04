package com.bing.myshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.adapter.MoreAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class GoodsClassify extends Activity implements OnItemClickListener {

	private ListView classifyList;
	private MoreAdapter classifyAdapter;
	private String[] feiliestr={"休闲","运动","正式","犹豫"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_goods_classify);
		initView();
	}


	private void initView(){
		classifyList=(ListView)findViewById(R.id.goodsclassesify_list);
		classifyAdapter=new MoreAdapter(this, getlist());
		classifyList.setAdapter(classifyAdapter);
		
		classifyList.setOnItemClickListener(this);
		
	}
	
	private List<Map<String, Object>> getlist(){
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		int length=feiliestr.length;
		for (int i = 0; i < length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();   
			map.put("morename", feiliestr[i]);
			list.add(map);
		}
		return list;
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		intent.setClass(GoodsClassify.this, BaoBeiList.class);
		startActivity(intent);
	}
	
}
