package com.example.azimi.cookhelper;

/**
 * Created by Zarif Shahriar on 12/3/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.LinkedList;
import java.util.List;

public class DBSQLiteHelper extends SQLiteOpenHelper{

    //db version
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RecipesDB";
    //db fields
    public static final String TABLE_NAME = "RecipesDB";
    public static final String KEY_NAME = "name";
    public static final String KEY_CUISINETYPE = "cuisineType";
    public static final String KEY_MEALTYPE = "mealType";
    public static final String KEY_INGREDIENTS = "ingredients";
    public static final String KEY_INSTRUCTIONS = "instructions";




    public DBSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_RECIPES_TABLE = ("CREATE TABLE "+TABLE_NAME+ "( " + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT NOT NULL, "
                + KEY_CUISINETYPE + " TEXT NOT NULL, "
                + KEY_MEALTYPE + " TEXT NOT NULL, "
                + KEY_INGREDIENTS + " TEXT NOT NULL, "
                + KEY_INSTRUCTIONS + " TEXT NOT NULL" +")");
        db.execSQL(CREATE_RECIPES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop books table if already exists
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+"");
        this.onCreate(db);
    }

    public void createRecipe(Recipe recipe) {
        // get reference of the BookDB database
        SQLiteDatabase db = this.getWritableDatabase();

        // make values to be inserted
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, recipe.getName());
        values.put(KEY_CUISINETYPE, recipe.getCuisine());
        values.put(KEY_MEALTYPE, recipe.getType());
        values.put(KEY_INGREDIENTS, recipe.getIngr());
        values.put(KEY_INSTRUCTIONS, recipe.getInstructions());

        // insert book
        db.insert(TABLE_NAME, null, values);

        // close database transaction
        db.close();
    }

    public List getAllRecipes() {
        List recipes = new LinkedList();

        // select recipe query
        String query = "SELECT  * FROM " + TABLE_NAME;

        // get reference of the RecipesDB database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // parse all results
        Recipe recipe;
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String cuisine = cursor.getString(2);
                String type = cursor.getString(3);
                String ingr = cursor.getString(4);
                String instructions = cursor.getString(5);
                recipe = new Recipe(name,cuisine,type,ingr,instructions);
                // Add book to books
                recipes.add(recipe);
            } while (cursor.moveToNext());
        }

        db.close();
        return recipes;
    }

    public void deleteRecipe(Recipe r){
        SQLiteDatabase db = this.getWritableDatabase();
        String s = "DELETE FROM RecipesDB WHERE name = '"+r.getName()+"'";
        db.execSQL(s);
        db.close();
    }


    public List searchName(String search){
        List recipes = new LinkedList();
        SQLiteDatabase db = this.getWritableDatabase();
        search =search.toLowerCase();
        String query = "SELECT * FROM RecipesDB WHERE name LIKE '%"+search+"%'";
        Cursor cursor = db.rawQuery(query, null);
        Recipe recipe;
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String cuisine = cursor.getString(2);
                String type = cursor.getString(3);
                String ingr = cursor.getString(4);
                String instructions = cursor.getString(5);
                recipe = new Recipe(name,cuisine,type,ingr,instructions);
                // Add recipe to recipes
                recipes.add(recipe);
            } while (cursor.moveToNext());
        }

        db.close();
        return recipes;
    }

    public List searchCuisine(String search){
        List recipes = new LinkedList();
        SQLiteDatabase db = this.getWritableDatabase();
        search =search.toLowerCase();
        String query = "SELECT * FROM RecipesDB WHERE cuisineType LIKE '%"+search+"%'";
        Cursor cursor = db.rawQuery(query, null);
        Recipe recipe;
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String cuisine = cursor.getString(2);
                String type = cursor.getString(3);
                String ingr = cursor.getString(4);
                String instructions = cursor.getString(5);
                recipe = new Recipe(name,cuisine,type,ingr,instructions);
                // Add recipe to recipes
                recipes.add(recipe);
            } while (cursor.moveToNext());
        }

        db.close();
        return recipes;
    }


    public List searchType(String search){
        List recipes = new LinkedList();
        SQLiteDatabase db = this.getWritableDatabase();
        search =search.toLowerCase();
        String query = "SELECT * FROM RecipesDB WHERE mealType LIKE '%"+search+"%'";
        System.out.println(query);
        Cursor cursor = db.rawQuery(query, null);
        Recipe recipe;
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String cuisine = cursor.getString(2);
                String type = cursor.getString(3);
                String ingr = cursor.getString(4);
                String instructions = cursor.getString(5);
                recipe = new Recipe(name,cuisine,type,ingr,instructions);
                // Add recipe to recipes
                recipes.add(recipe);
            } while (cursor.moveToNext());
        }

        db.close();
        return recipes;
    }

    public  List searchIngr(String search){

        System.out.println(search);
        List recipes = new LinkedList();

        //search tomato and avacado or pasta
        search =search.toLowerCase();
        String and = " AND ingredients ";
        String or= " OR ingredients ";
        String not= " NOT ";
        String query ="SELECT * FROM RecipesDB WHERE ingredients ";

        String [] testSplit = search.split(" ");

        for(int i=0;i<testSplit.length;i++){
            if(testSplit[i].equals("and")){
                query=query+and;
            }
            else if(testSplit[i].equals("or")){
                query=query+or;
            }
            else if(testSplit[i].equals("not")){
                query=query+not;
            }
            else{
                System.out.println(testSplit[i]);
                query = query+"LIKE '%"+testSplit[i]+"%'";
            }
        }

        System.out.println(query);
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        Recipe recipe;

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String cuisine = cursor.getString(2);
                String type = cursor.getString(3);
                String ingr = cursor.getString(4);
                String instructions = cursor.getString(5);
                recipe = new Recipe(name,cuisine,type,ingr,instructions);
                // Add recipe to recipes
                recipes.add(recipe);
            } while (cursor.moveToNext());
        }

        db.close();
        return recipes;

    }


}
