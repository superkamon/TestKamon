package com.KengKamon.library;

import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
 
import android.content.Context;
import android.util.Log;
 
/** 
 *======================================================================= 
 * 	�����������������ҧ app �Ѻ server �͹������ url �ͧ localhost ���  http://10.0.2.2/	*
 * 																		*
 * 	��Ҩ���Ẻ online �������¹���  http://yourdomain.com/android_login_api 		*
 * 																		*
 * 	��������Ѵ�ǡ library ŧ folder android_login_api							*
 *======================================================================= 
 */

public class UserFunctions {
	private JSONParser jsonParser;
    
    // Testing in localhost using  xampp 
    // use http://10.0.2.2/ to connect to your localhost ie http://localhost/
    private static String loginURL = "http://iteproject.kmi.tl/Ebuddy/Buddy/android_login_api/";//�ѹ�����¡� index.php 
    private static String registerURL = "http://iteproject.kmi.tl/Ebuddy/Buddy/android_login_api/";
     
    private static String login_tag = "login";
    private static String register_tag = "register";
     
    // constructor
    public UserFunctions(){
        jsonParser = new JSONParser();
    }
     
    /**
     * function make Login Request
     * @param email
     * @param password
     * */
    public JSONObject loginUser(String email, String password){
        // Building Parameters
    	//�������ҷ����觢���
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", login_tag));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));
        											//�觤�ҷ����������价�� url ����Ѻ log in ���Ǩ��� json ��Ѻ��
        JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
        // return json
        // Log.e("JSON", json.toString());
        return json;
    }
     
    /**
     * function make Login Request
     * @param name
     * @param email
     * @param password
     * */
    public JSONObject registerUser(String name, String email, String password){
        // Building Parameters
    	
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", register_tag));
        params.add(new BasicNameValuePair("name", name));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));
         
        // getting JSON Object                      
        JSONObject json = jsonParser.getJSONFromUrl(registerURL, params);
        
        // return json
        return json;
    }
     
    /**
     * Function get Login status
     * */
    public boolean isUserLoggedIn(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        int count = db.getRowCount();
        if(count > 0){
            // user logged in
            return true;
        }
        return false;
    }
     
    /**
     * Function to logout user
     * Reset Database
     * */
    public boolean logoutUser(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        db.resetTables();
        return true;
    }
     

}
