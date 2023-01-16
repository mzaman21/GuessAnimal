package com.example.bachoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    EditText Test_id;
    Button Test_Report;
    ListView IDs_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        DBHelper Dbhelper = new DBHelper(MainActivity5.this);
        ArrayList<Integer> given_test_ids = new ArrayList<>();

        Test_id = findViewById(R.id.VRid);
        Test_Report = findViewById(R.id.VRbtn);
        IDs_list = findViewById(R.id.Rids);

        try {
            //setting test_ids in list view
            given_test_ids = Dbhelper.getTest_Ids();
            ArrayAdapter IdsAdapter = new ArrayAdapter<Integer>(MainActivity5.this, android.R.layout.simple_list_item_1,given_test_ids);
            IDs_list.setAdapter(IdsAdapter);

        }catch (Exception e){
            Toast.makeText(MainActivity5.this, "ids not set into the list view", Toast.LENGTH_SHORT).show();
        }

        Test_Report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(Test_id.getText().toString());
                try {
//                    //setting test_ids in list view
//                    given_test_ids = Dbhelper.getTest_Ids();
//                    ArrayAdapter IdsAdapter = new ArrayAdapter<Integer>(MainActivity5.this, android.R.layout.simple_list_item_1,given_test_ids);
//                    IDs_list.setAdapter(IdsAdapter);

                }catch (Exception e){
                    Toast.makeText(MainActivity5.this, "ids not set into the list view", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}