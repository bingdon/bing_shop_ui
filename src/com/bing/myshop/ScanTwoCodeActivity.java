package com.bing.myshop;

import com.bing.view.ScanView;
import com.bing.zxingcamera.CameraManager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

public class ScanTwoCodeActivity extends Activity {

	private ScanView scanView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_scan_two_code);
		
		CameraManager.init(getApplication());
		
		scanView=(ScanView)findViewById(R.id.scanView1);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scan_two_code, menu);
		return true;
	}

}
