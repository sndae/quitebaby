package com.game.persistence;

import android.graphics.Canvas;
import android.hardware.Sensor;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.view.SurfaceHolder;

import com.game.integration.SensorListener;
import com.game.integration.Sound;
import com.game.ui.Picture;

/**
 * PlayState represents the actual gameplay state of the game.
 * 
 * @author Dennis Jr
 * 
 */
public class PlayState extends BaseGameState implements SensorEventListener {

	private static final String TAG = PlayState.class.getSimpleName();

	private static final float WEAK_SHAKE_THRESHOLD = 1;

	private static final float STRONG_SHAKE_THRESHOLD = 9999;

	private static final int BABY_CRY_START = 1;

	private static final int BABY_CRY_TARGET = 0;

	private static final int BABY_CRY_CHANGE_NO = 1;

	private static final int BABY_CRY_CHANGE_WEAK = -1;

	private static final int BABY_CRY_CHANGE_STRONG = 1;

	private static final int BABY_CRY_MAX = 1;

	private static final int BABY_CRY_MIN = 0;

	private static final int FRAMES_PER_SECOND = 50;

	private static final int FRAME_PERIOD = 1000 / FRAMES_PER_SECOND;

	private static final int MAX_FRAME_SKIPS = 5;

	private int babyCryLevel;

	private boolean running;

	private Picture view;

	private SurfaceHolder holder;

	private SensorListener input;

	private Sound sound;

	public PlayState(Picture view, SurfaceHolder holder, SensorListener input) {
		this.view = view;
		this.input = input;
		this.holder = holder;
		this.running = false;
		this.sound = new Sound();
		this.babyCryLevel = BABY_CRY_START;
	}

	@Override
	public void run() {
		while (this.running) {
			long beginTime = System.currentTimeMillis();
			int framesSkipped = 0;
			this.update();
			this.render();
			long timeDiff = System.currentTimeMillis() - beginTime;
			int sleepTime = (int) (FRAME_PERIOD - timeDiff);
			if (sleepTime > 0) {
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					Log.d(TAG, e.getMessage());
				}
			}
			while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
				this.update();
				sleepTime += FRAME_PERIOD;
				framesSkipped++;
			}
		}
	}

	@Override
	public void update() {
		float accelY = this.input.getAccelY();
		if (accelY < WEAK_SHAKE_THRESHOLD) {
			this.babyCryLevel += BABY_CRY_CHANGE_NO;
		} else if (accelY >= WEAK_SHAKE_THRESHOLD
				&& accelY < STRONG_SHAKE_THRESHOLD) {
			this.babyCryLevel += BABY_CRY_CHANGE_WEAK;
		} else if (accelY >= STRONG_SHAKE_THRESHOLD) {
			this.babyCryLevel += BABY_CRY_CHANGE_STRONG;
		}
		if (this.babyCryLevel > BABY_CRY_MAX) {
			this.babyCryLevel = BABY_CRY_MAX;
		} else if (this.babyCryLevel < BABY_CRY_MIN) {
			this.babyCryLevel = BABY_CRY_MIN;
		}
		if (this.babyCryLevel > BABY_CRY_TARGET) {
			this.view.babyHappy = false;
			if (!this.sound.mp.isPlaying()) {
				this.sound.PlaySound(this.view.getContext());
			}
		} else if (this.babyCryLevel <= BABY_CRY_TARGET) {
			this.view.babyHappy = true;
			if (this.sound.mp.isPlaying()) {
				this.sound.StopSound();
			}
		}
	}

	@Override
	public void render() {
		Canvas canvas = null;
		try {
			canvas = this.holder.lockCanvas();
			this.view.onDraw(canvas);
		} catch (Exception e) {
			Log.d(TAG, e.getMessage());
		} finally {
			if (canvas != null) {
				this.holder.unlockCanvasAndPost(canvas);
			}
		}
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		this.input.onAccuracyChanged(sensor, accuracy);
	}

	public void onSensorChanged(SensorEvent event) {
		this.input.onSensorChanged(event);
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}
