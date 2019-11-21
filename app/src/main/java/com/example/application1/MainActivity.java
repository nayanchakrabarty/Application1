package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText eTname, eTage, eTnationality;
    Button bAdd, bShow;
    HashMap<Integer, ArrayList<String>> userlist ;
    ArrayList<String> dataArray ;

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTname = findViewById(R.id.editTextName);
        eTage = findViewById(R.id.editTextAge);
        eTnationality = findViewById(R.id.editTextNaioanality);

        bAdd = findViewById(R.id.buttonAdd);
        bShow = findViewById(R.id.buttonShow);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eTname.getText().toString();
                String age = eTage.getText().toString();
                String nationality = eTnationality.getText().toString();

                dataArray = new ArrayList<>();
                dataArray.add(name);
                dataArray.add(age);
                dataArray.add(nationality);


                userlist.put(i,dataArray);
                Toast.makeText(MainActivity.this,"data added",Toast.LENGTH_LONG).show();
                Log.e("total data",userlist.toString());
                i++;
            }
        });

        bShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, SecondActivity.class);
                j.putExtra("data", userlist);
                Log.e("datas",userlist.toString());
                startActivity(j);
            }
        });
    }


}
