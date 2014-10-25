package com.KengKamon.buddyremote;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity {
	protected boolean _active = true;
    protected int _splashTime = 5000;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);
        
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while(_active && (waited < _splashTime)) {
                        sleep(100);
                        if(_active) {
                            waited += 100;
                        }
                    }
                } catch(InterruptedException e) {
                    // do nothing
                } finally {
                    finish();
    				Intent goMain = new Intent(getApplicationContext(), Sign_InActivity.class);
    				startActivity(goMain);
                }
            }
        };
        splashTread.start();
    }
	

}