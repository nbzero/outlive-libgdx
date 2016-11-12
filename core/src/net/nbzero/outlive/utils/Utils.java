package net.nbzero.outlive.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Utils {
	public static float FADE_TIME;
	public static float GLIDE_TIME;
	
	public static Skin skin;
	public static Skin charSelectSkin;
	
	// MainMenu
	public static float buttonWidth;
	public static float buttonHeight;
	public static float padButton;
	public static String gameLogoPath;
	public static String mainMenuBGPath;
	public static String creditsImagePath;
	public static Image gameLogo;
	public static Image mainMenuBG;
	public static Image creditsImage;
	
	public static TextureAtlas mainMenuButtonAtlas;
	public static ImageButton oneOneButton;
	public static ImageButton twoTwoButton;
	public static ImageButton configButton;
	public static ImageButton creditsButton;
	public static ImageButton exitButton;
	public static ImageButton startButton;
	public static ImageButton tutorialButton;
	
	public static ImageButton[] buttonArray = {oneOneButton, twoTwoButton, configButton, creditsButton, exitButton, startButton, tutorialButton};
	
	// Character Select
	public static String characterSelectBGPath;
	public static String characterSelectCharBGPath;
	public static Image characterSelectBG;
	public static Image characterSelectCharBG;
	public static String characterSelectReadyBGPath;
	public static Image characterSelectReadyBG;
	
	public static TextureAtlas characterButtonAtlas;
	public static ImageButton chopperButton;
	public static ImageButton lawButton;
	public static ImageButton luffyButton;
	public static ImageButton namiButton;
	public static ImageButton saboButton;
	public static ImageButton sanjiButton;
	public static ImageButton zoroButton;
	public static ImageButton usoppButton;
	
	public static float charButtonWidth;
	public static float charButtonHeight;
	
	public static TextureAtlas bgCharacterAtlas;
	public static Image chopperBGP1;
	public static Image lawBGP1;
	public static Image luffyBGP1;
	public static Image namiBGP1;
	public static Image saboBGP1;
	public static Image sanjiBGP1;
	public static Image zoroBGP1;
	public static Image usoppBGP1;
	public static Image chopperBGP2;
	public static Image lawBGP2;
	public static Image luffyBGP2;
	public static Image namiBGP2;
	public static Image saboBGP2;
	public static Image sanjiBGP2;
	public static Image zoroBGP2;
	public static Image usoppBGP2;
	
	public static FreeTypeFontGenerator generator;
	public static FreeTypeFontParameter parameter;
	public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
	public static BitmapFont fontTiny;
	public static BitmapFont p1CharFont;
	public static BitmapFont p2CharFont;
	public static BitmapFont titleFont;
	public static BitmapFont vsFont;
	public static BitmapFont countDownFont;
	
	public static void load() {
		FADE_TIME = 0.05f;
		GLIDE_TIME = 0.3f;
		
		loadMainMenu();
	}
	
	public static void loadMainMenu() {
		gameLogoPath = "Logo/GameLogo.png";
		mainMenuBGPath = "MainMenu/bg.png";
		creditsImagePath = "MainMenu/credit.png";
		gameLogo = new Image(new Texture(Gdx.files.internal(Utils.gameLogoPath)));
		mainMenuBG = new Image(new Texture(Gdx.files.internal(Utils.mainMenuBGPath)));
		mainMenuBG.setWidth(Gdx.graphics.getWidth());
		mainMenuBG.setHeight(Gdx.graphics.getHeight());
		creditsImage = new Image(new Texture(Gdx.files.internal(Utils.creditsImagePath)));
		
		buttonWidth = 280f;
		buttonHeight = 123f;
		padButton = -65f;
		
		skin = new Skin();
		mainMenuButtonAtlas = new TextureAtlas(Gdx.files.internal("MainMenu/MainMenuButton.atlas"));
		skin.addRegions(mainMenuButtonAtlas);
		startButton = new ImageButton(skin.getDrawable("startButton"), skin.getDrawable("startButtonSelected"), skin.getDrawable("startButtonSelected"));
		startButton.setWidth(Gdx.graphics.getWidth()*0.2f);
		configButton = new ImageButton(skin.getDrawable("configButton"), skin.getDrawable("configButton"), skin.getDrawable("configButtonSelected"));
		creditsButton = new ImageButton(skin.getDrawable("creditsButton"), skin.getDrawable("creditsButton"), skin.getDrawable("creditsButtonSelected"));
		tutorialButton = new ImageButton(skin.getDrawable("tutorialButton"), skin.getDrawable("tutorialButton"), skin.getDrawable("tutorialButtonSelected"));
		exitButton = new ImageButton(skin.getDrawable("exitButton"), skin.getDrawable("exitButton"), skin.getDrawable("exitButtonSelected"));
		oneOneButton = new ImageButton(skin.getDrawable("oneOneButton"), skin.getDrawable("oneOneButton"), skin.getDrawable("oneOneButtonSelected"));
		twoTwoButton = new ImageButton(skin.getDrawable("twoTwoButton"), skin.getDrawable("twoTwoButton"), skin.getDrawable("twoTwoButtonSelected"));
	}
	
	public static void loadCharSelect() {
		characterSelectBGPath = "CharacterSelect/bg.png";
		characterSelectCharBGPath = "CharacterSelect/charBG.png";
		characterSelectReadyBGPath = "CharacterSelect/readyBG.png";
		characterSelectBG = new Image(new Texture(Gdx.files.internal(Utils.characterSelectBGPath)));
		characterSelectBG.setWidth(Gdx.graphics.getWidth());
		characterSelectBG.setHeight(Gdx.graphics.getHeight());
		characterSelectCharBG = new Image(new Texture(Gdx.files.internal(Utils.characterSelectCharBGPath)));
		characterSelectReadyBG = new Image(new Texture(Gdx.files.internal(Utils.characterSelectReadyBGPath)));
		
		charSelectSkin = new Skin();
		characterButtonAtlas = new TextureAtlas(Gdx.files.internal("CharacterSelect/characterButton.atlas"));
		bgCharacterAtlas = new TextureAtlas(Gdx.files.internal("CharacterSelect/bgCharacter.atlas"));

		charSelectSkin.addRegions(characterButtonAtlas);
		chopperButton = new ImageButton(charSelectSkin.getDrawable("Chopper"), charSelectSkin.getDrawable("Chopper"), charSelectSkin.getDrawable("ChopperSelected"));
		lawButton = new ImageButton(charSelectSkin.getDrawable("Law"), charSelectSkin.getDrawable("Law"), charSelectSkin.getDrawable("LawSelected"));
		luffyButton = new ImageButton(charSelectSkin.getDrawable("Luffy"), charSelectSkin.getDrawable("Luffy"), charSelectSkin.getDrawable("LuffySelected"));
		namiButton = new ImageButton(charSelectSkin.getDrawable("Nami"), charSelectSkin.getDrawable("Nami"), charSelectSkin.getDrawable("NamiSelected"));
		saboButton = new ImageButton(charSelectSkin.getDrawable("Sabo"), charSelectSkin.getDrawable("Sabo"), charSelectSkin.getDrawable("SaboSelected"));
		sanjiButton = new ImageButton(charSelectSkin.getDrawable("Sanji"), charSelectSkin.getDrawable("Sanji"), charSelectSkin.getDrawable("SanjiSelected"));
		zoroButton = new ImageButton(charSelectSkin.getDrawable("Zoro"), charSelectSkin.getDrawable("Zoro"), charSelectSkin.getDrawable("ZoroSelected"));
		usoppButton = new ImageButton(charSelectSkin.getDrawable("Usopp"), charSelectSkin.getDrawable("Usopp"), charSelectSkin.getDrawable("UsoppSelected"));
		
		charButtonWidth = chopperButton.getWidth()+10;
		charButtonHeight = chopperButton.getHeight()+10;

		charSelectSkin.addRegions(bgCharacterAtlas);
		chopperBGP1 = new Image(charSelectSkin.getDrawable("ChopperBG"));
		lawBGP1 = new Image(charSelectSkin.getDrawable("LawBG"));
		luffyBGP1 = new Image(charSelectSkin.getDrawable("LuffyBG"));
		namiBGP1 = new Image(charSelectSkin.getDrawable("NamiBG"));
		saboBGP1 = new Image(charSelectSkin.getDrawable("SaboBG"));
		sanjiBGP1 = new Image(charSelectSkin.getDrawable("SanjiBG"));
		zoroBGP1 = new Image(charSelectSkin.getDrawable("ZoroBG"));
		usoppBGP1 = new Image(charSelectSkin.getDrawable("UsoppBG"));
		lawBGP1.setWidth(-lawBGP1.getWidth());
		saboBGP1.setWidth(-saboBGP1.getWidth());
		sanjiBGP1.setWidth(-sanjiBGP1.getWidth());
		chopperBGP1.setPosition(Gdx.graphics.getWidth()*0.1f, Gdx.graphics.getHeight()*0.02f);
		lawBGP1.setPosition(-lawBGP1.getWidth()+Gdx.graphics.getWidth()*0.1f, Gdx.graphics.getHeight()*0.02f);
		luffyBGP1.setPosition(Gdx.graphics.getWidth()*0.1f, Gdx.graphics.getHeight()*0.02f);
		namiBGP1.setPosition(Gdx.graphics.getWidth()*0.1f, Gdx.graphics.getHeight()*0.02f);
		saboBGP1.setPosition(-saboBGP1.getWidth()+Gdx.graphics.getWidth()*0.1f, Gdx.graphics.getHeight()*0.02f);
		sanjiBGP1.setPosition(-sanjiBGP1.getWidth()+Gdx.graphics.getWidth()*0.1f, Gdx.graphics.getHeight()*0.02f);
		zoroBGP1.setPosition(Gdx.graphics.getWidth()*0.1f, Gdx.graphics.getHeight()*0.02f);
		usoppBGP1.setPosition(Gdx.graphics.getWidth()*0.1f, Gdx.graphics.getHeight()*0.02f);
		chopperBGP1.setVisible(false);
		lawBGP1.setVisible(false);
		luffyBGP1.setVisible(false);
		namiBGP1.setVisible(false);
		saboBGP1.setVisible(false);
		sanjiBGP1.setVisible(false);
		zoroBGP1.setVisible(false);
		usoppBGP1.setVisible(false);
		
		chopperBGP2 = new Image(charSelectSkin.getDrawable("ChopperBG"));
		lawBGP2 = new Image(charSelectSkin.getDrawable("LawBG"));
		luffyBGP2 = new Image(charSelectSkin.getDrawable("LuffyBG"));
		namiBGP2 = new Image(charSelectSkin.getDrawable("NamiBG"));
		saboBGP2 = new Image(charSelectSkin.getDrawable("SaboBG"));
		sanjiBGP2 = new Image(charSelectSkin.getDrawable("SanjiBG"));
		zoroBGP2 = new Image(charSelectSkin.getDrawable("ZoroBG"));
		usoppBGP2 = new Image(charSelectSkin.getDrawable("UsoppBG"));
		zoroBGP2.setWidth(-zoroBGP2.getWidth());
		namiBGP2.setWidth(-namiBGP2.getWidth());
		luffyBGP2.setWidth(-luffyBGP2.getWidth());
		chopperBGP2.setWidth(-chopperBGP2.getWidth());
		usoppBGP2.setWidth(-usoppBGP2.getWidth());
		chopperBGP2.setPosition(-chopperBGP2.getWidth()+Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight()*0.02f);
		lawBGP2.setPosition(Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight()*0.02f);
		luffyBGP2.setPosition(-luffyBGP2.getWidth()+Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight()*0.02f);
		namiBGP2.setPosition(-namiBGP2.getWidth()+Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight()*0.02f);
		saboBGP2.setPosition(Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight()*0.02f);
		sanjiBGP2.setPosition(Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight()*0.02f);
		zoroBGP2.setPosition(-zoroBGP2.getWidth()+Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight()*0.02f);
		usoppBGP2.setPosition(-usoppBGP2.getWidth()+Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight()*0.02f);
		chopperBGP2.setVisible(false);
		lawBGP2.setVisible(false);
		luffyBGP2.setVisible(false);
		namiBGP2.setVisible(false);
		saboBGP2.setVisible(false);
		sanjiBGP2.setVisible(false);
		zoroBGP2.setVisible(false);
		usoppBGP2.setVisible(false);
	}
	
	public static void loadKitchenFont(){
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/KITCHENPOLICE.TTF"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 20;
		parameter.borderWidth = 2;
		parameter.characters = FONT_CHARACTERS;
		fontTiny = generator.generateFont(parameter);
		parameter.size = 48;
		parameter.borderStraight = true;
		parameter.borderWidth = 4;
		parameter.borderColor = Color.BLACK;
		titleFont = generator.generateFont(parameter);
		parameter.size = 96;
		parameter.borderWidth = 4;
		parameter.borderColor = Color.BLACK;
		vsFont = generator.generateFont(parameter);
		parameter.size = 48;
		parameter.borderWidth = 5;
		parameter.borderColor = Color.BLACK;
		p1CharFont = generator.generateFont(parameter);
		p2CharFont = generator.generateFont(parameter);
		parameter.size = 156;
		parameter.borderWidth = 6;
		parameter.borderColor = Color.BLACK;
		parameter.color = Color.WHITE;
		countDownFont = generator.generateFont(parameter);
		charSelectSkin.add("KitchenPoliceTitle", titleFont);
		charSelectSkin.add("KitchenPoliceVs", vsFont);
		charSelectSkin.add("KitchenPoliceTiny", fontTiny);
		charSelectSkin.add("KitchenPoliceP1CharFont", p1CharFont);
		charSelectSkin.add("KitchenPoliceP2CharFont", p2CharFont);
		charSelectSkin.add("KitchenPoliceCountDown", countDownFont);
	}
	
	public static void exitGame() {
		// Dispose everything
		skin.dispose();
		charSelectSkin.dispose();
	}
}
