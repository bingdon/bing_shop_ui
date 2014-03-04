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

public class EvaluateInfoAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private List<Map<String, Object>> list;
	
	private class ViewHolder{
		ImageView userHead;
		TextView username;
		TextView userevaluate;
		TextView goodsinfo;
		TextView date;
	}
	
	public EvaluateInfoAdapter(Context context,List<Map<String, Object>> list){
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
			arg1=inflater.inflate(R.layout.evaluateinfo_list, null);
			viewHolder.userHead=(ImageView)arg1.findViewById(R.id.evaluate_user_head_ima);
			viewHolder.username=(TextView)arg1.findViewById(R.id.evaluate_user_name);
			viewHolder.userevaluate=(TextView)arg1.findViewById(R.id.evaluate_user_main_txt);
			viewHolder.goodsinfo=(TextView)arg1.findViewById(R.id.evaluate_goodsinfo_txt);
			viewHolder.date=(TextView)arg1.findViewById(R.id.evaluate_goodsinfo_date);
			arg1.setTag(viewHolder);
		} else {
			viewHolder=(ViewHolder)arg1.getTag();
		}
		
		
		
		return arg1;
	}

}
