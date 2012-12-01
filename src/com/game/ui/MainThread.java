package com.game.ui;

import android.view.SurfaceHolder;

public class MainThread extends Thread{
private SurfaceHolder surfaceHolder;
private GameActivity gameActivity;
private boolean running;

public MainThread(SurfaceHolder surfaceHolder, GameActivity gameActivity){
	super();
	this.surfaceHolder = surfaceHolder;
	this.gameActivity = gameActivity;
}

public void setRunning(boolean running){
	this.running = running;
}
@Override
public void run(){
	while(running){
		//update game state
		//render state to the screen
				  }
	}
}
