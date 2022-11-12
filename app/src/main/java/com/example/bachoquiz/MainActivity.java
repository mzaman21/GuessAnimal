package com.example.bachoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView QuestionNo;
    ImageView animal;
    Button next,op1,op2,op3,op4;

    String[] selectedOption={"","","","","","","","","",""};
    String [] Answerlist ={"","","","","","","","","",""};
    Integer[] animalarray={
            R.drawable.dog,
            R.drawable.cat,
            R.drawable.goat,
            R.drawable.cow,
            R.drawable.duck,
            R.drawable.giraffe,
            R.drawable.hen,
            R.drawable.horse,
            R.drawable.rabbit,
            R.drawable.lion
    };
    String[] animalNames= {
            "Dog",
            "Cat",
            "Goat",
            "Cow",
            "duck",
            "Giraffe",
            "Hen",
            "Horse",
            "Rabbit",
            "Lion"
    };
    String[] currentoptionList={"","","",""};

    //variables
    int pickAnimalIndex,pickAnimalOptionIndex,optionvalue,selectedoptionIndex=0,AnswerIndex,incrementor=0,Questions=1;
    boolean checkduplicate;
    String Answer;

    //random numbers generation
    Random randomAnimalSelector = new Random();
    Random randomOptionSelector = new Random();
    Random AnswerPosition = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting id's
        QuestionNo = findViewById(R.id.questionno);

        animal = findViewById(R.id.animalpicture);

        op1 = findViewById(R.id.optionone);
        op2 = findViewById(R.id.optiontwo);
        op3 = findViewById(R.id.optionthree);
        op4 = findViewById(R.id.optionfour);

        next = findViewById(R.id.nextbtn);

        //first question call
        mainfunctionality();

        //next btn on click listener
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainfunctionality();
            }
        });


    }

    //all main functionality
    public void mainfunctionality(){


        if(Questions!=11) {


            String Qno_Counter = String.valueOf(Questions);
            QuestionNo.setText(Qno_Counter);

            //randomly set image
            pickAnimalIndex = randomAnimalSelector.nextInt(animalarray.length);
            animal.setImageResource(animalarray[pickAnimalIndex]);

            //set current question answer
            Answer = animalNames[pickAnimalIndex];

            //randomly set answer in option list
            AnswerIndex = AnswerPosition.nextInt(currentoptionList.length);
            currentoptionList[AnswerIndex] = Answer;

            //randomly set other three options in options list
            while (incrementor != 4) {
                optionvalue = randomAnimalOptions();
                //handle not to place at answer position
                if (incrementor != AnswerIndex) {
                    //handle duplication of options
                    if (checkoptions(optionvalue)) {
                        checkduplicate = true;
                        while (checkduplicate != false) {
                            optionvalue = randomAnimalOptions();
                            if (checkoptions(optionvalue) == false) {
                                checkduplicate = false;
                            }
                        }
                        currentoptionList[incrementor] = animalNames[optionvalue];
                        checkduplicate = true;
                    } else {
                        currentoptionList[incrementor] = animalNames[optionvalue];
                    }
                }
                //loop counter
                incrementor++;
            }

            //setting options on view
            op1.setText(currentoptionList[0]);
            op2.setText(currentoptionList[1]);
            op3.setText(currentoptionList[2]);
            op4.setText(currentoptionList[3]);

            //get selected option
            selectedAnswer();

            //clear options and checked options
            if (Questions != 0) {
                clearoptionlist();
                op1.setEnabled(true);
                op2.setEnabled(true);
                op3.setEnabled(true);
                op4.setEnabled(true);
            }
            Questions++;
            incrementor = 0;
        }
        else{

            //calling result activity
            Intent resultactivity = new Intent(MainActivity.this,MainActivity2.class);
            resultactivity.putExtra("Selected_Option", selectedOption);
            resultactivity.putExtra("Answer_list",Answerlist);
            this.startActivity(resultactivity);
        }
    }

    //clear options
    public  void  clearoptionlist(){
        for(int i=0;i<currentoptionList.length;i++){
            currentoptionList[i]="";
        }
    }

    //select random animal name for options
    public int randomAnimalOptions() {
            pickAnimalOptionIndex = randomOptionSelector.nextInt(animalNames.length);
            return pickAnimalOptionIndex;
    }

    //check weather duplicate or not
    public boolean checkoptions(int optionvalue){

        boolean checkoptionflag= false;

        //loop through the current option list
        for(int i =0;i<currentoptionList.length;i++){
            if(currentoptionList[i]==animalNames[optionvalue]) {
                checkoptionflag=true;
            }
        }
        //return true or false
        return checkoptionflag;
    }


    //get selected option
    public  void selectedAnswer(){

        //on click listneres
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOption[selectedoptionIndex]=op1.getText().toString();
                op1.setText("AnswerLocked");
                Answerlist[selectedoptionIndex]=Answer;
                selectedoptionIndex++;

                //disables other options
                op2.setEnabled(false);
                op3.setEnabled(false);
                op4.setEnabled(false);
            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOption[selectedoptionIndex]=op2.getText().toString();
                op2.setText("Answer Locked");
                Answerlist[selectedoptionIndex]=Answer;
                selectedoptionIndex++;

                //disables other options
                op3.setEnabled(false);
                op4.setEnabled(false);
                op1.setEnabled(false);
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOption[selectedoptionIndex]=op3.getText().toString();
                op3.setText("Answer Locked");
                Answerlist[selectedoptionIndex]=Answer;
                selectedoptionIndex++;

                //disables other options
                op1.setEnabled(false);
                op2.setEnabled(false);
                op4.setEnabled(false);
            }
        });
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOption[selectedoptionIndex]=op4.getText().toString();
                op4.setText("Answer Locked");
                Answerlist[selectedoptionIndex]=Answer;
                selectedoptionIndex++;

                //disables other options
                op1.setEnabled(false);
                op2.setEnabled(false);
                op3.setEnabled(false);
            }
        });
    }
}