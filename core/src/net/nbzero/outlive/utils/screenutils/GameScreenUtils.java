package net.nbzero.outlive.utils.screenutils;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

import net.nbzero.outlive.hud.GameScreenHUD;
import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.player.characters.Character;
import net.nbzero.outlive.player.characters.CharacterFactory;
import net.nbzero.outlive.screen.CharacterSelectScreen;
import net.nbzero.outlive.screen.GameScreen;
import net.nbzero.outlive.screen.MainMenuScreen;
import net.nbzero.outlive.sound.BGM;
import net.nbzero.outlive.sound.SoundUtils;
import net.nbzero.outlive.utils.Fireball;
import net.nbzero.outlive.utils.PositionHandler;
import net.nbzero.outlive.utils.Stone;
import net.nbzero.outlive.utils.Utils;

public class GameScreenUtils {
	
	private static Sound click;
	private static String bgPath;
	public static Texture bg;
	
	private static PlayerData p1;
	private static PlayerData p2;
	public static float elapsedTime;
	public static float trackTime;
	public static float deadTime;
	public static float regenTime;
	public static boolean paused;
	public static boolean matchFinished;
	
	public static ArrayList<Fireball> fireballs;
	public static ArrayList<Stone> stones;
	
	private static int menuSelected;
	
	public static void initialize(){
		click = Gdx.audio.newSound(Gdx.files.internal("sound/SFX/Click.mp3"));
		bgPath = CharacterSelectScreen.stagePath;
		switch(bgPath){
		case "Stage/forest.png":
			BGM.Battle2.getBGM().play();
			BGM.Battle2.getBGM().setVolume(SoundUtils.getMasterVolume());
			break;
		case "Stage/water.png":
			BGM.Battle3.getBGM().play();
			BGM.Battle3.getBGM().setVolume(SoundUtils.getMasterVolume());
			break;
		case "Stage/train.png":
			BGM.Battle1.getBGM().play();
			BGM.Battle1.getBGM().setVolume(SoundUtils.getMasterVolume());
			break;
		}
		System.out.println(SoundUtils.getMasterVolume());
		p1 = new PlayerData(100, 100, 0, new PositionHandler(160, 50), "Right");
		p2 = new PlayerData(100, 100, 0, new PositionHandler(820, 50), "Left");
		GameScreen.player1 = CharacterFactory.valueOf(CharacterSelectScreen.p1Char).getNew(p1);
		GameScreen.player2 = CharacterFactory.valueOf(CharacterSelectScreen.p2Char).getNew(p2);
		bg = new Texture(bgPath);
		GameScreen.batch = new SpriteBatch();
		GameScreen.stage = new Stage();
		GameScreen.shapeRenderer = new ShapeRenderer();
		elapsedTime = 0;
		trackTime = 0;
		matchFinished = false;
		fireballs = new ArrayList<Fireball>();
		GameScreenHUD.load();
		stones = new ArrayList<Stone>();
		Utils.loadVictory();
		deadTime = 0;
		paused = false;
		menuSelected = 0;
		GameScreen.player1.getPlayer().setSkill1CDTime(GameScreen.player1.getPlayer().getSkillCD(0));
		GameScreen.player1.getPlayer().setSkill2CDTime(GameScreen.player1.getPlayer().getSkillCD(1));
		GameScreen.player2.getPlayer().setSkill1CDTime(GameScreen.player2.getPlayer().getSkillCD(0));
		GameScreen.player2.getPlayer().setSkill2CDTime(GameScreen.player2.getPlayer().getSkillCD(1));
	}
	
	public static void pauseMenuChecker(){
		if(Gdx.input.isKeyJustPressed(Keys.UP) && menuSelected > 0){
			click.play();
			menuSelected--;
		}
		else if(Gdx.input.isKeyJustPressed(Keys.DOWN) && menuSelected < 2){
			click.play();
			menuSelected++;
		}
		
		switch(menuSelected){
		case 0:
			Utils.rematch.setChecked(true);
			Utils.repick.setChecked(false);
			break;
		case 1:
			Utils.rematch.setChecked(false);
			Utils.repick.setChecked(true);
			Utils.exit.setChecked(false);
			break;
		case 2:
			Utils.rematch.setChecked(false);
			Utils.repick.setChecked(false);
			Utils.exit.setChecked(true);
			break;
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.ENTER)){
			switch(menuSelected){
			case 0:
				GameScreen.disposeAll();
				((Game) Gdx.app.getApplicationListener()).setScreen(new GameScreen());
				break;
			case 1:
				GameScreen.disposeAll();
				((Game) Gdx.app.getApplicationListener()).setScreen(new CharacterSelectScreen());
				break;
			case 2:
				GameScreen.disposeAll();
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen());
				break;
			}
		}
	}

	public static void updateFireball() {
		ArrayList<Fireball> fireballsToRemove = new ArrayList<Fireball>();
		for(Fireball fireball : fireballs){
			fireball.update(Gdx.graphics.getDeltaTime());
			if (fireball.remove){
				fireballsToRemove.add(fireball);
			}
		}
		fireballs.removeAll(fireballsToRemove);
		
		for (Fireball fireball : fireballs){
			fireball.render(GameScreen.batch);
		}
	}
	
	public static void updateStones() {
		ArrayList<Stone> stonesToRemove = new ArrayList<Stone>();
		for(Stone stone : stones){
			stone.update(Gdx.graphics.getDeltaTime());
			if (stone.remove){
				stonesToRemove.add(stone);
			}
		}
		stones.removeAll(stonesToRemove);
		
		for (Stone stone : stones){
			stone.render(GameScreen.batch);
		}
	}
	
	public static void updateHitbox(Character player){
		player.setHitboxPosXLeft(player.getHitbox().getX()-player.getHitbox().getWidth()*0.8f);
		player.setHitboxPosXRight(player.getHitbox().getX()+player.getHitbox().getWidth()*0.8f);
		player.setSkillPosXLeft(player.getHitbox().getX()-player.getSkill1Box().getWidth()+player.getHitbox().getWidth()*1.2f);
		player.setSkillPosXRight(player.getHitbox().getX()-player.getHitbox().getWidth()*0.2f);
		player.setHitboxPosY(player.getHitbox().getY()+player.getPlayer().getSize().getY()*0.5f);
	}
}
