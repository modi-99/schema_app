package com.example.schema;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import Database.GetSchedule;
import Database.PutSchedule;
import Database.Schedule;

public class Pop extends MittSchema {

        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            int id = getIntent().getIntExtra(ScheduleAdapter.ID_VALUE, 0);
            boolean dinner = getIntent().getExtras().getBoolean(ScheduleAdapter.DINNER_VALUE);
            boolean lunch = getIntent().getExtras().getBoolean(ScheduleAdapter.LUNCH_VALUE);
            String date = getIntent().getExtras().getString(ScheduleAdapter.DATE_VALUE);

            setContentView(R.layout.popup_window);

            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);

            int width = dm.widthPixels;
            int height = dm.heightPixels;

            getWindow().setLayout((int)(width*.8),(int)(height*.6));

            WindowManager.LayoutParams params= getWindow().getAttributes();
            params.gravity= Gravity.CENTER;
            params.x=0;
            params.y=-20;

            getWindow().setAttributes(params);

            Spinner spinner= findViewById(R.id.spinner1);
            ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.employee_name, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);


            Button cancelButton;
            cancelButton=findViewById(R.id.btn_cancel);
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });


            Button acceptButton;
            acceptButton=findViewById(R.id.btn_accept);
            acceptButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Spinner spinner = (Spinner)findViewById(R.id.spinner1);
                    String newName = spinner.getSelectedItem().toString();
                    Schedule schedule = new Schedule();
                    schedule.setDatum(date);
                    schedule.setId(id);
                    schedule.setLunch(lunch);
                    schedule.setMiddag(dinner);
                    schedule.setNamn(newName);
                    PutSchedule putSchedule = new PutSchedule();
                    putSchedule.schedule = null;
                    putSchedule.schedule = schedule;
                    putSchedule.handler = new Handler();
                    putSchedule.execute();


                    finish();
                    Intent i = new Intent(getApplicationContext(), MittSchema.class);
                    startActivity(i);
                }
            });

        }



    }

