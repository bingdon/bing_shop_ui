package com.bing.myshop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;

public class BaobeiInfo extends Activity implements OnClickListener {

	/**
	 * 宝贝评价
	 */
	private RelativeLayout baobeievaluate;
	
	private RelativeLayout storeinfoLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_baobei_info);
		
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.baobei_info, menu);
		return true;
	}

	private void initView(){
		baobeievaluate=(RelativeLayout)findViewById(R.id.baobeiinfo_bel3);
		storeinfoLayout=(RelativeLayout)findViewById(R.id.baibeiinfo_bel4);
		
		baobeievaluate.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.baobeiinfo_bel3:
			Intent intent=new Intent();
			intent.setClass(BaobeiInfo.this, EvaluateInfo.class);
			startActivity(intent);
			
			break;

		default:
			break;
		}
	}
	
}
