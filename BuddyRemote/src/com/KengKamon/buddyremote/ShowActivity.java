package com.KengKamon.buddyremote;

import java.util.ArrayList;
import java.util.HashMap;

import com.KengKamon.library.MyDB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ShowActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listshow_activity);

		final MyDB myDb = new MyDB(this);
		final ArrayList<HashMap<String, String>> MebmerList = myDb
				.SelectAllData();

		// listView1
		ListView lisView1 = (ListView) findViewById(R.id.listView1);

		SimpleAdapter sAdap;
		sAdap = new SimpleAdapter(ShowActivity.this, MebmerList,
				R.layout.show_activity, new String[] { "ID", "Date", "Time",
						"Chanal" }, new int[] { R.id.ColMemberID, R.id.ColName,
						R.id.ColTel, R.id.ColChanal });
		lisView1.setAdapter(sAdap);

		// btnCancel (Cancel)
		final Button cancel = (Button) findViewById(R.id.btnCancel);
		cancel.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Open Form Main
				Intent newActivity = new Intent(ShowActivity.this,
						LogOutFragment.class);
				startActivity(newActivity);
			}
		});

	}

}