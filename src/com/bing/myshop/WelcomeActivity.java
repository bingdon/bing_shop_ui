package com.bing.myshop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		new Thread(new Runnable(){

			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				try
				{
					Thread.sleep(3000);
					Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
					startActivity(intent);
					finish();
					
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}).start();
		
	}


}
