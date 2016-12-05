package com.example.azimi.cookhelper;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EditRecipe extends AppCompatActivity {


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



    }
}
