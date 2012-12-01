package com.game.integration;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.MotionEvent;



import com.game.persistence.IInput;

/**
 * This class functions as an event listener for the accelerometer on the
 * device. This class does not handle the events for the sensor only allows
 * access to them.
 * 
 * @author Kenny
 */

public class SensorListener implements SensorEventListener, IInput {
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private float accelX;
	private float accelY;
	private float accelZ;
	private float touchX;
	private float touchY;
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
	 */

	public void onSensorChanged(SensorEvent event) {
		
		

		
		
		
		float x = event.values[0];
		float y = event.values[1];
		float z = event.values[2];
		
		if (!mInitialized) {
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
	
	@Override
	public boolean onTouchEvent(MotionEvent e) {
	    // MotionEvent reports input details from the touch screen
	    // and other input controls. In this case, you are only
	    // interested in events where the touch position changed.

	    float x = e.getX();
	    float y = e.getY();

	   
	    touchX = x;
	    touchY = y;
	    return true;
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
