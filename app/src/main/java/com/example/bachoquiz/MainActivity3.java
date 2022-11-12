package com.example.bachoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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