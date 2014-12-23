package com.KengKamon.buddyremote;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class PadFragment extends Fragment {
	Button button1, button5, button7, button4, button6, button2, button3;

	public PadFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_pad, container, false);

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
		// Mute_btn
		button5 = (Button) view.findViewById(R.id.button5);
		button5.setOnClickListener(new OnClickListener() {

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
		// arrow_up_btn
		button7 = (Button) view.findViewById(R.id.button7);
		button7.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
						R.raw.up);
				mpEffect.start();
				mpEffect.setOnCompletionListener(new OnCompletionListener() {
					public void onCompletion(MediaPlayer mp) {
						mp.release();

					}
				});

			}
		});
		// arrow_right_btn
		button4 = (Button) view.findViewById(R.id.button4);
		button4.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
						R.raw.right);
				mpEffect.start();
				mpEffect.setOnCompletionListener(new OnCompletionListener() {
					public void onCompletion(MediaPlayer mp) {
						mp.release();

					}
				});

			}
		});
		// arrow_down_btn
		button6 = (Button) view.findViewById(R.id.button6);
		button6.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
						R.raw.down);
				mpEffect.start();
				mpEffect.setOnCompletionListener(new OnCompletionListener() {
					public void onCompletion(MediaPlayer mp) {
						mp.release();

					}
				});

			}
		});
		// arrow_left_btn
		button2 = (Button) view.findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
						R.raw.left);
				mpEffect.start();
				mpEffect.setOnCompletionListener(new OnCompletionListener() {
					public void onCompletion(MediaPlayer mp) {
						mp.release();

					}
				});

			}
		});
		// ok_btn
		button3 = (Button) view.findViewById(R.id.button3);
		button3.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
						R.raw.ok);
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
