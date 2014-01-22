package com.zigabyte.simplelearninggame.gfx;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Render {

	private static float xOffset = 0;
	private static float yOffset = 0;

	public static void render(SpriteBatch batch, TextureRegion texture, float x, float y, float w, float h) {
		batch.draw(texture, x - xOffset, y - yOffset, w, h);
	}

	public static void setOffset(float x, float y) {
		xOffset = x;
		yOffset = y;
	}

	public static float getXOffset() {
		return xOffset;
	}

	public static float getYOffset() {
		return yOffset;
	}
}
