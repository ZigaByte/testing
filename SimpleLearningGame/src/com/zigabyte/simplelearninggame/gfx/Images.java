package com.zigabyte.simplelearninggame.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Images {

	public static final int SIZE = 8;
	private static int w;
	private static int h;

	public static Texture spritesheet;
	private static TextureRegion[] textures;

	// ******** Textures ******** //
	public static TextureRegion testTexture;
	public static TextureRegion grass;
	public static TextureRegion lava;
	public static TextureRegion stone;
	public static TextureRegion player;
	public static TextureRegion skeleton;
	public static TextureRegion wizzard;

	public static void loadImages() {
		spritesheet = new Texture(Gdx.files.internal("data/spritesheet.png"));

		w = spritesheet.getWidth() / SIZE;
		h = spritesheet.getHeight() / SIZE;

		textures = new TextureRegion[w * h];

		for (int i = 0; i < textures.length; i++) {
			textures[i] = new TextureRegion(spritesheet, i % w * SIZE, i / h * SIZE, SIZE, SIZE);
		}

		testTexture = textures[0];
		grass = textures[w + 15];
		lava = textures[3 * w + 11];
		stone = textures[10];
		player = textures[8 * w];
		skeleton = textures[8 * w + 1];
		wizzard = textures[8 * w + 2];

	}
}
