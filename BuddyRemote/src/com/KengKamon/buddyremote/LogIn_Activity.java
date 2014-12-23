package com.KengKamon.buddyremote;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.KengKamon.library.DatabaseHandler;
import com.KengKamon.library.UserFunctions;


public class LogIn_Activity extends Activity {
	
	Button Signin;
    EditText Email; //�Ҩ������ email �� email login ᷹ username
    EditText Password;
    TextView mRegister;    
    TextView loginErrorMsg;
    //private Context mContext; 
    // private UserManager mManager;
    
 // JSON Response node names
    private static String KEY_SUCCESS = "success";
    private static String KEY_ERROR = "error";
    private static String KEY_ERROR_MSG = "error_msg";
    private static String KEY_UID = "uid";
    private static String KEY_NAME = "name";
    private static String KEY_EMAIL = "email";
    private static String KEY_CREATED_AT = "created_at";
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign__in);

		 
		// Importing all assets like buttons, text fields
		 	Email = (EditText) findViewById(R.id.Email);
	        Password = (EditText) findViewById(R.id.Password);
	        mRegister = (TextView) findViewById(R.id.SignUp);
	        Signin = (Button) findViewById(R.id.Signin);
	        
	    // Login Activity
	        Signin.setOnClickListener(new View.OnClickListener() {
	            
	            public void onClick(View v) {
	            	
	            	  checkLogin();
	            	  
	            }
	        });
		}	
	
	//==============================Check Login=================================
		
	    private void checkLogin() {
	        String email = Email.getText().toString();
	        String password = Password.getText().toString();
	        UserFunctions userFunction = new UserFunctions();
            JSONObject json = userFunction.loginUser(email, password);
            
         // check for login response
            try {
                if (json.getString(KEY_SUCCESS) != null) {
                	Toast.makeText(this,"",Toast.LENGTH_LONG).show();
                    String res = json.getString(KEY_SUCCESS); 
                    if(Integer.parseInt(res) == 1){
                        // user successfully logged in
                        // Store user details in SQLite Database
                        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                        JSONObject json_user = json.getJSONObject("user");
                         
                        // Clear all previous data in database
                        userFunction.logoutUser(getApplicationContext());
                        db.addUser(json_user.getString(KEY_NAME), json_user.getString(KEY_EMAIL), json.getString(KEY_UID), json_user.getString(KEY_CREATED_AT));                        
                         
                        // Launch Dashboard Screen
                        Intent dashboard = new Intent(getApplicationContext(), Main.class);
                         
                        // Close all views before launching Dashboard
                        dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(dashboard);
                         
                        // Close Login Screen
                        finish();
                    }else{
                        // Error in login
                    	Toast.makeText(this,"Incorrect username/password",Toast.LENGTH_LONG).show();
                    	
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    
	
	    	    
	//============================================================================
	    
	public void doRegister(View v) {

			Intent itn = new Intent(this, Register_Activity.class);
			startActivity(itn);
		}
	    
	public void doForget(View v) {

		Intent itn = new Intent(this, ForgetPass_Activity.class);
		startActivity(itn);
	}
	
}
