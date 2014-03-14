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
import android.widget.ProgressBar;
import android.widget.TextView;
/**
 * 鑱婂ぉ閫傞厤鍣�
 * @author lyl
 *
 */
public class ChatAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private List<Map<String, Object>> list;
	
	private class ViewHolder{
		ImageView userhead;
		TextView time;
		TextView word;
		ProgressBar sendPro;
	}
	
	public ChatAdapter(Context context,List<Map<String, Object>> list){
		this.list=list;
		inflater=LayoutInflater.from(context);
				
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
			viewHolder=new ViewHolder();
			if (arg1==null) {
				if (list.get(arg0).equals("IN")) {
					arg1=inflater.inflate(R.layout.chat_in_layout, null);
					viewHolder.userhead=(ImageView)arg1.findViewById(R.id.chat_in_user_head_ima);
					viewHolder.time=(TextView)arg1.findViewById(R.id.chat_in_date_txt);
					viewHolder.word=(TextView)arg1.findViewById(R.id.chat_in_word_txt);
					viewHolder.sendPro=(ProgressBar)arg1.findViewById(R.id.chat_in_pro);
					arg1.setTag(viewHolder);
					
				} else {
					arg1=inflater.inflate(R.layout.chat_out_layout, null);
					viewHolder.userhead=(ImageView)arg1.findViewById(R.id.chat_out_user_head_ima);
					viewHolder.time=(TextView)arg1.findViewById(R.id.chat_out_date_txt);
					viewHolder.word=(TextView)arg1.findViewById(R.id.chat_out_word_txt);
					viewHolder.sendPro=(ProgressBar)arg1.findViewById(R.id.chat_out_pro);
					arg1.setTag(viewHolder);
					
				}
			} else {
				viewHolder=(ViewHolder)arg1.getTag();
			}
			
			viewHolder.time.setText((String)list.get(arg0).get("gettime"));
			viewHolder.word.setText((String)list.get(arg0).get("getwords"));
		
		return arg1;
	}

}
