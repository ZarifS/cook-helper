package com.example.azimi.cookhelper;

/**
 * Created by Zarif on 2016-12-02.
 */

public class Ingredient{

    private String name;
    private String quantity;
    private String unit;


    //ingredients only need name to be defined
    public Ingredient(String name, String quantity, String unit){
        this.name = name;
        this.quantity=quantity;
        this.unit=unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}