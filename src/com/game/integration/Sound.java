package com.game.integration;

import com.game.ui.R;

import android.content.Context;
import android.media.MediaPlayer;

public class Sound implements IAudio{
	//initialize global media player value 
	public MediaPlayer mp;

	/**
	 * Method to initialize the cry baby sound 
	 * @param context
	 */
	public Sound(Context context) {
		this.mp = MediaPlayer.create(context, R.raw.baby);
	
	}

	/**
	 * Method to play the crying baby sound 
	 * @param context
	 */
	public void PlaySound(Context context) {
		if (!this.mp.isPlaying()) {
			mp.start();
		}
	}
	
	/**
	 * Method to pause the baby from crying. 
	 */

	public void StopSound() {
		if (this.mp.isPlaying()) {
			mp.stop();
		}
	}

}
