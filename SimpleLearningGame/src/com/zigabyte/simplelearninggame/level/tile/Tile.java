package com.zigabyte.simplelearninggame.level.tile;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.zigabyte.simplelearninggame.gfx.Images;
import com.zigabyte.simplelearninggame.gfx.Render;
import com.zigabyte.simplelearninggame.level.Level;

public class Tile {
	public static final int ID = 0;

	public static Tile voidTile = new Tile();
	public static Tile grass = new GrassTile();
	public static Tile lava = new LavaTile();
	public static Tile water = new WaterTile();

	protected TextureRegion texture = Images.testTexture;

	public void render(SpriteBatch batch, int x, int y) {
		Render.render(batch, texture, x, y, Level.TILE_SIZE, Level.TILE_SIZE);
	}

}
