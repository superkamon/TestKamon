package com.KengKamon.buddyremote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ForgetPass_Activity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forget_pass);
	}
	public void doSignIn(View v) {
		Intent itn = new Intent(this, LogIn_Activity.class);
		startActivity(itn);
	}

}
