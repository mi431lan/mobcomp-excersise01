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
import com.example.firstmvp.model.db.DatabaseExampleImpl;
import com.example.firstmvp.presenter.db.DatabasePresenter;
import com.example.firstmvp.presenter.user.CalorieCalculatorPresenter;

public class MainActivity extends AppCompatActivity implements CalorieCalculatorPresenter.View, DatabasePresenter.View {

    CalorieCalculatorPresenter calorieCalculatorPresenter;
    DatabasePresenter databasePresenter;

    TextView formula;

    EditText weight;
    EditText height;
    EditText age;
    EditText activityLevel;

    Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calorieCalculatorPresenter = new CalorieCalculatorPresenter(this);
        databasePresenter = new DatabasePresenter(this, new DatabaseExampleImpl());

        formula = findViewById(R.id.formula);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);
        activityLevel = findViewById(R.id.activityLevel);

        buttonCalculate = findViewById(R.id.buttonCalculate);

        weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calorieCalculatorPresenter.updateWeight(Double.parseDouble(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calorieCalculatorPresenter.updateHeight(Double.parseDouble(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calorieCalculatorPresenter.updateAge(Double.parseDouble(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        activityLevel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calorieCalculatorPresenter.updateActivityLevel(Double.parseDouble(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (weight.getText().length() > 0 &&
                        height.getText().length() > 0 &&
                        age.getText().length() > 0 &&
                        activityLevel.getText().length() > 0) {
                    double calorieWaste=calorieCalculatorPresenter.calculateCalories();
                    databasePresenter.saveData(calorieWaste+"");
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter valid values!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void updateFormula(String info) {
        formula.setText(info);

    }


}
