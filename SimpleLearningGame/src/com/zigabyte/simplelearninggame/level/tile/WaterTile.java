package com.zigabyte.simplelearninggame.level.tile;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.zigabyte.simplelearninggame.gfx.Images;
import com.zigabyte.simplelearninggame.gfx.Render;
import com.zigabyte.simplelearninggame.level.Level;

public class WaterTile extends Tile {
	public static final int ID = 3;

	protected static TextureRegion texture = Images.water;

	public void render(SpriteBatch batch, int x, int y) {
		Render.render(batch, texture, x, y, Level.TILE_SIZE, Level.TILE_SIZE);
	}
}
