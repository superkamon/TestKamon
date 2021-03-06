package com.KengKamon.Welcome;

import com.KengKamon.Welcome.LogIn_Activity;
import com.KengKamon.buddyremote.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.widget.Toast;

public class SplashScreen extends Activity {

	protected boolean _active = true;
	protected int _splashTime = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);

		Thread splashTread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					while (_active && (waited < _splashTime)) {
						sleep(100);
						if (_active) {
							waited += 100;
						}
					}
				} catch (InterruptedException e) {
					// do nothing
				} finally {
					finish();
					Intent goMain = new Intent(getApplicationContext(),
							LogIn_Activity.class);
					startActivity(goMain);
				}
			}
		};
		splashTread.start();

	}

}
