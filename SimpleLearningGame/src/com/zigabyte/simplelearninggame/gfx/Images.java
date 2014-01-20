package com.zigabyte.simplelearninggame.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Images {

	public static final int SIZE = 8;

	public static Texture spritesheet;
	private static TextureRegion[] textures;

	public static TextureRegion testTexture;

	public static void loadImages() {
		spritesheet = new Texture(Gdx.files.internal("data/spritesheet.png"));

		textures = new TextureRegion[spritesheet.getWidth() * spritesheet.getHeight() / SIZE / SIZE];

		for (int i = 0; i < textures.length; i++) {
			textures[i] = new TextureRegion(spritesheet, i % SIZE, i / SIZE, SIZE, SIZE);
		}

		testTexture = textures[0];

	}
}
