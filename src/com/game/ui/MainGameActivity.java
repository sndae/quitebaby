package com.game.ui;

import com.game.ui.R;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainGameActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		Button new_game = (Button) findViewById(R.id.newGameButton);
		Button resume_game = (Button) findViewById(R.id.resumeGameButton);
		Button high_scores = (Button) findViewById(R.id.highScoresButton);
		Button how_to_play = (Button) findViewById(R.id.howToPlayButton);
		Button options = (Button) findViewById(R.id.optionsButton);
		Button quit = (Button) findViewById(R.id.quitButton);
				
		new_game.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 
			}
			});
		resume_game.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		});
		high_scores.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		});
		how_to_play.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(),HowToPlayMenu.class);
			}
		});
		options.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(),OptionsMenu.class);
			}
		});
		quit.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				System.exit(0);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main_game, menu);
		return true;
	}
}
