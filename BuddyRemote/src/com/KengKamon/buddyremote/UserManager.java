/**package com.KengKamon.buddyremote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserManager extends SQLiteOpenHelper implements UserManagerHelper {

	// ������������Ѻ Debug ��� read/write database
	public static final String TAG = UserManager.class.getSimpleName();
	private SQLiteDatabase mDatabase;

	public UserManager(Context context) {
		super(context, UserManagerHelper.DATABASE_NAME, null,
				UserManagerHelper.DATABASE_VERSION);
	}

	// ���ҧ Table ����Ҵ��¤���觹��
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE_USER = String.format("CREATE TABLE %s "
				+ "(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT)",
				User.TABLE, 
				User.Column.ID,
				User.Column.USERNAME,
				User.Column.PASSWORD//, 
				//User.Column.EMAIL // ���ҧ������ͧ�͹�á�����
				);

		db.execSQL(CREATE_TABLE_USER);

		Log.i(TAG, CREATE_TABLE_USER);
	}

	// ��Ҩ������� update data on table
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String DROP_USER = "DROP TABLE IF EXISTS "
				+ UserManagerHelper.DATABASE_VERSION;

		db.execSQL(DROP_USER);

		Log.i(TAG, DROP_USER);
		onCreate(mDatabase);
	}

	@Override
	public long registerUser(User user) {

		// ���ͻ�� user �� �ҡ����� ContentValues ���� insert
		// ������ŧ�ҹ������

		mDatabase = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(User.Column.USERNAME, user.getUsername());
		values.put(User.Column.PASSWORD, user.getPassword());

		long result = mDatabase.insert(User.TABLE, null, values);
		mDatabase.close();

		return result;
	}

	@Override
	public User checkUserLogin(User user) {
		/**�Ѻ�������������� �ͻ�� user �ҡ��� ��Ҩ��� user ������� 
		 * �ӡ�����¡�� query � database ��� username ��� password ������������ �Ѻ㹰ҹ������ �ѹ�ç�ѹ���
		 *  ����բ������ʴ���Ҷ١��ͧ ������ͻ�礡�Ѻ� ������ç ����觤�� null
		*/

	/*    mDatabase = this.getReadableDatabase();

	    Cursor cursor = mDatabase.query(User.TABLE,
	            null,
	            User.Column.USERNAME + " = ? AND " +
	                    User.Column.PASSWORD + " = ?",
	            new String[]{user.getUsername(), user.getPassword()},
	            null,
	            null,
	            null);

	    User currentUser = new User();

	    if (cursor != null) {
	        if (cursor.moveToFirst()) {
	            currentUser.setId((int) cursor.getLong(0));
	            currentUser.setUsername(cursor.getString(1));
	            currentUser.setPassword(cursor.getString(2));
	            mDatabase.close();
	            return currentUser;
	        }
	    }

	    return null;
	}

	@Override
	public int changePassword(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

/*	@Override
	public int changePassword(User user) {
		
		//�ӡ������¹ password �ͧ��������� �¡������ update �ҹ������

	    mDatabase = this.getWritableDatabase();

	    ContentValues values = new ContentValues();
	    values.put(User.Column.USERNAME, user.getUsername());
	    values.put(User.Column.PASSWORD, user.getPassword());

	    int row = mDatabase.update(User.TABLE,
	            values,
	            User.Column.ID + " = ?",
	            new String[] {String.valueOf(user.getId())});

	    mDatabase.close();
	    return row;
	}*/
//}
