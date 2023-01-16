package com.example.bachoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    //result variables
    TextView CorrectAns1,CorrectAns2,CorrectAns3,CorrectAns4,CorrectAns5,CorrectAns6,CorrectAns7,CorrectAns8,CorrectAns9,CorrectAns10
            ,MarkAns1,MarkAns2,MarkAns3,MarkAns4,MarkAns5,MarkAns6,MarkAns7,MarkAns8,MarkAns9,MarkAns10,ResultAns1,ResultAns2,ResultAns3
            ,ResultAns4,ResultAns5,ResultAns6,ResultAns7,ResultAns8,ResultAns9,ResultAns10;
  Button Share_Button,Git_Repo;

    String[] selectedoptionsarray={"","","","","","","","","",""};
    String [] correctanswerarray ={"","","","","","","","","",""};
    String [] Resultarray ={"","","","","","","","","",""};

    int i=0,rightcount=0,wrongcount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DBHelper Dbhelper = new DBHelper(MainActivity2.this);

        ArrayList<OnlineTest> Get_Test_Report = new ArrayList<>();
        try {

            int id = Dbhelper.get_Current_Test_id();
            Get_Test_Report = Dbhelper.getTestReport(id);

        }catch (Exception e){
            Toast.makeText(MainActivity2.this, "Unable to get report", Toast.LENGTH_SHORT).show();
        }

        for (int j=0; j<selectedoptionsarray.length;j++){
            selectedoptionsarray[j]= Get_Test_Report.get(j).getGivenAns();
            correctanswerarray[j]= Get_Test_Report.get(j).getCorrectAns();
            Resultarray[j]= Get_Test_Report.get(j).getResult();
        }


        //getting arrays from main activity
       // selectedoptionsarray = getIntent().getStringArrayExtra("Selected_Option");
       // correctanswerarray = getIntent().getStringArrayExtra("Answer_list");

        //map elements
        CorrectAns1= findViewById(R.id.A1);
        CorrectAns2= findViewById(R.id.A2);
        CorrectAns3= findViewById(R.id.A3);
        CorrectAns4= findViewById(R.id.A4);
        CorrectAns5= findViewById(R.id.A5);
        CorrectAns6= findViewById(R.id.A6);
        CorrectAns7= findViewById(R.id.A7);
        CorrectAns8= findViewById(R.id.A8);
        CorrectAns9= findViewById(R.id.A9);
        CorrectAns10= findViewById(R.id.A10);

        MarkAns1=findViewById(R.id.YA1);
        MarkAns2=findViewById(R.id.YA2);
        MarkAns3=findViewById(R.id.YA3);
        MarkAns4=findViewById(R.id.YA4);
        MarkAns5=findViewById(R.id.YA5);
        MarkAns6=findViewById(R.id.YA6);
        MarkAns7=findViewById(R.id.YA7);
        MarkAns8=findViewById(R.id.YA8);
        MarkAns9=findViewById(R.id.YA9);
        MarkAns10=findViewById(R.id.YA10);

        ResultAns1=findViewById(R.id.R1);
        ResultAns2=findViewById(R.id.R2);
        ResultAns3=findViewById(R.id.R3);
        ResultAns4=findViewById(R.id.R4);
        ResultAns5=findViewById(R.id.R5);
        ResultAns6=findViewById(R.id.R6);
        ResultAns7=findViewById(R.id.R7);
        ResultAns8=findViewById(R.id.R8);
        ResultAns9=findViewById(R.id.R9);
        ResultAns10=findViewById(R.id.R10);

        //setting each options result
        CorrectAns1.setText(correctanswerarray[i]);
        MarkAns1.setText(selectedoptionsarray[i]);
        ResultAns1.setText(Resultarray[i]);
//        if(correctanswerarray[i].equals(selectedoptionsarray[i])){
//            ResultAns1.setText("True");
//        }
//        else{
//            ResultAns1.setText("False");
//        }
        i++;
        CorrectAns2.setText(correctanswerarray[i]);
        MarkAns2.setText(selectedoptionsarray[i]);
        ResultAns2.setText(Resultarray[i]);
//        if(correctanswerarray[i].equals(selectedoptionsarray[i])){
//            ResultAns2.setText("True");
//        }
//        else{
//            ResultAns2.setText("False");
//        }
        i++;
        CorrectAns3.setText(correctanswerarray[i]);
        MarkAns3.setText(selectedoptionsarray[i]);
        ResultAns3.setText(Resultarray[i]);
//        if(correctanswerarray[i].equals(selectedoptionsarray[i])){
//            ResultAns3.setText("True");
//        }
//        else{
//            ResultAns3.setText("False");
//        }
        i++;
        CorrectAns4.setText(correctanswerarray[i]);
        MarkAns4.setText(selectedoptionsarray[i]);
        ResultAns4.setText(Resultarray[i]);
//        if(correctanswerarray[i].equals(selectedoptionsarray[i])){
//            ResultAns4.setText("True");
//        }
//        else{
//            ResultAns4.setText("False");
//        }
        i++;
        CorrectAns5.setText(correctanswerarray[i]);
        MarkAns5.setText(selectedoptionsarray[i]);
        ResultAns5.setText(Resultarray[i]);
//        if(correctanswerarray[i].equals(selectedoptionsarray[i])){
//            ResultAns5.setText("True");
//        }
//        else{
//            ResultAns5.setText("False");
//        }
        i++;
        CorrectAns6.setText(correctanswerarray[i]);
        MarkAns6.setText(selectedoptionsarray[i]);
        ResultAns6.setText(Resultarray[i]);
//        if(correctanswerarray[i].equals(selectedoptionsarray[i])){
//            ResultAns6.setText("True");
//        }
//        else{
//            ResultAns6.setText("False");
//        }
        i++;
        CorrectAns7.setText(correctanswerarray[i]);
        MarkAns7.setText(selectedoptionsarray[i]);
        ResultAns7.setText(Resultarray[i]);
//        if(correctanswerarray[i].equals(selectedoptionsarray[i])){
//            ResultAns7.setText("True");
//        }
//        else{
//            ResultAns7.setText("False");
//        }
        i++;
        CorrectAns8.setText(correctanswerarray[i]);
        MarkAns8.setText(selectedoptionsarray[i]);
        ResultAns8.setText(Resultarray[i]);
//        if(correctanswerarray[i].equals(selectedoptionsarray[i])){
//            ResultAns8.setText("True");
//        }
//        else{
//            ResultAns8.setText("False");
//        }
        i++;
        CorrectAns9.setText(correctanswerarray[i]);
        MarkAns9.setText(selectedoptionsarray[i]);
        ResultAns9.setText(Resultarray[i]);
//        if(correctanswerarray[i].equals(selectedoptionsarray[i])){
//            ResultAns9.setText("True");
//        }
//        else{
//            ResultAns9.setText("False");
//        }
        i++;
        CorrectAns10.setText(correctanswerarray[i]);
        MarkAns10.setText(selectedoptionsarray[i]);
        ResultAns10.setText(Resultarray[i]);
//        if(correctanswerarray[i].equals(selectedoptionsarray[i])){
//            ResultAns10.setText("True");
//        }
//        else{
//            ResultAns10.setText("False");
//        }
        i++;

        Share_Button = findViewById(R.id.Gitbtn);
        Git_Repo = findViewById(R.id.Gitbtn);
        Share_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

            }
        });
        Git_Repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://github.com/mzaman21/GuessAnimal.git");
                Intent intent = new
                        Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });
    }
}