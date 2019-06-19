package com.henry.wordpad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    private static final int VERSION = 1;
    private static final String DB_NAME = "mystock.db";
    public static final String TB_NAME = "tb_stockes";

    public DBHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public DBHelper(Context context){
        super(context,DB_NAME,null,VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TB_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,STOCKNAME TEXT,STOCKINDEX TEXT,STOCKLEAD TEXT,STOCKRANGE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}