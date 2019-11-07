package com.example.firstmvp.presenter.db;

import com.example.firstmvp.model.db.Database;

public class DatabasePresenter {

    private static final String TAG = "DatabasePresenter";

    private Database database;
    private View view;

    public DatabasePresenter(View view,Database database) {
        this.view = view;
        this.database =database;

    }

    public void saveData(String data) {
        database.saveData(data);

    }

    public void loadData(String data) {
        database.loadData(data);
    }


    public interface View {
    }

}
