package com.game.persistence;


/**
 * TitleState represents the game's Title Screen, where the player can choose to start the game, 
 * or view high scores or settings options.
 * @author Dennis Jr
 *
 */
public class TitleState extends BaseGameState{
	/**
	 * Update game logic. 
	 * @param container the game container.
	 */
	@Override
	public void update(IGameContainer container){
		//Get input listeners from the game container.
		IInput input = container.getInput();
	}
	
	/**
	 * Render the updated game environment to the screen.
	 * @param container the game container.
	 */
	@Override
	public void render(IGameContainer container){
		//Get rendering mechanisms from the game container.
		IGraphics graphics = container.getGraphics();
	}
}
