package com.bing.myshop;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.app.Activity;

public class UserEvaluate extends Activity implements OnClickListener {

	private RelativeLayout haopingLayout;
	
	private RelativeLayout chapingLayout;
	
	private RelativeLayout zhongpingLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_user_evaluate);
		
		initView();
		
	}

	private void initView(){
		haopingLayout=(RelativeLayout)findViewById(R.id.user_evaluate_haoping_layout);
		zhongpingLayout=(RelativeLayout)findViewById(R.id.user_evaluate_zhongping_layout);
		chapingLayout=(RelativeLayout)findViewById(R.id.user_evaluate_chaping_layout);
		
		haopingLayout.setOnClickListener(this);
		zhongpingLayout.setOnClickListener(this);
		chapingLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch (arg0.getId()) {
		case R.id.user_evaluate_haoping_layout:
			haopingLayout.setBackgroundResource(R.drawable.baobeilisttabbar_sec);
			zhongpingLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			chapingLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			
			break;

		case R.id.user_evaluate_zhongping_layout:
			haopingLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			zhongpingLayout.setBackgroundResource(R.drawable.baobeilisttabbar_sec);
			chapingLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			break;
			
		case R.id.user_evaluate_chaping_layout:
			haopingLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			zhongpingLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			chapingLayout.setBackgroundResource(R.drawable.baobeilisttabbar_sec);
			break;
			
		default:
			break;
		}
		
	}
	
}
