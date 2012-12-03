package com.game.integration;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

public interface IInput {
	public float getAccelY();
	public void onAccuracyChanged(Sensor sensor, int accuracy);
	public void onSensorChanged(SensorEvent event);
}
