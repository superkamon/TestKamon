package com.KengKamon.buddyremote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Sign_InActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign__in);
		
		
	}

	public void doRemote(View v) {
		Intent itn = new Intent(this, Main.class);
		startActivity(itn);
	}
	
	public void doRegister(View v) {
		
		Intent itn = new Intent(this, Register_Activity.class);
		startActivity(itn);
	}
}

