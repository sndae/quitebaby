package com.game.persistence;

import android.graphics.Canvas;
import android.hardware.Sensor;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.view.SurfaceHolder;

import com.game.integration.IAudio;
import com.game.integration.IInput;
import com.game.integration.SensorListener;
import com.game.integration.Sound;
import com.game.ui.IGameView;
import com.game.ui.Picture;

/**
 * PlayState represents the actual gameplay state of the game.
 * 
 * @author Dennis Jr
 * 
 */
public class PlayState extends BaseGameState implements SensorEventListener {

	/**
	 * Log tag for this class.
	 */
	private static final String TAG = PlayState.class.getSimpleName();
	
	/**
	 * Target frames per second.
	 */
	private static final int FRAMES_PER_SECOND = 50;

	/**
	 * Length of each frame.
	 */
	private static final int FRAME_PERIOD = 1000 / FRAMES_PER_SECOND;

	/**
	 * Maximum number of allowed skipped frames.
	 */
	private static final int MAX_FRAME_SKIPS = 5;

	/**
	 * Minimum strength of a weak shake.
	 */
	private static final float WEAK_SHAKE_THRESHOLD = 3;

	/**
	 * Minimum strength of a strong shake.
	 */
	private static final float STRONG_SHAKE_THRESHOLD = 9999;

	/**
	 * Value of babyCryLevel at the start of the game.
	 */
	private static final int BABY_CRY_START = 1* FRAMES_PER_SECOND;

	/**
	 * Target value of babyCryLevel to make the baby stop crying.
	 */
	private static final int BABY_CRY_TARGET = 0;

	/**
	 * Change of babyCryLevel when there is no shake (not enough).
	 */
	private static final int BABY_CRY_CHANGE_NO = 1;

	/**
	 * Change of babyCryLevel when there is a weak shake (target).
	 */
	private static final int BABY_CRY_CHANGE_WEAK = -1;

	/**
	 * Change of babycryLevel when there is a strong shake (too much).
	 */
	private static final int BABY_CRY_CHANGE_STRONG = 1;

	/**
	 * Maximum value of babyCryLevel.
	 */
	private static final int BABY_CRY_MAX = 1 * FRAMES_PER_SECOND;

	/**
	 * Mimimum value of babyCryLevel.
	 */
	private static final int BABY_CRY_MIN = 0;

	/**
	 * How long the baby stays happy after reaching BABY_CRY_TARGET until it 
	 * starts crying again.
	 */
	private static final int BABY_HAPPY_DURATION = 5 * FRAMES_PER_SECOND;

	/**
	 * Measures how much the baby must be gently shaken until it stops crying.
	 */
	private int babyCryLevel;

	/**
	 * Measures how much time the baby will remain happy until it start crying
	 * again.
	 */
	private int babyHappyTime;

	/**
	 * Specifies whether the game should be running.
	 */
	private boolean running;

	/**
	 * The Android View.
	 */
	public IGameView view;

	/**
	 * The SurfaceHolder.
	 */
	private SurfaceHolder holder;

	/**
	 * The mechanism for reading input from the accelerometer.
	 */
	private IInput input;

	/**
	 * The baby's crying sound.
	 */
	public IAudio sound;

	/**
	 * Creates a new PlayState with the specified View, SurfaceHolder, and 
	 * SensorListener.
	 * @param view the View.
	 * @param holder the SurfaceHolder.
	 * @param input the SensorListener.
	 */
	public PlayState(IGameView view, SurfaceHolder holder, IInput input) {
		this.view = view;
		this.input = input;
		this.holder = holder;
		this.running = false;
		this.sound = new Sound(this.view.getContext());
		this.babyCryLevel = BABY_CRY_START;
		this.babyHappyTime = 0;
	}

	/**
	 * Run the game.
	 */
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

	/**
	 * Update game logic.
	 */
	@Override
	public void update() {
		if (this.babyHappyTime <= 0) {
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
				this.view.setBabyHappy(false);
				this.sound.PlaySound(this.view.getContext());
			} else if (this.babyCryLevel <= BABY_CRY_TARGET) {
				this.view.setBabyHappy(true);
				this.sound.StopSound();
				this.babyHappyTime = BABY_HAPPY_DURATION;
			}
		} else {
			this.babyHappyTime -= 1;
			if (this.babyHappyTime <= 0){
				this.babyCryLevel = BABY_CRY_START;
			}
		}
	}

	/**
	 * Render the updated game environment to the screen.
	 */
	@Override
	public void render() {
		Canvas canvas = this.holder.lockCanvas();
		this.view.onDraw(canvas);
		this.holder.unlockCanvasAndPost(canvas);
	}

	/**
	 * 
	 */
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		this.input.onAccuracyChanged(sensor, accuracy);
	}

	/**
	 * 
	 */
	public void onSensorChanged(SensorEvent event) {
		this.input.onSensorChanged(event);
	}

	/**
	 * Set whether the game should be running.
	 * @param running whether the game should be running.
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}
}
