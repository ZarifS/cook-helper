package com.example.azimi.cookhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.List;


public class BrowseRecipes extends AppCompatActivity {

    ListView listView;
    SearchView searchView;
    public DBSQLiteHelper db = new DBSQLiteHelper(this);
    private List<Recipe> allRecipes;



    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_recipes);
        getSupportActionBar().hide();

        allRecipes=db.getAllRecipes();
        String names[] = new String[allRecipes.size()];


        for(int i=0;i<allRecipes.size();i++) {
            Recipe r;
            r=allRecipes.get(i);
            names[i] = r.getName();
        }

        listView = (ListView) findViewById(R.id.listView1);
        searchView =(SearchView) findViewById(R.id.searchView1);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent i= new Intent(BrowseRecipes.this,ViewRecipe.class);

                i.putExtra("Recipe", allRecipes.get(position));
                startActivity(i);
                finish();

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {

                adapter.getFilter().filter(text);
                return false;
            }
        });

//        Recipe r = db.searchIngr();
//        System.out.println(r.getName());
    }

}
