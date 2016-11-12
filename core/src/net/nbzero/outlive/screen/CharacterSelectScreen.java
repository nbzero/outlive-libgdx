package net.nbzero.outlive.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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
import net.nbzero.outlive.InputsControl;
import net.nbzero.outlive.Outlive;
import net.nbzero.outlive.tween.ActorAccessor;
import net.nbzero.outlive.utils.Utils;
import net.nbzero.outlive.utils.screenutils.CharacterScreenUtils;

public class CharacterSelectScreen implements Screen {

	private Stage stage;
	private TweenManager tweenManager;
	private Table table;
	private Table table2;
	private int p1Selected = 0;
	private int p2Selected = 0;
	private boolean p1Lock = false;
	private boolean p2Lock = false;
	protected static String p1Char = null;
	protected static String p2Char = null;
	private float delayTime;
	private Label titleText1;
	private Label titleText2;
	private Label vsText1;
	private Label vsText2;
	private Label p1CharText;
	private Label p1Locked;
	private Label p2CharText;
	private Label p2Locked;
	private Label readyText;
	private Label countDownText;
	private float elapsedTime = 0;
	private float fadeOutTime = 0;
	private float fadeInTime = 0;
	
	@Override
	public void show() {
		Outlive.bgm.stop();
		Outlive.bgm = Gdx.audio.newMusic(Gdx.files.internal("sound/BGM/Character select.wav"));
		Outlive.bgm.play();
		Outlive.bgm.setLooping(true);
		Outlive.bgm.setVolume(0.5f);
		Utils.loadCharSelect();
		Utils.loadKitchenFont();
		
		stage = new Stage();
		
		table = new Table(Utils.charSelectSkin);
		table.setPosition(Gdx.graphics.getWidth()*0.5f, Gdx.graphics.getHeight()*0.37f);
		table.setZIndex(3);
		table.add(Utils.lawButton).width(Utils.charButtonWidth).height(Utils.charButtonHeight);
		table.add(Utils.zoroButton).width(Utils.charButtonWidth).height(Utils.charButtonHeight);
		table.add().width(Utils.charButtonWidth).height(Utils.charButtonHeight);
		table.add(Utils.saboButton).width(Utils.charButtonWidth).height(Utils.charButtonHeight);
		table.add(Utils.namiButton).width(Utils.charButtonWidth).height(Utils.charButtonHeight);
		
		table2 = new Table(Utils.charSelectSkin);
		table2.setPosition(Gdx.graphics.getWidth()*0.5f, Gdx.graphics.getHeight()*0.15f);
		table2.setZIndex(3);
		table2.add(Utils.sanjiButton).width(Utils.charButtonWidth).height(Utils.charButtonHeight);
		table2.add(Utils.luffyButton).width(Utils.charButtonWidth).height(Utils.charButtonHeight);
		table2.add(Utils.chopperButton).width(Utils.charButtonWidth).height(Utils.charButtonHeight);
		table2.add(Utils.usoppButton).width(Utils.charButtonWidth).height(Utils.charButtonHeight);
		
		titleText1 = new Label("Character", Utils.charSelectSkin, "KitchenPoliceTitle", Color.WHITE);
		titleText2 = new Label("Selection", Utils.charSelectSkin, "KitchenPoliceTitle", Color.WHITE);
		vsText1 = new Label("V", Utils.charSelectSkin, "KitchenPoliceVs", Color.SCARLET);
		vsText2 = new Label("S", Utils.charSelectSkin, "KitchenPoliceVs", Color.SCARLET);
		p1CharText = new Label(CharacterScreenUtils.getCharName(p1Selected), Utils.charSelectSkin, "KitchenPoliceP1CharFont", Color.SKY);
		p1Locked = new Label("Locked", Utils.charSelectSkin, "KitchenPoliceTiny", Color.WHITE);
		p2CharText = new Label(CharacterScreenUtils.getCharName(p2Selected), Utils.charSelectSkin, "KitchenPoliceP2CharFont", Color.SALMON);
		p2Locked = new Label("Locked", Utils.charSelectSkin, "KitchenPoliceTiny", Color.WHITE);
		readyText = new Label("Are you ready?", Utils.charSelectSkin, "KitchenPoliceTitle", Color.WHITE);
		countDownText = new Label("5", Utils.charSelectSkin, "KitchenPoliceCountDown", Color.WHITE);
		
		titleText1.setPosition(Gdx.graphics.getWidth()*0.38f, Gdx.graphics.getHeight()*0.92f);
		titleText2.setPosition(Gdx.graphics.getWidth()*0.43f, Gdx.graphics.getHeight()*0.85f);
		vsText1.setPosition(Gdx.graphics.getWidth()*0.45f, Gdx.graphics.getHeight()*0.50f);
		vsText2.setPosition(Gdx.graphics.getWidth()*0.49f, Gdx.graphics.getHeight()*0.455f);
		p1CharText.setPosition(Gdx.graphics.getWidth()*0.12f, Gdx.graphics.getHeight()*0.52f);
		p1Locked.setPosition(Gdx.graphics.getWidth()*0.12f, Gdx.graphics.getHeight()*0.59f);
		p1Locked.setColor(1, 1, 1, 0);
		p2CharText.setPosition(Gdx.graphics.getWidth()*0.78f, Gdx.graphics.getHeight()*0.52f);
		p2Locked.setPosition(Gdx.graphics.getWidth()*0.78f, Gdx.graphics.getHeight()*0.59f);
		p2Locked.setColor(1, 1, 1, 0);
		readyText.setPosition(Gdx.graphics.getWidth()*0.3f, Gdx.graphics.getHeight()*0.59f);
		readyText.setColor(1, 1, 1, 0);
		countDownText.setPosition(Gdx.graphics.getWidth()*0.45f, Gdx.graphics.getHeight()*0.35f);
		countDownText.setColor(1, 1, 1, 0);
		
		stage.addActor(Utils.characterSelectBG);
		stage.addActor(Utils.characterSelectCharBG);
		Utils.characterSelectBG.setZIndex(0);
		Utils.characterSelectCharBG.setZIndex(2);
		stage.addActor(table);
		stage.addActor(table2);
		
		// Prepare BG Character
		stage.addActor(Utils.chopperBGP1);
		stage.addActor(Utils.lawBGP1);
		stage.addActor(Utils.luffyBGP1);
		stage.addActor(Utils.namiBGP1);
		stage.addActor(Utils.saboBGP1);
		stage.addActor(Utils.sanjiBGP1);
		stage.addActor(Utils.zoroBGP1);
		stage.addActor(Utils.usoppBGP1);
		stage.addActor(Utils.chopperBGP2);
		stage.addActor(Utils.lawBGP2);
		stage.addActor(Utils.luffyBGP2);
		stage.addActor(Utils.namiBGP2);
		stage.addActor(Utils.saboBGP2);
		stage.addActor(Utils.sanjiBGP2);
		stage.addActor(Utils.zoroBGP2);
		stage.addActor(Utils.usoppBGP2);
		
		// Texts
		stage.addActor(titleText1);
		stage.addActor(titleText2);
		stage.addActor(vsText1);
		stage.addActor(vsText2);
		stage.addActor(p1CharText);
		stage.addActor(p1Locked);
		stage.addActor(p2CharText);
		stage.addActor(p2Locked);
		stage.addActor(readyText);
		stage.addActor(countDownText);
		stage.addActor(Utils.characterSelectReadyBG);
		
		readyText.setZIndex(4);
		countDownText.setZIndex(4);
		Utils.characterSelectReadyBG.setZIndex(3);
		Utils.characterSelectReadyBG.setPosition(Gdx.graphics.getWidth()*0.115f, Gdx.graphics.getHeight()*0.26f);
		Utils.characterSelectReadyBG.setColor(1, 1, 1, 0);
		vsText1.setZIndex(2);
		vsText2.setZIndex(2);
		
		Utils.lawBGP1.setZIndex(1);
		Utils.zoroBGP1.setZIndex(1);
		Utils.saboBGP1.setZIndex(1);
		Utils.namiBGP1.setZIndex(1);
		Utils.sanjiBGP1.setZIndex(1);
		Utils.luffyBGP1.setZIndex(1);
		Utils.chopperBGP1.setZIndex(1);
		Utils.usoppBGP1.setZIndex(1);
		Utils.lawBGP2.setZIndex(1);
		Utils.zoroBGP2.setZIndex(1);
		Utils.saboBGP2.setZIndex(1);
		Utils.namiBGP2.setZIndex(1);
		Utils.sanjiBGP2.setZIndex(1);
		Utils.luffyBGP2.setZIndex(1);
		Utils.chopperBGP2.setZIndex(1);
		Utils.usoppBGP2.setZIndex(1);
		
		tweenManager = new TweenManager();
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		
		tweenManager.update(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void render(float delta) {
		elapsedTime += Gdx.graphics.getDeltaTime();
		if(fadeInTime < 1f)
			fadeInTime += Gdx.graphics.getDeltaTime();
		if(fadeInTime< 1f)
			fadeIn();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		stage.draw();

		if(!p1Lock){
			CharacterScreenUtils.checkSelectButton(p1Selected, p2Selected);
			CharacterScreenUtils.addP1CharBG(p1Selected);
			p1CharText.setText(CharacterScreenUtils.getCharName(p1Selected));
			if(Gdx.input.isKeyJustPressed(InputsControl.P1_LEFT) && p1Selected > 0){
				p1Selected--;
			}
			else if(Gdx.input.isKeyJustPressed(InputsControl.P1_RIGHT) && p1Selected < 7){
				p1Selected++;
			}
			else if(Gdx.input.isKeyJustPressed(InputsControl.P1_UP) && p1Selected > 3){
				p1Selected -= 4;
			}
			else if(Gdx.input.isKeyJustPressed(InputsControl.P1_UP) && p1Selected < 4){
				p1Selected = 0;
			}
			else if(Gdx.input.isKeyJustPressed(InputsControl.P1_DOWN) && p1Selected < 4){
				p1Selected += 4;
			}
			else if(Gdx.input.isKeyJustPressed(InputsControl.P1_DOWN) && p1Selected > 3){
				p1Selected = 7;
			}
			else if(Gdx.input.isKeyJustPressed(InputsControl.P1_ATTACK)){
				p1Locked.setColor(1, 1, 1, 1);
				p1Lock = true;
				p1Char = CharacterScreenUtils.getCharName(p1Selected);
			}
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P1_DEFENSE) && delayTime < 5f){
			p1Locked.setColor(1, 1, 1, 0);
			p1Lock = false;
			p1Char = null;
		}
		if(!p2Lock){
			CharacterScreenUtils.checkSelectButton(p2Selected, p1Selected);
			CharacterScreenUtils.addP2CharBG(p2Selected);
			p2CharText.setText(CharacterScreenUtils.getCharName(p2Selected));
			if(Gdx.input.isKeyJustPressed(InputsControl.P2_LEFT) && p2Selected > 0){
				p2Selected--;
			}
			else if(Gdx.input.isKeyJustPressed(InputsControl.P2_RIGHT) && p2Selected < 7){
				p2Selected++;
			}
			else if(Gdx.input.isKeyJustPressed(InputsControl.P2_UP) && p2Selected > 3){
				p2Selected -= 4;
			}
			else if(Gdx.input.isKeyJustPressed(InputsControl.P2_UP) && p2Selected < 4){
				p2Selected = 0;
			}
			else if(Gdx.input.isKeyJustPressed(InputsControl.P2_DOWN) && p2Selected < 4){
				p2Selected += 4;
			}
			else if(Gdx.input.isKeyJustPressed(InputsControl.P2_DOWN) && p2Selected > 3){
				p2Selected = 7;
			}
			else if(Gdx.input.isKeyJustPressed(InputsControl.P2_ATTACK)){
				p2Locked.setColor(1, 1, 1, 1);
				p2Lock = true;
				p2Char = CharacterScreenUtils.getCharName(p2Selected);
			}
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P2_DEFENSE) && delayTime < 5f){
			p2Locked.setColor(1, 1, 1, 0);
			p2Lock = false;
			p2Char = null;
		}
		
		if(p1Lock && p2Lock){
			delayTime += Gdx.graphics.getDeltaTime();
			Utils.characterSelectReadyBG.setColor(1, 1, 1, 1);
			readyText.setColor(1, 1, 1, 1);
			countDownText.setColor(1, 1, 1, 1);
			countDownText.setText(String.valueOf(5-(int) delayTime));
			if(delayTime >= 5f){
				fadeOutTime += Gdx.graphics.getDeltaTime();
				fadeOutToGameScreen();
				if(delayTime >= 6.2f){
					dispose();
					((Game) Gdx.app.getApplicationListener()).setScreen(new GameScreen());
				}
			}
		}
		else{
			Utils.characterSelectReadyBG.setColor(1, 1, 1, 0);
			readyText.setColor(1, 1, 1, 0);
			countDownText.setColor(1, 1, 1, 0);
			delayTime = 0;
			fadeOutTime = 0;
		}
		
		tweenManager.update(elapsedTime);
	}

