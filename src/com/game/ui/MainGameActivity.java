package com.game.ui;

import com.game.ui.R;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainGameActivity extends Activity {
	
	private Button new_game, resume_game, high_scores, how_to_play, options, quit;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
			
		new_game = (Button) findViewById(R.id.newGameButton);
		//resume_game = (Button) findViewById(R.id.resumeGameButton);
		high_scores = (Button) findViewById(R.id.highScoresButton);
		how_to_play = (Button) findViewById(R.id.howToPlayButton);
		options = (Button) findViewById(R.id.optionsButton);
		quit = (Button) findViewById(R.id.quitButton);
		
		//calls new game method
		new_game.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				loadNewGame();
			}
		});
			
		
		//resume_game.setOnClickListener(new View.OnClickListener() {
			//public void onClick(View v) {
				// TODO Auto-generated method stub
			//}
		//});
		high_scores.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Load high scores state
			}
		});
		how_to_play.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				loadHowToPlayMenu();
			}
		});
		//calls options menu method
		options.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				loadOptionsMenu();
			}
		});
		//exits the game
		quit.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			finish();
			System.exit(0);
			}
		});

}
	
//////////////////////Methods//////////////////////////////////////
		
		//method to load new game screen
		private void loadNewGame(){
		Intent loadNewGame = new Intent(this, GameActivity.class);
		startActivity(loadNewGame);
		}
		//method to load the options menu
		private void loadOptionsMenu() {
		Intent optionsMenu = new Intent(this, OptionsMenu.class);
		startActivity(optionsMenu);
		}
		//method to load the directions
		private void loadHowToPlayMenu(){
		Intent howToPlayMenu = new Intent(this, HowToPlayMenu.class);
		startActivity(howToPlayMenu);	
		}
		
	
		@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main_game, menu);
		return true;
	}
}
