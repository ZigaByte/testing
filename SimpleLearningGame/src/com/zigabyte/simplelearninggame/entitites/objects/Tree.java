package com.zigabyte.simplelearninggame.entitites.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.zigabyte.simplelearninggame.entitites.Entity;
import com.zigabyte.simplelearninggame.entitites.particle.Particle;
import com.zigabyte.simplelearninggame.gfx.Images;
import com.zigabyte.simplelearninggame.gfx.Render;

public class Tree extends Entity {

	protected TextureRegion top = Images.treeTop;
	protected TextureRegion bottom = Images.treeBottom;

	public Tree(float x, float y) {
		super(x, y);
		size = new Vector2(32, 32);
	}

	public void render(SpriteBatch batch) {
		Render.render(batch, bottom, pos.x - size.x / 2, pos.y, size.x * 2, size.y * 2);
		Render.render(batch, top, pos.x - size.x / 2, pos.y + size.y * 2, size.x * 2, size.y * 2);
	}

	public boolean blocks(Entity entity) {
		if (entity instanceof Particle) return false;
		return true;
	}
}
