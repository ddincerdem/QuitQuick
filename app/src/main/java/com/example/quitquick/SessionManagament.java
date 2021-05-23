package com.example.quitquick;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.quitquick.Entities.User;

public class SessionManagament {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_user";

    public SessionManagament(Context context)
    {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(User user)
    {
       int id = user.getUserID();
       editor.putInt(SESSION_KEY,id).commit();
    }

    public int getSession(){

     return sharedPreferences.getInt(SESSION_KEY,-1);

    }

    public void removeSession(){
     editor.putInt(SESSION_KEY,-1).commit();
    }
}
