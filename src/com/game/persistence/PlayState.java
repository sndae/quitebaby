package com.game.persistence;

import android.graphics.Canvas;
import android.hardware.Sensor;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.SurfaceHolder;

import com.game.integration.SensorListener;
import com.game.ui.Picture;

/**
 * PlayState represents the actual gameplay state of the game.
 * 
 * @author Dennis Jr
 * 
 */
public class PlayState extends BaseGameState implements SensorEventListener{

	private static final float WEAK_SHAKE_THRESHOLD = 0;
	
	private static final float STRONG_SHAKE_THRESHOLD = 0;
	
	private static final int BABY_CRY_START = 0;
	
	private static final int BABY_CRY_TARGET = 0;
	
	private static final int BABY_CRY_CHANGE_NO = 0;
	
	private static final int BABY_CRY_CHANGE_WEAK = 0;
	
	private static final int BABY_CRY_CHANGE_STRONG = 0;
	
	private int babyCryLevel;
	
	private boolean running;

	private Picture view;
	
	private SurfaceHolder holder;
	
	private SensorListener input;
	
	public PlayState(Picture view, SensorListener input) {
		this.view = view;
		this.input = input;
		this.running = false;
		this.babyCryLevel = BABY_CRY_START;
	}

	@Override
	public void run(){
		while(this.running){
			this.update();
			this.render();
		}
	}
	
	@Override
	public void update() {
		float accelY = this.input.getAccelY();
		if (accelY < WEAK_SHAKE_THRESHOLD){
			this.babyCryLevel += BABY_CRY_CHANGE_NO;
		} else if (accelY >= WEAK_SHAKE_THRESHOLD && accelY < STRONG_SHAKE_THRESHOLD){
			this.babyCryLevel += BABY_CRY_CHANGE_WEAK;
		} else if (accelY >= STRONG_SHAKE_THRESHOLD){
			this.babyCryLevel += BABY_CRY_CHANGE_STRONG;
		}
	}

	@Override
	public void render() {
		if (this.babyCryLevel > BABY_CRY_TARGET){
			//Draw Crying Baby
		} else if (this.babyCryLevel <= BABY_CRY_TARGET){
			//Draw Happy Baby
		}
		Canvas canvas = this.holder.lockCanvas();
		this.view.onDraw(canvas);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		this.input.onAccuracyChanged(sensor, accuracy);
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		this.input.onSensorChanged(event);
	}
}
