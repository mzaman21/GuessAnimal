package com.example.bachoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    EditText CandidateName;
    Button Start_Guessing,View_Reports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //Dphelper
        DBHelper Dbhelper = new DBHelper(MainActivity4.this);

        CandidateName = findViewById(R.id.CName);
        Start_Guessing= findViewById(R.id.TStart);
        View_Reports = findViewById(R.id.TReport);

        Start_Guessing.setOnClickListener(new View.OnClickListener() {
            Candidate NewCandidate;
            @Override
            public void onClick(View view) {
                try {

                    NewCandidate = new Candidate(CandidateName.getText().toString());
                    Dbhelper.addTest(NewCandidate);
                    Toast.makeText(MainActivity4.this, "New Candidate"+NewCandidate.getCandidateName()+ "Added", Toast.LENGTH_SHORT).show();
                    Intent Guess_Activity = new Intent(MainActivity4.this,MainActivity.class);
                    MainActivity4.this.startActivity(Guess_Activity);


                }catch (Exception e){
                    Toast.makeText(MainActivity4.this, "Candidate Not added", Toast.LENGTH_SHORT).show();
                }
            }
        });
        View_Reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling result activity
                Intent Reportactivity = new Intent(MainActivity4.this,MainActivity5.class);
                MainActivity4.this.startActivity(Reportactivity);
            }
        });
    }
}