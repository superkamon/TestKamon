package com.KengKamon.Welcome;

import com.KengKamon.buddyremote.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;

public class ForgetPass_Activity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forget_pass);
		
		
		// make it to connect internet
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy); 
		
		
		
	}
	public void doSignIn(View v) {
		Intent itn = new Intent(this, LogIn_Activity.class);
		startActivity(itn);
	}

}
