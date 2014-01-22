package com.zigabyte.simplelearninggame.entitites.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.zigabyte.simplelearninggame.entitites.Entity;
import com.zigabyte.simplelearninggame.entitites.mobs.Player;
import com.zigabyte.simplelearninggame.entitites.particle.Particle;
import com.zigabyte.simplelearninggame.entitites.particle.SmashParticle;
import com.zigabyte.simplelearninggame.gfx.Images;
import com.zigabyte.simplelearninggame.gfx.Render;
import com.zigabyte.simplelearninggame.phy.Vector2f;

public class Tree extends Entity {

	protected TextureRegion top = Images.treeTop;
	protected TextureRegion bottom = Images.treeBottom;

	public Tree(Vector2f pos) {
		super(pos);
		size = new Vector2f(32, 64);
	}

	public void render(SpriteBatch batch) {
		Render.render(batch, bottom, pos.x - size.x / 2, pos.y, size.x * 2, size.y);
		Render.render(batch, top, pos.x - size.x / 2, pos.y + size.y, size.x * 2, size.y);
	}

	public void interact(Entity entity) {
		level.add(new SmashParticle(pos.add(size.div(2)), new Vector2f(), 10));
		if (entity instanceof Player) remove();
	}

	public boolean blocks(Entity entity) {
		if (entity instanceof Particle) return false;
		return true;
	}

	public boolean isInteractable() {
		return true;
	}

}
