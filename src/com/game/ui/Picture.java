package com.game.ui;

import com.game.integration.SensorListener;
import com.game.persistence.IGameThread;
import com.game.persistence.PlayState;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Picture extends SurfaceView implements SurfaceHolder.Callback, IGameView {
	private static final String TAG = Picture.class.getSimpleName();
	public boolean babyHappy;
	public IGameThread thread;

	public Picture(Context context) {
		super(context);
		// intercept events
		getHolder().addCallback(this);
		// create thread
		thread = new PlayState(this, getHolder(), new SensorListener(context));
		setFocusable(true);
		this.babyHappy = false;
	}

	// @Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	// @Override
	public void surfaceCreated(SurfaceHolder holder) {
		thread.setRunning(true);
		thread.start();
	}

	// @Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		
	}

	@Override
	public void onDraw(Canvas canvas) {

		if (babyHappy) {
			canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
					R.drawable.baby_happy), 10, 10, null);
		} else {
			canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
					R.drawable.baby_unhappy), 10, 10, null);
		}
	}
	
	public boolean isBabyHappy(){
		return this.babyHappy;
	}
	
	public void setBabyHappy(boolean babyHappy){
		this.babyHappy = babyHappy;
	}
}
