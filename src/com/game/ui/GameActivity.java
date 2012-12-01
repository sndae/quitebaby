package com.game.ui;

import com.game.persistence.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;


public class GameActivity extends Activity {
	private Picture picture;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        picture = new Picture(this);
        
        //Get rid of the application title bar.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        }
	
	
}
