package com.example.azimi.cookhelper;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.LinkedList;

public class EditRecipe extends AppCompatActivity {


    public DBSQLiteHelper db = new DBSQLiteHelper(this);
    Recipe r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recipe);
        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent i = getIntent();
        r = (Recipe)i.getSerializableExtra("Recipe");


        TextView title = (TextView) findViewById(R.id.EditTitle);

        title.setText("EDIT: "+r.getName());

        Spinner dropdownCuisine = (Spinner) findViewById(R.id.spinnercuisine);
        String[] items1 = new String[]{"","American", "French", "Mexican", "Italian", "Chinese", "Arabic", "Indian", "Other"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        dropdownCuisine.setAdapter(adapter1);


        Spinner dropdownCategory = (Spinner) findViewById(R.id.spinnercategory);
        String[] items2 = new String[]{"","Main Dish", "Starter", "Desert", "Appetiser", "Sauce", "Other"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdownCategory.setAdapter(adapter2);


        Spinner dropdownUnit = (Spinner) findViewById(R.id.spinnerunit);
        String[] items3 = new String[]{"cup(s)", "tbsp", "tsp", "g", "l", "mg", "ml", "-"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        dropdownUnit.setAdapter(adapter3);

    }

    public void confirmBtnClick(View view){

        Recipe oldRecipe = r;
        Recipe newRecipe = r;

        EditText recipename = (EditText)findViewById(R.id.btn_recipename);
        Spinner cuisineType = (Spinner)findViewById(R.id.spinnercuisine);
        Spinner categorytype = (Spinner)findViewById(R.id.spinnercategory);
        EditText instructions = (EditText)findViewById(R.id.instructions);

        String nameString = recipename.getText().toString();
        String cuisineTypeString = cuisineType.getSelectedItem().toString();
        String categoryTypeString = categorytype.getSelectedItem().toString();
        String instructionsString = instructions.getText().toString();

        if(nameString != "") {
            newRecipe.setName(nameString);

        }

        if(cuisineTypeString != "") {
            newRecipe.setCuisine(cuisineTypeString);
        }

        if(categoryTypeString != "") {
            newRecipe.setType(categoryTypeString);
        }

        if(instructionsString !=""){
            newRecipe.setInstructions(instructionsString);
        }

        recipename.setText("");
        instructions.setText("");

        db.editRecipe(oldRecipe, newRecipe);
        System.out.println("after db");

//        Intent i= new Intent(EditRecipe.this, MainActivity.class);
//        startActivity(i);
//        finish();

    }

    public void backBtnClick(View view){
        Intent i= new Intent(EditRecipe.this,ViewRecipe.class);

        i.putExtra("Recipe", r);
        startActivity(i);
        finish();
    }


    public void addIngredientBtnClicked(View v){
        EditText ingname = (EditText)findViewById(R.id.btn_ingredientname);//Ingredient
        Spinner ingunit = (Spinner)findViewById(R.id.spinnerunit);
        EditText ingamount = (EditText)findViewById(R.id.btn_amountname);


        String ingnameString = ingname.getText().toString();

        System.out.println(ingnameString);
        String ingunitString = ingunit.getSelectedItem().toString();
        String ingamountString = ingamount.getText().toString();

        Ingredient ing = new Ingredient(ingnameString, ingamountString, ingunitString);


        //listofIngredients.add(ing);

        ingname.setText("");
        ingamount.setText("");


    }
}
