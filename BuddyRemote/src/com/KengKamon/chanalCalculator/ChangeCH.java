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
		Log.d("Value chanal", chanal);
		for (int i = 0; i < chanal.length(); i++) {
			final int x = Integer.parseInt(chanal.substring(i, i + 1));// �Ѻ��ҵ�Ƿ��
																		// i
																		// �֧��͹˹��
																		// i + 1
			Log.d("", "value of x = " + x);
			if (i == 0) {
				CHChange(x);
			} else {
				// delay �ç���
				CountDownTimer cdt = new CountDownTimer(1000, 1000) {
					public void onTick(long millisUntilFinished) {
						// Tick
					}

					public void onFinish() {
						// Finish
						CHChange(x);
					}
				}.start();
			}
			// new Handler().postDelayed(new Runnable() {
			//
			// @Override
			// public void run() {
			//
			// }
			// }, 1000);
			// ��͵͹����������������ѹ������Դ�ѹ��¹�Ф�Ѻ ���������
			// delay ���ǡ��� �蹡� 1 ����ѹ delay � 3 �� �� 2 ����ѹ delay
			// � 3 ��
			// �ѹ���价ӵԴ�ѹ����� �����¤�Ѻ�ѹ delay
			// �����ѹ����ҡѺ�Թҷշ�� 3 �ѹ��ӷ���ͧ������ѹ
			// ������ѹ�շҧ�������Ѻ ����ѹ����͹�Ѻ��3����Ǥ��¡�2
			// ���о���ͧ���� 32 ������������ �顴3�Ѻ2�¡�ѹ�����
			// ����ͧ�٤�Ѻ

		}

	}

	// function Change Chanal on TV
	public void CHChange(int x) {
		Log.d("", "play sound of CH = " + x);
		switch (x) {

		case 1:
			CH1();
			Log.d("Value of CH", "hello");
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
				mp.reset();
				mp.release();

			}
		});

	}

	public void CH2() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_2);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.reset();
				mp.release();

			}
		});

	}

	public void CH3() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_3);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.reset();
				mp.release();

			}
		});

	}

	public void CH4() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_4);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.reset();
				mp.release();

			}
		});

	}

	public void CH5() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_5);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.reset();
				mp.release();

			}
		});

	}

	public void CH6() {// <= �Ѻ��� Ch �Ѩ�غѹ�ҡ�ҡ�ա Function

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_6);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.reset();
				mp.release();

			}
		});

	}

	public void CH7() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_7);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.reset();
				mp.release();

			}
		});

	}

	public void CH8() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_8);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.reset();
				mp.release();

			}
		});

	}

	public void CH9() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_9);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.reset();
				mp.release();

			}
		});

	}

	public void CH0() {

		MediaPlayer mpEffect = MediaPlayer.create(mContext, R.raw.button_0);
		mpEffect.start();
		mpEffect.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				mp.reset();
				mp.release();

			}
		});

	}

}
