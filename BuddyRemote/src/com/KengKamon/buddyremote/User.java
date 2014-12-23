/*package com.KengKamon.buddyremote;

import android.provider.BaseColumns;

public class User {

    public static final String TABLE = "user";
    //===================================================================================
    //=============================										  ===============
    //============================= yung mai dai create email tam mai pen ===============
    //=============================										  ===============
    //===================================================================================
    public class Column {
    	//อาจจะไม่ได้ใช้ Id แต่อันนี้เอามาจาก net ถ้าทำ online อาจต้องสร้าง uid ขึ้นมา 
        public static final String ID = BaseColumns._ID;
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
        // สร้างมาจาก Class UserManager เพื่อสร้างตาราง Email แต่สร้างมาแค่นี้ข้างล่างยังไม่ได้ทำอะไร
		//public static final String EMAIL = "email";
    }

    private int id;
    private String username;
    private String password;
   // private String email;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
*/
