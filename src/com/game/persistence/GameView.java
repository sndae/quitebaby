package com.game.persistence;

import android.content.Context;
import android.view.SurfaceView;

/**
 * The GameContainer holds, manages, and runs the various components that make
 * up the game.
 * 
 * @author Dennis Jr
 * 
 */
public class GameView extends SurfaceView implements IGameContainer {
	
	/**
	 * The currently running game state.
	 */
	private IGameState state;

	/**
	 * Creates a new GameContainer with null input, graphics, and state, and is
	 * currently running. Use the appropriate setter methods to set input,
	 * graphics, and state after creation.
	 */
	public GameView(Context context) {
		super(context);
		this.state = null;
	}

	/**
	 * Creates a new GameContainer with specified input, graphics, and state,
	 * and is currently running.
	 * 
	 * @param input
	 *            the input mechanisms to be used.
	 * @param graphics
	 *            the rendering mechanisms to be used.
	 * @param state
	 *            the first game state to be run.
	 */
	public GameView(Context context, IGameState state) {
		super(context);
		this.state = state;
	}

	/**
	 * Sets the currently running game state. The new state will take effect on
	 * the next cycle of the game loop.
	 */
	public void setGameState(IGameState state) {
		this.state = state;
	}

	/**
	 * Get the currently running game state.
	 * 
	 * @return the currently running game state.
	 */
	public IGameState getGameState() {
		return this.state;
	}
}
