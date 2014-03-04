package com.bing.myshop;

import java.util.ArrayList;
import java.util.List;

import com.bing.adapter.CarGoodsAdapter;
import com.bing.goodsclass.CarGoods;
import com.bing.interf.AdapterFlag;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.app.Activity;
import android.content.Intent;

public class WaitEvaluate extends Activity implements OnItemClickListener {

	private ListView waitevaluateListView;
	private CarGoodsAdapter waitevlautateAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_wait_evaluate);
		initView();
	}


	private void initView(){
		waitevaluateListView=(ListView)findViewById(R.id.wait_evaluate_listview);
		waitevlautateAdapter=new CarGoodsAdapter(this, getList());
		waitevaluateListView.setAdapter(waitevlautateAdapter);
		waitevaluateListView.setOnItemClickListener(this);
	}

	private List<CarGoods> getList(){
		List<CarGoods> list=new ArrayList<CarGoods>();
		for (int i = 0; i < 10; i++) {
			CarGoods mCarGoods=new CarGoods();
			mCarGoods.setGoodsinfo("bing");
			mCarGoods.setActivityname(AdapterFlag.WAIT_EVALUATE);
			list.add(mCarGoods);
		}
		return list;
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		intent.setClass(WaitEvaluate.this, UserEvaluate.class);
		startActivity(intent);
	}
	
}
