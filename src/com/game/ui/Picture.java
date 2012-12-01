package com.game.ui;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Picture extends SurfaceView implements SurfaceHolder.Callback{
	public boolean babyHappy;
	private MainThread thread;
		public Picture(Context context){
			super(context);
		//intercept events
		getHolder().addCallback(this);
		//create thread
		thread = new MainThread(getHolder(),this);
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
		public void onDraw(Canvas canvas){
			canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.baby_happy), 10, 10, null);
		}
}	
    
    
    
    
 
	
	
	


