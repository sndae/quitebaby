package com.game.persistence;



/**
 * BaseGameState forms the basis for the various game states that the game will
 * run. Variables and Constants used by all game states should be defined here.
 * This class is abstract and thus no BaseGameState objects should be created,
 * instead use the completed game state classes such as PlayState.
 * 
 * @author Dennis Jr
 * 
 */
public abstract class BaseGameState extends Thread implements IGameThread{
	@Override
	public abstract void run();
	public abstract void update();
	public abstract void render();
	public abstract void setRunning(boolean running);
	
	/**
	 * Start the Thread.
	 */
	@Override
	public void start(){
		super.start();
	}
}
