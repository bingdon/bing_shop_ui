package com.bing.adapter;

import java.util.List;
import java.util.Map;

import com.bing.myshop.HomeFra;
import com.bing.myshop.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BaobeiListAdapter extends BaseAdapter{
	private LayoutInflater listContainer; 
	private List<Map<String, Object>> listItems; 
	
	public final class ViewHoder{
		TextView goodsname;//商品名称
		TextView goodsprice;//商品标价
		TextView sales;//销量
		ImageView goodima;//商品图片
		ImageView goodhonor;//商品级别
		RelativeLayout goodtagLayout;//商品签
	}
	
	public BaobeiListAdapter(Context context,List<Map<String, Object>> list){
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
			convertView=listContainer.inflate(R.layout.baobeiladapterlist, null);
			viewHoder.goodsname=(TextView)convertView.findViewById(R.id.baobeiadapter_baobei_name_txt);
			viewHoder.sales=(TextView)convertView.findViewById(R.id.baobeiadapter_baobei_sales_txt);
			viewHoder.goodsprice=(TextView)convertView.findViewById(R.id.baobeiadapter_baobei_price_txt);
			viewHoder.goodima=(ImageView)convertView.findViewById(R.id.baobeiadapter_baobei_head);
			viewHoder.goodhonor=(ImageView)convertView.findViewById(R.id.baobeiadapter_baobei_honor_ima);
			viewHoder.goodtagLayout=(RelativeLayout)convertView.findViewById(R.id.baobeiadaoter_goods_tag_layout);
			convertView.setTag(viewHoder);
		} else {
			viewHoder=(ViewHoder)convertView.getTag();
		}
		if (HomeFra.TAG==0) {
			viewHoder.goodtagLayout.setVisibility(View.INVISIBLE);
		}
		
//		viewHoder.goodsname.setText((String)listItems.get(position).get("goodsname"));
		return convertView;
	}
}
