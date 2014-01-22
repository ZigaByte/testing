package com.zigabyte.simplelearninggame.entitites;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.zigabyte.simplelearninggame.gfx.Render;
import com.zigabyte.simplelearninggame.level.Level;
import com.zigabyte.simplelearninggame.phy.Vector2f;

public class Entity {
	protected Vector2f pos;
	protected Vector2f size;

	protected TextureRegion texture;

	protected boolean removed = false;

	public static Level level;

	static {
		level = Level.level;
	}

	public Entity(Vector2f pos) {
		this.pos = pos;
		size = new Vector2f(16, 16);
	}

	public void remove() {
		removed = true;
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

	public boolean canmove(Vector2f move) {
		List<Entity> e = Level.level.getEntities();

		for (int i = 0; i < e.size(); i++) {
			if (!e.get(i).blocks(this)) continue;
			if (e.get(i) == this) continue;

			Entity e1 = e.get(i);
			boolean collides = (pos.x + move.x < e1.pos.x + e1.size.x && pos.x + size.x + move.x > e1.pos.x && pos.y + move.y < e1.pos.y + e1.size.y / 2 && pos.y + size.y / 2 + move.y > e1.pos.y);
			if (collides) return false;
		}

		return true;
	}

	public Vector2f getPos() {
		return pos;
	}

	public void setPos(Vector2f pos) {
		this.pos = pos;
	}

	public Vector2f getSize() {
		return size;
	}

	public void setSize(Vector2f size) {
		this.size = size;
	}

	public boolean isInteractable() {
		return false;
	}

	public boolean isRemoved() {
		return removed;
	}

	public boolean isAtVector(Vector2f pointAt) {
		return (pointAt.x > pos.x && pointAt.x < pos.x + size.x && pointAt.y > pos.y && pointAt.y < pos.y + size.y);
	}
}
