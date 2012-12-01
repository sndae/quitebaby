package com.game.persistence;

/**
 * IGameStates represent the various components of the game, such as Title
 * Screen, Options Screen, and the actual Gameplay Screen. Each IGameState has
 * its own methods of updating game logic and then rendering the updated game
 * environment to the screen.
 * 
 * @author Dennis Jr
 * 
 */
public interface IGameState {
	/**
	 * Update game logic. Input can be retrieved from the game container.
	 * 
	 * @param container
	 *            the game container.
	 */
	public void update();

	/**
	 * Render the updated game environment to the screen. Rendering mechanisms
	 * can be retrieved from the game container.
	 * 
	 * @param container
	 *            the game container.
	 */
	public void render();
}
