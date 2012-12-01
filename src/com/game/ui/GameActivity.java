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
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;


public class GameActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //Get rid of the application title bar.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
	
	public class Picture extends SurfaceView implements SurfaceHolder.Callback{
	private MainThread thread;
		public Picture(Context context){
			super(context);
		//intercept events
		getHolder().addCallback(this);
		//create thread
		///////////////////thread = new MainThread(getHolder(),this);
		setFocusable(true);
		}
		//@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		}
		//@Override
	    public void surfaceCreated(SurfaceHolder holder) {
	    thread.setRunning(true);
	    thread.start();
	    }
		//@Override
	    public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		while(retry){
		try{
			thread.join();
			retry = false;
		} catch(InterruptedException e)
		{
			
		}
		}
	    } 
		@Override
		protected void onDraw(Canvas canvas){
			canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.baby_happy), 10, 10, null);
		}
		}
}
