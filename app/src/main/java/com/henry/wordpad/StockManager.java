package com.henry.wordpad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class StockManager {
    private DBHelper dbHelper;
    private String TBNAME;

    public StockManager(Context context){
        dbHelper = new DBHelper(context);
        TBNAME = DBHelper.TB_NAME;
    }

    public void add(StockItem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("stockname", item.getStockName());
        values.put("stockindex", item.getStockIndex());
        values.put("stocklead", item.getStockLead());
        values.put("stockrange", item.getStockRange());
        db.insert(TBNAME,null,values);
        db.close();
    }

    public void deleteAll(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,null,null);
        db.close();
    }

    public void addAll(List<StockItem> list){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        for(StockItem item : list){
            ContentValues values = new ContentValues();
            values.put("stockname",item.getStockName());
            values.put("stockindex",item.getStockIndex());
            values.put("stocklead", item.getStockLead());
            values.put("stockrange", item.getStockRange());
            db.insert(TBNAME,null,values);
        }
        db.close();
    }


     public List<StockItem> listAll(){
        List<StockItem> stockList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME,null,null,null,null,null,null);
        if(cursor!=null){
           stockList = new ArrayList<StockItem>();
            while(cursor.moveToNext()){
                StockItem item = new StockItem();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setStockName(cursor.getString(cursor.getColumnIndex("STOCKNAME")));
                item.setStockIndex(cursor.getString(cursor.getColumnIndex("STOCKINDEX")));
                item.setStockLead(cursor.getString(cursor.getColumnIndex("STOCKLEAD")));
                item.setStockRange(cursor.getString(cursor.getColumnIndex("STOCKRANGE")));
                stockList.add(item);
            }
            cursor.close();
        }
        db.close();
        return stockList;
    }
}
