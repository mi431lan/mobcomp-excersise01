package com.example.firstmvp.model.user;

import android.util.Log;

public class CalorieCalculator {
    private static String TAG = "CalorieCalculator";
    private double weight;
    private double height;
    private double age;
    private double activityLevel;

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setActivityLevel(double activityLevel) {
        this.activityLevel = activityLevel;
    }

    public double calculateCalories() {
        double calorieWastage = 0;
        calorieWastage = ((9.99 * weight) + (6.25 * height) - (4.92 * age)) * activityLevel;
        Log.d(TAG,"Calorie Wastage calculated: "+calorieWastage);
        return calorieWastage;
    }

    @Override
    public String toString() {
        return "((9.99 *" + weight + ") + (6.25 * " + height + ") -  (4,92 * " + age + ") + 5 ) * " + activityLevel;
    }
}
