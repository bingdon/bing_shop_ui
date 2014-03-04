package com.bing.myshop;

import com.bing.interf.AdapterFlag;

import android.app.Fragment;
import android.content.Intent;
import android.location.GpsStatus.Listener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 我的 
 * @author lyl
 *
 */
public class UserFra extends Fragment implements OnClickListener{

	//我的收货地址
	private TextView myreciveaddress;
	private RelativeLayout mLayout;
	/**
	 * 下发四个按钮
	 */
	private ImageView user_all_oder,user_wait_goods,user_wait_pay,
			user_wait_sended,userchatImageView;
	
	private LinearLayout my_re_address;
	/**
	 * 四个列表
	 */
	private RelativeLayout wait_evaluate_layout,back_pay_layout,
			pay_bao_layout,coomera_foucs_layout;
	/**
	 * 收藏按钮
	 */
	private ImageView shoucangView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View fr0v=inflater.inflate(R.layout.user_layout, null, false);
		
		return fr0v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		initView();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
//		initView();
	}

	public void initView(){
//		my_re_address=(LinearLayout)getActivity().findViewById(R.id.user_my_re_address_layout);
		shoucangView=(ImageView)getActivity().findViewById(R.id.shoucangima);
		myreciveaddress=(TextView)getActivity().findViewById(R.id.user_my_re_address);
		userchatImageView=(ImageView)getActivity().findViewById(R.id.usearchat);
		user_all_oder=(ImageView)getActivity().findViewById(R.id.user_all_order);
		user_wait_goods=(ImageView)getActivity().findViewById(R.id.user_wait_goods);
		user_wait_pay=(ImageView)getActivity().findViewById(R.id.user_wait_pay);
		user_wait_sended=(ImageView)getActivity().findViewById(R.id.user_wait_sended);
		
		wait_evaluate_layout=(RelativeLayout)getActivity().findViewById(R.id.wait_evaluate_layout);
		back_pay_layout=(RelativeLayout)getActivity().findViewById(R.id.back_pay_layout);
		pay_bao_layout=(RelativeLayout)getActivity().findViewById(R.id.pay_bao_layout);
		coomera_foucs_layout=(RelativeLayout)getActivity().findViewById(R.id.coomera_foucs_layout);
		
		shoucangView.setOnClickListener(this);
		myreciveaddress.setOnClickListener(this);
		userchatImageView.setOnClickListener(this);
//		my_re_address.setOnClickListener(this);
		user_all_oder.setOnClickListener(this);
		user_wait_goods.setOnClickListener(this);
		user_wait_pay.setOnClickListener(this);
		user_wait_sended.setOnClickListener(this);
		
		
		wait_evaluate_layout.setOnClickListener(this);
		back_pay_layout.setOnClickListener(this);
		pay_bao_layout.setOnClickListener(this);
		coomera_foucs_layout.setOnClickListener(this);
		
		Log.i(getTag(), "启动"+user_all_oder.getId());
		Toast.makeText(getActivity(), "启动", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.i(getTag(), "启动");
		switch (v.getId()) {
		
		case R.id.shoucangima:
			enterNewActivity(AdapterFlag.SHOUCANG);
			break;
		
		case R.id.user_my_re_address:
			Intent intent=new Intent();
			intent.setClass(getActivity(), DeliverAddress.class);
			startActivity(intent);
			
			break;
			

		case R.id.usearchat:
			enterNewActivity(AdapterFlag.CHATVIEW);
			Toast.makeText(getActivity(), "触摸", Toast.LENGTH_LONG).show();
			break;
			
		case R.id.user_all_order:
			Toast.makeText(getActivity(), "触摸", Toast.LENGTH_LONG).show();
			enterNewActivity(AdapterFlag.ALLORDER);
			break;
			
		case R.id.user_wait_goods:
			Toast.makeText(getActivity(), "触摸", Toast.LENGTH_LONG).show();
			enterNewActivity(AdapterFlag.WAIT_RECE);
			break;
			
		case R.id.user_wait_pay:
			Toast.makeText(getActivity(), "触摸", Toast.LENGTH_LONG).show();
			enterNewActivity(AdapterFlag.WAIT_PAY);
			break;
			
		case R.id.user_wait_sended:
			Toast.makeText(getActivity(), "触摸", Toast.LENGTH_LONG).show();
			enterNewActivity(AdapterFlag.WAIT_SENDED);
			break;
			
		case R.id.user_my_re_address_layout:
			Intent intent1=new Intent();
			intent1.setClass(getActivity(), DeliverAddress.class);
			startActivity(intent1);
			break;
			
		case R.id.wait_evaluate_layout:
			enterNewActivity(AdapterFlag.WAIT_EVALUATE);
			break;
			
		case R.id.back_pay_layout:
			enterNewActivity(AdapterFlag.BACK_PAY);
			break;
			
		case R.id.pay_bao_layout:
			
			break;
			
		case R.id.coomera_foucs_layout:
			enterNewActivity(AdapterFlag.ATT_STORE);
			break;
			
		default:
			break;
		}
	}
	
	
	private void enterNewActivity(int id){
		Intent intent=new Intent();
		switch (id) {
		case AdapterFlag.ALLORDER:
			intent.setClass(getActivity(), MyAllOrder.class);
			break;

		case AdapterFlag.WAIT_RECE:
			intent.setClass(getActivity(), WaitRecevieGoods.class);
			break;
			
		case AdapterFlag.WAIT_PAY:
			intent.setClass(getActivity(), WaitPay.class);
			break;
			
		case AdapterFlag.WAIT_SENDED:
			intent.setClass(getActivity(), WaitGoSen.class);
			break;
			
		case AdapterFlag.ATT_STORE:
			intent.setClass(getActivity(), AttStore.class);
			break;
			
		case AdapterFlag.WAIT_EVALUATE:
			intent.setClass(getActivity(), WaitEvaluate.class);
			
			break;
			
		case AdapterFlag.SHOUCANG:
			
			intent.setClass(getActivity(), UserShoucang.class);
			break;
			
		case AdapterFlag.BACK_PAY:
			intent.setClass(getActivity(), UserBackPay.class);
			break;
			
		case AdapterFlag.CHATVIEW:
			intent.setClass(getActivity(), ChatActivity.class);
			break;
			
		default:
			break;
		}
		
		startActivity(intent);
	}
	

}
