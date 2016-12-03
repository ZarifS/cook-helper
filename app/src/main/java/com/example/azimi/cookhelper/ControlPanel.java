package com.example.azimi.cookhelper;

/**
 * Created by Zarif on 2016-12-02.
 */

import java.util.*;

public class ControlPanel{

    //array list of type integer so that ingredients can be accessed by index
    ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
//    Recipe r = new Recipe(ingredientList)
    //array of ingredients used
    Ingredient [] ingredientsUsed;


    //inner class Recipe
    public class Recipe{

        String name;
        int key, prepTime, cookTime;
        String directions;
        Ingredient [] used;

        public Recipe(String name, String cusine, String type, sString directions, Ingredient [] used){
            this.name = name;
            this.key = key;
            this.prepTime = prepTime;
            this.cookTime = cookTime;
            this.directions = directions;
            this.used = used;
        }

        //getters

        public int getIndex(Recipe r){
            return r.key;
        }

        public Ingredient[] getUsed(Recipe r){
            return r.used;
        }

        public String getName(Recipe r){
            return r.name;
        }

        public int getPrepTime(Recipe r){
            return r.prepTime;
        }

        public int getCookTime(Recipe r){
            return r.cookTime;
        }

        public String directions(Recipe r){
            return r.directions;
        }
    }

    //inner class Ingredient.java
    public class Ingredient{

        String name;
        int index;

        //ingredients only need name to be defined
        public Ingredient(String name, int index){
            this.name = name;
            this.index = index;
        }
        //getter
        public String getName(Ingredient i){
            return i.name;
        }

        public int getIndex(Ingredient i){
            return i.index;
        }

    }

    public void addIngredient(Ingredient i){
        ingredientList.add(i.index, i);
    }

    public void addRecipe(Recipe r){
        recipeList.add(r);
    }

    public void deleteRecipe(Recipe r){
        recipeList.remove(r.key);
    }
}

