package com.game.integration;

import com.game.ui.R;

import android.content.Context;
import android.media.MediaPlayer;



public class Sound {
	MediaPlayer mp;
	
	
	public void PlaySound(Context context){
		
		mp = MediaPlayer.create(context,R.raw.baby);
		mp.reset();
		mp.start();
	
	}
	 
	public void StopSound(){mp.release(); mp.pause();}
	
	public void PauseSound(){}
}
