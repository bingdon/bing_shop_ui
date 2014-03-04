package com.bing.myshop;

import java.util.ArrayList;
import java.util.List;

import com.bing.adapter.CarGoodsAdapter;
import com.bing.goodsclass.CarGoods;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.widget.ListView;

public class MyAllOrder extends Activity {

	private ListView ordeListView;
	
	private CarGoodsAdapter mGoodsAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_my_all_order);
		
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_all_order, menu);
		return true;
	}

	private void initView(){
		ordeListView=(ListView)findViewById(R.id.my_all_ord_list);
		mGoodsAdapter=new CarGoodsAdapter(this, getList());
		ordeListView.setAdapter(mGoodsAdapter);
	}

	private List<CarGoods> getList(){
		List<CarGoods> list=new ArrayList<CarGoods>();
		for (int i = 0; i < 10; i++) {
			CarGoods mCarGoods=new CarGoods();
			mCarGoods.setGoodsinfo("bing");
			list.add(mCarGoods);
		}
		return list;
	}
	
}
