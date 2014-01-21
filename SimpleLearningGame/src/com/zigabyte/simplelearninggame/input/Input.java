package com.zigabyte.simplelearninggame.input;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class Input implements InputProcessor {

	public static boolean up;
	public static boolean down;
	public static boolean left;
	public static boolean right;

	public static int x;
	public static int y;
	public static int button;

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.UP) up = true;
		if (keycode == Keys.DOWN) down = true;
		if (keycode == Keys.LEFT) left = true;
		if (keycode == Keys.RIGHT) right = true;
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.UP) up = false;
		if (keycode == Keys.DOWN) down = false;
		if (keycode == Keys.LEFT) left = false;
		if (keycode == Keys.RIGHT) right = false;
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int buttonPressed) {
		x = screenX;
		y = screenY;
		button = buttonPressed;
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int buttonPressed) {
		x = screenX;
		y = screenY;
		button = buttonPressed;
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		x = screenX;
		y = screenY;
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		x = screenX;
		y = screenY;
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
