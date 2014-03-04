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

public class WaitPay extends Activity {

	private ListView waitpaylist;
	private CarGoodsAdapter waitpayAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_wait_pay);
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wait_pay, menu);
		return true;
	}

	
	private void initView(){
		waitpaylist=(ListView)findViewById(R.id.wait_pay_list);
		waitpayAdapter=new CarGoodsAdapter(this, getList());
		waitpaylist.setAdapter(waitpayAdapter);
		
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
