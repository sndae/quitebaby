package com.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class OptionsMenu extends Activity{
	
	private Button save_options, cancel_options;
	private Spinner difficulty;
	public String difficultyValue;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.optionsmenu);
	
	
		difficulty = (Spinner)findViewById(R.id.easynormalhard);
		difficultyValue = difficulty.getSelectedItem().toString();
		
		save_options = (Button)findViewById(R.id.saveOptionsButton);
		cancel_options = (Button)findViewById(R.id.cancelOptionsButton);
	
		
		//difficulty.setAdapter(adapter)
		save_options.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
		
		    }									
		});
		cancel_options.setOnClickListener(new View.OnClickListener() {
		//calls cancel options method
			public void onClick(View v) {
				cancelOptionsMethod();
				finish();
		
			}});
		}
			
//////////////////////////Methods///////////////////////////
			
		//method to cancel options
		private void cancelOptionsMethod() {
			Intent cancelOptionsMenu = new Intent(this, MainGameActivity.class);
			startActivity(cancelOptionsMenu);	
			
			}
		}




