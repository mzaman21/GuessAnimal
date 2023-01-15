package com.example.bachoquiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String Online_Test_Table = "Online_Test";
    public static final String Report_Table = "Report";
    public static final String Id = "Id";
    public static final String Option_No = "OptionNo";
    public static final String Correct_Ans = "CorrectAns";
    public static final String Given_Ans = "GivenAns";
    public static final String Result = "Result";
    public static final String Report_Test_Id = "TestId";
    public static final String Candidate_Name = "CandidateName";

    public DBHelper(Context context) {
        super(context, "OnlineTestDB.db",null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase TestResult) {

        String createTestTable = "CREATE TABLE " + Online_Test_Table + "(" + Id + " Integer PRIMARY KEY AUTOINCREMENT, " + Candidate_Name + "Text ) ";
        TestResult.execSQL(createTestTable);

        String createResultTable = "CREATE TABLE " + Report_Table + "(" + Id + " Integer PRIMARY KEY AUTOINCREMENT, "+ Report_Test_Id + "Int" + Option_No + " Int, " + Correct_Ans + " Text, " + Given_Ans + "Text"+ Result +" Text) ";
        TestResult.execSQL(createResultTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
