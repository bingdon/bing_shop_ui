package com.bing.myshop;

import java.util.ArrayList;
import java.util.List;

import com.bing.adapter.CarGoodsAdapter;
import com.bing.goodsclass.CarGoods;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MyShopCar extends Fragment{

	private ListView mygoodslist;
	private CarGoodsAdapter carGoodsAdapter;
//	private List<CarGoods> list=new ArrayList<CarGoods>();
	
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
		View fr0v=inflater.inflate(R.layout.my_shop_car, null, false);
		
		return fr0v;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	private void initView(){
		mygoodslist=(ListView)getActivity().findViewById(R.id.mygoodslist);
		carGoodsAdapter=new CarGoodsAdapter(getActivity(), getList());
		mygoodslist.setAdapter(carGoodsAdapter);
	}
	
	private List<CarGoods> getList(){
		List<CarGoods> list=new ArrayList<CarGoods>();
		for (int i = 0; i < 10; i++) {
			CarGoods mCarGoods=new CarGoods();
			mCarGoods.setGoodsinfo("bing");
			list.add(mCarGoods);
		}
		Log.i(getTag(), "开始:"+list.get(0).getGoodsinfo());
		return list;
	}
	
}
