package com.game.integration;
import android.content.Context;
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

public class SensorListener implements SensorEventListener {
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private float accelX;
	private float accelY;
	private float accelZ;
	private boolean mInitialized;
	private final float NOISE = (float) 2.0;

	/**
	 * method to get access sensor activity
	 * 
	 * @return sensor service
	 * @return accelerometer sensor
	 */
	public SensorListener(Context context) {
		mInitialized = false;
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
	}

	/**
	 * Method to check sensor eventlistener on resume
	 */

	protected void onResume() {
       
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}

	/**
	 * Method to unregister the listener onPause of activity
	 */
	protected void onPause() {
		
		mSensorManager.unregisterListener(this);
	}

	/**
	 * method for getting integers from sensor
	 */
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	/**
	 * method for when sensor changes
	 * sets values for X, Y, Z for accelerometer
	 */

	public void onSensorChanged(SensorEvent event) {
		//Sets X Y and Z equal to accelerometer values.
		float x = event.values[0];
		float y = event.values[1];
		float z = event.values[2];
		
		if (!mInitialized) {
			//passes X, Y and Z to accel variables.
			accelX = x;
			accelY = y;
			accelZ = z;
			mInitialized = true;
			} else {
			float deltaX = Math.abs(accelX - x);
			float deltaY = Math.abs(accelY - y);
			float deltaZ = Math.abs(accelZ - z);
			if (deltaX < NOISE) deltaX = (float)0.0;
			if (deltaY < NOISE) deltaY = (float)0.0;
			if (deltaZ < NOISE) deltaZ = (float)0.0;
			accelX = x;
			accelY = y;
			accelZ = z;
			}
		
	}
	
	/**
	 * Get method to pull Y value from Sensor
	 * @return accelY Accelerometer value
	 */
	public float getAccelY(){
		return this.accelY;
	}
	
	/**
	 * Get method to pull Y value from Sensor
	 * @return accelX Accelerometer value
	 */
	public float getAccelX(){
		return this.accelX;
	}
	
	/**
	 * Get method to pull Y value from Sensor
	 * @return accelZ Accelerometer value
	 */
	public float getAccelZ(){
		return this.accelZ;
	}
}
