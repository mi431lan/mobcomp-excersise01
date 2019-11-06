package com.example.firstmvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.firstmvp.R;
import com.example.firstmvp.presenter.DatabasePresenter;
import com.example.firstmvp.presenter.UserPresenter;

public class MainActivity extends AppCompatActivity implements UserPresenter.View, DatabasePresenter.View {

    UserPresenter userPresenter;
    DatabasePresenter databasePresenter;

    TextView userInfoTextView;
    EditText fullName;
    EditText email;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userPresenter = new UserPresenter(this);
        databasePresenter= new DatabasePresenter(this);

        userInfoTextView = (TextView) findViewById(R.id.userInfo);
        fullName = (EditText) findViewById(R.id.fullName);
        email = (EditText) findViewById(R.id.email);
        buttonSave = (Button)findViewById(R.id.buttonSave);

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
                if(fullName.getText().length()>0&&email.getText().length()>0){

                }
            }
        });
    }

    @Override
    public void updateUserInfoTextView(String info) {
        userInfoTextView.setText(info);
    }
}
