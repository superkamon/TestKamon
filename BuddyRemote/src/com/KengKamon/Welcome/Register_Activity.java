package com.KengKamon.Welcome;

import org.json.JSONException;
import org.json.JSONObject;

import com.KengKamon.buddyremote.Main;
import com.KengKamon.buddyremote.R;
import com.KengKamon.library.DatabaseHandler;
import com.KengKamon.library.UserFunctions;

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
import android.widget.Toast;

public class Register_Activity extends Activity {

	EditText inputUserName;
	EditText inputPassword;
	EditText inputEmail;
	Button btnRegister;
	Button btnLinkToSignIn;

	// use for validation
	private EditText email;
	private String valid_email;
	private Boolean status;

	// TextView registerErrorMsg;

	// JSON Response node names
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	// private static String KEY_UID = "uid";
	private static String KEY_NAME = "name";
	private static String KEY_EMAIL = "email";

	// private static String KEY_CREATED_AT = "created_at";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		// make it to connect internet
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		// ///////////////////////////////////////////////////////////////
		// Check validator email
		initilizeUI();
		// //////////////////////////////////////////////////////////////

		// Importing all assets like buttons, text fields
		inputUserName = (EditText) findViewById(R.id.registerUserName);
		inputPassword = (EditText) findViewById(R.id.registerPassword);
		inputEmail = (EditText) findViewById(R.id.registerEmail);
		btnRegister = (Button) findViewById(R.id.btnRegister);
		btnLinkToSignIn = (Button) findViewById(R.id.btnLinkToSignIn);

		// Register Button Click event
		btnRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = inputUserName.getText().toString();
				String email = inputEmail.getText().toString();
				String password = inputPassword.getText().toString();
				UserFunctions userFunction = new UserFunctions();
				
				if (name.matches("") || email.matches("")
						|| password.matches("")) {
					// Error in registration
					Toast.makeText(Register_Activity.this,
							" Compleate all of Textbox !!! ",
							Toast.LENGTH_SHORT).show();
				} else {

					boolean mail = Is_Valid_Email(inputEmail);

					if (mail != false) {
						//sent data toserver
						JSONObject json = userFunction.registerUser(name, email, password);
						
						// check for login response
						try {
							if (json.getString(KEY_SUCCESS) != null) {
								String res = json.getString(KEY_SUCCESS);
								if (Integer.parseInt(res) == 1) {
									
									// user successfully registred Store user details in SQLite Database
									DatabaseHandler db = new DatabaseHandler(getApplicationContext());
									JSONObject json_user = json.getJSONObject("user");

									// Clear all previous data in database
									userFunction.logoutUser(getApplicationContext());
									db.addUser(json_user.getString(KEY_NAME),json_user.getString(KEY_EMAIL)	);
									
									// Launch Dashboard Screen
									Intent dashboard = new Intent(getApplicationContext(), Main.class);
									
									// Close all views before launching Dashboard
									dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
									startActivity(dashboard);
									
									// Close Registration Screen
									finish();
								} else {
									// Error in registration
									Toast.makeText(Register_Activity.this,
											"Error occured in registration",Toast.LENGTH_LONG).show();
									inputUserName.setText("");
									inputPassword.setText("");
									inputEmail.setText("");

								}
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}

					} else {
						Toast.makeText(Register_Activity.this,
								" Invalid Email Address !!! ", Toast.LENGTH_SHORT)
								.show();

					}

				}
			}

			// /////////////////// check form mail ////////////////////////////
			private boolean Is_Valid_Email(EditText inputEmail) {
				// TODO Auto-generated method stub
				if (isEmailValid(inputEmail.getText().toString()) == false) {
					status = false;

				} else {
					// valid_email = inputEmail.getText().toString();
					status = true;
				}
				return status;
			}

			boolean isEmailValid(CharSequence email) {
				return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
						.matches();
			}

			// ////////////////////////////////////////////////////////////////

		});

		btnLinkToSignIn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent itn = new Intent(getApplicationContext(),
						LogIn_Activity.class); // ใส่ this error
				startActivity(itn);
				// Close Registration View
				finish();

			}

		});

	}

	/**
	 * This method is used to initialize UI Components
	 */
	private void initilizeUI() {
		// TODO Auto-generated method stub

		email = (EditText) findViewById(R.id.registerEmail);

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
}
