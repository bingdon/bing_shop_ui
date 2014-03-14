package com.bing.myshop;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
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
	/**
	 * 等待界面
	 */
	private ProgressDialog mDialog;
	
	private boolean FLAG=false;
	
	private int count=0;
	/**
	 * 用户名
	 */
	private EditText usernameedit;
	/**
	 * 密码
	 */
	private EditText passwordedit;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	
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
		usernameedit=(EditText)findViewById(R.id.login_number_edit);
		passwordedit=(EditText)findViewById(R.id.login_password_edit);
		loginLayout.setOnClickListener(this);
		passwordfindLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login_bel_layout:
			attempLogin();
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
	/**
	 * 登陆成功
	 */
	public void loginSucces(){
		Intent intent=new Intent();
		intent.setClass(LoginActivity.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
	
	Runnable loginRunnable=new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (!FLAG) {
				
				if (count>5) {
					FLAG=true;
					Message msg=new Message();
					msg.what=0;
					loginHandler.sendMessage(msg);
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				count++;
				
			}
		}
	};
	
	
	private Handler loginHandler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			int what=msg.what;
			switch (what) {
			case 0:
				Log.i("登陆:", "标志:"+FLAG);
				if (FLAG) {
					mDialog.dismiss();
					loginSucces();
				}
				break;

			default:
				break;
			}
			
			super.handleMessage(msg);
		}
		
		
		
	};
	
	
	public void attempLogin(){
		usernameedit.setError(null);
		passwordedit.setError(null);
		username=usernameedit.getText().toString();
		password=passwordedit.getText().toString();
		
		if (TextUtils.isEmpty(username)) {
			usernameedit.setError("用户名不能为空");
		}
		
		if (TextUtils.isEmpty(password)) {
			passwordedit.setError("密码不能为空");
		}
		
		if (!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(password)) {
			Log.i("登陆", "username:"+username+"password:"+password);
			mDialog=ProgressDialog.show(LoginActivity.this, "登陆", "请稍后...");
			new Thread(loginRunnable).start();
		}
		
	}
	
}
