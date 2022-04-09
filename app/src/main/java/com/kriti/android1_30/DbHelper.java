package com.kriti.android1_30;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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

    int updateData(int rollno, String name)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        return sq.update(TABLE_NAME, cv, "rollno = " + rollno, null);
    }

    int deleteData(int rollno)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        return sq.delete(TABLE_NAME, "rollno = " + rollno, null);
    }

    ArrayList<StudentData> getAllData()
    {
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor cursor = sq.rawQuery("select * from " + TABLE_NAME, null);
        ArrayList <StudentData> students = new ArrayList<>();

        while (cursor.moveToNext())
        {
            StudentData std = new StudentData();
            std.setRollno(cursor.getInt(0));
            std.setName(cursor.getString(1));
            std.setGender(cursor.getString(2));
            students.add(std);
            Log.d("Info", std.toString());
        }

        return students;
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
