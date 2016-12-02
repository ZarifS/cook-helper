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
    }

    public void browseBtnClick(View view) {

        Intent intent = new Intent(this, BrowseRecipes.class);
        startActivity(intent);
    }

    public void createBtnClick(View view){

        Intent intent = new Intent(this, CreateRecipe.class);
        startActivity(intent);
    }
}
