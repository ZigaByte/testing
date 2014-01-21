package com.zigabyte.simplelearninggame.entitites;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Entity {
	protected Vector2 pos;
	protected Vector2 size;

	protected TextureRegion texture;

	public Entity(float x, float y) {
		pos = new Vector2(x, y);
		size = new Vector2(16, 16);
	}

	public void update() {

	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, pos.x, pos.y, size.x, size.y);
	}

}
