package com.example.dell.dailyfourtune;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DELL on 01/12/2015.
 */
public class MyPreferences {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE=0;
    private static  final String PREF_NAME = "DailyFourtune";
    private static final String IS_FIRSTIME = "IsFirstTime";
    public static final String UserName = "name";

    public MyPreferences(Context context) {
        this._context = context;
        pref =_context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = pref.edit();
    }
     public boolean isFirstTime(){
         return pref.getBoolean(IS_FIRSTIME,true);
     }
    public void setOld(boolean b){
        if(b){
            editor.putBoolean(IS_FIRSTIME,false);
            editor.commit();
        }
    }

    public void setUserName(String name){
        editor.putString(UserName, name);
        editor.commit();
    }
    public String getUserName(){
        return pref.getString(UserName,"");
    }
}
