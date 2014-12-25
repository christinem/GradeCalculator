package com.murad.gradecalculator;

import com.murad.calculators.FourPointScaleCalculator;
import com.murad.calculators.NinePointScaleCalculator;
import com.murad.gradecalculator.R;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public class NinePointFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public NinePointFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			/*View rootView = inflater.inflate(
					R.layout.fragment_gpacalculator_dummy, container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER))); */
			return inflater.inflate(R.layout.nine_point_layout, container, false);
		}

    /**
     * Returns the calculation of the GPA on a 4.0 scale, and displays it in a TextView
     * @return
     */
    public void sendToCalculate() {
        NinePointScaleCalculator calculator = new NinePointScaleCalculator();
        CompileGrades compiler = new CompileGrades();
        Double calc = calculator.calculate(compiler.getValues(getView()));
        DecimalFormat df = new DecimalFormat("###.##");
        String calculation = df.format(calc);
        // grab TextVew ID and display GPA
        TextView view1 = (TextView) getView().findViewById(R.id.total_nine_point);
        view1.setTextSize(20);
        view1.setText("Your GPA is " + calculation + ".");

    }

}
