package net.nbzero.outlive.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import net.nbzero.outlive.tween.ActorAccessor;
import net.nbzero.outlive.utils.Utils;

public class MainMenuScreen implements Screen {
	private Stage stage;
	private TweenManager tweenManager;
	private Table table;
	private static int selected = 0;
	private static int menu = 0; 
	
	@Override
	public void show() {
		stage = new Stage();
		
		table = new Table(Utils.skin);
		table.setFillParent(true);
		
		table.setPosition(Gdx.graphics.getWidth()/3, -100);
		table.add(Utils.startButton).width(Utils.buttonWidth).height(Utils.buttonHeight).padBottom(Utils.padButton).row();
		table.add(Utils.tutorialButton).width(Utils.buttonWidth).height(Utils.buttonHeight).padBottom(Utils.padButton).row();
		table.add(Utils.configButton).width(Utils.buttonWidth).height(Utils.buttonHeight).padBottom(Utils.padButton).row();
		table.add(Utils.creditsButton).width(Utils.buttonWidth).height(Utils.buttonHeight).padBottom(Utils.padButton).row();
		table.add(Utils.exitButton).width(Utils.buttonWidth).height(Utils.buttonHeight).padBottom(Utils.padButton).row();
		
		stage.addActor(Utils.mainMenuBG);
		stage.addActor(table);
		
		tweenManager = new TweenManager();
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		
		Timeline.createSequence().beginSequence()
		.push(Tween.set(Utils.mainMenuBG, ActorAccessor.ALPHA).target(0))
		.push(Tween.to(Utils.mainMenuBG, ActorAccessor.ALPHA, 0.5f).target(1))
		.end().start(tweenManager);
		fadeInButton();
		
		Tween.from(table, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0).start(tweenManager);
		Tween.from(table, ActorAccessor.Y, Utils.GLIDE_TIME).target(Gdx.graphics.getHeight()/8).start(tweenManager);
		
		tweenManager.update(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		stage.draw();
		
		// Main Menu Controller
		if(menu == 0){
			checkSelectButton(selected);
			if(Gdx.input.isKeyJustPressed(Keys.DOWN) && selected<4) {
				selected++;
				checkSelectButton(selected);
			}
			if(Gdx.input.isKeyJustPressed(Keys.UP) && selected>0){
				selected--;
				checkSelectButton(selected);
			}
			if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
				switch(selected){
				case 0:
					fadeOutButton();
					Timeline.createParallel().beginParallel()
					.push(Tween.set(Utils.mainMenuBG, ActorAccessor.ALPHA).target(1))
					.push(Tween.to(Utils.mainMenuBG, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
					.end().setCallback(new TweenCallback() {
						
						@Override
						public void onEvent(int type, BaseTween<?> source) {
							((Game) Gdx.app.getApplicationListener()).setScreen(new CharacterSelectScreen());
						}
					}).start(tweenManager);
					break;
				case 1:
					fadeOutButton();
					menu = 1;
					break;
				case 2:
					fadeOutButton();
					menu = 2;
					break;
				case 3:
					stage.addActor(Utils.creditsImage);
					Timeline.createSequence().beginSequence()
					.push(Tween.set(Utils.creditsImage, ActorAccessor.ALPHA).target(0))
					.push(Tween.to(Utils.creditsImage, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(1))
					.end().start(tweenManager);
					menu = 3;
					break;
				case 4:
					Utils.exitGame();
					Gdx.app.exit();
					break;
				}
			}
		}
		else if(menu == 1){
			if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
				selected = 1;
				menu = 0;
				fadeInButton();
			}
		}
		else if(menu == 2){
			if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
				selected = 2;
				menu = 0;
				fadeInButton();
			}
		}
		else if(menu == 3){
			if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
				Timeline.createSequence().beginSequence()
				.push(Tween.set(Utils.creditsImage, ActorAccessor.ALPHA).target(1))
				.push(Tween.to(Utils.creditsImage, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
				.end().start(tweenManager);
				selected = 3;
				menu = 0;
			}
		}

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
		stage.dispose();
		Utils.skin.dispose();
	}

	// Select Button Checker
	private void checkSelectButton(int selected){
		switch(selected){
		case 0:
			Utils.startButton.setChecked(true);
			Utils.tutorialButton.setChecked(false);
			break;
		case 1:
			Utils.startButton.setChecked(false);
			Utils.tutorialButton.setChecked(true);
			Utils.configButton.setChecked(false);
			break;
		case 2:
			Utils.tutorialButton.setChecked(false);
			Utils.configButton.setChecked(true);
			Utils.creditsButton.setChecked(false);
			break;
		case 3:
			Utils.configButton.setChecked(false);
			Utils.creditsButton.setChecked(true);
			Utils.exitButton.setChecked(false);
			break;
		case 4:
			Utils.creditsButton.setChecked(false);
			Utils.exitButton.setChecked(true);
			break;
		}
	}
	
	private void fadeOutButton(){
		Timeline.createParallel().beginParallel()
		.push(Tween.set(Utils.startButton, ActorAccessor.ALPHA).target(1))
		.push(Tween.set(Utils.tutorialButton, ActorAccessor.ALPHA).target(1))
		.push(Tween.set(Utils.configButton, ActorAccessor.ALPHA).target(1))
		.push(Tween.set(Utils.creditsButton, ActorAccessor.ALPHA).target(1))
		.push(Tween.set(Utils.exitButton, ActorAccessor.ALPHA).target(1))
		.push(Tween.to(Utils.startButton, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
		.push(Tween.to(Utils.tutorialButton, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
		.push(Tween.to(Utils.configButton, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
		.push(Tween.to(Utils.creditsButton, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
		.push(Tween.to(Utils.exitButton, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
		.end().start(tweenManager);
	}
	
	private void fadeInButton(){
		Timeline.createSequence().beginSequence()
		.push(Tween.set(Utils.startButton, ActorAccessor.ALPHA).target(0))
		.push(Tween.set(Utils.tutorialButton, ActorAccessor.ALPHA).target(0))
		.push(Tween.set(Utils.configButton, ActorAccessor.ALPHA).target(0))
		.push(Tween.set(Utils.creditsButton, ActorAccessor.ALPHA).target(0))
		.push(Tween.set(Utils.exitButton, ActorAccessor.ALPHA).target(0))
		.push(Tween.to(Utils.startButton, ActorAccessor.ALPHA, Utils.FADE_TIME).target(1))
		.push(Tween.to(Utils.tutorialButton, ActorAccessor.ALPHA, Utils.FADE_TIME).target(1))
		.push(Tween.to(Utils.configButton, ActorAccessor.ALPHA, Utils.FADE_TIME).target(1))
		.push(Tween.to(Utils.creditsButton, ActorAccessor.ALPHA, Utils.FADE_TIME).target(1))
		.push(Tween.to(Utils.exitButton, ActorAccessor.ALPHA, Utils.FADE_TIME).target(1))
		.end().start(tweenManager);
	}
}
