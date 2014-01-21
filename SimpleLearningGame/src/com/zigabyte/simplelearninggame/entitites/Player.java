package com.zigabyte.simplelearninggame.entitites;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.zigabyte.simplelearninggame.gfx.Images;
import com.zigabyte.simplelearninggame.input.Input;

public class Player extends Entity {

	private float speed = 5f;

	private boolean flip = false;

	public Player(float x, float y) {
		super(x, y);
		size = new Vector2(32, 32);
		texture = Images.player;
	}

	public void update() {
		// Get the move of the player this update
		Vector2 move = new Vector2();
		if (Input.down) move.add(0, -1);
		if (Input.up) move.add(0, +1);
		if (Input.left) move.add(-1, 0);
		if (Input.right) move.add(1, 0);

		move = move.nor().mul(speed);
		pos = pos.add(move);

		// Get the player's flip from dotproduct of move and a left vector
		Vector2 left = new Vector2(1, 0);
		float result = left.dot(move);
		if (result < 0) flip = true;
		else flip = false;

	}

	public void render(SpriteBatch batch) {
		if (flip) texture.flip(true, false); // if the player is looking in left, flip

		super.render(batch);

		if (flip) texture.flip(true, false); // flip back

	}

}
