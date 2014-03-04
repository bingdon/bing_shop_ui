package com.bing.myshop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginActivity extends Activity implements OnClickListener {

	/**
	 * 登陆
	 */
	private RelativeLayout loginLayout;
	/**
	 * 密码找回
	 */
	private RelativeLayout passwordfindLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	
	private void initView(){
		loginLayout=(RelativeLayout)findViewById(R.id.login_bel_layout);
		passwordfindLayout=(RelativeLayout)findViewById(R.id.login_password_find_layout);
		loginLayout.setOnClickListener(this);
		passwordfindLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login_bel_layout:
			Intent intent=new Intent();
			intent.setClass(LoginActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
			break;
			
		case R.id.login_password_find_layout:
			Intent intent2=new Intent();
			intent2.setClass(LoginActivity.this, PasswordFindActivity.class);
			startActivity(intent2);
			break;

		default:
			break;
		}
	}

}
