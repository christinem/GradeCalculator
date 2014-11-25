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
		
		if (grade < 50) {
			rating = 0.0;
		} else if (grade >= 50 && grade <= 52) {
			rating = 0.7;
		} else if (grade >= 53 && grade <= 56) {
			rating = 1.0;
		} else if (grade >= 57 && grade <= 59) {
			rating =1.3;
		} else if (grade >= 60 && grade <= 62) {
			rating = 1.7;
		} else if (grade >= 63 && grade <= 66) {
			rating = 2.0;
		} else if (grade >= 67 && grade <= 69) {
			rating = 2.3;
		} else if (grade >= 70 && grade <= 72) {
			rating = 2.7;
		} else if (grade >= 73 && grade <= 76) {
			rating = 3.0;
		} else if (grade >= 77 && grade <= 79) {
			rating = 3.3;
		} else if (grade >= 80 && grade <= 84) {
			rating = 3.7;
		} else if (grade >= 85) {
			rating = 4.0;
		}
		
		return rating;
	}
}
