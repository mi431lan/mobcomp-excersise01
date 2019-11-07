package com.example.firstmvp.view.caloriewastage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.firstmvp.R;

public class CalorieWastageActivity extends AppCompatActivity {

    TextView calorieWaste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_wastage);
        String calorieWastage = getIntent().getStringExtra("CALORIE_WASTAGE");

        calorieWaste = findViewById(R.id.calorieWaste);
        calorieWaste.setText("Calorie Wastage: "+calorieWastage);
    }
}
