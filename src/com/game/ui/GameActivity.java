package com.game.ui;

import com.game.persistence.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;


public class GameActivity extends Activity {
	private static final String TAG = GameActivity.class.getSimpleName();
	private Picture picture;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        picture = new Picture(this);
        setContentView(picture);
        //Get rid of the application title bar.
        }
	
	public void onDestroy(){
	}
	
	@Override
	public void onBackPressed(){
		PlayState thread = this.picture.thread;
		thread.setRunning(false);
		thread.sound.StopSound();
		thread.sound.mp.release();
		Intent mainMenu = new Intent(this, MainGameActivity.class);
		super.onBackPressed();
		startActivity(mainMenu);
	}
}
