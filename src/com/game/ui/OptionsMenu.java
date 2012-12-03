package com.game.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class OptionsMenu extends Activity{
	
	private Button save_options, cancel_options;
	private Spinner difficulty;
	public String difficultyValue, babyName;
	public EditText et;
	public AlertDialog alert;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.optionsmenu);
	
		
		difficulty = (Spinner)findViewById(R.id.easynormalhard);
		save_options = (Button)findViewById(R.id.saveOptionsButton);
		cancel_options = (Button)findViewById(R.id.cancelOptionsButton);
		
		
		
		
		
		
		save_options.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			difficultyValue = difficulty.getSelectedItem().toString();
			saveBabyName();
			alert.show();
			android.os.SystemClock.sleep(3000);
			finish();
		    }									
		});
		cancel_options.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				finish();
						
			}});
		}
	public void saveBabyName(){
		et=(EditText)findViewById(R.id.EditBabyName);
		babyName=et.getText().toString();
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Baby's Name is: " + babyName);
		alert = builder.create();
	}
}
			





