package com.example.schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    public static Data data= new Data();

    public ScheduleAdapter sAdapter;
    public ArrayList<Employee> cDate= new ArrayList<>();


    public void ResetAll(){
        cDate=new ArrayList<>();
    }

    public void addDates(Employee cD){
        cDate.add(cD);
    }
    /*
    public void addShifts(ArrayList<String> sh){
        this.list2=sh;
    }
    */
    public ArrayList<Employee> getDate(){
        return cDate;
    }
    /*
    public ArrayList<String> getShift(){
        return (ArrayList<String>) list2;
    }
    */
    public int getSizeDate(){
        return cDate.size();
    }


}
