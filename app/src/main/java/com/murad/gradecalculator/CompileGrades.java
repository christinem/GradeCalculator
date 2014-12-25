package com.murad.gradecalculator;

import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christine on 2014-12-25.
 */
public class CompileGrades {

    /*
    A class that grabs values from user input and compiles them into lists to be used to calculate
    GPA.
     */
    public CompileGrades() {

    }

    /**
     * Returns an ArrayList containing Double Arrays of each Grade/Weight pair
     *
     * @return an ArrayList containing Double Arrays of each Grade/Weight pair
     */
    public static List<Double[]> getValues(View view) {
        List<Double> gradeList = new ArrayList<Double>();
        List<Double[]> finalList = new ArrayList<Double[]>();
        List<Double> weightList = new ArrayList<Double>();

        // Arrays to access IDs for EditTexts
        int[] gradeArray = {R.id.Grade1, R.id.Grade2, R.id.Grade3,
                R.id.Grade4, R.id.Grade5, R.id.Grade6,
                R.id.Grade7, R.id.Grade8, R.id.Grade9, R.id.Grade10};
        int[] weightArray = {R.id.Weight1, R.id.Weight2, R.id.Weight3,
                R.id.Weight4, R.id.Weight5, R.id.Weight6, R.id.Weight7,
                R.id.Weight8, R.id.Weight9, R.id.Weight10};

        // Parse the EditTexts for grades and get doubles, put them into their own list
        for (int gradeID : gradeArray) {
            EditText gradeText = (EditText) view.findViewById(gradeID);
            String gradeString = gradeText.getText().toString();
            double grade;
            if (gradeString.trim().equals("")) {
                grade = 0.0;
            } else {
                grade = Double.parseDouble(gradeString);
            }
            gradeList.add(grade);
        }

        // Parse the EditTexts for grades and get doubles, put them into their own list
        for (int weightID : weightArray) {
            EditText weightText = (EditText) view.findViewById(weightID);
            String weightString = weightText.getText().toString();
            double weight;
            if (weightString.trim().equals("")) {
                weight = 0.0;
            } else {
                weight = Double.parseDouble(weightString);
            }
            weightList.add(weight);
        }

        // Create a List of Double Arrays with {Grade, Weight}
        int i = 0;
        while (i < 10) {
            Double[] array = {gradeList.get(i), weightList.get(i)};
            finalList.add(array);
            i++;
        }


        return finalList;
    }
}