package com.zigabyte.simplelearninggame.entitites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Entity {
	private Vector2 pos;
	private Vector2 size;

	private Texture texture;

	public Entity(float x, float y) {
		pos = new Vector2(x, y);
		size = new Vector2();
	}

	public void update() {

	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, pos.x, pos.y, size.x, size.y);
	}

}
