package com.game.integration;

import com.game.persistence.IInput;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * This class functions as an event listener for the accelerometer on the
 * device. This class does not handle the events for the sensor only allows
 * access to them.
 * 
 * @author Kenny
 */

public class SensorActivity extends Activity implements SensorEventListener, IInput {
	private final SensorManager mSensorManager;
	private final Sensor mAccelerometer;
	private float accelX;
	private float accelY;
	private float accelZ;
	private float touchX;
	private float touchY;


	/**
	 * method to get access sensor activity
	 * 
	 * @return sensor service
	 * @return accelerometer sensor
	 */
	public SensorActivity() {
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mAccelerometer = mSensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	}

	/**
	 * Method to check sensor eventlistener on resume
	 */

	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener((SensorEventListener) this,
				mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}

	/**
	 * Method to unregister the listener onPause of activity
	 */
	protected void onPause() {
		super.onPause();
		mSensorManager.unregisterListener((SensorEventListener) this);
	}

	/**
	 * method for getting integers from sensor
	 */
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	/**
	 * method for when sensor changes
	 */

	public void onSensorChanged(SensorEvent event) {
		
		
	}
	
public void pollInput(){}
	

	public float getAccelX(){
		
		
		return accelX;}


	public float getAccelY(){
		return accelY;}

	
	public float getAccelZ(){
		
		return accelZ;}

	
	public float getTouchX(){
		
		return touchX ;
	}

	
	public float getTouchY(){
		return touchY;
	}
}
