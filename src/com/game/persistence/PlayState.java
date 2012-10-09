package com.game.persistence;


/**
 * PlayState represents the actual gameplay state of the game.
 * @author Dennis Jr
 *
 */
public class PlayState extends BaseGameState{
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
