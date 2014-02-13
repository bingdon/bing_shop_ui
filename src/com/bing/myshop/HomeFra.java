package com.bing.myshop;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.bing.adapter.BingPagerAdapter;
import com.bing.untils.FixedSpeedScroller;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomeFra extends Fragment implements OnClickListener{
	//图片循环播放页
	private ViewPager mPager;
	//图片view
	private View view0,view1,view2,view3;
	//view合集
	private List<View> picList=new ArrayList<View>();
	//播放指示view
	private ViewGroup group;
	//切换原点
	private ImageView[] imageViews;
	//焦点原点
	private ImageView imageView;
	//线程运行标志
	private boolean taskflag=false;
	//改变播放速度
	FixedSpeedScroller mScroller;
	
	private ImageView hotgoods,searchView;
	
	@SuppressLint("NewApi")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		initView();
		initMv();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View fr0v=inflater.inflate(R.layout.home_layout, null, false);
		
		return fr0v;
	}

	@SuppressLint("NewApi")
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	private void initMv(){
		hotgoods=(ImageView)getActivity().findViewById(R.id.hotestgoods);
		searchView=(ImageView)getActivity().findViewById(R.id.searchview);
		hotgoods.setOnClickListener(this);
		searchView.setOnClickListener(this);
	}
 	
	
	private void initView(){
		mPager=(ViewPager)getActivity().findViewById(R.id.picpager);
		
		LayoutInflater layoutInflater=getActivity().getLayoutInflater();
		
		view0=layoutInflater.inflate(R.layout.picauto, null, false);
		view1=layoutInflater.inflate(R.layout.picauto, null, false);
		view2=layoutInflater.inflate(R.layout.picauto, null, false);
		view3=layoutInflater.inflate(R.layout.picauto, null, false);
		
		picList.add(view0);
		picList.add(view1);
		picList.add(view2);
		picList.add(view3);
		
		mPager.setAdapter(new BingPagerAdapter(picList));
		
		mPager.setCurrentItem(0);
		
		pointslid();
		
		mPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < imageViews.length; i++) {
					imageViews[arg0]
							.setBackgroundResource(R.drawable.page_indicator_focused);
					if (arg0 != i) {
						imageViews[i]
								.setBackgroundResource(R.drawable.page_indicator_unfocused);
					}
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		taskflag=true;
		setSpeed();
		AutopicTask mAutopicTask=new AutopicTask();
		mAutopicTask.execute(0);
		
		
	}
	/**
	 * 初始化小点
	 */
	public void pointslid(){
		
		group=(ViewGroup)getActivity().findViewById(R.id.point_line);
		
		/**
		 * �м���ͼƬ �������ʾ����СԲ��
		 */
		imageViews=new ImageView[picList.size()];
		for (int i = 0; i < picList.size(); i++) {
			LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			//����ÿ��СԲ�������ߵļ��
			margin.setMargins(10, 0, 0, 0);
			imageView = new ImageView(getActivity());
			//����ÿ��СԲ��Ŀ��
			imageView.setLayoutParams(new LayoutParams(15, 15));
			imageViews[i] = imageView;
			if (i == 0) {
				// Ĭ��ѡ�е�һ��ͼƬ
				imageViews[i]
						.setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				//����ͼƬ������δѡ��״̬
				imageViews[i]
						.setBackgroundResource(R.drawable.page_indicator_unfocused);
			}
			group.addView(imageViews[i], margin);
		}
	}
	/**
	 * 播放任务
	 * @author lyl
	 *
	 */
	class AutopicTask extends AsyncTask<Integer, Integer, Integer>{

		@Override
		protected Integer doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			int id=0;
			
			while (taskflag) {
				
				
				Log.i("Fra0", "运行:"+id);
				
				publishProgress(id);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				id=params[0]+id+1;
				if (id>3) {
					id=0;
					mScroller.setmDuration(0);
					
				}else {
					if (mScroller.getDuration()==0) {
						mScroller.setmDuration(1000);
					}
				}
				
			}
			
			return id;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			
			mPager.setCurrentItem(values[0]);
			
		}
		
	}
	
	/**
	 * 切换速度
	 */
	public void setSpeed(){
		try {  
            Field mField = ViewPager.class.getDeclaredField("mScroller");  
            mField.setAccessible(true);  
            mScroller = new FixedSpeedScroller(mPager.getContext(),  
                    new AccelerateInterpolator());  
            //可以用setDuration的方式调整速率  
            //mScroller.setmDuration(10000);  
            mField.set(mPager, mScroller);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.hotestgoods:
			looperActivity(0);
			break;
			
		case R.id.searchview:
			looperActivity(1);
			break;

		default:
			break;
		}
	}

	public void looperActivity(int posion){
		Intent intent=new Intent();
		switch (posion) {
		case 0:
			intent.setClass(getActivity(),HotsGoodsActivity.class);
			break;
			
		case 1:
			intent.setClass(getActivity(),SearchActivity.class);
			break;

		default:
			break;
		}
		
		startActivity(intent);
	}
	
	
	
}
