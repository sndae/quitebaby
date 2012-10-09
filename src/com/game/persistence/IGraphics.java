package com.game.persistence;

import android.graphics.drawable.Drawable;

/**
 * An IGraphics holds and manages the mechanisms for rendering objects to the
 * screen.
 * 
 * @author Dennis Jr TO DO: This interface may be more appropriate in either the
 *         integration or ui packages. TO DO: Determine exact data type to be
 *         used for images; android.graphics.drawable.Drawable is being used in
 *         the meantime because it has a method createFromPath(String path) that
 *         looks like it can create images from files.
 */
public interface IGraphics {
	/**
	 * Draw an image on the screen at the desired position. This method assumes
	 * that the image will be drawn starting at the top left corner and going
	 * down and to the right.
	 * 
	 * @param image
	 *            the image to be drawn
	 * @param x
	 *            the desired x axis position of the image's top left corner
	 * @param y
	 *            the desired y axis position of the image's top left corner
	 */
	public void draw(Drawable image, float x, float y);
}
