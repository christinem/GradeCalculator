package com.murad.calculators;

import java.util.List;

public class NinePointScaleCalculator {

public NinePointScaleCalculator() {
		
	}
	
	public double calculate(List<Double[]> gradeAndWeights) {
		double total = 0;
		double totalWeight = 0;
		for (Double[] array: gradeAndWeights) {
			total += getGPARating(array[0]) * array[1];
			totalWeight += array[1];
		}
		return total/totalWeight;
		
	}
	
	public double getGPARating(double grade){
		double rating = 0.0;
		
		if (grade >= 0 && grade <= 39) {
			rating = 0.0;
		} else if (grade >= 40 && grade <= 49) {
			rating = 1.0;
		} else if (grade >= 50 && grade <= 54) {
			rating = 2.0;
		} else if (grade >= 55 && grade <= 59) {
			rating = 3.0;
		} else if (grade >= 60 && grade <= 64) {
			rating = 4.0;
		} else if (grade >= 65 && grade <= 69) {
			rating = 5.0;
		} else if (grade >= 70 && grade <= 74) {
			rating = 6.0;
		} else if (grade >= 75 && grade <= 79) {
			rating = 7.0;
		} else if (grade >= 80 && grade <= 89) {
			rating = 8.0;
		} else if (grade >= 90 && grade <= 100) {
			rating = 9.0;
		}
		
		return rating;
	}
}
