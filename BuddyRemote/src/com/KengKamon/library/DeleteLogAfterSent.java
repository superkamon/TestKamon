package com.KengKamon.library;

import org.json.JSONException;

import com.KengKamon.buddyremote.SentLogToDatabase;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class DeleteLogAfterSent extends AsyncTask<Void, Void, Void> {
	private Context mContext;

	public DeleteLogAfterSent(Context context) {
		this.mContext = context;
	}

//	protected void onPreExecute() {

	//}

	protected Void doInBackground(Void... params) {

		// TODO Auto-generated method stub
		SentLogToDatabase sent = new SentLogToDatabase(mContext);
		sent.getDataFromLoginSQLite();
		return null;

	}

	protected void onPostExecute(Void result) {

		MyDB db = new MyDB(mContext);
		db.resetTables();
		Log.e("Log", " Delete Success " );
	
	}

}
