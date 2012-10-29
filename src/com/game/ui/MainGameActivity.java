package com.game.ui;

import com.game.ui.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainGameActivity extends Activity {

Button new_game, resume_game, high_scores, settings, how_to_play,test_button;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		new_game = (Button) findViewById(R.id.newGameButton);
		resume_game = (Button) findViewById(R.id.resumeGameButton);
		high_scores = (Button) findViewById(R.id.highScoresButton);
		how_to_play = (Button) findViewById(R.id.howToPlayButton);
		settings = (Button) findViewById(R.id.settingsButton);
				

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
			}
		});
		settings.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main_game, menu);
		return true;
	}
}
