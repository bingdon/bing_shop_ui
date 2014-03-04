package com.bing.adapter;

import java.util.List;
import java.util.Map;

import com.bing.myshop.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AddressAdapter extends BaseAdapter{
	private LayoutInflater listContainer; 
	private List<Map<String, Object>> listItems; 
	
	public final class ViewHoder{
		TextView username;
		TextView userrecvads;
		TextView userrecvadsinfo;
		ImageView tag;
	}
	
	public AddressAdapter(Context context,List<Map<String, Object>> list){
		this.listContainer=LayoutInflater.from(context);
		this.listItems=list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHoder viewHoder;
		if (convertView==null) {
			viewHoder=new ViewHoder();
			convertView=listContainer.inflate(R.layout.address_list, null);
			viewHoder.username=(TextView)convertView.findViewById(R.id.hhotsgoodstxt);
			convertView.setTag(viewHoder);
		} else {
			viewHoder=(ViewHoder)convertView.getTag();
		}
		
		viewHoder.username.setText((String)listItems.get(position).get("username"));
		return convertView;
	}

}
