package com.naheel.sw2.widget.Stark;



import com.naheel.sw2.widget.example.analog.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class EmailActivity extends Activity {
	
	EditText textMessage;
	Button buttonSend;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams buttonParams = 
                new LinearLayout.LayoutParams(
                	LinearLayout.LayoutParams.MATCH_PARENT, 
                	LinearLayout.LayoutParams.WRAP_CONTENT);
		ScrollView scrollView=new ScrollView(this);
		scrollView.addView(layout);
		setContentView(scrollView);
		
		context = this;
		
		textMessage = new EditText(this);
		textMessage.setHint(R.string.email_hint);
		layout.addView(textMessage, buttonParams);
		
		buttonSend = new Button(this);
		buttonSend.setText(R.string.email_send_btn);
		layout.addView(buttonSend, buttonParams);
		
		buttonSend.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View v) {
 
			  String message = textMessage.getText().toString();
			  String appName = getResources().getString(R.string.app_name);
			  String chooser = getResources().getString(R.string.email_send_btn);
			  String emailAddress = getResources().getString(R.string.email);
			  
			  Intent email = new Intent(Intent.ACTION_SEND);
			  email.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
			  email.putExtra(Intent.EXTRA_SUBJECT, appName);
			  email.putExtra(Intent.EXTRA_TEXT, message);
			  email.setType("message/email");
 
			  startActivity(Intent.createChooser(email, chooser));
 
			}
		});
	    
	    
		
	}
	

    

}
