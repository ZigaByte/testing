package com.zigabyte.simplelearninggame.entitites.mobs;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zigabyte.simplelearninggame.entitites.Entity;
import com.zigabyte.simplelearninggame.entitites.particle.Particle;
import com.zigabyte.simplelearninggame.gfx.Images;
import com.zigabyte.simplelearninggame.input.Input;
import com.zigabyte.simplelearninggame.phy.Vector2f;

public class Player extends Entity {

	private int attackSpeed = 1;

	private float speed = 5f;
	private int attackTimer;

	private boolean flip = false;

	public Player(Vector2f pos) {
		super(pos);
		size = new Vector2f(32, 32);
		texture = Images.player;
		System.out.println(pos.x + "  " + pos.y);
	}

	public void update() {
		move();

		attack();
	}

	private void attack() {
		attackTimer--;
		if (attackTimer > 0) return;
		if (Input.button != 0) return;

		Vector2f pointAt = new Vector2f(Input.xW, Input.yW);
		List<Entity> entities = level.getEntities();
		Entity e = null;
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isInteractable()) {
				if (entities.get(i).isAtVector(pointAt)) e = entities.get(i);
			}
		}

		if (e != null) e.interact(this);

		attackTimer = attackSpeed;
	}

	private void move() {
		// Get the move of the player this update
		Vector2f move = new Vector2f(0, 0);
		if (Input.down) move = move.add(0, -1);
		if (Input.up) move = move.add(0, +1);
		if (Input.left) move = move.add(-1, 0);
		if (Input.right) move = move.add(1, 0);

		if (move.lenght() == 0) return;

		move = move.normalize().mul(speed);

		// Get the player's flip from dotproduct of move and a left vector
		if (move.x != 0) {
			Vector2f left = new Vector2f(1, 0);
			float result = left.dot(move);
			if (result < 0) flip = true;
			else flip = false;
		}

		// Check collison and move if there is no obstacles
		Vector2f moveX = move.mul(1, 0);
		Vector2f moveY = move.mul(0, 1);
		if (canmove(moveY)) pos = pos.add(moveY);
		if (canmove(moveX)) pos = pos.add(moveX);

	}

	public void render(SpriteBatch batch) {
		if (flip) texture.flip(true, false); // if the player is looking in left, flip

		super.render(batch);

		if (flip) texture.flip(true, false); // flip back
		// System.out.println(pos.y + "   " + pos.y);
	}

	public boolean blocks(Entity entity) {
		if (entity instanceof Particle) return false;
		return true;
	}

}
