package com.KengKamon.buddyremote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Register_Activity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
	}
	public void doSignIn(View v) {
		Intent itn = new Intent(this, Sign_InActivity.class);
		startActivity(itn);
	}

}
