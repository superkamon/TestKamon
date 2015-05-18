package com.KengKamon.buddyremote;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import com.KengKamon.library.DatabaseHandler;
import com.KengKamon.library.MyDB;

import android.app.AlertDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Vibrator;
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
	Button button1, button5, button7, button4, button6, button2, button10,button8,button9,button11;

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
		button10 = (Button) view.findViewById(R.id.button3);
		button10.setOnClickListener(new OnClickListener() {

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
		// back btn
				button10 = (Button) view.findViewById(R.id.button10);
				button10.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
								R.raw.back);
						mpEffect.start();
						mpEffect.setOnCompletionListener(new OnCompletionListener() {
							public void onCompletion(MediaPlayer mp) {
								mp.release();

							}
						});

					}
				});
				// home btn
				button8 = (Button) view.findViewById(R.id.button8);
				button8.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
								R.raw.back);
						mpEffect.start();
						mpEffect.setOnCompletionListener(new OnCompletionListener() {
							public void onCompletion(MediaPlayer mp) {
								mp.release();

							}
						});

					}
				});
				// Fav_btn
				button9 = (Button) view.findViewById(R.id.button9);
				button9.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {

						Vibrator vi = (Vibrator) getActivity().getSystemService(
								Context.VIBRATOR_SERVICE);
						// Vibrate for 500 milliseconds
						vi.vibrate(50);

						 SaveFavToLog();

					}
				});
				// input btn
				button11 = (Button) view.findViewById(R.id.button11);
				button11.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						MediaPlayer mpEffect = MediaPlayer.create(getActivity(),
								R.raw.input);
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
	/**
	 * =====================================================================
	 * =========== Save Fav To Log ======================================
	 * =====================================================================
	 */
	public boolean SaveFavToLog() {
		// checkChanal
		String FormattedChanal = "Fav";

		// Dialog
		final AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
		AlertDialog ad = adb.create();

		// get email for sent with log
		DatabaseHandler db = new DatabaseHandler(getActivity()
				.getApplicationContext());
		HashMap<String, String> userHashMap = db.getUserDetails();
		String tMemberID = userHashMap.get("email");

		// new Class DB
		final MyDB myDb = new MyDB(getActivity());

		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = df.format(c.getTime());
		String formattedTime = tf.format(c.getTime());

		// Save Data
		long saveStatus = myDb.InsertData(tMemberID, formattedDate,
				formattedTime, FormattedChanal);
		if (saveStatus <= 0) {
			ad.setMessage("Error!! ");
			ad.show();
			return false;
		}
		
		return true;
	}
}
