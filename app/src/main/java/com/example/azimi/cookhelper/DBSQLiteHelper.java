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
        return recipes;
    }

    public void deleteRecipe(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String s = "DELETE FROM RecipesDB WHERE id ="+id+"";
        db.execSQL(s);
    }

    public void searchIngr(String search){
        //search tomato and avacado or pasta
        search.toLowerCase();
        String and = " AND ingredients LIKE %";
        String or= " OR ingredients LIKE %";
        String query ="SELECT FROM " +TABLE_NAME +" WHERE "+KEY_INGREDIENTS+" LIKE";

        SQLiteDatabase db = this.getWritableDatabase();
        String [] testSplit = search.split(" ");
        for(int i=0;i<testSplit.length;i++){
            if(testSplit[i].equals("and")){
                query=query+and;
            }
            if(testSplit[i].equals("or")){
                query=query+or;
            }
            else{
                query=query+ " "+testSplit[i];
            }

        }


        System.out.println("PRINTING TEST STRING IN COMPLETE...");
        System.out.println(search);

        System.out.println("PRINTING TEST STRING ARRAY AFTER SPLIT...");
        for(int i=0; i <testSplit.length; i++){
            System.out.println(testSplit[i]);
        }
    }

    public Recipe searchCuisine(String search){
        SQLiteDatabase db = this.getWritableDatabase();
        String s = "SELECT FROM RecipesDB WHERE cuisineType =" +search;
        return null;
    }

    public Recipe searchType(String search){
        SQLiteDatabase db = this.getWritableDatabase();
        String s = "SELECT FROM RecipesDB WHERE mealType = " +search;
        return null;
    }


}
