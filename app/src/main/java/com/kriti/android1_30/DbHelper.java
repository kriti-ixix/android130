package com.kriti.android1_30;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper
{
    static final String DB_NAME = "School";
    static final int DB_VER = 1;
    static final String TABLE_NAME = "students";

    public DbHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VER);
    }

    long insertData(int rollno, String name, String gender)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("rollno", rollno);
        cv.put("name", name);
        cv.put("gender", gender);
        return sq.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(rollno integer primary key, name text, " +
                "gender text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
