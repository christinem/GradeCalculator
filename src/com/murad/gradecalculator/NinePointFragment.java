package com.murad.gradecalculator;

import com.murad.gradecalculator.R;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
	}
