package com.example.bachoquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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

        String createTestTable = "CREATE TABLE " + Online_Test_Table + "(" + Id + " Integer PRIMARY KEY AUTOINCREMENT, " + Candidate_Name + " Text) ";
        TestResult.execSQL(createTestTable);

        String createResultTable = "CREATE TABLE " + Report_Table + "(" + Id + " Integer PRIMARY KEY AUTOINCREMENT, "+ Report_Test_Id + " Int, " + Option_No + " Int, " + Correct_Ans + " Text, " + Given_Ans + " Text, "+ Result +" Text) ";
        TestResult.execSQL(createResultTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDatabase, int oldVersion, int newVersion) {

        // If you need to add a column
        if (newVersion > oldVersion) {
            myDatabase.execSQL("ALTER TABLE Report_Table ADD COLUMN Report_Test_Id INTEGER");
        }
    }
    public void  addTest(Candidate CandidateTest){
        SQLiteDatabase db = this.getWritableDatabase();

        //Hash map, as we did in bundles
        ContentValues cv= new ContentValues();

        cv.put(Candidate_Name, CandidateTest.getCandidateName());

        db.insert(Online_Test_Table, null, cv);
        db.close();
    }
    public void  addReport(ArrayList<OnlineTest> Report){

        //Hash map, as we did in bundles
        SQLiteDatabase db = this.getWritableDatabase();
        for(int i = 0 ; i < Report.size(); i++) {

            ContentValues cv= new ContentValues();
            cv.put(Option_No, Report.get(i).getOptionNo());
            cv.put(Report_Test_Id, Report.get(i).getTest_Id());
            cv.put(Correct_Ans, Report.get(i).getCorrectAns());
            cv.put(Given_Ans, Report.get(i).getGivenAns());
            cv.put(Result, Report.get(i).getResult());
            db.insert(Report_Table, null, cv);
        }
        db.close();
    }
    public ArrayList<OnlineTest> getTestReport(int Tid) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor Report_Cursor = db.rawQuery("SELECT * FROM Report WHERE TestId=?" , new String[]{String.valueOf(Tid)});

        ArrayList<OnlineTest> Test_Report = new ArrayList<>();

        // moving our cursor to first position.
        if (Report_Cursor.moveToFirst()) {
            do {
                OnlineTest Option = new OnlineTest();
                Option.setOptionNo(Report_Cursor.getInt(2));
                Option.setTest_Id(Report_Cursor.getInt(1));
                Option.setCorrectAns(Report_Cursor.getString(3));
                Option.setGivenAns(Report_Cursor.getString(4));
                Option.setResult(Report_Cursor.getString(5));
                Test_Report.add(Option);
            } while (Report_Cursor.moveToNext());

        }
        Report_Cursor.close();
        return Test_Report;
    }
    public Candidate getUserTest(int Tid) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor Candidate_Cursor = db.rawQuery("SELECT * FROM Online_Test WHERE Id=?" , new String[]{String.valueOf(Tid)});
        Candidate candidate_test = new Candidate();
        // moving our cursor to first position.
        if (Candidate_Cursor.moveToFirst()) {
            do {

                candidate_test.setId(Candidate_Cursor.getInt(0));
                candidate_test.setCandidateName(Candidate_Cursor.getString(1));

            } while (Candidate_Cursor.moveToNext());

        }
        Candidate_Cursor.close();
        return candidate_test;
    }
    public ArrayList<Integer> getTest_Ids() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor TestIds_Cursor = db.rawQuery("SELECT Id FROM Online_Test" , null);
        Candidate Test_Ids = new Candidate();
        ArrayList<Integer> IDs_List= new ArrayList<>();
        // moving our cursor to first position.
        if (TestIds_Cursor.moveToFirst()) {
            do {
                int id = 0;
                id=TestIds_Cursor.getInt(0);
                IDs_List.add(id);
            } while (TestIds_Cursor.moveToNext());

        }
        TestIds_Cursor.close();
        return IDs_List;
    }
    public int get_Current_Test_id() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor CTest_Id_Cursor = db.rawQuery("SELECT * FROM Online_Test ORDER BY Id DESC LIMIT 1" , null);

        int id = 0;

        // moving our cursor to first position.
        if (CTest_Id_Cursor.moveToFirst()) {
            do {

                id = CTest_Id_Cursor.getInt(0);

            } while (CTest_Id_Cursor.moveToNext());

        }
        CTest_Id_Cursor.close();
        return id;
    }

}
