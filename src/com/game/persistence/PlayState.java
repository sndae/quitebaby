package com.game.persistence;

import android.graphics.drawable.Drawable;

/**
 * PlayState represents the actual gameplay state of the game.
 * 
 * @author Dennis Jr
 * 
 */
public class PlayState extends BaseGameState {
	/**
	 * The value of babyCryLevel at the start of the game.
	 */
	private static final int INITIAL_CRY_LEVEL = 10;

	/**
	 * The player's score at the start of the game.
	 */
	private static final int INITIAL_SCORE = 0;

	/**
	 * The duration of the game in frames or cycles of the game loop, and the
	 * initial value of timeRemaining. Assume 60 frames per second when
	 * assigning this value.
	 */
	private static final int GAME_LENGTH = 3600;

	/**
	 * The game ends when timeRemaining is equal to this value.
	 */
	private static final int GAME_END = 0;

	/**
	 * How much timeRemaining decreases at the end of each frame.
	 */
	private static final int FRAME_LENGTH = -1;

	/**
	 * Y-axis accelerometer input less than this value registers as "no shake",
	 * and input greater than this value and less than the value of STRONG_SHAKE
	 * registers as a "weak shake".
	 */
	private static final float WEAK_SHAKE = 10;

	/**
	 * Y-axis Accelerometer input greater than this value registers as a
	 * "strong shake".
	 */
	private static final float STRONG_SHAKE = 50;

	/**
	 * How much babyCryLevel increases on "no shake".
	 */
	private static final int CRY_CHANGE_NONE = 1;

	/**
	 * How much babyCryLevel decreases on "weak shake".
	 */
	private static final int CRY_CHANGE_WEAK = -1;

	/**
	 * How much babyCryLevel increases on "strong shake".
	 */
	private static final int CRY_CHANGE_STRONG = 2;

	/**
	 * The value of babyCryLevel that determines that the baby is happy.
	 */
	private static final int BABY_HAPPY = 0;

	/**
	 * How many points score increases each frame that babyCryLevel = 0.
	 */
	private static final int SCORE_INCREASE = 100;

	/**
	 * The file path of the image to be used as the background.
	 */
	private static final String BACKGROUND_IMAGE = "type file path here";

	/**
	 * The file path of the image to be used to represent the crying baby.
	 */
	private static final String CRY_BABY_IMAGE = "type file path here";

	/**
	 * The file path of the image to be used to represent the happy baby.
	 */
	private static final String HAPPY_BABY_IMAGE = "type file path here";

	/**
	 * The x axis position of the background image's top left corner.
	 */
	private static final float BACKGROUND_X = 0;

	/**
	 * The y axis position of the background image's top left corner.
	 */
	private static final float BACKGROUND_Y = 0;

	/**
	 * The x axis position of the baby image's top left corner.
	 */
	private static final float BABY_X = 0;

	/**
	 * The y axis position of the baby image's top left corner.
	 */
	private static final float BABY_Y = 0;

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
	 * The image to be used as the background.
	 */
	private Drawable background;

	/**
	 * The image that represents the crying baby.
	 */
	private Drawable cryingBaby;

	/**
	 * The image that represents the happy baby.
	 */
	private Drawable happyBaby;

	/**
	 * Creates a new PlayState with the predesignated values.
	 */
	public PlayState() {
		this.babyCryLevel = INITIAL_CRY_LEVEL;
		this.score = INITIAL_SCORE;
		this.timeRemaining = GAME_LENGTH;
		this.background = Drawable.createFromPath(BACKGROUND_IMAGE);
		this.cryingBaby = Drawable.createFromPath(CRY_BABY_IMAGE);
		this.happyBaby = Drawable.createFromPath(HAPPY_BABY_IMAGE);
	}

	/**
	 * Update game logic.
	 * 
	 * @param container
	 *            the game container.
	 */
	@Override
	public void update(IGameContainer container) {
		// =====STEP 1: CHECK INPUT=====
		// Get input from the game container.
		IInput input = container.getInput();
		// Poll y-axis motion from the accelerometer.
		float accelY = input.getAccelY();
		// =====STEP 2: CHECK FOR TIME REMAINING=====
		// If timeRemaining is greater than GAME_END...
		if (this.timeRemaining > GAME_END) {
			// =====STEP 3A: ADJUST BABY CRY LEVEL BASED ON INPUT=====
			// Determine whether the input is "no shake", "weak shake", or
			// "strong shake", and respond accordingly.
			// If accelY is "no shake"...
			if (accelY < WEAK_SHAKE) {
				// Increase babyCryLevel by CRY_CHANGE_NONE.
				this.babyCryLevel += CRY_CHANGE_NONE;
				// Else if accelY is "weak shake"...
			} else if (accelY > WEAK_SHAKE && accelY < STRONG_SHAKE) {
				// If babyCryLevel is greater than BABY_HAPPY...
				if (this.babyCryLevel > BABY_HAPPY) {
					// Decrease babyCryLevel by CRY_CHANGE_WEAK.
					this.babyCryLevel += CRY_CHANGE_WEAK;
				}
				// Else if accelY is "strong shake"...
			} else if (accelY > STRONG_SHAKE) {
				// Increase babyCryLevel by CRY_CHANGE_STRONG.
				this.babyCryLevel += CRY_CHANGE_STRONG;
			}
			// =====STEP 4A: ADJUST SCORE======
			// If babyCryLevel is BABY_HAPPY...
			if (this.babyCryLevel == BABY_HAPPY) {
				// Increase score by SCORE_INCREASE.
				this.score += SCORE_INCREASE;
			}
			// =====STEP 5A: DECREASE TIME REMAINING=====
			// Decrease timeRemaining by FRAME_LENGTH.
			this.timeRemaining += FRAME_LENGTH;
			// Else, there is no time remaining...
		} else {
			// =====STEP 3B: END THE GAME=====
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
		// REMINDER: Render images in order from back to front.
		// =====STEP 1: GET RENDERING MECHANISMS=====
		// Get rendering mechanisms from the game container.
		IGraphics graphics = container.getGraphics();
		// =====STEP 2: RENDER BACKGROUND=====
		// Draw the background.
		graphics.draw(this.background, BACKGROUND_X, BACKGROUND_Y);
		// =====STEP 3: RENDER BABY=====
		// Check whether baby should be crying or happy, and render
		// the appropriate image.
		// If babyCryLevel is BABY_HAPPY...
		if (this.babyCryLevel == BABY_HAPPY) {
			// Draw the happy baby.
			graphics.draw(this.happyBaby, BABY_X, BABY_Y);
		} else {
			// Else, draw the crying baby.
			graphics.draw(this.cryingBaby, BABY_X, BABY_Y);
		}
	}
}
