package com.KengKamon.buddyremote;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.support.v4.app.Fragment;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


//เน€เธญเธฒเน�เธงเน�เธ”เธนlogเธ•เธณเน�เธซเธ�เน�เธ�เธ—เธตเน�เธ–เธนเธ�เธฅเธทเธญเธ�

public class NumRemoteFragment extends Fragment { // use fragment not activity

	Button button1, btn_mute, volup_btn,voldown_btn, chup_btn,chdown_btn; 
	String result;
	TextView txtResult;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_num_remote, container,
				false);
							 		
		// PowerButton
		button1 = (Button) view.findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
						R.raw.power);
				mpEffect.start();
				mpEffect.setOnCompletionListener(new OnCompletionListener() {
					public void onCompletion(MediaPlayer mp) {
						mp.release();

					}
				});			
			}
		});

		// Mute_BTN		
		
		btn_mute = (Button) view.findViewById(R.id.btn_mute);
		btn_mute.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
						R.raw.mute);
				mpEffect.start();
				mpEffect.setOnCompletionListener(new OnCompletionListener() {
					public void onCompletion(MediaPlayer mp) {
						mp.release();
					
					}
				});
			
			}
						
		});
		// volup_btn
		volup_btn = (Button) view.findViewById(R.id.volup_btn);
		volup_btn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
						R.raw.volume_up);
				mpEffect.start();
				mpEffect.setOnCompletionListener(new OnCompletionListener() {
					public void onCompletion(MediaPlayer mp) {
						mp.release();

					}
				});

			}
		});
		// voldown_btn
		voldown_btn = (Button) view.findViewById(R.id.voldown_btn);
		voldown_btn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
						R.raw.volume_down);
				mpEffect.start();
				mpEffect.setOnCompletionListener(new OnCompletionListener() {
					public void onCompletion(MediaPlayer mp) {
						mp.release();

					}
				});

			}
		});
		// chup_btn
				chup_btn = (Button) view.findViewById(R.id.button4);
				chup_btn.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
								R.raw.page_up);
						mpEffect.start();
						mpEffect.setOnCompletionListener(new OnCompletionListener() {
							public void onCompletion(MediaPlayer mp) {
								mp.release();

							}
						});

					}
				});
				// chdown_btn
				chdown_btn = (Button) view.findViewById(R.id.button5);
				chdown_btn.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
								R.raw.page_down);
						mpEffect.start();
						mpEffect.setOnCompletionListener(new OnCompletionListener() {
							public void onCompletion(MediaPlayer mp) {
								mp.release();

							}
						});

					}
				});
		return view;
	}

}
