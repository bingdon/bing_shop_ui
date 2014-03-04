package com.bing.myshop;

import java.util.ArrayList;
import java.util.List;

import com.bing.adapter.AttStoreAdapter;
import com.bing.goodsclass.AttStoreInfo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class AttStore extends Activity implements OnItemClickListener {

	private ListView attstorelist;
	private AttStoreAdapter attStoreAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_att_store);
		initView();
	}

	
	private void initView(){
		attstorelist=(ListView)findViewById(R.id.attstore_list);
		attStoreAdapter=new AttStoreAdapter(this, getList());
		attstorelist.setAdapter(attStoreAdapter);
		
		attstorelist.setOnItemClickListener(this);
	}

	private List<AttStoreInfo> getList(){
		List<AttStoreInfo> list=new ArrayList<AttStoreInfo>();
		for (int i = 0; i < 10; i++) {
			AttStoreInfo mAttStoreInfo=new AttStoreInfo();
			mAttStoreInfo.setGoodsinfo("bing");
			list.add(mAttStoreInfo);
		}
		return list;
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		intent.setClass(AttStore.this, StoreInfoNext.class);
		startActivity(intent);
	}
	
}
