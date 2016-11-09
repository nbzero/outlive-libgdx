package net.nbzero.outlive.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.nbzero.outlive.player.PlayerData;

public class GameScreen implements Screen {
	private static SpriteBatch batch;
	private static float elapsedTime;
	private static PlayerData p1;
	
	@Override
	public void show() { }

	@Override
	public void render(float delta) {
		elapsedTime += Gdx.graphics.getDeltaTime();
		System.out.println(elapsedTime);
		
		Gdx.gl.glClearColor(1, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			p1.getPos().setX(p1.getPos().getX()-4);
			System.out.println("x-4!");
		}
		
		
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

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

}
