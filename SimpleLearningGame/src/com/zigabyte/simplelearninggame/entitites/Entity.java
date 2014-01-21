package com.zigabyte.simplelearninggame.entitites;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.zigabyte.simplelearninggame.gfx.Render;
import com.zigabyte.simplelearninggame.level.Level;

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
		Render.render(batch, texture, pos.x, pos.y, size.x, size.y);
	}

	public void interact(Entity entity) {

	}

	public boolean blocks(Entity entity) {
		return false;
	}

	public boolean canmove(Vector2 move) {
		List<Entity> e = Level.level.getEntities();

		for (int i = 0; i < e.size(); i++) {
			if (!e.get(i).blocks(this)) continue;
			if (e.get(i) == this) continue;

			Entity e1 = e.get(i);
			boolean collides = (pos.x + move.x < e1.pos.x + e1.size.x && pos.x + size.x + move.x > e1.pos.x && pos.y + move.y < e1.pos.y + e1.size.y && pos.y + size.y + move.y > e1.pos.y);
			if (collides) return false;
		}

		return true;
	}

	public Vector2 getPos() {
		return pos;
	}

	public void setPos(Vector2 pos) {
		this.pos = pos;
	}

	public Vector2 getSize() {
		return size;
	}

	public void setSize(Vector2 size) {
		this.size = size;
	}
}
