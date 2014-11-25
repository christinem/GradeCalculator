package com.murad.gradecalculator;

import java.util.List;
import java.util.Stack;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class SchoolActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_school);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.school, menu);
		return true;
	}
	
	public void redirectUofT(View view) {
		Toast.makeText(this, "University of Toronto uses the 4.0 GPA Scale", 5000).show();
	}
	
	public void redirectYork(View view) {
		Toast.makeText(this, "York uses the 9.0 GPA Scale", 5000).show();
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
	
	public void sendEmail(View view) {
		 Intent i = new Intent(Intent.ACTION_SEND);
	     i.setType("*/*");
	     i.putExtra(Intent.EXTRA_EMAIL, new String[]{"christine.murad@mail.utoronto.ca"});
	     i.putExtra(Intent.EXTRA_SUBJECT, "Grade Calculator: New School Suggestion");

	     startActivity(createEmailOnlyChooserIntent(i, "Choose an email client:"));
	
	}

}
