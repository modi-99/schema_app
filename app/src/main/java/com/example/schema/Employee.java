package com.example.schema;

import java.util.Date;

public class Employee {


    //String name;
    private String cDate;
    private String shift;
    private boolean lunchSkift;
    private boolean middagSkift;
    private String name;
    private Integer id;

    public Employee(String _cDate, boolean lunchSkift, boolean middagSkift, String name, Integer id){
        this.cDate=_cDate;
        this.lunchSkift= lunchSkift;
        this.middagSkift=middagSkift;
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


