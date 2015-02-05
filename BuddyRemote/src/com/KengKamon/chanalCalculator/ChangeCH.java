package com.KengKamon.chanalCalculator;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

import com.KengKamon.buddyremote.R;

public class ChangeCH {
	
	
	
	
	private Context mContext;

	public ChangeCH(Context context) {
		this.mContext = context;

	}

	
	public void checkChanal(int Ch) {
		
		String chanal = String.valueOf(Ch);
		Log.d("Value chanal",  chanal );
		for (int i = 0; i < chanal.length(); i++) {
			int x = Integer.parseInt(chanal.substring(i, i+1));// สับเอาตัวที่ i ถึงก่อนหน้า i + 1
			Log.d("", "value of x = " + x);
			CHChange(x);
		}

	}

	public void CHChange(int x) {
		switch (x) {

		case 1:
			CH1();
			Log.d("Value of CH", "hello" );
			break;
		case 2:
			CH2();
			break;
		case 3:
			CH3();
			break;
		case 4:
			CH4();
			break;
		case 5:
			CH5();
			break;
		case 6:
			CH6();
			break;
		case 7:
			CH7();
			break;
		case 8:
			CH8();
			break;
		case 9:
			CH9();
			break;
		case 0:
			CH0();
			break;

		}
	}

	public void CH1() {
		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_1);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.release();

			}
		});

	}

	public void CH2() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_2);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.release();

			}
		});

	}

	public void CH3() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_3);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.release();

			}
		});

	}

	public void CH4() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_4);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.release();

			}
		});

	}

	public void CH5() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_5);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.release();

			}
		});

	}

	public void CH6() {// <= รับค่า Ch ปัจจุบันมากจากอีก Function

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_6);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.release();

			}
		});

	}

	public void CH7() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_7);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.release();

			}
		});

	}

	public void CH8() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_8);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.release();

			}
		});

	}

	public void CH9() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_9);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.release();

			}
		});

	}

	public void CH0() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_0);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.release();

			}
		});

	}
	
	
}
