package com.example.bachoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    Button rightbtn,wrongbtn,reportbtn;

    String[] selectedoptionsarray;
    String[] correctanswerarray;
    int rightcount=0,wrongcount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        rightbtn=findViewById(R.id.righta);
        wrongbtn= findViewById(R.id.wronga);
        reportbtn= findViewById(R.id.report);

        //getting arrays from main activity
        selectedoptionsarray = getIntent().getStringArrayExtra("Selected_Option");
        correctanswerarray = getIntent().getStringArrayExtra("Answer_list");
        for(int i=0;i<correctanswerarray.length;i++){
            if(correctanswerarray[i].equals(selectedoptionsarray[i])){
                rightcount++;
            }
            else{
                wrongcount++;
            }
        }


        rightbtn.setText("Right Answers: "+String.valueOf(rightcount));
        wrongbtn.setText("Wrongs Ansers: "+String.valueOf(wrongcount));

        //storing report in database

        //Dphelper
        DBHelper Dbhelper = new DBHelper(MainActivity3.this);
        try {
            int CT_id = Dbhelper.get_Current_Test_id();
            ArrayList<OnlineTest> New_test_report = new ArrayList<>();

            for(int j = 0;j<selectedoptionsarray.length;j++){

                OnlineTest NTest_Report = new OnlineTest();
                NTest_Report.setTest_Id(CT_id);
                NTest_Report.setOptionNo(j);
                NTest_Report.setCorrectAns(correctanswerarray[j]);
                NTest_Report.setGivenAns(selectedoptionsarray[j]);
                if(correctanswerarray[j].equals(selectedoptionsarray[j])) {
                    NTest_Report.setResult("True");
                }
                else {
                    NTest_Report.setResult("False");
                }
                New_test_report.add(NTest_Report);
            }

            Dbhelper.addReport(New_test_report);


        }catch (Exception e){
            Toast.makeText(MainActivity3.this, "New Report Not added", Toast.LENGTH_SHORT).show();
        }

        reportbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling result activity
                Intent resultactivity = new Intent(MainActivity3.this,MainActivity2.class);
                resultactivity.putExtra("Selected_Option", selectedoptionsarray);
                resultactivity.putExtra("Answer_list",correctanswerarray);
                MainActivity3.this.startActivity(resultactivity);
            }
        });
    }
}