package com.bing.myshop;

import java.util.ArrayList;
import java.util.List;

import com.bing.adapter.CarGoodsAdapter;
import com.bing.goodsclass.CarGoods;
import com.bing.interf.AdapterFlag;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.widget.ListView;

public class WaitRecevieGoods extends Activity {

	private ListView waitrelist;
	private CarGoodsAdapter waitreAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_wait_recevie_goods);
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wait_recevie_goods, menu);
		return true;
	}

	private void initView(){
		waitrelist=(ListView)findViewById(R.id.wait_re_go_list);
		waitreAdapter=new CarGoodsAdapter(this, getList());
		waitrelist.setAdapter(waitreAdapter);
	}
	
	
	private List<CarGoods> getList(){
		List<CarGoods> list=new ArrayList<CarGoods>();
		for (int i = 0; i < 10; i++) {
			CarGoods mCarGoods=new CarGoods();
			mCarGoods.setGoodsinfo("bing");
			mCarGoods.setActivityname(AdapterFlag.WAIT_RECE);
			list.add(mCarGoods);
		}
		return list;
	}
}
