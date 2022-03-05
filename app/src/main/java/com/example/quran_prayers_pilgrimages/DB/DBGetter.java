package com.example.quran_prayers_pilgrimages.DB;

import android.content.Context;
import android.database.Cursor;

public class DBGetter {



    Integer GetIndexCount(Context context)
    {
        DBManager dbManager=new DBManager(context);
        dbManager.OpenDB();
        Cursor cursor= dbManager.DB.rawQuery("select * from AccountTbl",null);
        return cursor.getCount();
    }

    Integer GetID(Context context,int Position) {
        DBManager dbManager = new DBManager(context);
        dbManager.OpenDB();
        Cursor cursor=dbManager.DB.rawQuery("select ID from AccountTbl",null);
        cursor.moveToPosition(Position);
        return cursor.getInt(0);
    }


    String GetTitle(Context context,int Position)
    {
        DBManager dbManager=new DBManager(context);
        dbManager.OpenDB();
        Cursor cursor= dbManager.DB.rawQuery("select Title from AccountTbl",null);
        cursor.moveToPosition(Position);
        return cursor.getString(0);
    }

    String GetUserName(Context context,int Position)
    {
        DBManager dbManager=new DBManager(context);
        dbManager.OpenDB();
        Cursor cursor= dbManager.DB.rawQuery("select UserName from AccountTbl",null);
        cursor.moveToPosition(Position);
        return cursor.getString(0);
    }

    String GetPassWord(Context context,int Position)
    {
        DBManager dbManager=new DBManager(context);
        dbManager.OpenDB();
        Cursor cursor= dbManager.DB.rawQuery("select PassWord from AccountTbl",null);
        cursor.moveToPosition(Position);
        return cursor.getString(0);
    }

    String GetUrl(Context context,int Position)
    {
        DBManager dbManager=new DBManager(context);
        dbManager.OpenDB();
        Cursor cursor= dbManager.DB.rawQuery("select Url from AccountTbl",null);
        cursor.moveToPosition(Position);
        return cursor.getString(0);
    }

    String GetCatgory(Context context,int Position)
    {
        DBManager dbManager=new DBManager(context);
        dbManager.OpenDB();
        Cursor cursor= dbManager.DB.rawQuery("select Catgory from AccountTbl",null);
        cursor.moveToPosition(Position);
        return cursor.getString(0);
    }

    String GetPririty(Context context,int Position)
    {
        DBManager dbManager=new DBManager(context);
        dbManager.OpenDB();
        Cursor cursor= dbManager.DB.rawQuery("select Priority from AccountTbl",null);
        cursor.moveToPosition(Position);
        return cursor.getString(0);
    }

    String GetDiscription(Context context,int Position)
    {
        DBManager dbManager=new DBManager(context);
        dbManager.OpenDB();
        Cursor cursor= dbManager.DB.rawQuery("select Discription from AccountTbl",null);
        cursor.moveToPosition(Position);
        return cursor.getString(0);
    }

    String GetPassWordLogin(Context context)
    {
        DBManager dbManager=new DBManager(context);
        dbManager.OpenDB();
        Cursor cursor= dbManager.DB.rawQuery("select PassWordLogin from LoginTbl",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }

}
