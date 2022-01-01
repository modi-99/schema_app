package com.example.schema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Database.GetSchedule;


public class MittSchema extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitt_schema);
        Context context = MittSchema.this;

        //ArrayList<Employee> cDate= new ArrayList<Employee>();
        Data.data.ResetAll();
        //Data.data.addDates(new Employee("21-01-10", true,false, "HelloWorld"));
        /*Data.data.addDates(new Employee("21-01-11",true,false));
        Data.data.addDates(new Employee("21-01-12", true,false));
        Data.data.addDates(new Employee("21-01-13",false,false));
        Data.data.addDates(new Employee("21-01-14", false,true));
        Data.data.addDates(new Employee("21-01-15",false,true));
        Data.data.addDates(new Employee("21-01-16", false,true));*/


        button=findViewById(R.id.button);
        RecyclerView recyclerView= findViewById(R.id.r_view_Mschema);

        Data.data.sAdapter=new ScheduleAdapter(MittSchema.this);
        recyclerView.setAdapter(Data.data.sAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MittSchema.this));

        GetSchedule getSchedule = new GetSchedule();
        getSchedule.schedulesList = null;
        getSchedule.handler = new Handler();
        getSchedule.context = MittSchema.this;
        getSchedule.recyclerView = findViewById(R.id.r_view_Mschema);
        getSchedule.execute();

    }
}