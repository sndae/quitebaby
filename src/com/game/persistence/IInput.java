package com.game.persistence;

import android.view.MotionEvent;

/**
 * An IInput holds and manages the listeners for the device's various input
 * mechanisms.
 * 
 * @author Dennis Jr TO DO: This interface may be more appropriate in the
 *         integration package.
 */
public interface IInput {
	/**
	 * Reads and stores the input from the device's input mechanisms.
	 */
	public void pollInput();
	
	/**
	 * Get the X axis value of the device's accelerometer.
	 * 
	 * @return the X value of the accelerometer.0
	 */
	public float getAccelX();

	/**
	 * Get the Y axis value of the device's accelerometer.
	 * 
	 * @return the Y value of the accelerometer.
	 */
	public float getAccelY();

	/**
	 * Get the Z axis value of the device's accelerometer.
	 * 
	 * @return the Z value of the accelerometer
	 */
	public float getAccelZ();

	/**
	 * Get the X axis value of where the touch screen is being touched.
	 * 
	 * @return the X value of the touch screen.
	 */
	public float getTouchX();

	/**
	 * Get the Y axis value of where the touch screen is being touched.
	 * 
	 * @return the Y value of the touch screen.
	 */
	public float getTouchY();

	boolean onTouchEvent(MotionEvent e);
}
