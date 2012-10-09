package com.game.persistence;

/**
 * SettingsState represents the game's options screen, where the player can
 * adjust game settings.
 * 
 * @author Dennis Jr
 * 
 */
public class SettingsState extends BaseGameState {
	/**
	 * Update game logic.
	 * 
	 * @param container
	 *            the game container.
	 */
	@Override
	public void update(IGameContainer container) {
		// Get input listeners from the game container.
		IInput input = container.getInput();
	}

	/**
	 * Render the updated game environment to the screen.
	 * 
	 * @param container
	 *            the game container.
	 */
	@Override
	public void render(IGameContainer container) {
		// Get rendering mechanisms from the game container.
		IGraphics graphics = container.getGraphics();
	}
}
