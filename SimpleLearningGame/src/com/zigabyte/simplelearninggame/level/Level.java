package com.zigabyte.simplelearninggame.level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zigabyte.simplelearninggame.MainGame;
import com.zigabyte.simplelearninggame.entitites.Entity;
import com.zigabyte.simplelearninggame.entitites.mobs.Player;
import com.zigabyte.simplelearninggame.entitites.objects.Tree;
import com.zigabyte.simplelearninggame.entitites.particle.SmashParticle;
import com.zigabyte.simplelearninggame.gfx.Render;
import com.zigabyte.simplelearninggame.input.Input;
import com.zigabyte.simplelearninggame.level.tile.GrassTile;
import com.zigabyte.simplelearninggame.level.tile.LavaTile;
import com.zigabyte.simplelearninggame.level.tile.Tile;
import com.zigabyte.simplelearninggame.level.tile.WaterTile;
import com.zigabyte.simplelearninggame.phy.Vector2f;

public class Level {

	public static final int TILE_SIZE = 32;
	private final Random random = new Random();
	public static Level level;

	private List<Entity> entities = new ArrayList<Entity>();
	private Player player;

	private int w, h;// Size of the level in tiles
	private int[] tiles;

	private Comparator<Entity> entitySorter = new Comparator<Entity>() {
		@Override
		public int compare(Entity e0, Entity e1) {
			if (e0.getPos().y < e1.getPos().y) return 1;
			if (e0.getPos().y > e1.getPos().y) return -1;
			return 0;
		}
	};

	public Level() {
		level = this;
		w = h = 64;
		tiles = new int[w * h];
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = random.nextInt(3) + 1;
		}

		player = new Player(new Vector2f(0, 0));
		add(player);

		for (int i = 0; i < 150; i++) {
			Tree tree = new Tree(new Vector2f(0 + random.nextInt(40) * 32, 0 + random.nextInt(40) * 32));
			if (tree.canmove(new Vector2f())) add(tree);
		}
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public void remove(Entity e) {
		entities.remove(e);
	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.update();
			if (e.isRemoved()) remove(e);
		}

		// level.add(new SmashParticle(new Vector2f(Input.xW, Input.yW), new Vector2f(), 10));
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

		Render.setOffset(player.getPos().x - MainGame.w / 2, player.getPos().y - MainGame.h / 2);

		Collections.sort(entities, entitySorter);
	}

	public Tile getTile(int x, int y) {
		if (tiles[x + y * w] == Tile.ID) return Tile.voidTile;
		if (tiles[x + y * w] == GrassTile.ID) return Tile.grass;
		if (tiles[x + y * w] == LavaTile.ID) return Tile.lava;
		if (tiles[x + y * w] == WaterTile.ID) return Tile.water;

		System.err.print("Tile Not Found, rendering voidTile");
		return Tile.voidTile;
	}

	public List<Entity> getEntities() {
		return entities;
	}
}
