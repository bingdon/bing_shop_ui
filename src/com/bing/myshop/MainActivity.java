package com.bing.myshop;


import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

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
		hometab=(ImageView)findViewById(R.id.hometab);
		shopcartab=(ImageView)findViewById(R.id.shopcartab);
		usertab=(ImageView)findViewById(R.id.usertab);
		moretab=(ImageView)findViewById(R.id.moretab);
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
			break;
			
		case R.id.shopcartab:
			settab(1);
			break;
			
		case R.id.usertab:
			settab(2);
			break;
	
		case R.id.moretab:
	
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
