package com.example.firstmvp.presenter;

import com.example.firstmvp.model.Database;
import com.example.firstmvp.model.DatabaseA1;
import com.example.firstmvp.model.User;

public class UserPresenter {

    User user;
    View view;


    public UserPresenter(View view) {
        this.view = view;
        user  = new User();
    }

    public void updateFullName(String fullName) {
        user.setFullName(fullName);
        view.updateUserInfoTextView(user.toString());
    }

    public void updateEmail(String email) {
        user.setEmail(email);
        view.updateUserInfoTextView(user.toString());
    }


    public interface View {
        void updateUserInfoTextView(String info);
    }
}
