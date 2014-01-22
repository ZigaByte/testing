package com.zigabyte.simplelearninggame.entitites.particle;

import com.zigabyte.simplelearninggame.gfx.Images;
import com.zigabyte.simplelearninggame.phy.Vector2f;

public class SmashParticle extends Particle {

	public SmashParticle(Vector2f pos, Vector2f vel, int lifetime) {
		super(pos, vel, lifetime);
		texture = Images.smash;
		size = new Vector2f(32, 32);
	}

	public void setSize(Vector2f size) {
		this.size = size;
	}

}
