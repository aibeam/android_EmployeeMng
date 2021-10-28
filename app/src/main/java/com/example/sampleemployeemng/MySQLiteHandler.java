package com.example.sampleemployeemng;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class MySQLiteHandler {
    DatabaseHelper helper;
    SQLiteDatabase db;

    public MySQLiteHandler(Context context) {
        helper = new DatabaseHelper(context);
    }

    //database open
    public static MySQLiteHandler open(Context context) {
        return new MySQLiteHandler(context);
    }

    //database close
    public void close() {
        helper.close();
    }

    //database save
    public void insert(String name, int age, String mobile) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("mobile", mobile);
        db.insert("emp", null, values);
    }

    //database update
    public void update(int id, String name, int age, String mobile) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",id);
        values.put("name", name);
        values.put("age", age);
        values.put("mobile", mobile);
        db.update("emp", values, "id=?", new String[]{String.valueOf(id)});
    }

    //database delete
    public void delete(int id) {
        db = helper.getWritableDatabase();
        db.delete("emp","id=?", new String[]{String.valueOf(id)});
    }

    //database select
    @SuppressLint("Range")
    public void select(ArrayList<Employee> list) {
        db = helper.getReadableDatabase();
        Cursor c = db.query("emp", null, null,null, null, null, null);

        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            int age = c.getInt(c.getColumnIndex("age"));
            String mobile = c.getString(c.getColumnIndex("mobile"));

            Employee employee = new Employee(id, name, age, mobile);
            list.add(employee);
            Log.i("emp:", employee.toString());
        }
    }
}
