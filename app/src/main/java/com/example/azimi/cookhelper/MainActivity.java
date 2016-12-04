package com.example.azimi.cookhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void browseBtnClick(View view) {

        Intent intent = new Intent(this, BrowseRecipes.class);
        startActivity(intent);
    }

    public void addBtnClick(View view){

        Intent intent = new Intent(this, CreateRecipe.class);
        startActivity(intent);
    }

    public void aboutBtnClick(View view){

        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void viewBtnClick(View view){
        Intent intent = new Intent(this, ViewRecipe.class);
        startActivity(intent);
    }
}
