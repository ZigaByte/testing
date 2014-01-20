package com.zigabyte.simplelearninggame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zigabyte.simplelearninggame.gfx.Images;
import com.zigabyte.simplelearninggame.level.Level;

public class MainGame implements ApplicationListener {

	// ******** Rendering variables ******** //
	private OrthographicCamera camera;
	private SpriteBatch batch;

	// ******** Game variables ******** //
	private Level level;

	@Override
	public void create() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		batch = new SpriteBatch();

		// Loading graphics
		Images.loadImages();

		// Initializing the level class that runs the game
		level = new Level();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void render() {
		level.update();

		Gdx.gl.glClearColor(0, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		level.render(batch);

		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}