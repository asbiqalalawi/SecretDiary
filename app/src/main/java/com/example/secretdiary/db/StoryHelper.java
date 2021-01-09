package com.example.secretdiary.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.UserDictionary.Words._ID;
import static com.example.secretdiary.db.DatabaseContract.TABLE_NAME;

public class StoryHelper {
    private static final String DATABASE_TABLE = TABLE_NAME;
    private static DatabaseHelper dataBaseHelper;
    private static StoryHelper INSTANCE;

    private static SQLiteDatabase database;

    //Constructor
    public StoryHelper(Context context) {
        dataBaseHelper = new DatabaseHelper(context);
    }

    //Initiate database
    public static StoryHelper getInstance(Context context){
        if (INSTANCE == null){
            synchronized (SQLiteOpenHelper.class){
                if (INSTANCE == null){
                INSTANCE = new StoryHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    //open and close database connection
    public void open() throws SQLException{
        database = dataBaseHelper.getWritableDatabase();
    }

    public void close(){
        dataBaseHelper.close();

        if (database.isOpen())
            database.close();
    }

    //retrieving data
    public Cursor queryAll(){
        return database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                _ID + " DESC");
    }

    //retrieve data with specific id
    public Cursor queryById(String id){
        return database.query(
                DATABASE_TABLE,
                null,
                _ID + " = ?",
                new String[]{id},
                null,
                null,
                null,
                null);
    }

    //saving data
    public long insert(ContentValues values){
        return database.insert(DATABASE_TABLE, null, values);
    }

    //update data
    public int update(String id, ContentValues values){
        return database.update(DATABASE_TABLE, values, _ID + " = ?", new String[]{id});
    }

    //delete data
    public int deleteById(String id){
        return database.delete(DATABASE_TABLE, _ID + " = ?", new String[]{id});
    }
}
