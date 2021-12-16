package com.example.schema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;



public class MittSchema extends AppCompatActivity {
    String cDate[];
    String shift[];


    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitt_schema);
        button=findViewById(R.id.button);

       
    }
}