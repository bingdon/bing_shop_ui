package com.bing.myshop;

import java.util.ArrayList;
import java.util.List;

import com.bing.adapter.CarGoodsAdapter;
import com.bing.goodsclass.CarGoods;
import com.bing.interf.AdapterFlag;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;
import android.widget.ListView;

public class UserBackPay extends Activity {

	/**
	 * 退款列表
	 */
	private ListView bakpayListView;
	/**
	 * 适配器
	 */
	private CarGoodsAdapter backpayAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_user_back_pay);
		
		initView();
	}

	
	private void initView(){
		bakpayListView=(ListView)findViewById(R.id.user_back_pay_listview);
		backpayAdapter=new CarGoodsAdapter(this, getList());
		bakpayListView.setAdapter(backpayAdapter);
		
		
	}

	private List<CarGoods> getList(){
		List<CarGoods> list=new ArrayList<CarGoods>();
		for (int i = 0; i < 10; i++) {
			CarGoods mCarGoods=new CarGoods();
			mCarGoods.setActivityname(AdapterFlag.BACK_PAY);
			mCarGoods.setGoodsinfo("bing");
			list.add(mCarGoods);
		}
		return list;
	}
	
}
