package net.nbzero.outlive.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import net.nbzero.outlive.sound.BGM;
import net.nbzero.outlive.tween.ActorAccessor;
import net.nbzero.outlive.utils.Utils;
import net.nbzero.outlive.utils.screenutils.MainMenuUtils;

public class MainMenuScreen implements Screen {
	private Stage stage;
	public static TweenManager tweenManager;
	private Table table;
	public static Table configTable;
	private static int selected = 0;
	private static int menu = 0; 
	
	@Override
	public void show() {
//		Utils.configBGMLabel = new Label("BGM", Utils.skin, "KitchenPoliceConfig", Color.WHITE);
//		Utils.configBGMNumLabel = new Label((int)(BGM.MainMenu.getVolume()*100) + "%", Utils.skin, "KitchenPoliceConfig", Color.WHITE);
		configTable = new Table(Utils.skin);
		configTable.setPosition(Gdx.graphics.getWidth()*0.8f, Gdx.graphics.getHeight()*0.5f);
		configTable.setColor(1, 1, 1, 0);
		configTable.add(Utils.configBGMLabel);
		configTable.add(Utils.configBGMNumLabel).padLeft(50).row();
		
		BGM.MainMenu.play();
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
		stage.addActor(configTable);
		
		tweenManager = new TweenManager();
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		
		Timeline.createSequence().beginSequence()
		.push(Tween.set(Utils.mainMenuBG, ActorAccessor.ALPHA).target(0))
		.push(Tween.to(Utils.mainMenuBG, ActorAccessor.ALPHA, 0.5f).target(1))
		.end().start(tweenManager);
		MainMenuUtils.fadeInButton();
		
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
			MainMenuUtils.checkSelectButton(selected);
			if(Gdx.input.isKeyJustPressed(Keys.DOWN) && selected<4) {
				selected++;
			}
			if(Gdx.input.isKeyJustPressed(Keys.UP) && selected>0){
				selected--;
			}
			if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
				switch(selected){
				case 0:
					MainMenuUtils.fadeOutButton();
					Timeline.createParallel().beginParallel()
					.push(Tween.set(Utils.mainMenuBG, ActorAccessor.ALPHA).target(1))
					.push(Tween.to(Utils.mainMenuBG, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
					.end().setCallback(new TweenCallback() {
						
						@Override
						public void onEvent(int type, BaseTween<?> source) {
							dispose();
							((Game) Gdx.app.getApplicationListener()).setScreen(new CharacterSelectScreen());
						}
					}).start(tweenManager);
					break;
				case 1:
					stage.addActor(Utils.tutorialBG);
					Timeline.createSequence().beginSequence()
					.push(Tween.set(Utils.tutorialBG, ActorAccessor.ALPHA).target(0))
					.push(Tween.to(Utils.tutorialBG, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(1))
					.end().start(tweenManager);
					menu = 1;
					break;
				case 2:
					MainMenuUtils.fadeOutButton();
					MainMenuUtils.fadeInConfig();
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
				Timeline.createSequence().beginSequence()
				.push(Tween.set(Utils.tutorialBG, ActorAccessor.ALPHA).target(1))
				.push(Tween.to(Utils.tutorialBG, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
				.end().start(tweenManager);
				selected = 1;
				menu = 0;
			}
		}
		else if(menu == 2){
			if(Gdx.input.isKeyJustPressed(Keys.LEFT) && BGM.MainMenu.getVolume()>=0.049f){
				BGM.MainMenu.setVolume(BGM.MainMenu.getVolume()-0.05f);
				Utils.configBGMNumLabel.setText((int)(BGM.MainMenu.getVolume()*100) + "%");
			}
			if(Gdx.input.isKeyJustPressed(Keys.RIGHT) && BGM.MainMenu.getVolume()<=0.951f){
				BGM.MainMenu.setVolume(BGM.MainMenu.getVolume()+0.05f);
				Utils.configBGMNumLabel.setText((int)(BGM.MainMenu.getVolume()*100) + "%");
			}
			if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
				selected = 2;
				menu = 0;
				MainMenuUtils.fadeInButton();
				MainMenuUtils.fadeOutConfig();
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
		BGM.MainMenu.getBGM().dispose();
	}
}
