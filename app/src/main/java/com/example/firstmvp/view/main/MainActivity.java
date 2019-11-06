package com.example.firstmvp.view.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstmvp.R;
import com.example.firstmvp.model.db.DatabaseA1;
import com.example.firstmvp.presenter.db.DatabasePresenter;
import com.example.firstmvp.presenter.user.UserPresenter;

public class MainActivity extends AppCompatActivity implements UserPresenter.View, DatabasePresenter.View {

    UserPresenter userPresenter;
    DatabasePresenter databasePresenter;

    TextView userName;
    TextView userEmail;

    EditText fullName;
    EditText email;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userPresenter = new UserPresenter(this);
        databasePresenter = new DatabasePresenter(this, new DatabaseA1());

        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.userEmail);

        fullName = findViewById(R.id.fullName);
        email = findViewById(R.id.email);
        buttonSave = findViewById(R.id.buttonSave);

        fullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userPresenter.updateFullName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userPresenter.updateEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fullName.getText().length() > 0 && email.getText().length() > 0) {
                    databasePresenter.saveUser(fullName.toString() + " " + email.toString());
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter email and name!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void updateUserName(String info) {
        userName.setText(info);
    }

    @Override
    public void updateUserEmail(String info) {
        userEmail.setText(info);
    }

}