	@Override
	public void resize(int width, int height) {	}

	@Override
	public void pause() { }

	@Override
	public void resume() { }

	@Override
	public void hide() { }

	@Override
	public void dispose() {	
		stage.dispose();
		Utils.charSelectSkin.dispose();
	}
	
	private void fadeOutToGameScreen(){
		Utils.characterSelectBG.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.characterSelectCharBG.setColor(1, 1, 1, 1-fadeOutTime);
		table.setColor(1, 1, 1, 1-fadeOutTime);
		table2.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.chopperBGP1.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.lawBGP1.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.luffyBGP1.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.namiBGP1.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.saboBGP1.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.sanjiBGP1.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.zoroBGP1.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.usoppBGP1.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.chopperBGP2.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.lawBGP2.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.luffyBGP2.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.namiBGP2.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.saboBGP2.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.sanjiBGP2.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.zoroBGP2.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.usoppBGP2.setColor(1, 1, 1, 1-fadeOutTime);
		
		// Texts
		titleText1.setColor(1, 1, 1, 1-fadeOutTime);
		titleText2.setColor(1, 1, 1, 1-fadeOutTime);
		vsText1.setColor(1, 1, 1, 1-fadeOutTime);
		vsText2.setColor(1, 1, 1, 1-fadeOutTime);
		p1CharText.setColor(1, 1, 1, 1-fadeOutTime);
		p1Locked.setColor(1, 1, 1, 1-fadeOutTime);
		p2CharText.setColor(1, 1, 1, 1-fadeOutTime);
		p2Locked.setColor(1, 1, 1, 1-fadeOutTime);
		readyText.setColor(1, 1, 1, 1-fadeOutTime);
		countDownText.setColor(1, 1, 1, 1-fadeOutTime);
		Utils.characterSelectReadyBG.setColor(1, 1, 1, 1-fadeOutTime);
	}
	
	private void fadeIn(){
		Utils.characterSelectBG.setColor(1, 1, 1, fadeInTime);
		Utils.characterSelectCharBG.setColor(1, 1, 1, fadeInTime);
		table.setColor(1, 1, 1, fadeInTime);
		table2.setColor(1, 1, 1, fadeInTime);
		Utils.lawBGP1.setColor(1, 1, 1, fadeInTime);
		Utils.lawBGP2.setColor(1, 1, 1, fadeInTime);
		
		// Texts
		titleText1.setColor(1, 1, 1, fadeInTime);
		titleText2.setColor(1, 1, 1, fadeInTime);
		vsText1.setColor(1, 1, 1, fadeInTime);
		vsText2.setColor(1, 1, 1, fadeInTime);
		p1CharText.setColor(1, 1, 1, fadeInTime);
		p2CharText.setColor(1, 1, 1, fadeInTime);
	}
}
