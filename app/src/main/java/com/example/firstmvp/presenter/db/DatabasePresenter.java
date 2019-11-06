package com.example.firstmvp.presenter;

import com.example.firstmvp.model.Database;
import com.example.firstmvp.model.DatabaseA1;

public class DatabasePresenter {

    Database database;
    View view;

    public DatabasePresenter(View view){
        this.view = view;
        this.database=new DatabaseA1();

    }

    public void saveUser(String user){
        database.saveUser(user);
    }
    public void loadUser(String user){
        database.loadUser(user);
    }


    public interface View{}

}
