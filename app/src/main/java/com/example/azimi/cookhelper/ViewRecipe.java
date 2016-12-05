package com.example.azimi.cookhelper;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;


public class ViewRecipe extends AppCompatActivity {

    public DBSQLiteHelper db = new DBSQLiteHelper(this);
    private List<Recipe> allRecipes;
    Recipe r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        allRecipes=db.getAllRecipes();
        Intent i = getIntent();
        r = (Recipe)i.getSerializableExtra("Recipe");

        String[] temp = new String[r.getIngr().length()];
        TextView recipename = (TextView) findViewById(R.id.recipeName);
        TextView mealtype=(TextView) findViewById(R.id.mealType);
        TextView cuisinetype=(TextView) findViewById(R.id.cuisine);
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
        String[] arr = r.getIngr().split(",");//array that stores all values in which ingr was split with comma

        for(int j = 0; j<arr.length; j=j+3){
            String s = "  - "+arr[j]+", "+arr[j+1]+" "+arr[j+2];//goes thru array and stores indexs 0-3 into a string
            temp[j] = s;//stores that string into the array temp
        }

        int x = 0;

        for(int z = 0; z<temp.length; z++) {

            if(x<temp.length) {
                ingredients[z].setText(temp[x]);
                if(temp[x+3] == null){
                    break;
                }
                else {
                    x = x + 3;
                }
            }
        }
        instructions.setText(r.getInstructions());
    }

    public void deleteBtnClick(View view) {


        db.deleteRecipe(r);

        Intent intent = new Intent(this, BrowseRecipes.class);
        startActivity(intent);
        finish();

    }

    public void backBtnClick(View view) {

        Intent intent = new Intent(this, BrowseRecipes.class);
        startActivity(intent);
        finish();

    }

    public void editBtnClick(View view){

        Intent i= new Intent(ViewRecipe.this,EditRecipe.class);

        i.putExtra("Recipe", r);
        startActivity(i);
        finish();
    }
}
