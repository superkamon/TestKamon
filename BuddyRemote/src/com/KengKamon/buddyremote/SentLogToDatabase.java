package com.KengKamon.buddyremote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;

import com.KengKamon.library.DatabaseHandler;
import com.KengKamon.library.JSONParser;
import com.KengKamon.library.MyDB;

public class SentLogToDatabase {
	private Context mContext;
	private JSONParser jsonParser;
	// Testing in localhost using xampp
	// use http://10.0.2.2/ to connect to your localhost ie http://localhost/
	private static String loginURL = "http://webserv.kmitl.ac.th/s4010026/Buddy/sentlog_api/";// มันจะเรียกไป
																									// index.php
	private static String Log_tag = "log";
	
	//สร้าง constructor
	public SentLogToDatabase(Context context) {
		this.mContext = context;
		//ลืมประกาศเลย error
		jsonParser = new JSONParser();
	}

	/**
	 * function make SentLog Request
	 * */
	public JSONObject SentLog(String id, String date, String time, String chanal) {
		
		
		// Building Parametersj
		// เตรียมค่าที่จะส่งขึ้นไป
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", Log_tag));
		params.add(new BasicNameValuePair("id", id));
		params.add(new BasicNameValuePair("date", date));
		params.add(new BasicNameValuePair("time", time));
		params.add(new BasicNameValuePair("chanal", chanal));
		// ส่งค่าที่เตรียมไว้ไปที่ url สำหรับ sentlog แล้วจะได้ json กลับมา
		JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
		return json;
		}
		

	public void getDataFromLoginSQLite() {
		// public getDataFromLoginSQLite(Context context) {}
		// หาวิธีดึงข้อมูลจาก MyDB เอาไป เข้า Json
		MyDB myDb = new MyDB(mContext); 

		ArrayList<HashMap<String, String>> logArrayList = myDb.SelectAllData();

		HashMap<String, String> rowHashMap;
		{
			// *** Add ***//
			for (int i = 0; i < logArrayList.size(); i++) {
				rowHashMap = logArrayList.get(i);
				SentLog(rowHashMap.get("ID"), rowHashMap.get("Date"),
						rowHashMap.get("Time"), rowHashMap.get("Chanal"));
			}

		}

	}
}
