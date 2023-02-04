package com.example.teacherquranapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHandler   extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ROLLNO = "rollNo";

    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SABQ = "sabq";
    private static final String COLUMN_SABQI = "sabqi";
    private static final String COLUMN_MANZIL = "manzil";

    public DBHandler( Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_ROLLNO + " TEXT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_SABQ + " TEXT,"
                + COLUMN_MANZIL + " TEXT,"
                + COLUMN_SABQI + " TEXT"

                + ")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public  boolean insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_ROLLNO, student.getRollNo());
        values.put(COLUMN_SABQ, student.getSabq());
        values.put(COLUMN_SABQI, student.getSabqi());
        values.put(COLUMN_MANZIL, student.getManzil());


        long result= db.insert(TABLE_NAME, null, values);
        db.close();
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor ReadAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    public  boolean updateData(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_ROLLNO, student.getRollNo());
        values.put(COLUMN_SABQ, student.getSabq());
        values.put(COLUMN_SABQI, student.getSabqi());
        values.put(COLUMN_MANZIL, student.getManzil());

        long result = db.update(TABLE_NAME, values, "rollNo=?", new String[]{student.getRollNo()});
        db.close();

        if (result == -1) {

            return false;
        } else {
            return true;
        }
    }

    public  boolean deleteData(String rollNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result =db.delete(TABLE_NAME, COLUMN_ROLLNO + " = ?", new String[] {rollNo});
        db.close();
        if (result == -1) {

            return false;
        } else {
            return true;
        }
    }
}


