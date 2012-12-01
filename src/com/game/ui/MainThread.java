package com.game.ui;



import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread{
private SurfaceHolder surfaceHolder;
private com.game.ui.Picture gameActivity;
private boolean running;

public MainThread(SurfaceHolder surfaceHolder, com.game.ui.Picture picture){
	super();
	this.surfaceHolder = surfaceHolder;
	this.gameActivity = picture;
}

public void setRunning(boolean running){
	this.running = running;
}
@Override
public void run(){
	Canvas canvas;
	while(running){
		canvas = null;
	try {
		canvas = this.surfaceHolder.lockCanvas();
		synchronized(surfaceHolder){
			this.gameActivity.onDraw(canvas);
		}
	} finally {
		if(canvas != null){
			surfaceHolder.unlockCanvasAndPost(canvas);
		}
	}
		//update game state
		//render state to the screen
				  }
	}
}
