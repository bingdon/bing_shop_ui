package com.bing.adapter;

import java.util.List;

import com.bing.goodsclass.CarGoods;
import com.bing.interf.AdapterFlag;
import com.bing.myshop.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * 多重复用容器
 * @author lyl
 *
 */
public class CarGoodsAdapter extends BaseAdapter{

	private List<CarGoods> list;
	private LayoutInflater inflater;
	
	private final class ViewHolder{
		//商品图片
		public ImageView goodsIma;
		public RelativeLayout leftbutton;
		public RelativeLayout rightbutton;
		public TextView lefttxt;
		public TextView righttxt;
		public TextView goodstag;
		public TextView goodnai;
	}
	
	
	public CarGoodsAdapter(Context context,List<CarGoods> list){
		this.list=list;
		this.inflater=LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		if (convertView==null) {
			viewHolder=new ViewHolder();
			convertView=inflater.inflate(R.layout.cargoodslist, null);
			viewHolder.goodnai=(TextView)convertView.findViewById(R.id.goodsname);
			viewHolder.leftbutton=(RelativeLayout)convertView.findViewById(R.id.cargo_left_layout);
			viewHolder.rightbutton=(RelativeLayout)convertView.findViewById(R.id.cargo_right_layout);
			viewHolder.lefttxt=(TextView)convertView.findViewById(R.id.cargolefttxt);
			viewHolder.righttxt=(TextView)convertView.findViewById(R.id.cargorighttxt);
			convertView.setTag(viewHolder);
		} else {
			viewHolder=(ViewHolder)convertView.getTag();
		}
		judeActivity(list.get(position).getActivityname(), viewHolder, position);
		viewHolder.goodnai.setText((String)list.get(position).getGoodsinfo());
		
		return convertView;
	}

	private void judeActivity(int id,ViewHolder viewHolder,int position){
		
		switch (id) {
		case AdapterFlag.ALLORDER:
			
			break;
			
		case AdapterFlag.WAIT_RECE:
			viewHolder.leftbutton.setBackgroundResource(R.drawable.wake_send);
			viewHolder.rightbutton.setBackgroundResource(R.drawable.wake_send);
			viewHolder.lefttxt.setText("查看物流");
			viewHolder.righttxt.setText("确认收货");
			break;
			
		case AdapterFlag.WAIT_PAY:
	
			break;
	
		case AdapterFlag.WAIT_SENDED:
			viewHolder.rightbutton.setBackgroundResource(R.drawable.wake_send);
			viewHolder.lefttxt.setText("已付款");
			viewHolder.righttxt.setText("提醒发货");
			break;

		case AdapterFlag.WAIT_EVALUATE:
			viewHolder.leftbutton.setBackgroundResource(R.drawable.wake_send);
			viewHolder.rightbutton.setBackgroundResource(R.drawable.wake_send);
			viewHolder.lefttxt.setText("交易成功");
			viewHolder.righttxt.setText("评价");
			break;
			
		case AdapterFlag.BACK_PAY:
			viewHolder.leftbutton.setBackgroundResource(R.drawable.wake_send);
			viewHolder.rightbutton.setBackgroundResource(R.drawable.wake_send);
			viewHolder.lefttxt.setText("交易成功");
			viewHolder.righttxt.setText("申请退款");
			break;
		default:
			break;
		}
		
	}
	
}
