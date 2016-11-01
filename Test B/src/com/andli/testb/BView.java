package com.andli.testb;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.andli.testb.R;

public class BView extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button button = new Button(this);
		button.setText("启动应用A");
		addContentView(button, new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Intent intent = new Intent();
				// Bundle bundle = new Bundle();
				// bundle.putString("loginid", "test");
				// bundle.putString("password", "11111");
				// intent.setClassName("com.andli", "com.andli.apk2");
				// intent.putExtras(bundle);
				// startActivity(intent);
				try {
					// sdis.wx/.LoginActivity
					// 调用方式一:直接调用包名
					final PackageManager pm = getPackageManager();
					Intent intent2 = pm.getLaunchIntentForPackage("com.andli.testa");
					Bundle bundle = new Bundle();
					bundle.putString("loginid", "test");
					bundle.putString("password", "11111");
					intent2.putExtras(bundle);
					// 调用方式二：调用启动页面
					// Intent intent = new Intent();
					// ComponentName comp = new ComponentName("sdis.wx",
					// "sdis.wx.StartActivity");
					// intent.setComponent(comp );
					// intent.setAction("android.intent.action.MAIN");
					startActivity(intent2);
					Log.i("andli", intent2.toString());
				} catch (Exception e) {
					e.printStackTrace();
					Toast.makeText(BView.this, e.toString(), 5000).show();
				}
			}
		});
	}
}