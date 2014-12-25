package com.murad.gradecalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.murad.gradecalculator.R;
import com.murad.calculators.FinalGradeCalculator;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class FinalGradeFragment extends Fragment {
	
	public static final String ARG_SECTION_NUMBER = "section_number";

	public FinalGradeFragment() {
	
	}
	
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			return inflater.inflate(R.layout.final_grade_layout, container, false);
			
		}
		
		/**
		 * Returns an ArrayList containing Double Arrays of each Grade/Weight pair
		 * @return an ArrayList containing Double Arrays of each Grade/Weight pair
		 */
		public List<Double[]> getValues(View view) {
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
			for(int gradeID: gradeArray) {
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
			for (int weightID: weightArray) {
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
		
		/**
		 * Returns the calculation of the GPA on a 4.0 scale, and displays it in a TextView
		 * @return
		 */
		public void sendToCalculate() {
			FinalGradeCalculator calculator = new FinalGradeCalculator();
			Double[] calc = calculator.calculate(this.getValues(getView()));
			DecimalFormat df = new DecimalFormat("###.##");
			String calculation = df.format(calc[0]);
			// grab TextVew ID and display GPA
			TextView view1 = (TextView) getView().findViewById(R.id.total_final_grade);
			view1.setTextSize((float)12.5);
			view1.setText("Amount accounted for: " + calc[1] + "%. Your Final Grade is " + calculation + "% .");
			
		}
	}

