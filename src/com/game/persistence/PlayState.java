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
	 * The duration of the game in frames, or cycles of the game loop, and 
	 * the initial value of timeRemaining. Assume 60 frames per second when
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
	private static final int FRAME_LENGTH = 1;

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
	private static final int CRY_CHANGE_WEAK = 1;

	/**
	 * How much babyCryLevel increases on "strong shake".
	 */
	private static final int CRY_CHANGE_STRONG = 2;

	/**
	 * The baby is happy when babyCryLevel is less than or equal to 
	 * this value.
	 */
	private static final int BABY_HAPPY = 5;
	
	/**
	 * The minimum possible value of babyCryLevel.
	 */
	private static final int BABY_MIN = 0;
	
	/**
	 * The maximum possible value of babyCryLevel.
	 */
	private static final int BABY_MAX = 20;

	/**
	 * How many points score increases each frame that the baby is happy.
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
	 * The baby's mood. The baby is happy when this is less than or equal to 
	 * BABY_HAPPY, and crying when this is greater than BABY_HAPPY.
	 */
	private int babyCryLevel;

	/**
	 * The player's score. Score increases when the baby is happy.
	 */
	private int score;

	/**
	 * How much time remains in the game, in frames.
	 */
	private int timeRemaining;

	/**
	 * The background image.
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
	 * Specifies whether the game should be running.
	 */
	private boolean running;

	private GameView view;
	
	/**
	 * Creates a new PlayState with the predesignated values.
	 */
	public PlayState(GameView view) {
		this.view = view;
		this.babyCryLevel = INITIAL_CRY_LEVEL;
		this.score = INITIAL_SCORE;
		this.timeRemaining = GAME_LENGTH;
		this.background = Drawable.createFromPath(BACKGROUND_IMAGE);
		this.cryingBaby = Drawable.createFromPath(CRY_BABY_IMAGE);
		this.happyBaby = Drawable.createFromPath(HAPPY_BABY_IMAGE);
	}

	@Override
	public void run(){
		while(this.running){
			this.update();
			this.render();
		}
	}
	
	/**
	 * Update game logic. After checking for input from the 
	 * accelerometer and verifying that there is time remaining in 
	 * the game, the baby's mood adjusts according to the input, then 
	 * if the baby is happy the player's score increases. If there is 
	 * no time remaining, then the game ends.
	 * 
	 * @param container
	 *            the game container.
	 */
	@Override
	public void update() {
	}

	/**
	 * Render the updated game environment to the screen. Images 
	 * are rendered in order from back to front.
	 * 
	 * @param container
	 *            the game container.
	 */
	@Override
	public void render() {
	}
}
