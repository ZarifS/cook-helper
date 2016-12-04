package com.example.azimi.cookhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class ViewRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        getSupportActionBar().hide();

        Intent i = getIntent();
        Recipe r = (Recipe)i.getSerializableExtra("Recipe");

        String[] temp = new String[r.getIngr().length()];
        TextView recipename = (TextView) findViewById(R.id.recipeName);
        TextView mealtype=(TextView) findViewById(R.id.mealType);
        TextView cuisinetype=(TextView) findViewById(R.id.cuisineType);
        TextView ingredient1=(TextView) findViewById(R.id.ing1);
        TextView ingredient2=(TextView) findViewById(R.id.ing2);
        TextView ingredient3=(TextView) findViewById(R.id.ing3);
        TextView ingredient4=(TextView) findViewById(R.id.ing4);
        TextView ingredient5=(TextView) findViewById(R.id.ing5);
        TextView ingredient6=(TextView) findViewById(R.id.ing6);
        TextView ingredient7=(TextView) findViewById(R.id.ing7);
        TextView ingredient8=(TextView) findViewById(R.id.ing8);
        TextView ingredient9=(TextView) findViewById(R.id.ing9);
        TextView ingredient10=(TextView) findViewById(R.id.ing10);

        TextView[] ingredients = {ingredient1, ingredient2, ingredient3, ingredient4, ingredient5,
                ingredient6, ingredient7, ingredient8, ingredient9, ingredient10};


        TextView instructions=(TextView) findViewById(R.id.instructions);

        recipename.setText(r.getName());
        mealtype.setText(r.getType());
        cuisinetype.setText(r.getCuisine());
        String[] arr = r.getIngr().split(",");

        for(int j = 0; j<arr.length; j=j+3){
            String s = arr[j]+", "+arr[j+1]+" "+arr[j+2];
            temp[j] = s;

        }

        int x = 0;

        for(int z = 0; z<ingredients.length; z++) {
            ingredients[z].setText(temp[x]);
            x=x+3;
        }

        instructions.setText(r.getInstructions());
        

    }
}
