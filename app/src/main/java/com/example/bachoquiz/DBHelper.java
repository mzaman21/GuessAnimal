package com.example.bachoquiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String Online_Test_Table = "OnliestTestResult";
    public static final String Id = "Id";
    public static final String Option_No = "OptionNo";
    public static final String Correct_Ans = "CorrectAns";
    public static final String Given_Ans = "GivenAns";
    public static final String Result = "Result";

    public DBHelper(Context context) {
        super(context, "OnlineTestDB.db",null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase TestResult) {
        String createTableSTatement = "CREATE TABLE " + Online_Test_Table + "(" + Id + " Integer PRIMARY KEY AUTOINCREMENT, " + Option_No + " Int, " + Correct_Ans + " Text, " + Given_Ans + "Text"+ Result +" Text) ";
        TestResult.execSQL(createTableSTatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
