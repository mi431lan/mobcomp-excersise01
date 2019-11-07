package com.example.firstmvp.model.user;

public class User {

    private String fullName;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return "FullName: " + fullName;
    }

    public String getEmail() {
        return "Email: " + email;
    }
}
