package com.game.persistence;


/**
 * An IGameContainer holds, manages, and runs the various components that make up a game.
 * @author Dennis Jr
 *
 */
public interface IGameContainer {
	/**
	 * Set the currently running game state.
	 * @param state the game state to be set.
	 */
	public void setGameState(IGameState state);
	
	/**
	 * Run the game loop, which consists of updating game logic and then rendering the 
	 * updated game environment to the screen.
	 */
	public void gameLoop();
}
