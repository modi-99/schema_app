package com.example.schema;

import java.util.Date;

public class Employee {


    //String name;
    private String cDate;
    private String shift;
    private boolean lunchSkift;
    private boolean middagSkift;


    public Employee(String _cDate, boolean b, boolean c){
        this.cDate=_cDate;
        lunchSkift=b;
        middagSkift=c;
    }


    public String getDate(){
        return cDate;
    }

    public boolean getLunchShift(){
        return lunchSkift;

    }
    public boolean getDinnerShift() {
        return middagSkift;

    }

}


