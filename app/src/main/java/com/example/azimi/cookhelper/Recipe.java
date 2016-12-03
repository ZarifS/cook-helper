package com.example.azimi.cookhelper;

import java.util.LinkedList;

/**
 * Created by Zarif on 2016-12-02.
 */

public class Recipe {

    private String name;
    private String cusine;
    private String type;
    private String instructions;
    private String ingr;



    public Recipe(String name, String cusine, String type, LinkedList<Ingredient> ingredients, String instructions) {
        this.name = name;
        this.cusine=cusine;
        this.type =type;
        this.instructions = this.instructions;
        for(int i=0; i<ingredients.size();i++){
            ingr=ingr + (","+ingredients.get(i).getName()+","+ingredients.get(i).getQuantity()+","+ingredients.get(i).getUnit());
        }
    }
    public Recipe(String name, String cusine, String type, String instructions, String ingredients) {
        this.name = name;
        this.cusine=cusine;
        this.type =type;
        this.instructions = instructions;
        this.ingr=ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCusine() {
        return cusine;
    }

    public void setCusine(String cusine) {
        this.cusine = cusine;
    }

    public String getIngr() {
        return ingr;
    }

    public void setIngr(String ingr) {
        this.ingr = ingr;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
