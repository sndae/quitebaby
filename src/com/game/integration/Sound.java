package com.game.integration;

import com.game.ui.R;

import android.content.Context;
import android.media.MediaPlayer;

public class Sound {
	public MediaPlayer mp;

	public Sound(Context context) {
		this.mp = MediaPlayer.create(context, R.raw.baby);
	
	}

	public void PlaySound(Context context) {
		if (!this.mp.isPlaying()) {
			
			mp.start();
		}
	}

	public void StopSound() {
		if (this.mp.isPlaying()) {
			mp.pause();
			
	
			
		}
	}

	public void PauseSound() {
	}
}
