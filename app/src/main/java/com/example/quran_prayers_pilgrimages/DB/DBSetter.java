package com.example.quran_prayers_pilgrimages.DB;

import android.content.Context;

public class DBSetter {

    void AddAccount(Context context, String Title, String UserName, String PassWord, String Url, String Catgory, String Priority, String Discriptions)
    {
        DBManager dbManager= new DBManager(context);
        dbManager.OpenDB();
        String query="INSERT INTO AccountTbl (TItle,UserName,PassWord,Url,Catgory,Priority,Discription) VALUES (" + "'" + Title+ "',"+
                "'"+UserName+"',"+
                "'"+PassWord+"',"+
                "'"+Url+"',"+
                "'"+Catgory+"',"+
                "'"+Priority+"',"+
                "'"+Discriptions+"')";

        dbManager.DB.execSQL(query);
    }

    void RemoveAccount(Context context,Integer Position)
    {
        DBManager dbManager=new DBManager(context);
        dbManager.OpenDB();
        DBGetter dbGetter=new DBGetter();
        String query="Delete from AccountTbl where ID="+dbGetter.GetID(context,Position);;
        dbManager.DB.execSQL(query);
    }

    void UpdateAccount(Context context,String Title, String UserName, String PassWord, String Url, String Catgory, String Priority, String Discriptions, Integer Position)
    {
        DBManager dbManager=new DBManager(context);
        dbManager.OpenDB();
        DBGetter dbGetter=new DBGetter();
        String query="update AccountTbl set Title=" + "'" +Title+"',"
                + "Username=" + "'" +UserName+"',"
                + "PassWord=" + "'" +PassWord+"',"
                + "Url=" + "'" +Url+"',"
                + "Catgory=" + "'" +Catgory+"',"
                + "Priority=" + "'" +Priority+"',"
                + "Discription=" + "'" +Discriptions+"' where ID=" +dbGetter.GetID(context,Position);
        dbManager.DB.execSQL(query);
    }

    void UpdatePassWordLogin(Context context,String PassWord)
    {
        DBManager dbManager=new DBManager(context);
        dbManager.OpenDB();
        String query="update LoginTbl set PassWordLogin=" + "'" + PassWord +"'";
        dbManager.DB.execSQL(query);
    }
}
