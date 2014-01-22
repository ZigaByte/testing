package com.zigabyte.simplelearninggame.entitites.particle;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zigabyte.simplelearninggame.entitites.Entity;
import com.zigabyte.simplelearninggame.gfx.Render;
import com.zigabyte.simplelearninggame.phy.Vector2f;

public class Particle extends Entity {

	protected static final int Y_OFFSET = 50;

	protected Vector2f vel; // Velocity

	protected int lifetime;

	public Particle(Vector2f pos, Vector2f vel, int lifetime) {
		super(pos);
		this.pos = pos.add(0, -Y_OFFSET);
		this.vel = vel;
		this.lifetime = lifetime;
	}

	public void update() {
		if (lifetime == 0) remove();
		lifetime--;

		pos = pos.add(vel);
	}

	public void render(SpriteBatch batch) {
		Render.render(batch, texture, pos.x - size.x / 2, pos.y - size.y / 2 + Y_OFFSET, size.x, size.y);
	}

	public boolean isInteractable() {
		return false;
	}

}
