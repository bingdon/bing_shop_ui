package com.bing.myshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.adapter.BaobeiListAdapter;
import com.bing.adapter.BingPagerAdapter;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

public class BaoBeiList extends Activity implements OnClickListener, OnPageChangeListener {

	/**
	 * 综合
	 */
	private RelativeLayout sumtabLayout;
	/**
	 * 销量
	 */
	private RelativeLayout salestabLayout;
	/**
	 * 价格
	 */
	private RelativeLayout pricetabLayout;
	/**
	 * 荣誉
	 */
	private RelativeLayout honortabLayout;
	/**
	 * 综合
	 */
	private final int SUM=0;
	/**
	 * 销量
	 */
	private final int SALES=1;
	/**
	 * 价格
	 */
	private final int PRICE=2;
	/**
	 * 荣誉
	 */
	private final int HONOR=3;
	/**
	 * 加载列表
	 */
	private ViewPager baobeilistPager;
	/**
	 * 综合排序view
	 */
	private View sumView;
	/**
	 * 销量排序view
	 */
	private View salesView;
	/**
	 * 价格排序view
	 */
	private View priceView;
	/**
	 * 荣誉排序view
	 */
	private View honorView;
	
	private List<View> pagerViews=new ArrayList<View>();
	
	private ListView sumListView;
	
	private ListView salesListView;
	
	private ListView priceListView;
	
	private ListView honorListView;
	/**
	 * 列表容器
	 */
	private BaobeiListAdapter baobeiListAdapter;
	
	private TextView title;
	/**
	 * 收藏
	 */
	private ImageView shoucangView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_bao_bei_list);
		initView();
		initPager();
	}

	/**
	 * 初始化
	 */
	private void initView(){
		sumtabLayout=(RelativeLayout)findViewById(R.id.baobeilistsumlayout);
		salestabLayout=(RelativeLayout)findViewById(R.id.baobeilistsaleslayout);
		pricetabLayout=(RelativeLayout)findViewById(R.id.baobeilistpricelayout);
		honortabLayout=(RelativeLayout)findViewById(R.id.baobeilisthonorlayout);
		
		shoucangView=(ImageView)findViewById(R.id.baobeilist_shoucang_ima);
		
		title=(TextView)findViewById(R.id.baobei_list_title_txt);
		if (HomeFra.TAG==1) {
			title.setText("最热单品");
		}
		
		
		
		sumtabLayout.setOnClickListener(this);
		salestabLayout.setOnClickListener(this);
		pricetabLayout.setOnClickListener(this);
		honortabLayout.setOnClickListener(this);
		shoucangView.setOnClickListener(this);
		
	}

	/**
	 * 初始化pager及其内容
	 */
	@SuppressLint("CutPasteId")
	private void initPager(){
		baobeilistPager=(ViewPager)findViewById(R.id.baobeilistpager);
		LayoutInflater inflater=getLayoutInflater();
		sumView=inflater.inflate(R.layout.baobeilistpagerlist, null);
		salesView=inflater.inflate(R.layout.baobeilistpagerlist, null);
		priceView=inflater.inflate(R.layout.baobeilistpagerlist, null);
		honorView=inflater.inflate(R.layout.baobeilistpagerlist, null);
		
		sumListView=(ListView)sumView.findViewById(R.id.baobeilist_list);
		salesListView=(ListView)salesView.findViewById(R.id.baobeilist_list);
		priceListView=(ListView)priceView.findViewById(R.id.baobeilist_list);
		honorListView=(ListView)honorView.findViewById(R.id.baobeilist_list);
		
		baobeiListAdapter=new BaobeiListAdapter(this, getlist());
		sumListView.setAdapter(baobeiListAdapter);
		salesListView.setAdapter(baobeiListAdapter);
		priceListView.setAdapter(baobeiListAdapter);
		honorListView.setAdapter(baobeiListAdapter);
		
		pagerViews.add(sumView);
		pagerViews.add(salesView);
		pagerViews.add(priceView);
		pagerViews.add(honorView);
		
		baobeilistPager.setAdapter(new BingPagerAdapter(pagerViews));
		
		baobeilistPager.setCurrentItem(0);
		
		baobeilistPager.setOnPageChangeListener(this);
		
		sumListView.setOnItemClickListener(listLister);
		salesListView.setOnItemClickListener(listLister);
		priceListView.setOnItemClickListener(listLister);
		honorListView.setOnItemClickListener(listLister);
		
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.baobeilistsumlayout:
			tabInst(SUM);
			break;
			
		case R.id.baobeilistsaleslayout:
			tabInst(SALES);
			break;
			
		case R.id.baobeilistpricelayout:
			tabInst(PRICE);
			break;
	
		case R.id.baobeilisthonorlayout:
			tabInst(HONOR);
			break;
			
		case R.id.baobeilist_shoucang_ima:
			Intent intent=new Intent();
			intent.setClass(BaoBeiList.this, UserShoucang.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
	
	/**
	 * 切换背景
	 * @param tabid tab标志
	 */
	private void tabInst(int tabid){
		switch (tabid) {
		case SUM:
			sumtabLayout.setBackgroundResource(R.drawable.baobeilisttabbar_sec);
			salestabLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			pricetabLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			honortabLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			baobeilistPager.setCurrentItem(SUM);
			
			break;
			
		case SALES:
			
			sumtabLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			salestabLayout.setBackgroundResource(R.drawable.baobeilisttabbar_sec);
			pricetabLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			honortabLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			baobeilistPager.setCurrentItem(SALES);
			
			break;
			
		case PRICE:
	
			sumtabLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			salestabLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			pricetabLayout.setBackgroundResource(R.drawable.baobeilisttabbar_sec);
			honortabLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			baobeilistPager.setCurrentItem(PRICE);
			
			break;
	
		case HONOR:
	
			sumtabLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			salestabLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			pricetabLayout.setBackgroundResource(R.drawable.baobeilisttabbar);
			honortabLayout.setBackgroundResource(R.drawable.baobeilisttabbar_sec);
			baobeilistPager.setCurrentItem(HONOR);
			
			break;

		default:
			break;
		}
	}
	
	private List<Map<String, Object>> getlist(){
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();   
			if (HomeFra.TAG==1) {
				map.put("tag", "hot");
			}
			map.put("goodsname", "bing");
			list.add(map);
		}
		return list;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		tabInst(arg0);
	}
	
	
	private OnItemClickListener listLister =new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			Intent intent=new Intent();
			intent.setClass(BaoBeiList.this, BaobeiInfo.class);
			startActivity(intent);
		}
	};
		
	
}
