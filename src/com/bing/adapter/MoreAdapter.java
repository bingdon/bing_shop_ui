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

public class MoreAdapter extends BaseAdapter{

	private LayoutInflater listContainer; 
	private List<Map<String, Object>> listItems; 
	
	public final class ViewHoder{
		TextView morname;
		ImageView tag;
	}
	
	public MoreAdapter(Context context,List<Map<String, Object>> list){
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
			convertView=listContainer.inflate(R.layout.morelist, null);
			viewHoder.morname=(TextView)convertView.findViewById(R.id.morname);
			convertView.setTag(viewHoder);
		} else {
			viewHoder=(ViewHoder)convertView.getTag();
		}
		
		viewHoder.morname.setText((String)listItems.get(position).get("morename"));
		return convertView;
	}

}
