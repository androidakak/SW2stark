package com.naheel.sw2.widget.Stark;


import com.naheel.sw2.widget.example.analog.R;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;


public class ClockWidgetPreferenceActivity extends Activity {
	
	Context context;
	String appVersion;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preference);
		context = this;
		
		PackageManager manager = this.getPackageManager();
		try {
		   PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
		   appVersion = info.versionName;
		   } catch (NameNotFoundException e) {
		   }

		String prefInfo = getString(R.string.preference_info);
		tv = (TextView) findViewById(R.id.textInfo);
		tv.setText(prefInfo + "\nVersion: " + appVersion);
		
		Button learnBtn = (Button) findViewById(R.id.learnBtn);
		learnBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				AlertDialog.Builder alert = new AlertDialog.Builder(context);
				alert.setMessage("Learn how to make your own watch faces for the SmartWatch 2 \nGuide made by Naheel Azawy");
				alert.setPositiveButton("Go to the guide", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://forum.xda-developers.com/smartwatch/sony/tut-make-watchface-t2801780"));
						startActivity(intent);
					}
				});
				alert.setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
				
				alert.show();
				
			}
		});
	    
	    Button help = (Button) findViewById(R.id.helpBtn);
	    help.setOnClickListener(new OnClickListener() {

	        @Override
	        public void onClick(View v) {
	        	
	        	AlertDialog.Builder alert = new AlertDialog.Builder(context);
				alert.setTitle("Help");
				alert.setMessage(R.string.help);
				alert.setNegativeButton("Ok",
	                    new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int id) {
	                    dialog.cancel();
	                }
	            });

	            
	            alert.show();
	        }
	    });
	    
	    Button xda = (Button) findViewById(R.id.moreBtn);
	    xda.setOnClickListener(new OnClickListener() {
	        
	        @Override
	        public void onClick(View v) {
	    		String moreAddres = getString(R.string.more_address);
	        	Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(moreAddres));
				startActivity(intent);
	        }
	    });
	    
	    Button email = (Button) findViewById(R.id.emailBtn);
	    email.setOnClickListener(new OnClickListener() {

	        @Override
	        public void onClick(View v) {
	        	Intent myIntent = new Intent(getBaseContext(), EmailActivity.class);
	        	startActivity(myIntent);
	        }
	    });
		
	}

	

	}
