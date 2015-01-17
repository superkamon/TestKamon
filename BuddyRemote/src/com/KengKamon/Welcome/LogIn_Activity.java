package com.KengKamon.Welcome;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.KengKamon.buddyremote.Main;
import com.KengKamon.buddyremote.R;
import com.KengKamon.library.DatabaseHandler;
import com.KengKamon.library.UserFunctions;


public class LogIn_Activity extends Activity {
	
	Button btnSignin;
    EditText inputEmail; //อาจจะแก้เป็น email ใช้ email login แทน username
    EditText inputPassword;
    TextView btnLinkToRegister;    
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
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 
	

		 
		// Importing all assets like buttons, text fields
		 	inputEmail = (EditText) findViewById(R.id.loginEmail);
	        inputPassword = (EditText) findViewById(R.id.loginPassword);
	        btnLinkToRegister = (TextView) findViewById(R.id.btnLinkToSignUp);
	        btnSignin = (Button) findViewById(R.id.btnLogin);
	        
	    // Login Activity
	        btnSignin.setOnClickListener(new View.OnClickListener() {	            
	            public void onClick(View v) {	            	
	            	  checkLogin();	            	  
	            }
	        });
		}	
	
	//==============================Check Login=================================
		
	    private void checkLogin() {
	        String email = inputEmail.getText().toString();
	        String password = inputPassword.getText().toString();
	        //สร้าง user function สำหรับ log in ไปที่ server แล้วจะได้ json กลับมา
	        UserFunctions userFunction = new UserFunctions();
            JSONObject json = userFunction.loginUser(email, password);
            
         // check for login response
            try {
                if (json.getString(KEY_SUCCESS) != null) {
                	//Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
                    String res = json.getString(KEY_SUCCESS); //อ่าน key success ออกมาดูซิว่า
                    if(Integer.parseInt(res) == 1){// มันเท่ากับ 1 หรือป่าว(ถ้าสำเร็จมันจะส่ง 1 กลับมา)
                        // user successfully logged in
                        // Store user details in SQLite Database
                        DatabaseHandler db = new DatabaseHandler(getApplicationContext()); //ตัวจัดการ database
                        JSONObject json_user = json.getJSONObject("user"); // อ่าน user ออกมาจะได้ json object กลับมา
                         
                        // Clear all previous data in database
                        userFunction.logoutUser(getApplicationContext());
                        // ทีนี้ก็อ่าน value ผ่าน key ที่อยู่ใน json object ที่ชื่อ user ได้ 
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
                    	inputPassword.setText("");
                    	
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();// ถ้ามีข้อผิดพลาดเกี่ยวกับ json เกิดขึ้นอย่าเด้งนะ ให้แสดงข้อผิดพลาดออกมาดู (อันนี้พี่บอกคอม)
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
