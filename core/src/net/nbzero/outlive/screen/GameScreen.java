package net.nbzero.outlive.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.player.characters.Character;
import net.nbzero.outlive.player.characters.Luffy;
import net.nbzero.outlive.positon.PositionHandler;

public class GameScreen implements Screen {
	private static SpriteBatch batch;
	private static float elapsedTime;
	private static PlayerData p1;
	private Luffy luffy;
	
	@Override
	public void show() { }

	@Override
	public void render(float delta) {
		batch = new SpriteBatch();
		elapsedTime += Gdx.graphics.getDeltaTime();
		System.out.println(elapsedTime);
		p1 = new PlayerData(100, 100, 0, new PositionHandler(), "Right");
		luffy = new Luffy(p1);
		
		Gdx.gl.glClearColor(1, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			
		}else{
			batch.draw(luffy.drawStanding().getKeyFrame(elapsedTime, true), 0, 0, 300, 300);
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
