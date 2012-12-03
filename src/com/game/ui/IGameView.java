package com.game.ui;

import android.content.Context;
import android.graphics.Canvas;

public interface IGameView {
	public Context getContext();
	public void onDraw(Canvas canvas);
	public boolean isBabyHappy();
	public void setBabyHappy(boolean babyHappy);
}
