package com.example.firstmvp.presenter.user;

import com.example.firstmvp.model.user.CalorieCalculator;

public class CalorieCalculatorPresenter {

    private CalorieCalculator calorieCalculator;
    private View view;


    public CalorieCalculatorPresenter(View view) {
        this.view = view;
        calorieCalculator = new CalorieCalculator();
    }

    public void updateWeight(double weight) {
        calorieCalculator.setWeight(weight);
        view.updateFormula(calorieCalculator.toString());
    }

    public void updateHeight(double height) {
        calorieCalculator.setHeight(height);
        view.updateFormula(calorieCalculator.toString());
    }

    public void updateAge(double age) {
        calorieCalculator.setAge(age);
        view.updateFormula(calorieCalculator.toString());
    }

    public void updateActivityLevel(double activityLevel) {
        calorieCalculator.setActivityLevel(activityLevel);
        view.updateFormula(calorieCalculator.toString());
    }
    public double calculateCalories() {
        return calorieCalculator.calculateCalories();
    }


    public interface View {
        void updateFormula(String info);


    }
}
