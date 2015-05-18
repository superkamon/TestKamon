package com.KengKamon.library;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDB extends SQLiteOpenHelper {

	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "mydatabase";

	// Table Name
	private static final String TABLE_LOG = "log";

	public MyDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}


	


	//======================= Create Table ======================================
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + TABLE_LOG
				+"(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "ID INTEGER ," 
				+ " Date TEXT(100),"
				+ " Time TEXT(100), "
				+ " Chanal TEXT(100));"); // อาจมีการเพิ่ม attribute ในภายหน้า
		Log.d("CREATE TABLE", "Create Table Successfully.");

	}
	//===========================================================================
	
	//============================= Insert Data =================================
	public long InsertData(String strID, String strDate, String strTime, String strChanal) {
		// TODO Auto-generated method stub
		
		 try {
			SQLiteDatabase db;
     		db = this.getWritableDatabase(); // Write Data
     		 		
			ContentValues Val = new ContentValues();
			Val.put("ID", strID); 
			Val.put("Date", strDate);
			Val.put("Time", strTime);
			Val.put("Chanal", strChanal);

			long rows = db.insert(TABLE_LOG,null, Val);

			db.close();
			return rows; // return rows inserted.
           
		 } catch (Exception e) {
		    return -1;
		 }

	}
	
	// ========================= Select Data ========================================
		public String[] SelectData(String strMemberID) {
			// TODO Auto-generated method stub
			
			 try {
				String arrData[] = null;	
				
				 SQLiteDatabase db;
				 db = this.getReadableDatabase(); // Read Data
					
				 Cursor cursor = db.query(TABLE_LOG, new String[] { "*" }, 
						 	"ID=?",
				            new String[] { String.valueOf(strMemberID) }, null, null, null, null);
				 
				 	if(cursor != null)
				 	{
						if (cursor.moveToFirst()) {
							arrData = new String[cursor.getColumnCount()];
							/***
							 *  0 = ID
							 *  1 = Date
							 *  2 = Time
							 */
							arrData[0] = cursor.getString(cursor.getColumnIndex("ID"));
							arrData[1] = cursor.getString(cursor.getColumnIndex("Date"));
							arrData[2] = cursor.getString(cursor.getColumnIndex("Time"));
							arrData[3] = cursor.getString(cursor.getColumnIndex("Chanal"));
							//Log.d("Database", "datarow: " + arrData[0] + " " + arrData[1] + " "+ arrData[2]);
						}
				 	}
				 	cursor.close();
					db.close();
					return arrData;
					
			 } catch (Exception e) {
			    return null;
			 }

		}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOG);
		// Re Create on method  onCreate
		onCreate(db);
	}


	public ArrayList<HashMap<String, String>> SelectAllData() {
		// Show All Data
		// TODO Auto-generated method stub
			
			 try {
				 
				 ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
				 HashMap<String, String> map;
				 
				 SQLiteDatabase db;
				 db = this.getReadableDatabase(); // Read Data
					
				 String strSQL = "SELECT  * FROM " + TABLE_LOG;
				 Cursor cursor = db.rawQuery(strSQL, null);
				 
				 	if(cursor != null)
				 	{
				 	    if (cursor.moveToFirst()) {
				 	        do {
				 	        	map = new HashMap<String, String>();
				 	        	map.put("ID", cursor.getString(cursor.getColumnIndex("ID")));
					 	        map.put("Date", cursor.getString(cursor.getColumnIndex("Date")));
					 	        map.put("Time", cursor.getString(cursor.getColumnIndex("Time")));
					 	        map.put("Chanal", cursor.getString(cursor.getColumnIndex("Chanal"))); 
					 	      
					 	        MyArrList.add(map);
				 	        } while (cursor.moveToNext());
				 	    }
				 	}
				 	cursor.close();
				 	db.close();
					return MyArrList;
					
			 } catch (Exception e) {
		
		return null;
			 }

		
		
	}
	
	 public void resetTables(){
	        SQLiteDatabase db = this.getWritableDatabase();
	        // Delete All Rows
	        db.delete(TABLE_LOG, null, null);
	        db.close();
	    }

}