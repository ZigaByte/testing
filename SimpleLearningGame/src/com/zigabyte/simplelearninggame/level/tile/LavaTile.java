package com.zigabyte.simplelearninggame.level.tile;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.zigabyte.simplelearninggame.gfx.Images;
import com.zigabyte.simplelearninggame.level.Level;

public class LavaTile extends Tile {
	public static final int ID = 02;

	protected TextureRegion texture = Images.lava;

	public void render(SpriteBatch batch, int x, int y) {
		batch.draw(texture, x, y, Level.TILE_SIZE, Level.TILE_SIZE);
	}
}
