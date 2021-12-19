package com.example.schema;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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

    public class Pop extends MittSchema {

        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);


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

                    finish();
                }
            });

        }



    }

