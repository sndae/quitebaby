package com.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class OptionsMenu extends Activity{
	private Button save_options, cancel_options;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.optionsmenu);
		
		save_options = (Button)findViewById(R.id.saveOptionsButton);
		cancel_options = (Button)findViewById(R.id.cancelOptionsButton);
		
		save_options.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
				// TODO Saves selected settings
									}
		});
		cancel_options.setOnClickListener(new View.OnClickListener() {
		//calls cancel options method
			public void onClick(View v) {
				cancelOptionsMethod();
		
			}});
		}
			
//////////////////////////Methods///////////////////////////
			
		//method to cancel options
		private void cancelOptionsMethod() {
			Intent cancelOptionsMenu = new Intent(this, MainGameActivity.class);
			startActivity(cancelOptionsMenu);	
			}

}


