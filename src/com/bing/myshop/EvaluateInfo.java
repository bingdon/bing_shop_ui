package com.bing.myshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.adapter.BingPagerAdapter;
import com.bing.adapter.EvaluateInfoAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.widget.ListView;
/**
 * 评价详情
 * @author lyl
 *
 */
public class EvaluateInfo extends Activity {

	/**
	 * 评价列表
	 */
	private ListView evaluateList;
	/**
	 * 显示容器
	 */
	private EvaluateInfoAdapter evaluateInfoAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_evaluate_info);
		
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.evaluate_info, menu);
		return true;
	}

	private void initView(){
		evaluateList=(ListView)findViewById(R.id.evaluateinfo_listview);
		evaluateInfoAdapter=new EvaluateInfoAdapter(EvaluateInfo.this, getlist());
		evaluateList.setAdapter(evaluateInfoAdapter);
	}
	
	private List<Map<String, Object>> getlist(){
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();   
			map.put("username", "bing");
			list.add(map);
		}
		return list;
	}
	
}
