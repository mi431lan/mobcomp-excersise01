package com.example.firstmvp.presenter.user;

import com.example.firstmvp.model.user.User;

public class UserPresenter {

    private User user;
    private View view;


    public UserPresenter(View view) {
        this.view = view;
        user  = new User();
    }

    public void updateFullName(String fullName) {
        user.setFullName(fullName);
        view.updateUserInfoTextView(user.getFullName());
    }

    public void updateEmail(String email) {
        user.setEmail(email);
        view.updateUserInfoTextView(user.getEmail());
    }


    public interface View {
        void updateUserInfoTextView(String info);
    }
}
