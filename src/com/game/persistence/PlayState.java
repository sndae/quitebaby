package com.game.persistence;

import com.game.integration.SensorListener;

/**
 * PlayState represents the actual gameplay state of the game.
 * 
 * @author Dennis Jr
 * 
 */
public class PlayState extends BaseGameState {

	private boolean running;

	private GameView view;
	
	private SensorListener input;
	
	public PlayState(GameView view, SensorListener input) {
		this.view = view;
		this.input = input;
	}

	@Override
	public void run(){
		while(this.running){
			this.update();
			this.render();
		}
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void render() {
	}
}
