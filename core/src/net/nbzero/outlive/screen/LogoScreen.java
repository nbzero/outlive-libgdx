package net.nbzero.outlive.screen;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import net.nbzero.outlive.tween.SpriteAccessor;
import net.nbzero.outlive.utils.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LogoScreen implements Screen {
	private SpriteBatch batch;
	private Sprite splash;
	private TweenManager tweenManager;
	private float fadeTime = 2.0f;
	
	
	@Override
	public void show() {
//		Sound sfx;
//		sfx = Gdx.audio.newSound(Gdx.files.internal("sound/SFX/sword17.mp3"));
//		sfx.play(1.0f);
		batch = new SpriteBatch();
		tweenManager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		
		splash = new Sprite(new Texture(Utils.gameLogoPath));
		splash.setPosition(Gdx.graphics.getWidth()/2 - splash.getWidth()/2, Gdx.graphics.getHeight()/2 - splash.getHeight()/2);
		
		Timeline.createSequence().beginSequence()
			.push(Tween.set(splash, SpriteAccessor.ALPHA).target(0))
			.push(Tween.to(splash, SpriteAccessor.ALPHA, fadeTime).target(1))
			.push(Tween.to(splash, SpriteAccessor.ALPHA, fadeTime-1).target(0))
			.end().setCallback(new TweenCallback() {
				
				@Override
				public void onEvent(int type, BaseTween<?> source) {
					((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen());
				}
			}).start(tweenManager);
		
		// Update once to fix flash of splash
		tweenManager.update(Float.MIN_VALUE);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		splash.draw(batch);
		batch.end();
		
		tweenManager.update(delta);
	}

	@Override
	public void resize(int width, int height) { }

	@Override
	public void pause() { }

	@Override
	public void resume() { }

	@Override
	public void hide() { }

	@Override
	public void dispose() { 
		batch.dispose();
	}

}
