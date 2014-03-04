package com.bing.adapter;

import java.util.List;

import com.bing.goodsclass.AttStoreInfo;
import com.bing.myshop.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AttStoreAdapter extends BaseAdapter{

	private LayoutInflater inflater;
	private List<AttStoreInfo> list;
	
	private class ViewHolder{
		//商店图片
		public ImageView  storeHead;
		public TextView storename;
		public ImageView storelevel;
		public RelativeLayout storestate;
		public TextView storestatetxt;
	}
	
	public AttStoreAdapter(Context context,List<AttStoreInfo> list){
		inflater=LayoutInflater.from(context);
		this.list=list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		if (arg1==null) {
			viewHolder=new ViewHolder();
			arg1=inflater.inflate(R.layout.attstore_list_layout, null);
			viewHolder.storeHead=(ImageView)arg1.findViewById(R.id.attstore_list_atthead);
			viewHolder.storename=(TextView)arg1.findViewById(R.id.attstore_list_attstroename_txt);
			viewHolder.storestate=(RelativeLayout)arg1.findViewById(R.id.attstore_list_canle_layout);
			viewHolder.storestatetxt = (TextView)arg1.findViewById(R.id.attstore_list_canle_txt);
			arg1.setTag(viewHolder);
		} else {
			viewHolder =(ViewHolder)arg1.getTag(); 
		}
		
//		viewHolder.storename.setText(list.get(arg0).getAttStorename());
		
		
		return arg1;
	}

}
