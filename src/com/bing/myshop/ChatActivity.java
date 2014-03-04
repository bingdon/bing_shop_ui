package com.bing.myshop;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.adapter.ChatAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
/**
 * 商品聊天
 * @author lyl
 *
 */
public class ChatActivity extends Activity {

	/**
	 * 发送按钮
	 */
	private Button sendButton;
	/**
	 * 发送内容
	 */
	private EditText sendEditText;
	/**
	 * 显示列表
	 */
	private ListView chatListView;
	/**
	 * 列表适配
	 */
	private ChatAdapter chatAdapter;
	/**
	 *  列表内容
	 */
	private List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_chat);
		initView();
	}


	private void initView(){
		
		sendButton=(Button)findViewById(R.id.send_button);
		sendEditText=(EditText)findViewById(R.id.chat_edit);
		
		chatListView=(ListView)findViewById(R.id.chat_listView);
		chatAdapter=new ChatAdapter(this, list);
		chatListView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		chatListView.setAdapter(chatAdapter);
		
		sendButton.setOnClickListener(listener);
		sendEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				if (s.length()>0) {
					sendButton.setEnabled(true);
				} else {
					sendButton.setEnabled(false);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private OnClickListener listener=new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Map<String,Object>  map=new HashMap<String,Object>();
			
			 Calendar calendar=Calendar.getInstance();
			String word=sendEditText.getText().toString();
			
			String time=""+calendar.get(Calendar.HOUR)+":"
					+calendar.get(Calendar.MINUTE);
			map.put("getwords", word);
			map.put("gettime", time);
			list.add(map);
			chatAdapter.notifyDataSetChanged();
			sendEditText.setText("");
			sendButton.setEnabled(false);
		}
	};
	
}
