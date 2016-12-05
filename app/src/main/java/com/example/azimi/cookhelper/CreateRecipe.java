package com.example.azimi.cookhelper;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.E;

public class CreateRecipe extends AppCompatActivity {


    public DBSQLiteHelper db = new DBSQLiteHelper(this);


    private LinkedList<Ingredient> listofIngredients;
    private List<Recipe> allRecipes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);
        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        allRecipes=db.getAllRecipes();
        System.out.println("The first two test cases were messed up (Both TestRecipe). The correct test case is Pasta");
        for(int i=0;i<allRecipes.size();i++){
            Recipe r;
            r=allRecipes.get(i);
            System.out.println(r.getName());
            System.out.println(r.getCuisine());
            System.out.println(r.getType());
            System.out.println(r.getIngr());
            System.out.println(r.getInstructions());
        }


        listofIngredients = new LinkedList<>();

        Spinner dropdownCuisine = (Spinner) findViewById(R.id.spinnercuisine);
        String[] items1 = new String[]{"American", "French", "Mexican", "Italian", "Chinese", "Arabic", "Indian", "Other"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        dropdownCuisine.setAdapter(adapter1);


        Spinner dropdownCategory = (Spinner) findViewById(R.id.spinnercategory);
        String[] items2 = new String[]{"Main Dish", "Starter", "Desert", "Appetiser", "Sauce", "Other"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdownCategory.setAdapter(adapter2);


        Spinner dropdownUnit = (Spinner) findViewById(R.id.spinnerunit);
        String[] items3 = new String[]{"cup(s)", "tbsp", "tsp", "g", "l", "mg", "ml", "-"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        dropdownUnit.setAdapter(adapter3);


    }



    public void onClick_addRecipeClicked(View view){




        EditText recipename = (EditText)findViewById(R.id.btn_recipename);
        Spinner cuisineType = (Spinner)findViewById(R.id.spinnercuisine);
        Spinner categorytype = (Spinner)findViewById(R.id.spinnercategory);
        EditText instructions = (EditText)findViewById(R.id.instructions);



        String nameString = recipename.getText().toString();
        String cuisineTypeString = cuisineType.getSelectedItem().toString();
        String categoryTypeString = categorytype.getSelectedItem().toString();
        String instructionsString = instructions.getText().toString();

        Recipe recipe = new Recipe(nameString,cuisineTypeString,categoryTypeString, listofIngredients, instructionsString);//Create a new recipe
        db.createRecipe(recipe);

        recipename.setText("");
        instructions.setText("");


    }


    public void onClick_addIngredientClicked(View v){
        EditText ingname = (EditText)findViewById(R.id.btn_ingredientname);//Ingredient
        Spinner ingunit = (Spinner)findViewById(R.id.spinnerunit);
        EditText ingamount = (EditText)findViewById(R.id.btn_amountname);


        String ingnameString = ingname.getText().toString();

        System.out.println(ingnameString);
        String ingunitString = ingunit.getSelectedItem().toString();
        String ingamountString = ingamount.getText().toString();

        Ingredient ing = new Ingredient(ingnameString, ingamountString, ingunitString);

        listofIngredients.add(ing);

        ingname.setText("");
        ingamount.setText("");


    }

    public void storeRecipe(Recipe recipe){

    }
}
