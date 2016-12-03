package com.example.azimi.cookhelper;

/**
 * Created by Zarif on 2016-12-02.
 */

public class Ingredient{

    String name;
    Double quantity;
    String unit;


    //ingredients only need name to be defined
    public Ingredient(String name){
        this.name = name;
    }
    //getter
    public String getName(Ingredient i){
        return i.name;
    }

}