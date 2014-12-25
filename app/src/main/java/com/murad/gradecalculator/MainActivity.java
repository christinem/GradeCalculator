package com.murad.gradecalculator;
import java.util.List;
import java.util.Stack;

import com.google.analytics.tracking.android.EasyTracker;
import com.murad.gradecalculator.R;

import android.app.ActionBar;


import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        /*final Button btn = (Button) findViewById(R.id.new_calculation);
        final PopupMenu popupMenu = new PopupMenu(this, btn);
		popupMenu.getMenuInflater().inflate(R.menu.main, popupMenu.getMenu());
		
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				 popupMenu.show();
			}
		});
		
		popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				switch(item.getItemId()) {
				case R.id.new_calculation:
					break;
				}
				return true;
			}
	   
		}); */
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true; 
		//super.onCreateOptionsMenu(menu);
	}
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.gpa_calculation:
			Intent intent = new Intent(this, GPACalculatorActivity.class);
			startActivity(intent);
			return true;
		case R.id.final_grade_calculation:
			Intent intent1 = new Intent(this, FinalGradeCalculatorActivity.class);
			startActivity(intent1);
		default:
			return super.onOptionsItemSelected(item);
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
	  
	  public void searchSchool(View view) {
		  Intent intent = new Intent(this, SchoolActivity.class);
		  startActivity(intent);
	  }
	  
	  public Intent createEmailOnlyChooserIntent(Intent source,
		        CharSequence chooserTitle) {
		        Stack<Intent> intents = new Stack<Intent>();
		        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",
		                "christine.murad@mail.utoronto.ca", null));
		        List<ResolveInfo> activities = getPackageManager()
		                .queryIntentActivities(i, 0);

		        for(ResolveInfo ri : activities) {
		            Intent target = new Intent(source);
		            target.setPackage(ri.activityInfo.packageName);
		            intents.add(target);
		        }

		        if(!intents.isEmpty()) {
		            Intent chooserIntent = Intent.createChooser(intents.remove(0),
		                    chooserTitle);
		            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS,
		                    intents.toArray(new Parcelable[intents.size()]));

		            return chooserIntent;
		        } else {
		            return Intent.createChooser(source, chooserTitle);
		        }
		    }
		
		public void sendSuggestion(View view) {
			 Intent i = new Intent(Intent.ACTION_SEND);
		     i.setType("*/*");
		     i.putExtra(Intent.EXTRA_EMAIL, new String[]{"christine.murad@mail.utoronto.ca"});
		     i.putExtra(Intent.EXTRA_SUBJECT, "Grade Calculator: App suggestions");

		     startActivity(createEmailOnlyChooserIntent(i, "Choose an email client:"));
		
		}

}
