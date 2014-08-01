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
 
public class UserDataBase extends SQLiteOpenHelper {
 
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserDB";
    private static final String TABLE_CONTACTS = "UserData";
    
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SEX = "sex";
    private static final String KEY_DOB = "dob";
    private static final String KEY_CEP = "cep";
    private static final String KEY_ENDERECO = "endereco";
    private static final String KEY_BAIRRO = "bairro";
    private static final String KEY_CIDADE = "cidade";
    private static final String KEY_ESTADO = "estado";
    private static final String KEY_TELEFONE = "telefone";
    private static final String KEY_CELULAR = "celular";
    private static final String KEY_BLOQUEADO = "bloqueado";
    private static final String KEY_ATIVO = "ativo";
    private static final String KEY_SENHA = "senha";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_DOCUMENTSECUNDARIO = "documentoSecundario";
    private static final String KEY_DOCUMENTPRINCIPAL = "documentoPrincipal";
    
    
    
    public UserDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
        		+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_SEX + " TEXT," + KEY_DOB + " TEXT,"
                + KEY_CEP +  " TEXT," + KEY_ENDERECO + " TEXT,"
                + KEY_BAIRRO + " TEXT," + KEY_CIDADE + " TEXT,"
                + KEY_ESTADO +  " TEXT," + KEY_TELEFONE + " TEXT,"
                + KEY_CELULAR +  " TEXT," + KEY_BLOQUEADO + " TEXT,"
                + KEY_ATIVO +  " TEXT," + KEY_SENHA + " TEXT,"
                + KEY_EMAIL +  " TEXT," + KEY_DOCUMENTSECUNDARIO + " TEXT,"
                + KEY_DOCUMENTPRINCIPAL + " TEXT" + ")";
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
    public void adddataitem(UserDataManager contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        
        values.put(KEY_NAME, contact.getName()); // dataitem Name
        values.put(KEY_SEX, contact.getSex()); // dataitem Phone
        values.put(KEY_DOB, contact.getDob()); // dataitem Name
        values.put(KEY_CEP, contact.getCep()); 
        values.put(KEY_ENDERECO, contact.getEndereco()); // dataitem Name
        values.put(KEY_BAIRRO, contact.getBairro()); 
        values.put(KEY_CIDADE, contact.getCidade()); // dataitem Name
        values.put(KEY_ESTADO, contact.getEstado()); 
        values.put(KEY_TELEFONE, contact.getTelefone()); // dataitem Name
        values.put(KEY_CELULAR, contact.getCelular());
        values.put(KEY_BLOQUEADO, contact.getBairro());
        values.put(KEY_ATIVO, contact.getAtivo());
        values.put(KEY_SENHA, contact.getSenha());
        values.put(KEY_EMAIL, contact.getEmail());
        values.put(KEY_DOCUMENTSECUNDARIO, contact.getDocumentoSecundario());
        values.put(KEY_DOCUMENTPRINCIPAL, contact.getDocumentoPrincipal());
        
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
    // Getting single contact
    public UserDataManager getdataitem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
        		KEY_NAME, KEY_SEX, KEY_DOB, KEY_CEP,KEY_ENDERECO, KEY_BAIRRO, KEY_CIDADE, KEY_ESTADO, KEY_TELEFONE, KEY_CELULAR, KEY_BLOQUEADO, KEY_ATIVO, KEY_SENHA, KEY_EMAIL, KEY_DOCUMENTSECUNDARIO, KEY_DOCUMENTPRINCIPAL }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        UserDataManager contact = new UserDataManager(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12),cursor.getString(13),cursor.getString(14),cursor.getString(15),cursor.getString(16));
        db.close();
        return contact;
    }
    // Getting All dataitems
    public List<UserDataManager> getAlldataitems() {
        List<UserDataManager> contactList = new ArrayList<UserDataManager>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	UserDataManager contact = new UserDataManager();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setSex(cursor.getString(2));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        // return contact list
        db.close();
        return contactList;
    }
 
    // Updating single contact
    public int updatedataitem(UserDataManager contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        
        values.put(KEY_NAME, contact.getName()); // dataitem Name
        values.put(KEY_SEX, contact.getSex()); // dataitem Phone
        values.put(KEY_DOB, contact.getDob()); // dataitem Name
        values.put(KEY_CEP, contact.getCep()); 
        values.put(KEY_ENDERECO, contact.getEndereco()); // dataitem Name
        values.put(KEY_BAIRRO, contact.getBairro()); 
        values.put(KEY_CIDADE, contact.getCidade()); // dataitem Name
        values.put(KEY_ESTADO, contact.getEstado()); 
        values.put(KEY_TELEFONE, contact.getTelefone()); // dataitem Name
        values.put(KEY_CELULAR, contact.getCelular()); 
        values.put(KEY_BLOQUEADO, contact.getBairro());
        values.put(KEY_ATIVO, contact.getAtivo());
        values.put(KEY_SENHA, contact.getSenha());
        values.put(KEY_EMAIL, contact.getEmail());
        values.put(KEY_DOCUMENTSECUNDARIO, contact.getDocumentoSecundario());
        values.put(KEY_DOCUMENTPRINCIPAL, contact.getDocumentoPrincipal());
        
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
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