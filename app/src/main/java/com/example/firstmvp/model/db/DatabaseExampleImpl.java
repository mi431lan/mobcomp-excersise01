package com.example.firstmvp.model.db;

import android.util.Log;

public class DatabaseExampleImpl implements Database {

    private static final String TAG = "DatabaseExampleImpl";

    @Override
    public void loadData(String data) {
        Log.d(TAG, "Data loaded.");
    }

    @Override
    public void saveData(String data) {
        Log.d(TAG, "Data saved.");
    }
}
