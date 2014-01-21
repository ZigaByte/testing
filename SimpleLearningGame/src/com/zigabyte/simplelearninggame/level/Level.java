package com.zigabyte.simplelearninggame.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zigabyte.simplelearninggame.entitites.Entity;
import com.zigabyte.simplelearninggame.entitites.Player;
import com.zigabyte.simplelearninggame.level.tile.GrassTile;
import com.zigabyte.simplelearninggame.level.tile.LavaTile;
import com.zigabyte.simplelearninggame.level.tile.Tile;

public class Level {

	public static final int TILE_SIZE = 32;
	private final Random random = new Random();

	private List<Entity> entities = new ArrayList<Entity>();
	private Player player;

	private int w, h;// Size of the level in tiles
	private int[] tiles;

	public Level() {
		w = h = 32;
		tiles = new int[w * h];
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = random.nextInt(2) + 1;
		}

		player = new Player(50, 50);
		add(player);
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public void remove(Entity e) {
		entities.remove(e);
	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
	}

	public void render(SpriteBatch batch) {
		// Render tiles //
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				getTile(x, y).render(batch, x * TILE_SIZE, y * TILE_SIZE);
			}
		}

		// Render entities //
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(batch);
		}
	}

	public Tile getTile(int x, int y) {
		if (tiles[x + y * w] == Tile.ID) return Tile.voidTile;
		if (tiles[x + y * w] == GrassTile.ID) return Tile.grass;
		if (tiles[x + y * w] == LavaTile.ID) return Tile.lava;

		System.err.print("Tile Not Found, rendering voidTile");
		return Tile.lava;
	}
}
