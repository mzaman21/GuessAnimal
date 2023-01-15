package com.example.bachoquiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String id = "Id";
    public static final String Option_No = "OptionNo";
    public static final String Correct_Ans = "CorrectAns";
    public static final String Given_Ans = "GivenAns";
    public static final String Result = "Result";

    public DBHelper(Context context) {
        super(context, "OnlineTestDB.db",null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
