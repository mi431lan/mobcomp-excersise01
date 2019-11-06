package com.example.firstmvp.model;

import android.util.Log;

public class DatabaseA1 implements Database {

    private static final String TAG="DatabaseA1";
    @Override
    public void loadUser(String name) {
        Log.d(TAG,"User loaded.");
    }

    @Override
    public void saveUser(String user) {
        Log.d(TAG,"User saved.");
    }
}
