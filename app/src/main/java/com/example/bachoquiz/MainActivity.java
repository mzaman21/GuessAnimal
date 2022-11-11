package com.example.bachoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView animal;
    RadioGroup Optionlist;
    RadioButton optionselected,animalop1,animalop2,animalop3,animalop4;

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
    int pickAnimalIndex,pickAnimalOptionIndex,optionvalue,previousoptionIndex=0,AnswerIndex,incrementor=0;
    boolean checkduplicate;
    String Answer;
    Random randomAnimalSelector = new Random();
    Random randomOptionSelector = new Random();
    Random AnswerPosition = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalop1= findViewById(R.id.firstoption);
        animalop2= findViewById(R.id.secondoption);
        animalop3= findViewById(R.id.thirdoption);
        animalop4= findViewById(R.id.fourthoption);

        pickAnimalIndex = randomAnimalSelector.nextInt(animalarray.length);

        animal = findViewById(R.id.animalpicture);
        animal.setImageResource(animalarray[pickAnimalIndex]);
        Answer=animalNames[pickAnimalIndex];

        //randomly set answer
        AnswerIndex =AnswerPosition.nextInt(currentoptionList.length);
        currentoptionList[AnswerIndex] = Answer;

        while (incrementor!=4){
            optionvalue = randomAnimalOptions();
            if(incrementor!=AnswerIndex) {
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
            incrementor++;
        }

        animalop1.setText(currentoptionList[0]);
        animalop2.setText(currentoptionList[1]);
        animalop3.setText(currentoptionList[2]);
        animalop4.setText(currentoptionList[3]);
    }
    public int randomAnimalOptions() {
            pickAnimalOptionIndex = randomOptionSelector.nextInt(animalNames.length);
            return pickAnimalOptionIndex;
    }
    public boolean checkoptions(int optionvalue){
        boolean checkoptionflag= false;

        for(int i =0;i<currentoptionList.length;i++){
            if(currentoptionList[i]==animalNames[optionvalue]) {
                checkoptionflag=true;
            }
        }
        return checkoptionflag;
    }

}