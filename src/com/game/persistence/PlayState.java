package com.game.persistence;

/**
 * PlayState represents the actual gameplay state of the game.
 * 
 * @author Dennis Jr
 * 
 */
public class PlayState extends BaseGameState {
	/**
	 * Y-axis accelerometer input less than this value registers as "no shake",
	 * and input greater than this value and less than the value of STRONG_SHAKE
	 * registers as a "weak shake".
	 */
	private static final float WEAK_SHAKE = 0;

	/**
	 * Y-axis Accelerometer input greater than this value registers as a
	 * "strong shake".
	 */
	private static final float STRONG_SHAKE = 0;

	/**
	 * How much babyCryLevel increases on "no shake".
	 */
	private static final int CRY_NORMAL = 1;

	/**
	 * How much babyCryLevel decreases on "weak shake".
	 */
	private static final int CRY_GOOD = 1;

	/**
	 * How much babyCryLevel increases on "strong shake".
	 */
	private static final int CRY_BAD = 2;

	/**
	 * How many points score increases each frame that babyCryLevel = 0.
	 */
	private static final int SCORE_INCREASE = 100;

	/**
	 * How much the baby is crying and how close it is to stopping.
	 */
	private int babyCryLevel;

	/**
	 * The player's score. Score increases as long as the player keeps the baby
	 * happy (babyCryLevel = 0).
	 */
	private int score;

	/**
	 * How much time remains in the current round of the game.
	 */
	private int timeRemaining;

	/**
	 * Creates a new PlayState with the predesignated values.
	 */
	public PlayState() {
		this.babyCryLevel = 0;
		this.score = 0;
		this.timeRemaining = 0;
	}

	/**
	 * Update game logic.
	 * 
	 * @param container
	 *            the game container.
	 */
	@Override
	public void update(IGameContainer container) {
		// STEP 1: CHECK INPUT============================================
		// Get input listeners from the game container.
		IInput input = container.getInput();
		// Poll y-axis motion from the accelerometer.
		float accelY = input.getAccelY();
		// STEP 2: CHECK FOR TIME REMAINING===============================
		// If timeRemaining is greater than 0...
		if (this.timeRemaining > 0) {
			// STEP 3A: ADJUST BABY CRY LEVEL BASED ON INPUT==============
			// Determine whether the input is "no shake", "weak shake", or
			// "strong shake", and respond accordingly.
			// If accelY is "no shake"...
			if (accelY < WEAK_SHAKE) {
				// Increase babyCryLevel by CRY_NORMAL.
				this.babyCryLevel += CRY_NORMAL;
				// Else if accelY is "weak shake"...
			} else if (accelY > WEAK_SHAKE && accelY < STRONG_SHAKE) {
				// If babyCryLevel is greater than 0...
				if (this.babyCryLevel > 0) {
					// Decrease babyCryLevel by CRY_GOOD.
					this.babyCryLevel -= CRY_GOOD;
				}
				// Else if accelY is "strong shake"...
			} else if (accelY > STRONG_SHAKE) {
				// Increase babyCryLevel by CRY_BAD.
				this.babyCryLevel += CRY_BAD;
			}
			// STEP 4A: ADJUST SCORE======================================
			// If babyCryLevel is = 0...
			if (this.babyCryLevel == 0) {
				// Increase score by SCORE_INCREASE.
				this.score += SCORE_INCREASE;
			}
			// STEP 5A: DECREASE TIME REMAINING===========================
			// Decrease timeRemaining by 1 frame.
			this.timeRemaining -= 1;
		}
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
