package com.example.azimi.cookhelper;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.List;

public class SearchRecipes extends AppCompatActivity {

    public DBSQLiteHelper db = new DBSQLiteHelper(this);

    ListView listViewSearch;
    EditText search;
    Spinner dropdownSearch;
    String searchresult;
    String searchtype;
    ArrayAdapter<String> adapter;
    String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipes);
        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        dropdownSearch = (Spinner) findViewById(R.id.spinnerSearch);
        String[] items = new String[]{"Name","Category","Cuisine", "Ingredients"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdownSearch.setAdapter(adapter);

        search = (EditText)findViewById(R.id.search);
        listViewSearch = (ListView) findViewById(R.id.listView);


    }

    public void enterBtnClicked(View view){

        searchresult = search.getText().toString();
        searchtype = dropdownSearch.getSelectedItem().toString();
        System.out.println(searchresult);
        System.out.println(searchtype);
        if(searchtype == "Category"){
            final List<Recipe> queryResults = db.searchType(searchresult);
            names = new String[queryResults.size()];
            for(int i = 0; i < queryResults.size(); i++){
                names[i] = queryResults.get(i).getName();
                System.out.println(queryResults.get(i).getName());
            }
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
            listViewSearch.setAdapter(adapter);

            listViewSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {

                    Intent i= new Intent(SearchRecipes.this,ViewRecipe.class);

                    i.putExtra("Recipe", queryResults.get(position));
                    startActivity(i);
                    finish();

                }
            });
        }

        else if(searchtype == "Cuisine"){
            final List<Recipe> queryResults = db.searchCuisine(searchresult);
            names = new String[queryResults.size()];
            for(int i = 0; i < queryResults.size(); i++){
                names[i] = queryResults.get(i).getName();
            }
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
            listViewSearch.setAdapter(adapter);

            listViewSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {

                    Intent i= new Intent(SearchRecipes.this,ViewRecipe.class);

                    i.putExtra("Recipe", queryResults.get(position));
                    startActivity(i);
                    finish();

                }
            });
        }

        else if(searchtype == "Ingredients"){
            final List<Recipe> queryResults = db.searchIngr(searchresult);
            names = new String[queryResults.size()];
            for(int i = 0; i < queryResults.size(); i++){
                names[i] = queryResults.get(i).getName();
            }
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
            listViewSearch.setAdapter(adapter);

            listViewSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {

                    Intent i= new Intent(SearchRecipes.this,ViewRecipe.class);

                    i.putExtra("Recipe", queryResults.get(position));
                    startActivity(i);
                    finish();

                }
            });
        }

        else{
            final List<Recipe> queryResults = db.searchName(searchresult);
            names = new String[queryResults.size()];
            for(int i = 0; i < queryResults.size(); i++){
                names[i] = queryResults.get(i).getName();
            }
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
            listViewSearch.setAdapter(adapter);

            listViewSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {

                    Intent i= new Intent(SearchRecipes.this,ViewRecipe.class);

                    i.putExtra("Recipe", queryResults.get(position));
                    startActivity(i);
                    finish();

                }
            });
        }

    }
}
