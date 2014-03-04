package com.bing.myshop;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	//标签
	private ImageView hometab,shopcartab,
	usertab,moretab;
	//frament管理
	private FragmentManager mFragmentManager;
	//主页
	private HomeFra homeFra;
	//购物车
	private MyShopCar myShopCar;
	//更多
	private MoreFra moreFra;
	//我的
	private UserFra userFra;
	/**
	 * 下标
	 */
	private TextView mhometxt,mshopcartxt,musertxt,mmoretxt;
	
	private int bisque;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		initView();
		
		mFragmentManager=getFragmentManager();
		
		settab(0);
	}

	
	private void settab(int posion) {
		// TODO Auto-generated method stub
		FragmentTransaction transaction=mFragmentManager.beginTransaction();
		
		hidefra(transaction);
		switch (posion) {
		case 0:
			
			if (homeFra==null) {
				homeFra=new HomeFra();
				transaction.add(R.id.tabshow, homeFra);
				
				
			} else {
				transaction.show(homeFra);
			}
			
			break;
			
		case 1:
//			
			if (myShopCar==null) {
				myShopCar=new MyShopCar();
				transaction.add(R.id.tabshow, myShopCar);
				
				
			} else {
				transaction.show(myShopCar);
			}
			
			break;
			
		case 2:
			
			if (userFra==null) {
				userFra=new UserFra();
				transaction.add(R.id.tabshow, userFra);
				
				
			} else {
				transaction.show(userFra);
			}
			
			break;	
			
			
		case 3:
	
			if (moreFra==null) {
				moreFra=new MoreFra();
				transaction.add(R.id.tabshow, moreFra);
				
				
			} else {
				transaction.show(moreFra);
			}
			
			break;
			

		default:
			break;
		}
		
		transaction.commit();
	}


	public void initView(){
		
		bisque=getResources().getColor(R.color.peachpuff);
		hometab=(ImageView)findViewById(R.id.hometab);
		shopcartab=(ImageView)findViewById(R.id.shopcartab);
		usertab=(ImageView)findViewById(R.id.usertab);
		moretab=(ImageView)findViewById(R.id.moretab);
		mhometxt=(TextView)findViewById(R.id.mhometxt);
		musertxt=(TextView)findViewById(R.id.musertxt);
		mshopcartxt=(TextView)findViewById(R.id.mshopcartxt);
		mmoretxt=(TextView)findViewById(R.id.mmoretxt);
		hometab.setOnClickListener(this);
		shopcartab.setOnClickListener(this);
		usertab.setOnClickListener(this);
		moretab.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.hometab:
			settab(0);
			
			hometab.setImageResource(R.drawable.home_tab_sec);
			shopcartab.setImageResource(R.drawable.car_tab);
			usertab.setImageResource(R.drawable.user_tab);
			moretab.setImageResource(R.drawable.more_tab);
			
			mhometxt.setTextColor(bisque);
			mshopcartxt.setTextColor(Color.GRAY);
			musertxt.setTextColor(Color.GRAY);
			mmoretxt.setTextColor(Color.GRAY);
			
			break;
			
		case R.id.shopcartab:
			settab(1);
			
			hometab.setImageResource(R.drawable.home_tab);
			shopcartab.setImageResource(R.drawable.car_tab_sec);
			usertab.setImageResource(R.drawable.user_tab);
			moretab.setImageResource(R.drawable.more_tab);
			
			mhometxt.setTextColor(Color.GRAY);
			mshopcartxt.setTextColor(bisque);
			musertxt.setTextColor(Color.GRAY);
			mmoretxt.setTextColor(Color.GRAY);
			
			break;
			
		case R.id.usertab:
			settab(2);
			
			hometab.setImageResource(R.drawable.home_tab);
			shopcartab.setImageResource(R.drawable.car_tab);
			usertab.setImageResource(R.drawable.user_tab_sec);
			moretab.setImageResource(R.drawable.more_tab);
			
			mhometxt.setTextColor(Color.GRAY);
			mshopcartxt.setTextColor(Color.GRAY);
			musertxt.setTextColor(bisque);
			mmoretxt.setTextColor(Color.GRAY);
			
			break;
	
		case R.id.moretab:
			settab(3);
			
			hometab.setImageResource(R.drawable.home_tab);
			shopcartab.setImageResource(R.drawable.car_tab);
			usertab.setImageResource(R.drawable.user_tab);
			moretab.setImageResource(R.drawable.more_tab_sec);
			
			mhometxt.setTextColor(Color.GRAY);
			mshopcartxt.setTextColor(Color.GRAY);
			musertxt.setTextColor(Color.GRAY);
			mmoretxt.setTextColor(bisque);
			
			break;

		default:
			break;
		}
	}
	
	private void hidefra(FragmentTransaction transaction){
		if (homeFra!=null) {
			transaction.hide(homeFra);
		}
		
		if (myShopCar!=null) {
			transaction.hide(myShopCar);
		}
//		
		if (userFra!=null) {
			transaction.hide(userFra);
		}
		
		if (moreFra!=null) {
			transaction.hide(moreFra);
		}
		
		
		
	}
	
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}
