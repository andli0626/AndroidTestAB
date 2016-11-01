package com.andli.testa;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AView extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//显示TextView
		TextView showTextView = new TextView(this);
		showTextView.setTextSize(18);
		addContentView(showTextView, new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		showTextView.setText("应用A 已启动！");
		
		Intent intent = getIntent();
		
		//获取从应用B传递过来的值
		Bundle mBundle = new Bundle();
		mBundle = intent.getExtras();
		if (mBundle != null) {
			String loginid  = mBundle.getString("loginid");
			String password = mBundle.getString("password");
			showTextView.setText("从应用B传过来的数据:用户名="+ loginid + "  密码="+ password);
		}
		
		 
		//获取通过浏览器启动传递过来的值  
		if(Intent.ACTION_VIEW.equals(intent.getAction())){  
		    Uri uri = intent.getData();  
		    if(uri != null){  
		        String loginid  = uri.getQueryParameter("loginid");  
		        String password = uri.getQueryParameter("password"); 
		        if(loginid!=null && password!=null){
		        	 showTextView.setText("从浏览器启动传递过来的数据:用户名="+ loginid + "  密码="+ password);
		        }
		    }  
		}
	}
}