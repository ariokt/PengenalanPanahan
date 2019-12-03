package com.example.ariowaskito.pengenalanpanahan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDbHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME="dbq.db";
	private static final int SCHEMA_VERSION=1;	
	public myDbHelper(Context context){super(context, DATABASE_NAME, null, SCHEMA_VERSION);}
	


	private static final String tb_koordinat="tbq";
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL("CREATE TABLE "+tb_koordinat+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, usia TEXT, jk TEXT,hasil TEXT, waktu TEXT, keterangan TEXT)");
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}
	public Cursor getAll(){
		return (getReadableDatabase().rawQuery("SELECT _id, nama, usia, jk, hasil, waktu, keterangan FROM "+tb_koordinat+" order by nama asc", null));
	}	
	public Cursor gCount(){
		return (getReadableDatabase().rawQuery("SELECT COUNT(*) as `row` FROM "+tb_koordinat+"", null));
	}
	public Cursor getBy_id(String id){
		String[] args={id};
		return (getReadableDatabase().rawQuery("SELECT _id, nama, usia, jk,hasil, waktu, keterangan FROM "+tb_koordinat+" WHERE _id=?", args));
	}
	//insertkoordinat
	public void insertDb(String nama, String usia, String jk,String hasil, String waktu, String keterangan){
		ContentValues cv=new ContentValues();
		cv.put("nama", nama);
		cv.put("usia", usia);
		cv.put("jk", jk);
		cv.put("hasil", hasil);
		cv.put("waktu", waktu);
		cv.put("keterangan", keterangan);
		getWritableDatabase().insert(tb_koordinat,"nama", cv);
	}
	public void updateDb(String id, String nama, String usia, String jk,String hasil, String waktu, String keterangan){
		ContentValues cv=new ContentValues();
		String[] args={id};
		cv.put("nama", nama);
		cv.put("usia", usia);
		cv.put("jk", jk);
		cv.put("hasil", hasil);
		cv.put("waktu", waktu);
		cv.put("keterangan", keterangan);
		getWritableDatabase().update(tb_koordinat,cv,"_id=?", args);
	}
	public void deleteDb(String id){
		String[] args={id};
		getWritableDatabase().delete(tb_koordinat,"_id=?", args);
	}
	public String getnama(Cursor c){return(c.getString(1));}
	public String getusia(Cursor c){return(c.getString(2));}
	public String getjk(Cursor c){return(c.getString(3));}
	public String gethasil(Cursor c){return(c.getString(4));}
	public String getwaktu(Cursor c){return(c.getString(5));}
	public String getketerangan(Cursor c){return(c.getString(6));}

}


