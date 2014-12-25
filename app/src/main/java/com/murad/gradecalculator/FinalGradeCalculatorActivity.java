package com.murad.gradecalculator;

import com.google.analytics.tracking.android.EasyTracker;

import com.murad.gradecalculator.R;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableRow;
import android.widget.TextView;

public class FinalGradeCalculatorActivity extends FragmentActivity implements
		ActionBar.OnNavigationListener {

	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	public Fragment newFragment;
	public static int GRADE_POSITION;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final_grade_calculator);

		// Set up the action bar to show a dropdown list.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		// Set up the dropdown list navigation in the action bar.
		actionBar.setListNavigationCallbacks(
		// Specify a SpinnerAdapter to populate the dropdown list.
				new ArrayAdapter<String>(getActionBarThemedContextCompat(),
						android.R.layout.simple_list_item_1,
						android.R.id.text1, new String[] {
								getString(R.string.title_final_grade), }), this);
	}

	/**
	 * Backward-compatible version of {@link ActionBar#getThemedContext()} that
	 * simply returns the {@link android.app.Activity} if
	 * <code>getThemedContext</code> is unavailable.
	 */
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	private Context getActionBarThemedContextCompat() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			return getActionBar().getThemedContext();
		} else {
			return this;
		}
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.final_grade_calculator, menu);
		return true;
	}

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
	
		GRADE_POSITION = 1;
		
		// When the given dropdown item is selected, show its contents in the
		// container view.
		
		String [] actions = {"Final Grade"};
		
		if (actions[position] == "Final Grade") {
			// Create new fragment and transaction
		    newFragment = new FinalGradeFragment();
		    Bundle args = new Bundle();
			args.putInt(FinalGradeFragment.ARG_SECTION_NUMBER, position + 1);
			newFragment.setArguments(args);
			FragmentTransaction transaction = getFragmentManager().beginTransaction();

			// Replace whatever is in the fragment_container view with this fragment,
			// and add the transaction to the back stack
			transaction.replace(R.id.final_grade_container, newFragment);
			//transaction.addToBackStack(null);

			// Commit the transaction
			transaction.commit();
			
		} /* else if (actions[position] == "9.0 Scale") {
			newFragment = new NinePointFragment();
			FragmentTransaction transaction = getFragmentManager().beginTransaction();

			// Replace whatever is in the fragment_container view with this fragment,
			// and add the transaction to the back stack
			transaction.replace(R.id.gpa_container, newFragment);
			transaction.addToBackStack(null);

			// Commit the transaction
			transaction.commit();
		}*/
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.help:
			Intent intent = new Intent(this, HelpPageActivity.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	/**
	 * Trigger the Fragment's sendToCalculate() method.
	 * @param view A user interface type.
	 */
	public void sendToCalculate(View view) {
		 if(newFragment instanceof FinalGradeFragment) {
			 ((FinalGradeFragment) newFragment).sendToCalculate();
		 } /*else if (newFragment instanceof NinePointFragment) {
			// include when implemented Nine Point Scale 		 
		 }*/
		 
	 }
	
	/**
	 * Reveals extra rows to add Grades for calculation on the press of button.
	 * @param view A User Interface Type.
	 */
	public void revealRow(View view1) {
		View view = (View) findViewById(R.id.final_grade_table);
		GRADE_POSITION += 1;
		if (GRADE_POSITION == 2) {
			TableRow row = (TableRow) view.findViewById(R.id.grade2);
			row.setVisibility(View.VISIBLE);
		}
		else if (GRADE_POSITION == 3) {
			TableRow row = (TableRow) view.findViewById(R.id.grade3);
			row.setVisibility(View.VISIBLE);
		}
		else if (GRADE_POSITION == 4) {
			TableRow row = (TableRow) view.findViewById(R.id.grade4);
			row.setVisibility(View.VISIBLE);
		}
		else if (GRADE_POSITION == 5) {
			TableRow row = (TableRow) view.findViewById(R.id.grade5);
			row.setVisibility(View.VISIBLE);
		}
		else if (GRADE_POSITION == 6) {
			TableRow row = (TableRow) view.findViewById(R.id.grade6);
			row.setVisibility(View.VISIBLE);
		}
		else if (GRADE_POSITION == 7) {
			TableRow row = (TableRow) view.findViewById(R.id.grade7);
			row.setVisibility(View.VISIBLE);
		}
		else if (GRADE_POSITION == 8) {
			TableRow row = (TableRow) view.findViewById(R.id.grade8);
			row.setVisibility(View.VISIBLE);
		}
		
		else if (GRADE_POSITION == 9) {
			TableRow row = (TableRow) view.findViewById(R.id.grade9);
			row.setVisibility(View.VISIBLE);
		}
		
		else if (GRADE_POSITION == 10) {
			TableRow row = (TableRow) view.findViewById(R.id.grade10);
			row.setVisibility(View.VISIBLE);
		}
		
	}
	
	 @Override
	  public void onStart() {
	    super.onStart();
	     // The rest of your onStart() code.
	    EasyTracker.getInstance(this).activityStart(this);  // Add this method.
	  }

	  @Override
	  public void onStop() {
	    super.onStop();
	     // The rest of your onStop() code.
	    EasyTracker.getInstance(this).activityStop(this);  // Add this method.
	  }
}
