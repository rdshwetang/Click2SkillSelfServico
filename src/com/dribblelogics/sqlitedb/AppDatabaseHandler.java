/* 
 * @author Shwetang R.D 
 * Visual Sistemas Electronicos Ltda.
 * Belo Horizonte-Brazil -2014
 */
package com.dribblelogics.sqlitedb;
 
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class AppDatabaseHandler extends SQLiteOpenHelper {
 
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "C2SDataBase";
    private static final String TABLE_CONTACTS = "C2SWebServiceAddress";
    private static final String KEY_ID = "id";
    private static final String KEY_URL = "url";
 
    public AppDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_URL + " TEXT" +")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        // Create tables again
        onCreate(db);
    }
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
    // Adding new contact
    public void adddataitem(AppDataManager contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_URL, contact.getUrl()); // dataitem Name
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
    // Getting single contact
    public AppDataManager getdataitem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
        		KEY_URL}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        AppDataManager contact = new AppDataManager(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1) );
        db.close();
        return contact;
    }
    // Getting All dataitems
    public List<AppDataManager> getAlldataitems() {
        List<AppDataManager> contactList = new ArrayList<AppDataManager>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	AppDataManager contact = new AppDataManager();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setUrl(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        // return contact list
        db.close();
        return contactList;
    }
 
    // Updating single contact
    public int updatedataitem(AppDataManager contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_URL, contact.getUrl());
        
        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }
 
    // Deleting single contact
    public void deletedataitem(AppDataManager contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }
    
    public void deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS,null,null);
        db.close();
    }
    // Getting contacts Count
    public int getdataitemsCount() {
    	String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int count = cursor.getCount();
        db.close();
        return count;
    }
}