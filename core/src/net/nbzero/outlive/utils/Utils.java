package net.nbzero.outlive.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Utils {
	public static float FADE_TIME;
	public static float GLIDE_TIME;
	public static float buttonWidth;
	public static float buttonHeight;
	public static float padButton;
	
	public static String gameLogoPath;
	public static String mainMenuBGPath;
	public static Image gameLogo;
	public static Image mainMenuBG;
	
	public static Skin skin;
	
	public static TextureAtlas mainMenuButtonAtlas;
	public static ImageButton oneOneButton;
	public static ImageButton twoTwoButton;
	public static ImageButton configButton;
	public static ImageButton creditsButton;
	public static ImageButton exitButton;
	public static ImageButton startButton;
	public static ImageButton tutorialButton;
	
	public static ImageButton[] buttonArray = {oneOneButton, twoTwoButton, configButton, creditsButton, exitButton, startButton, tutorialButton};
	
	public static void load() {
		FADE_TIME = 0.05f;
		GLIDE_TIME = 0.3f;
		buttonWidth = 280f;
		buttonHeight = 123f;
		padButton = -65f;
		
		gameLogoPath = "Logo/GameLogo.png";
		mainMenuBGPath = "MainMenu/bg.png";
		gameLogo = new Image(new Texture(Gdx.files.internal(Utils.gameLogoPath)));
		mainMenuBG = new Image(new Texture(Gdx.files.internal(Utils.mainMenuBGPath)));
		mainMenuBG.setWidth(Gdx.graphics.getWidth());
		mainMenuBG.setHeight(Gdx.graphics.getHeight());
		
		skin = new Skin();
		mainMenuButtonAtlas = new TextureAtlas(Gdx.files.internal("MainMenu/MainMenuButton.atlas"));
		skin.addRegions(mainMenuButtonAtlas);
		startButton = new ImageButton(skin.getDrawable("startButton"), skin.getDrawable("startButtonSelected"), skin.getDrawable("startButtonSelected"));
		configButton = new ImageButton(skin.getDrawable("configButton"), skin.getDrawable("configButton"), skin.getDrawable("configButtonSelected"));
		creditsButton = new ImageButton(skin.getDrawable("creditsButton"), skin.getDrawable("creditsButton"), skin.getDrawable("creditsButtonSelected"));
		tutorialButton = new ImageButton(skin.getDrawable("tutorialButton"), skin.getDrawable("tutorialButton"), skin.getDrawable("tutorialButtonSelected"));
		exitButton = new ImageButton(skin.getDrawable("exitButton"), skin.getDrawable("exitButton"), skin.getDrawable("exitButtonSelected"));
		oneOneButton = new ImageButton(skin.getDrawable("oneOneButton"), skin.getDrawable("oneOneButton"), skin.getDrawable("oneOneButtonSelected"));
		twoTwoButton = new ImageButton(skin.getDrawable("twoTwoButton"), skin.getDrawable("twoTwoButton"), skin.getDrawable("twoTwoButtonSelected"));
	}
	
	public static void exitGame() {
		// Dispose everything
		skin.dispose();
	}
}
