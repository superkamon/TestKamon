package com.KengKamon.sentMail;

import java.util.List;

import com.KengKamon.Welcome.ForgetPass_Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class SendMailTask extends AsyncTask<Object,String,Void> {
	private Context mContext;
	private ProgressDialog statusDialog;

	public SendMailTask(Context context) {
		this.mContext = context;
	}

	protected void onPreExecute() {
		statusDialog = new ProgressDialog(mContext);
		statusDialog.setMessage("Getting ready...");
		statusDialog.setIndeterminate(false);
		statusDialog.setCancelable(false);
		statusDialog.show();
	}

	@Override
	protected Void doInBackground(Object... args) {
		try {
			Log.i("SendMailTask", "About to instantiate GMail...");
			publishProgress("Processing input....");
			GMail androidEmail = new GMail(args[0].toString(),
					args[1].toString(), (List) args[2], args[3].toString(),
					args[4].toString());
			publishProgress("Preparing mail message....");
			androidEmail.createEmailMessage();
			publishProgress("Sending email....");
			androidEmail.sendEmail();
			publishProgress("Email Sent.");
			Log.i("SendMailTask", "Mail Sent.");

		} catch (Exception e) {
			publishProgress(e.getMessage());
			Log.e("SendMailTask", e.getMessage());
		}
		return null;
	}

	@Override
	public void onProgressUpdate(String... values) {
		statusDialog.setMessage(values[0].toString());

	}

	
	public void onPostExecute(Void result) {

		statusDialog.dismiss();
		Toast.makeText(mContext, "Email Send Success !!!", Toast.LENGTH_LONG)
		.show();
		
	}

}
