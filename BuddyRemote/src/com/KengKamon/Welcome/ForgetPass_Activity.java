package com.KengKamon.Welcome;

import java.util.Arrays;
import java.util.List;

import com.KengKamon.buddyremote.R;
//import com.KengKamon.sentMail.SendMailActivity;
import com.KengKamon.sentMail.SendMailTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgetPass_Activity extends Activity{
	// for validate
	private EditText email;
	private String valid_email;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forget_pass);		
		
		// make it to connect internet
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		/////////////////////////////////////////////////////////////////////////
		//					email validation 
		initilizeUI();
		
		/////////////////////////////////////////////////////////////////////////
		////////////////////////  sent mail by Gmail   //////////////////////////
		final Button send = (Button) this.findViewById(R.id.button1);

		send.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Log.i("SendMailActivity", "Send Button Clicked.");

				String fromEmail = "buddytvapp@gmail.com"; //((TextView) findViewById(R.id.editText1))
						//.getText().toString();
				String fromPassword = "01121272";//((TextView) findViewById(R.id.editText2))
						//.getText().toString();
				String toEmails = ((TextView) findViewById(R.id.editText1))
						.getText().toString();
				List<String> toEmailList = Arrays.asList(toEmails
						.split("\\s*,\\s*"));
				Log.i("SendMailActivity", "To List: " + toEmailList);
				String emailSubject ="Forget Password!!!"; //((TextView) findViewById(R.id.editText4))
						//.getText().toString();
				String emailBody ="Please follow this link to reset password \n\n http://iteproject.kmi.tl/Ebuddy/forgetpass.php"; //((TextView) findViewById(R.id.editText5))
						//.getText().toString();
			 new SendMailTask(ForgetPass_Activity.this).execute(fromEmail,
						fromPassword, toEmailList, emailSubject, emailBody);
			}
		});		
		
	}
	//////////////////////////////////////////////////////////////////
	//			use this for valadate email
	/**
	 * This method is used to initialize UI Components
	 */
	private void initilizeUI() {
	    // TODO Auto-generated method stub

	    email = (EditText) findViewById(R.id.editText1);

	    email.addTextChangedListener(new TextWatcher() {

	        @Override
	        public void onTextChanged(CharSequence s, int start, int before,
	                int count) {
	            // TODO Auto-generated method stub

	        }

	        @Override
	        public void beforeTextChanged(CharSequence s, int start, int count,
	                int after) {
	            // TODO Auto-generated method stub

	        }

	        @Override
	        public void afterTextChanged(Editable s) {
	            // TODO Auto-generated method stub

	            // TODO Auto-generated method stub
	            Is_Valid_Email(email); // pass your EditText Obj here.
	        }

	        public void Is_Valid_Email(EditText edt) {
	            if (edt.getText().toString() == null) {
	                edt.setError("Invalid Email Address");
	                valid_email = null;
	            } else if (isEmailValid(edt.getText().toString()) == false) {
	                edt.setError("Invalid Email Address");
	                valid_email = null;
	            } else {
	                valid_email = edt.getText().toString();
	            }
	        }

	        boolean isEmailValid(CharSequence email) {
	            return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
	                    .matches();
	        } // end of TextWatcher (email)
	    });

	}
	//////////////////////////////////////////////////////////////////////
	public void doSignIn(View v) {
		Intent itn = new Intent(this, LogIn_Activity.class);
		startActivity(itn);
	}

}
