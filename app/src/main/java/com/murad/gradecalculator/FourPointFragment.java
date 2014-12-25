package com.murad.gradecalculator;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import com.murad.gradecalculator.R;
import com.murad.calculators.FourPointScaleCalculator;


/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public class FourPointFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";
		

		public FourPointFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// Reset Grade Position to 1 every time activity is started
			return inflater.inflate(R.layout.four_point_layout, container, false);
			
		}
		

		
		/**
		 * Returns the calculation of the GPA on a 4.0 scale, and displays it in a TextView
		 * @return
		 */
		public void sendToCalculate() {
			FourPointScaleCalculator calculator = new FourPointScaleCalculator();
            CompileGrades compiler = new CompileGrades();
			Double calc = calculator.calculate(compiler.getValues(getView()));
			DecimalFormat df = new DecimalFormat("###.##");
			String calculation = df.format(calc);
			// grab TextVew ID and display GPA
			TextView view1 = (TextView) getView().findViewById(R.id.total_four_point);
			view1.setTextSize(20);
			view1.setText("Your GPA is " + calculation + ".");
			
		}
		
	}

