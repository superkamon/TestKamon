package com.KengKamon.buddyremote;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import com.KengKamon.chanalCalculator.ChanalUpBtn;
import com.KengKamon.library.DatabaseHandler;
import com.KengKamon.library.MyDB;

import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Vibrator;

public class NumRemoteFragment extends Fragment { // use fragment not activity

	Button button1, btn_mute, volup_btn, voldown_btn, chup_btn, chdown_btn;
	String result;
	TextView txtResult;
	int Ch = 1; // ตอนนี้ set ให้เป็น 1 อนาคต ให้ user กด ปุ่ม เมื่อ tv เปิด
	// อยู่ที่ช่อง 1 เเลว้ให้มัน set Ch = 1 เเล้วไปดู ใน life cycle
	// ได้มันจะทำให้เก็บค่า Ch ปัจจุบัน แม้ปิด TV
	String formattedChanal;
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_num_remote, container, false);

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
				Vibrator vi = (Vibrator) getActivity().getSystemService(
						Context.VIBRATOR_SERVICE);
				// Vibrate for 500 milliseconds
				vi.vibrate(50);
				Ch = Ch + 1;
				if (Ch > 36) {
					Ch = 1;
					SaveDataToLog();
				} else {
					SaveDataToLog();
				}
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

				Vibrator vi = (Vibrator) getActivity().getSystemService(
						Context.VIBRATOR_SERVICE);
				// Vibrate for 500 milliseconds
				vi.vibrate(50);

				Ch = Ch - 1;
				if (Ch < 1) {
					Ch = 36;
					SaveDataToLog();
				} else {
					SaveDataToLog();
				}
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

	/**
	 * =====================================================================
	 * =========== Save Data To Log ======================================
	 * =====================================================================
	 */
	public boolean SaveDataToLog() {
		// checkChanal
		String FormattedChanal = ChanalUpBtn.checkChanalUp(Ch);

		// final EditText tMemberID = (EditText)
		// view.findViewById(R.id.editText1);
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
		// Toast.makeText(this,
		// "Add Data Successfully. ",Toast.LENGTH_SHORT).show();
		return true;
	}

}
