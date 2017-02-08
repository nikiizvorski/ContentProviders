package com.nikiizvorski.contentproviders.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE = "DBto";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_MSG = "message";
    public static final String COLUMN_ID = "_ID";
    public static final String COLUMN_NAME = "name";

    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = " CREATE TABLE " + TABLE_MSG + " ( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT NOT NULL);";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
}

