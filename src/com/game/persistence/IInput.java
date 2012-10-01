package com.game.persistence;

/**
 * An IInput holds and manages the listeners for the device's various input mechanisms.
 * NOTE: This is a placeholder version of the interface to be replaced by a full version later.
 * @author Dennis Jr
 *
 */
public interface IInput {
	/**
	 * Get the X axis value of the device's accelerometer.
	 * @return the X value of the accelerometer.0
	 */
	public float getAccelX();
	
	/**
	 * Get the Y axis value of the device's accelerometer.
	 * @return the Y value of the accelerometer.
	 */
	public float getAccelY();
	
	
	/**
	 * Get the Z  axis value of the device's accelerometer.
	 * @return the Z value of the accelerometer
	 */
	public float getAccelZ();
	
	/**
	 * Get the X axis value of where the touch screen is being touched.
	 * @return the X value of the touch screen.
	 */
	public float getTouchX();
	
	/**
	 * Get the Y axis value of where the touch screen is being touched.
	 * @return the Y value of the touch screen.
	 */
	public float getTouchY();
}
