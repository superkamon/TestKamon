package com.KengKamon.buddyremote;

import java.util.HashMap;

import com.KengKamon.Welcome.LogIn_Activity;
import com.KengKamon.library.DatabaseHandler;
import com.KengKamon.library.DeleteLogAfterSent;
import com.KengKamon.library.MyDB;
import com.KengKamon.library.UserFunctions;
import com.KengKamon.buddyremote.SentLogToDatabase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LogOutFragment extends Fragment {
	UserFunctions userFunctions;
	Button btnLogout;
	TextView UserID;
	EditText inputEmail;
	// HashMap<String, String> User;
	Button Showlog;
	DeleteLogAfterSent delLog;
	Button SentLog;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**
		 * Dashboard Screen for the application
		 * */

		// show dashboard

		View rootview = inflater.inflate(R.layout.fragment_logout, container,
				false);

		UserID = (TextView) rootview.findViewById(R.id.textView2);
		// inflate อview มาก่อนครับ

		// เราจะอ่านข้อมูลจาก database อันดํบแรกสร้างตัวจัดการ database
		// ขึ้นมาก่อนครับ

		// แล้วก็ดึงได้เลย
		DatabaseHandler db = new DatabaseHandler(getActivity()
				.getApplicationContext());
		HashMap<String, String> userHashMap = db.getUserDetails();
		String userName = userHashMap.get("name");
		UserID.setText(userName.toString());

		// LogOut Btn
		// พอกด เเล้ว error ให้น้องดู !!!!
		btnLogout = (Button) rootview.findViewById(R.id.btnLogout);

		btnLogout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
						
				userFunctions.logoutUser(getActivity());
				UserID.setText("");
				Intent login = new Intent(
						
						getActivity().getApplicationContext(),
						LogIn_Activity.class);
				login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(login);
				
			}
		});
		// ShowLog Btn
		Showlog = (Button) rootview.findViewById(R.id.Showlog);
		Showlog.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent Log = new Intent(getActivity().getApplicationContext(),
						ShowActivity.class);
				startActivity(Log);
			}
		});
		// sentLog Btn
		SentLog = (Button) rootview.findViewById(R.id.SentLog);
		SentLog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				delLog= new DeleteLogAfterSent(getActivity());
				delLog.execute();
								
			}
		});

		return rootview;
	}


	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		delLog= new DeleteLogAfterSent(getActivity());
		delLog.execute();
		
		
	
		
		
		
		
	}
	
	
	

}
