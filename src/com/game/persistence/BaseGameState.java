package com.game.persistence;



/**
 * BaseGameState forms the basis for the various game states that the game will
 * run. Variables and Constants used by all game states should be defined here.
 * This class is abstract and thus no BaseGameState objects should be created,
 * instead use the completed game state classes such as TitleState,
 * SettingsState, HighScoreState, and PlayState. Also, this class' update and
 * render methods do nothing and are instead overridden by those of the
 * completed game states.
 * 
 * @author Dennis Jr
 * 
 */
public abstract class BaseGameState extends Thread{
	/**
	 * Does nothing, is overridden by the update methods of completed game
	 * states.
	 */
	public abstract void update();

	/**
	 * Does nothing, is overridden by the render methods of completed game
	 * states.
	 */
	public abstract void render();
}
