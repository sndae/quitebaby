package com.game.persistence;

/**
 * The GameContainer holds, manages, and runs the various components that make
 * up the game.
 * 
 * @author Dennis Jr
 * 
 */
public class GameContainer implements IGameContainer {
	/**
	 * The listeners for the device's various input mechanisms.
	 */
	private IInput input;

	/**
	 * The mechanisms for rendering game objects to the screen.
	 */
	private IGraphics graphics;

	/**
	 * The currently running game state.
	 */
	private IGameState state;

	/**
	 * Determines whether to continue running the game loop. While true, the
	 * game loop continues to execute. When false, the game loop ends.
	 */
	private boolean running;

	/**
	 * Creates a new GameContainer with null input, graphics, and state, and is
	 * currently running. Use the appropriate setter methods to set input,
	 * graphics, and state after creation.
	 */
	public GameContainer() {
		this.input = null;
		this.graphics = null;
		this.state = null;
		this.running = true;
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
	public GameContainer(IInput input, IGraphics graphics, IGameState state) {
		this.input = input;
		this.graphics = graphics;
		this.state = state;
		this.running = true;
	}

	/**
	 * Sets the currently running game state. The new state will take effect on
	 * the next cycle of the game loop.
	 */
	public void setGameState(IGameState state) {
		this.state = state;
	}

	/**
	 * The game loop, which consists of polling input, updating game logic, and
	 * then rendering the updated game environment to the screen. This cycle
	 * continues until something specifies that it should stop, such as a
	 * request to exit the application.
	 */
	public void gameLoop() {
		while (running) {
			// Read and record device input.
			this.input.pollInput();
			// Update game logic.
			this.state.update(this);
			// Render the updated game environment to the screen.
			this.state.render(this);
		}
	}

	/**
	 * Set the listeners for the device's input mechanisms.
	 * 
	 * @param input
	 *            the input listeners to be set.
	 */
	public void setInput(IInput input) {
		this.input = input;
	}

	/**
	 * Get the listeners for the device's input mechanisms
	 * 
	 * @return the input listeners.
	 */
	public IInput getInput() {
		return this.input;
	}

	/**
	 * Set the mechanisms for rendering objects to the screen.
	 * 
	 * @param graphics
	 *            the rendering mechanisms to be set.
	 */
	public void setGraphics(IGraphics graphics) {
		this.graphics = graphics;
	}

	/**
	 * Get the mechanisms for rendering objects to the screen.
	 * 
	 * @return the rendering mechanisms.
	 */
	public IGraphics getGraphics() {
		return this.graphics;
	}

	/**
	 * Get the currently running game state.
	 * 
	 * @return the currently running game state.
	 */
	public IGameState getGameState() {
		return this.state;
	}

	/**
	 * Set whether the game should be running.
	 * 
	 * @param running
	 *            whether the game should be running.
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * Get whether the game should be running.
	 * 
	 * @return whether the game should be running.
	 */
	public boolean isRunning() {
		return this.running;
	}
}
