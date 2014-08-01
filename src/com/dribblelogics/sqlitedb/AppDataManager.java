/* 
 * @author Shwetang R.D 
 * Visual Sistemas Electronicos Ltda.
 * Belo Horizonte-Brazil -2014
 */
package com.dribblelogics.sqlitedb;
public class AppDataManager {
     
    //private variables
    int _id;
    String _url;
    public AppDataManager(){
    }
    
    // constructor
    public AppDataManager(int id, String url){
        this._id = id;
        this._url = url;
    }
    // constructor
    public AppDataManager(String url){
        this._url = url;
    }
    // getting ID
    public int getID(){
        return this._id;
    }
    // setting id
    public void setID(int id){
        this._id = id;
    }
    // getting name
    public String getUrl(){
        return this._url;
    }
    // setting name
    public void setUrl(String name){
        this._url = name;
    }
}