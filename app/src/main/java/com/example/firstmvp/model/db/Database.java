package com.example.firstmvp.model.db;

public interface Database {

    void saveUser(String user);

    void loadUser(String name);
}
