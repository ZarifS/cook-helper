package com.example.azimi.cookhelper;

import java.util.LinkedList;

/**
 * Created by Zarif on 2016-12-02.
 */

public class Recipe {

    String name;
    String cusine;
    String type;
    String directions;
    String ingredients;



    public Recipe(String name, String cusine, String type, String directions, LinkedList<Ingredients> ingredients) {
        this.name = name;
        this.cusine=cusine;
        this.type =type;
        this.directions=directions;
        LinkedList<Ingredient> temp = ingredients;
        for(int i=0; i<ingredients.size();i++){
            this.ingredients=ingredients +(","+)
        }


    }

    //getters


}