package com.example.earthquakeapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DepremDataBase";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Kullanıcı (id INTEGER PRIMARY KEY, AdSoyad VARCHAR, email VARCHAR, Sifre VARCHAR, Tel VARCHAR)");
        db.execSQL("CREATE TABLE IF NOT EXISTS Yardim (id INTEGER PRIMARY KEY, productName VARCHAR, productComment VARCHAR, numOfProducts INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Kullanıcı");
        db.execSQL("DROP TABLE IF EXISTS Yardim");
        onCreate(db);
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Kullanıcı", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("AdSoyad"));
                @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex("email"));
                @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex("Sifre"));
                @SuppressLint("Range") String phoneNumber = cursor.getString(cursor.getColumnIndex("Tel"));

                User user = new User(id, name, email, password, phoneNumber);
                userList.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return userList;
    }

    public boolean kullaniciKaydet(String adSoyad, String email, String sifre, String tel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("AdSoyad", adSoyad);
        values.put("email", email);
        values.put("Sifre", sifre);
        values.put("Tel", tel);
        long result = db.insert("Kullanıcı", null, values);
        db.close();
        return result != -1;
    }

    public boolean yardimKaydet(String productName, String productComment, int numOfProducts) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("productName", productName);
        values.put("productComment", productComment);
        values.put("numOfProducts", numOfProducts);
        long result = db.insert("Yardim", null, values);
        db.close();
        return result != -1;
    }

    public List<Help> getAllYardim() {
        List<Help> yardimList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Yardim", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String productName = cursor.getString(cursor.getColumnIndex("productName"));
                @SuppressLint("Range") String productComment = cursor.getString(cursor.getColumnIndex("productComment"));
                @SuppressLint("Range") int numOfProducts = cursor.getInt(cursor.getColumnIndex("numOfProducts"));

                Help yardim = new Help(id, productName, productComment, numOfProducts);
                yardimList.add(yardim);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return yardimList;
    }

}