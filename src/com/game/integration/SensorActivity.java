package com.game.integration;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.game.persistence.IInput;
import com.game.ui.R;

/**
 * This class functions as an event listener for the accelerometer on the
 * device. This class does not handle the events for the sensor only allows
 * access to them.
 * 
 * @author Kenny
 */

public class SensorActivity extends Activity implements SensorEventListener, IInput {
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private float accelX;
	private float accelY;
	private float accelZ;
	private float touchX;
	private float touchY;
	private boolean mInitialized;
	private final float NOISE = (float) 2.0;

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        mInitialized = false;
	        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	        mSensorManager.registerListener(this, mAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
	    }


	/**
	 * method to get access sensor activity
	 * 
	 * @return sensor service
	 * @return accelerometer sensor
	 */
	public SensorActivity() {
		//mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		//mAccelerometer = mSensorManager
				//.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	}

	/**
	 * Method to check sensor eventlistener on resume
	 */

	protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}

	/**
	 * Method to unregister the listener onPause of activity
	 */
	protected void onPause() {
		super.onPause();
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
