package com.example.quran_prayers_pilgrimages.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DBManager extends SQLiteOpenHelper {


    static String DBName="PassManager.db";
    static String DBPath;
    Context context;
    SQLiteDatabase DB;


    public DBManager(Context context) {
        super(context, DBName, null, 1);
        this.context=context;
        DBPath=context.getExternalCacheDir().getPath()+"/"+DBName;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void OpenDB()
    {
        if (DBExits())
        {
            try
            {
                DB=SQLiteDatabase.openDatabase(DBPath,null,SQLiteDatabase.OPEN_READWRITE);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            if(CopyDB())
            {
                OpenDB();
            }
        }
    }

    public Boolean DBExits()
    {
        File file=new File(DBPath);
        if (file.exists())
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public Boolean CopyDB()
    {
        try {
            OutputStream outputStream = new FileOutputStream(DBPath);
            InputStream inputStream = context.getAssets().open(DBName);
            byte[] buffer = new byte[1024];
            int ch;
            while ((ch = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, ch);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }


    @Override
    public synchronized void close() {
        super.close();
    }


    public String Show()
    {
        OpenDB();
        Cursor cursor= DB.rawQuery("select Audio from Works_Tbl where id=1",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }
}
