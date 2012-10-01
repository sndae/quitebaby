package com.game.ui;

import com.game.ui.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainGameActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_game, menu);
        return true;
    }
}
