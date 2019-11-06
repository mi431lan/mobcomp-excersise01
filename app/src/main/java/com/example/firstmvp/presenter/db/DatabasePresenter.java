package com.example.firstmvp.presenter.db;

import com.example.firstmvp.model.db.Database;
import com.example.firstmvp.model.db.DatabaseA1;

public class DatabasePresenter {

    private static final String TAG = "DatabasePresenter";

    private Database database;
    private View view;

    public DatabasePresenter(View view,Database database) {
        this.view = view;
        this.database =database;

    }

    public void saveUser(String user) {
        database.saveUser(user);

    }

    public void loadUser(String user) {
        database.loadUser(user);
    }


    public interface View {
    }

}
