package com.bing.myshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.adapter.AddressAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class DeliverAddress extends Activity {
	private ListView myaddressListView;
	private AddressAdapter mAddressAdapter;
	private String[] usernames={"啊我额","啊我额","义务与","一二三"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_deliver_address);
		initView();
	}

	private void initView(){
		myaddressListView=(ListView)findViewById(R.id.addresslist);
		mAddressAdapter=new AddressAdapter(this, getlist());
		myaddressListView.setAdapter(mAddressAdapter);
		
		myaddressListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(DeliverAddress.this, AddressInfo.class);
				startActivity(intent);
			}
		});
		
	}
	private List<Map<String, Object>> getlist(){
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		int length=usernames.length;
		for (int i = 0; i < length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();   
			map.put("username", usernames[i]);
			list.add(map);
		}
		return list;
	}
}
