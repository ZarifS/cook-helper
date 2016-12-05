package com.example.azimi.cookhelper;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    public void addBtnClick(View view){

        Intent intent = new Intent(this, CreateRecipe.class);
        startActivity(intent);
    }

    public void browseBtnClick(View view) {

        Intent intent = new Intent(this, BrowseRecipes.class);
        startActivity(intent);
    }

    public void searchBtnClick(View view){

        Intent intent = new Intent(this, SearchRecipes.class);
        startActivity(intent);
    }


    public void helpbtnClick(View view){

        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }

    public void aboutBtnClick(View view){

        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }



}
