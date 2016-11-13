package net.nbzero.outlive.screen;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

import net.nbzero.outlive.InputsControl;
import net.nbzero.outlive.hud.GameScreenHUD;
import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.player.characters.Character;
import net.nbzero.outlive.player.characters.CharacterFactory;
import net.nbzero.outlive.sound.BGM;
import net.nbzero.outlive.sound.SoundUtils;
import net.nbzero.outlive.utils.CollideHandler;
import net.nbzero.outlive.utils.Fireball;
import net.nbzero.outlive.utils.PositionHandler;
import net.nbzero.outlive.utils.Stone;
import net.nbzero.outlive.utils.Utils;

public class GameScreen implements Screen {
	public static SpriteBatch batch;
	private static Stage stage;
	public static float elapsedTime;
	public static float trackTime;
	private static PlayerData p1;
	private static PlayerData p2;
	private static Texture bg;
	protected static TextureRegion keyFrame;
	protected Character player1;
	protected Character player2;
	protected static int atkCount;
	private static ShapeRenderer shapeRenderer;
	private static boolean debugMode;
	protected static float speed, hitboxPosXLeft, hitboxPosXRight, hitboxPosY, skillPosXLeft, skillPosXRight;
	// Set From Character select screen
	protected static String p1Char = "Luffy";
	protected static String p2Char = "Usopp";
	private static String bgPath;
	protected static ArrayList<Fireball> fireballs; 
	protected static int checkFireball=1;
	private static Label player1Label;
	private static Label player2Label;
	private static Label player1HPLabel;
	private static Label player2HPLabel;
	private static Label player1MPLabel;
	private static Label player2MPLabel;
	private static Label p1Skill1CDLabel;
	private static Label p1Skill2CDLabel;
	private static Label p2Skill1CDLabel;
	private static Label p2Skill2CDLabel;
	private static Label timerLabel;
	protected static ArrayList<Stone> stones; 
	private static boolean paused = false;
	private static boolean matchFinished = false;
	private static float deadTime = 0;
	private static int menuSelected;
	private static Label winner20Label;
	private static Label winner10Label;
	private float regenTime = 0;
	private Sound click;
	
	@Override
	public void show() {
		debugMode = false;
		initialize();
		initialHUD();
		
	}

	@Override
	public void render(float delta) {
		// To keep track of time and animation
		elapsedTime += Gdx.graphics.getDeltaTime();
		if(!paused && !matchFinished){
			regenTime += Gdx.graphics.getDeltaTime();
			trackTime += Gdx.graphics.getDeltaTime();
		}
		// To update every character hitbox every render
		updateHitbox(player1);
		updateHitbox(player2);
		
		Gdx.gl.glClearColor(1, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		batch.draw(bg, 0, 0);
		//// Player1
		// Start check input
		if(Gdx.input.isKeyPressed(InputsControl.P1_LEFT) && player1.getPlayer().hasControl() 
				&& !paused && !matchFinished) {
			GameScreenDrawAnim.moveLeftAnim(player1);
			if(Gdx.input.isKeyPressed(InputsControl.P1_UP)){
				if(!CollideHandler.checkMapCollide("up", player1.getHitbox())){
					player1.moveY(player1.getPlayer().getPos().getY(), player1.getHitbox().getY(), player1.getMoveSpeed());
				}
			}
			else if(Gdx.input.isKeyPressed(InputsControl.P1_DOWN)){
				if(!CollideHandler.checkMapCollide("down", player1.getHitbox())){
					player1.moveY(player1.getPlayer().getPos().getY(), player1.getHitbox().getY(), -player1.getMoveSpeed());
				}
			}
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_RIGHT) && player1.getPlayer().hasControl() 
				&& !paused && !matchFinished) {
			GameScreenDrawAnim.moveRightAnim(player1);
			if(Gdx.input.isKeyPressed(InputsControl.P1_UP)){
				if(!CollideHandler.checkMapCollide("up", player1.getHitbox())){
					player1.moveY(player1.getPlayer().getPos().getY(), player1.getHitbox().getY(), player1.getMoveSpeed());
				}
			}
			else if(Gdx.input.isKeyPressed(InputsControl.P1_DOWN)){
				if(!CollideHandler.checkMapCollide("down", player1.getHitbox())){
					player1.moveY(player1.getPlayer().getPos().getY(), player1.getHitbox().getY(), -player1.getMoveSpeed());
				}
			}
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_UP) && player1.getPlayer().hasControl() 
				&& !paused && !matchFinished) {
			GameScreenDrawAnim.moveUpAnim(player1);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_DOWN) && player1.getPlayer().hasControl() 
				&& !paused && !matchFinished) {
			GameScreenDrawAnim.moveDownAnim(player1);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P1_DASH) && !player1.getPlayer().isDashing() && player1.getPlayer().hasControl()
				&& !paused && !matchFinished){
			player1.getPlayer().setDashing(true);
			player1.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P1_ATTACK) && !player1.getPlayer().isAttacking() && player1.getPlayer().hasControl()
				&& !paused && !matchFinished){
			player1.getPlayer().setAttacking(true);
			player1.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_DEFENSE) && !player1.getPlayer().isAttacking()
				&& !player1.getPlayer().isDead() && !player2.getPlayer().isHitted() 
				&& !player1.getPlayer().isSkilling1() && !player1.getPlayer().isSkilling2()
				&& !paused && !matchFinished){
			GameScreenDrawAnim.defenseAnim(player1);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_SKILL1) && !player1.getPlayer().isSkilling1()&& player1.getPlayer().hasControl() 
				&& !paused && !matchFinished && player1.getPlayer().isSkill1Ready()){
			player1.getPlayer().setSkilling1(true);
			player1.getPlayer().setSkill1Ready(false);
			player1.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_SKILL2)&& !player1.getPlayer().isSkilling2()&& player1.getPlayer().hasControl()
				&& !paused && !matchFinished && player1.getPlayer().isSkill2Ready()){
			player1.getPlayer().setSkilling2(true);
			player1.getPlayer().setSkill2Ready(false);
			player1.getPlayer().setHasControl(false);
		}
		// End check input
		// Start check states
		else if(player1.getPlayer().isDashing()){
			player1.getPlayer().setDelayTime(player1.getPlayer().getDelayTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.dashingAnim(player1);
		}
		else if(player1.getPlayer().isAttacking()){
			player1.getPlayer().setAttackTime(player1.getPlayer().getAttackTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.attackingAnim(player1);
			GameScreenAtkUtils.checkAtkHit(player1, player2);
			player1.getPlayer().setAttackTime(GameScreenAtkUtils.getAtkTime(player1, player1.getPlayer().getAttackTime()));
		}
		else if(player1.getPlayer().isSkilling1()){
			player1.getPlayer().setDelayTime(player1.getPlayer().getDelayTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.skill1Anim(player1);
			GameScreenAtkUtils.checkSkill1Hit(player1, player2);
			player1.getPlayer().setDelayTime(GameScreenAtkUtils.getSkill1Time(player1, player1.getPlayer().getDelayTime()));
		}
		else if(player1.getPlayer().isSkilling2()){
			player1.getPlayer().setDelayTime(player1.getPlayer().getDelayTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.skill2Anim(player1);
			GameScreenAtkUtils.checkSkill2Hit(player1, player2);
			player1.getPlayer().setDelayTime(GameScreenAtkUtils.getSkill2Time(player1, player1.getPlayer().getDelayTime()));
		}
		else if(player1.getPlayer().isDead() || player1.getPlayer().getHp() <= 0){
			player1.getPlayer().setHp(0);
			player1.getPlayer().setDead(true);
			player1.getPlayer().setHasControl(false);
			// For fade
			deadTime += Gdx.graphics.getDeltaTime();
			// For animation
			player1.getPlayer().setDeadTime(player1.getPlayer().getDeadTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.deadAnim(player1);
			player2.getPlayer().setHitable(false);
			matchFinished = true;
			winner20Label.setText(CharacterSelectScreen.p2Char + " (P2)");
		}
		else if(player1.getPlayer().isHitted()){
			GameScreenDrawAnim.getHitAnim(player1);
		}
		else {
			GameScreenDrawAnim.idleAnim(player1);
			if(player1.getPlayer().getHp()<=0){
				player1.getPlayer().setHp(0);
				player1.getPlayer().setDead(true);
				player1.getPlayer().setHasControl(false);
			}
		}
		GameScreenAtkUtils.checkSkillCD(player1);
		
		//// Player2
		// Start check input
		if(Gdx.input.isKeyPressed(InputsControl.P2_LEFT) && player2.getPlayer().hasControl()
				&& !paused && !matchFinished) {
			GameScreenDrawAnim.moveLeftAnim(player2);
			if(Gdx.input.isKeyPressed(InputsControl.P2_UP)){
				if(!CollideHandler.checkMapCollide("up", player2.getHitbox())){
					player2.moveY(player2.getPlayer().getPos().getY(), player2.getHitbox().getY(), player2.getMoveSpeed());
				}
			}
			else if(Gdx.input.isKeyPressed(InputsControl.P2_DOWN)){
				if(!CollideHandler.checkMapCollide("down", player2.getHitbox())){
					player2.moveY(player2.getPlayer().getPos().getY(), player2.getHitbox().getY(), -player2.getMoveSpeed());
				}
			}
		} 
		else if(Gdx.input.isKeyPressed(InputsControl.P2_RIGHT) && player2.getPlayer().hasControl()
				&& !paused && !matchFinished) {
			GameScreenDrawAnim.moveRightAnim(player2);
			if(Gdx.input.isKeyPressed(InputsControl.P2_UP)){
				if(!CollideHandler.checkMapCollide("up", player2.getHitbox())){
					player2.moveY(player2.getPlayer().getPos().getY(), player2.getHitbox().getY(), player2.getMoveSpeed());
				}
			}
			else if(Gdx.input.isKeyPressed(InputsControl.P2_DOWN)){
				if(!CollideHandler.checkMapCollide("down", player2.getHitbox())){
					player2.moveY(player2.getPlayer().getPos().getY(), player2.getHitbox().getY(), -player2.getMoveSpeed());
				}
			}
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_UP) && player2.getPlayer().hasControl()
				&& !paused && !matchFinished) {
			GameScreenDrawAnim.moveUpAnim(player2);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_DOWN) && player2.getPlayer().hasControl() 
				&& !paused && !matchFinished) {
			GameScreenDrawAnim.moveDownAnim(player2);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P2_DASH) && !player2.getPlayer().isDashing() 
				&& player2.getPlayer().hasControl() && !paused  && !matchFinished){
			player2.getPlayer().setDashing(true);
			player2.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P2_ATTACK) && !player2.getPlayer().isAttacking()
				&& player2.getPlayer().hasControl() && !player2.getPlayer().isHitted() && !paused  && !matchFinished){
			player2.getPlayer().setAttacking(true);
			player2.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_DEFENSE) && !player2.getPlayer().isAttacking()
				&& !player2.getPlayer().isDead() && !player2.getPlayer().isHitted() 
				&& !player2.getPlayer().isSkilling1() && !player2.getPlayer().isSkilling2()
				&& !paused && !matchFinished){
			GameScreenDrawAnim.defenseAnim(player2);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_SKILL1) && !player2.getPlayer().isSkilling1()&& player2.getPlayer().hasControl()
				&& !paused && !matchFinished && player2.getPlayer().isSkill1Ready()){
			player2.getPlayer().setSkilling1(true);
			player2.getPlayer().setSkill1Ready(false);
			player2.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_SKILL2)&& !player2.getPlayer().isSkilling2()&& player2.getPlayer().hasControl()
				&& !paused && !matchFinished && player2.getPlayer().isSkill2Ready()){
			player2.getPlayer().setSkilling2(true);
			player2.getPlayer().setSkill2Ready(false);
			player2.getPlayer().setHasControl(false);
		}
		// End check input
		// Start check states
		else if(player2.getPlayer().isDashing()){
			player2.getPlayer().setDelayTime(player2.getPlayer().getDelayTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.dashingAnim(player2);
		}
		else if(player2.getPlayer().isAttacking()){
			player2.getPlayer().setAttackTime(player2.getPlayer().getAttackTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.attackingAnim(player2);
			GameScreenAtkUtils.checkAtkHit(player2, player1);
			player2.getPlayer().setAttackTime(GameScreenAtkUtils.getAtkTime(player2, player2.getPlayer().getAttackTime()));
		}
		else if(player2.getPlayer().isSkilling1()){
			player2.getPlayer().setDelayTime(player2.getPlayer().getDelayTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.skill1Anim(player2);
			GameScreenAtkUtils.checkSkill1Hit(player2, player1);
			player2.getPlayer().setDelayTime(GameScreenAtkUtils.getSkill1Time(player2, player2.getPlayer().getDelayTime()));
		}
		else if(player2.getPlayer().isSkilling2()){
			player2.getPlayer().setDelayTime(player2.getPlayer().getDelayTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.skill2Anim(player2);
			GameScreenAtkUtils.checkSkill2Hit(player2, player1);
			player2.getPlayer().setDelayTime(GameScreenAtkUtils.getSkill2Time(player2, player2.getPlayer().getDelayTime()));
		}
		else if(player2.getPlayer().isHitted()){
			GameScreenDrawAnim.getHitAnim(player2);
		}
		else if(player2.getPlayer().isDead() || player2.getPlayer().getHp()<=0){
			player2.getPlayer().setHp(0);
			player2.getPlayer().setDead(true);
			player2.getPlayer().setHasControl(false);
			// For Fade
			deadTime += Gdx.graphics.getDeltaTime();
			// For Animation
			player2.getPlayer().setDeadTime(player2.getPlayer().getDeadTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.deadAnim(player2);
			player1.getPlayer().setHitable(false);
			matchFinished = true;
			winner20Label.setText(CharacterSelectScreen.p1Char + " (P1)");
		}
		else {
			GameScreenDrawAnim.idleAnim(player2);
			if(player2.getPlayer().getHp()<=0){
				player2.getPlayer().setHp(0);
				player2.getPlayer().setDead(true);
				player2.getPlayer().setHasControl(false);
			}
		}
		GameScreenAtkUtils.checkSkillCD(player2);
		//update fireball
		ArrayList<Fireball> fireballsToRemove = new ArrayList<Fireball>();
		for(Fireball fireball : fireballs){
			fireball.update(delta);
			if (fireball.remove){
				fireballsToRemove.add(fireball);
			}
		}
		fireballs.removeAll(fireballsToRemove);
		
		for (Fireball fireball : fireballs){
			fireball.render(batch);
		}
		

		//update stone
		ArrayList<Stone> stonesToRemove = new ArrayList<Stone>();
		for(Stone stone : stones){
			stone.update(delta);
			if (stone.remove){
				stonesToRemove.add(stone);
			}
		}
		stones.removeAll(stonesToRemove);
		
		for (Stone stone : stones){
			stone.render(batch);
		}
		
		batch.end();
		
		if(regenTime>=1){
			GameScreenAtkUtils.regenMP(player1);
			GameScreenAtkUtils.regenMP(player2);
			regenTime -= 1f;
		}
		// Check pause
		if(Gdx.input.isKeyJustPressed(InputsControl.ESCAPE_MENU) && !paused && !matchFinished){
			paused = true;
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.ESCAPE_MENU) && paused){
			paused = false;
			winner20Label.setColor(1, 1, 1, 0);
			winner10Label.setColor(1, 1, 1, 0);
			Utils.ButtonBG.setColor(1, 1, 1, 0);
			Utils.exit.setColor(1, 1, 1, 0);
			Utils.repick.setColor(1, 1, 1, 0);
			Utils.rematch.setColor(1, 1, 1, 0);
		}
		if(paused){
			renderPauseScreen();
		}
		if(matchFinished){
			renderMatchFinished();
		}
		
		renderHUD();
		renderDebugMode();
		
		stage.act(delta);
		stage.draw();
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
		batch.dispose();
		stage.dispose();
		BGM.Battle1.getBGM().dispose();
		BGM.Battle2.getBGM().dispose();
		BGM.Battle3.getBGM().dispose();
	}
	
	private void initialize(){
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
		player1 = CharacterFactory.valueOf(CharacterSelectScreen.p1Char).getNew(p1);
		player2 = CharacterFactory.valueOf(CharacterSelectScreen.p2Char).getNew(p2);
		bg = new Texture(bgPath);
		batch = new SpriteBatch();
		stage = new Stage();
		shapeRenderer = new ShapeRenderer();
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
		player1.getPlayer().setSkill1CDTime(player1.getPlayer().getSkillCD(0));
		player1.getPlayer().setSkill2CDTime(player1.getPlayer().getSkillCD(1));
		player2.getPlayer().setSkill1CDTime(player2.getPlayer().getSkillCD(0));
		player2.getPlayer().setSkill2CDTime(player2.getPlayer().getSkillCD(1));
	}
	
	private void renderHUD(){
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		shapeRenderer.begin(ShapeType.Filled);
		// BG
		shapeRenderer.setColor(new Color(1, 1, 1, 0.75f));
		shapeRenderer.rect(GameScreenHUD.getP1PlayerBarBG1().getX(), GameScreenHUD.getP1PlayerBarBG1().getY(),
				GameScreenHUD.getP1PlayerBarBG1().getWidth(), GameScreenHUD.getP1PlayerBarBG1().getHeight());
		shapeRenderer.rect(GameScreenHUD.getP1PlayerBarBG2().getX(), GameScreenHUD.getP1PlayerBarBG2().getY(),
				GameScreenHUD.getP1PlayerBarBG2().getWidth(), GameScreenHUD.getP1PlayerBarBG2().getHeight());
		shapeRenderer.rect(GameScreenHUD.getP2PlayerBarBG1().getX(), GameScreenHUD.getP2PlayerBarBG1().getY(),
				GameScreenHUD.getP2PlayerBarBG1().getWidth(), GameScreenHUD.getP2PlayerBarBG1().getHeight());
		shapeRenderer.rect(GameScreenHUD.getP2PlayerBarBG2().getX(), GameScreenHUD.getP2PlayerBarBG2().getY(),
				GameScreenHUD.getP2PlayerBarBG2().getWidth(), GameScreenHUD.getP2PlayerBarBG2().getHeight());
		// Base HP, MP
		shapeRenderer.setColor(0, 0, 0, 1);
		shapeRenderer.rect(GameScreenHUD.getP1BaseHPBar().getX(), GameScreenHUD.getP1BaseHPBar().getY(),
				GameScreenHUD.getP1BaseHPBar().getWidth(), GameScreenHUD.getP1BaseHPBar().getHeight());
		shapeRenderer.rect(GameScreenHUD.getP1BaseMPBar().getX(), GameScreenHUD.getP1BaseMPBar().getY(),
				GameScreenHUD.getP1BaseMPBar().getWidth(), GameScreenHUD.getP1BaseMPBar().getHeight());
		shapeRenderer.rect(GameScreenHUD.getP2BaseHPBar().getX(), GameScreenHUD.getP2BaseHPBar().getY(),
				GameScreenHUD.getP2BaseHPBar().getWidth(), GameScreenHUD.getP2BaseHPBar().getHeight());
		shapeRenderer.rect(GameScreenHUD.getP2BaseMPBar().getX(), GameScreenHUD.getP2BaseMPBar().getY(),
				GameScreenHUD.getP2BaseMPBar().getWidth(), GameScreenHUD.getP2BaseMPBar().getHeight());
		// Dynamic HP, MP
		shapeRenderer.setColor(0.54f, 0.71f, 0.18f, 1);
		shapeRenderer.rect(GameScreenHUD.getP1BaseHPBar().getX(), GameScreenHUD.getP1BaseHPBar().getY(),
				player1.getPlayer().getHPPercentage()*250, GameScreenHUD.getP1BaseHPBar().getHeight());
		shapeRenderer.rect(GameScreenHUD.getP2BaseHPBar().getX(), GameScreenHUD.getP2BaseHPBar().getY(),
				player2.getPlayer().getHPPercentage()*250, GameScreenHUD.getP2BaseHPBar().getHeight());
		shapeRenderer.setColor(0.22f, 0.63f, 0.65f, 1);
		shapeRenderer.rect(GameScreenHUD.getP1BaseMPBar().getX(), GameScreenHUD.getP1BaseMPBar().getY(),
				player1.getPlayer().getMPPercentage()*250, GameScreenHUD.getP1BaseMPBar().getHeight());
		shapeRenderer.rect(GameScreenHUD.getP2BaseMPBar().getX(), GameScreenHUD.getP2BaseMPBar().getY(),
				player2.getPlayer().getMPPercentage()*250, GameScreenHUD.getP2BaseMPBar().getHeight());
		// Skill Cooldown
		shapeRenderer.setColor(1, 1, 1, 0.8f);
		shapeRenderer.rect(GameScreenHUD.getP1Skill1Bar().getX(), GameScreenHUD.getP1Skill1Bar().getY(),
				GameScreenHUD.getP1Skill1Bar().getWidth(), GameScreenHUD.getP1Skill1Bar().getHeight());
		shapeRenderer.rect(GameScreenHUD.getP1Skill2Bar().getX(), GameScreenHUD.getP1Skill2Bar().getY(),
				GameScreenHUD.getP1Skill2Bar().getWidth(), GameScreenHUD.getP1Skill2Bar().getHeight());
		shapeRenderer.rect(GameScreenHUD.getP2Skill1Bar().getX(), GameScreenHUD.getP2Skill1Bar().getY(),
				GameScreenHUD.getP2Skill1Bar().getWidth(), GameScreenHUD.getP2Skill1Bar().getHeight());
		shapeRenderer.rect(GameScreenHUD.getP2Skill2Bar().getX(), GameScreenHUD.getP2Skill2Bar().getY(),
				GameScreenHUD.getP2Skill2Bar().getWidth(), GameScreenHUD.getP2Skill2Bar().getHeight());
		shapeRenderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
		player1HPLabel.setText((int) player1.getPlayer().getHp()+"/"+(int) player1.getPlayer().getMaxHP());
		player1MPLabel.setText((int) player1.getPlayer().getMp()+"/"+(int) player1.getPlayer().getMaxMP());
		player2HPLabel.setText((int) player2.getPlayer().getHp()+"/"+(int) player2.getPlayer().getMaxHP());
		player2MPLabel.setText((int) player2.getPlayer().getMp()+"/"+(int) player2.getPlayer().getMaxMP());
		if(player1.getPlayer().getSkill1CDTime() >= player1.getPlayer().getSkillCD(0)){
			p1Skill1CDLabel.setText("Ready");
			p1Skill1CDLabel.setFontScale(1);
		}
		else{
			p1Skill1CDLabel.setText(String.valueOf((int) player1.getPlayer().getSkill1CDTime()+1));
			p1Skill1CDLabel.setFontScale(1.5f);
		}
		if(player1.getPlayer().getSkill2CDTime() >= player1.getPlayer().getSkillCD(1)){
			p1Skill2CDLabel.setText("Ready");
			p1Skill2CDLabel.setFontScale(1);
		}
		else{
			p1Skill2CDLabel.setText(String.valueOf((int) player1.getPlayer().getSkill2CDTime()+1));
			p1Skill2CDLabel.setFontScale(1.5f);
		}
		if(player2.getPlayer().getSkill1CDTime() >= player2.getPlayer().getSkillCD(0)){
			p2Skill1CDLabel.setText("Ready");
			p2Skill1CDLabel.setFontScale(1);
		}
		else{
			p2Skill1CDLabel.setText(String.valueOf((int) player2.getPlayer().getSkill1CDTime()+1));
			p2Skill1CDLabel.setFontScale(1.5f);
		}
		if(player2.getPlayer().getSkill2CDTime() >= player2.getPlayer().getSkillCD(1)){
			p2Skill2CDLabel.setText("Ready");
			p2Skill2CDLabel.setFontScale(1);
		}
		else{
			p2Skill2CDLabel.setText(String.valueOf((int) player2.getPlayer().getSkill2CDTime()+1));
			p2Skill2CDLabel.setFontScale(1.5f);
		}
		timerLabel.setText(String.valueOf((int) trackTime));
	}
	
	private void initialHUD(){
		// HUD
		player1Label = new Label(CharacterSelectScreen.p1Char + " (P1)", Utils.gameScreenSkin, "imagineFontPlayer", Color.BLACK);
		player2Label = new Label(CharacterSelectScreen.p2Char + " (P2)", Utils.gameScreenSkin, "imagineFontPlayer", Color.BLACK);
		player1Label.setPosition(GameScreenHUD.getP1NameLabel().getX(), GameScreenHUD.getP1NameLabel().getY());
		player2Label.setPosition(GameScreenHUD.getP2NameLabel().getX(), GameScreenHUD.getP2NameLabel().getY());
		
		player1HPLabel = new Label((int) player1.getPlayer().getHp()+"/"+(int) player1.getPlayer().getMaxHP(), Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		player1MPLabel = new Label((int) player1.getPlayer().getMp()+"/"+(int) player1.getPlayer().getMaxMP(), Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		player2HPLabel = new Label((int) player2.getPlayer().getHp()+"/"+(int) player2.getPlayer().getMaxHP(), Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		player2MPLabel = new Label((int) player2.getPlayer().getMp()+"/"+(int) player2.getPlayer().getMaxMP(), Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		player1HPLabel.setPosition(GameScreenHUD.getP1HPLabel().getX(), GameScreenHUD.getP1HPLabel().getY());
		player1MPLabel.setPosition(GameScreenHUD.getP1MPLabel().getX(), GameScreenHUD.getP1MPLabel().getY());
		player2HPLabel.setPosition(GameScreenHUD.getP2HPLabel().getX(), GameScreenHUD.getP2HPLabel().getY());
		player2MPLabel.setPosition(GameScreenHUD.getP2MPLabel().getX(), GameScreenHUD.getP2MPLabel().getY());
		
		p1Skill1CDLabel = new Label("Ready", Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		p1Skill2CDLabel = new Label("Ready", Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		p2Skill1CDLabel = new Label("Ready", Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		p2Skill2CDLabel = new Label("Ready", Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		p1Skill1CDLabel.setPosition(GameScreenHUD.getP1Skill1LabelPos().getX(), GameScreenHUD.getP1Skill1LabelPos().getY());
		p1Skill2CDLabel.setPosition(GameScreenHUD.getP1Skill2LabelPos().getX(), GameScreenHUD.getP1Skill2LabelPos().getY());
		p2Skill1CDLabel.setPosition(GameScreenHUD.getP2Skill1LabelPos().getX(), GameScreenHUD.getP2Skill1LabelPos().getY());
		p2Skill2CDLabel.setPosition(GameScreenHUD.getP2Skill2LabelPos().getX(), GameScreenHUD.getP2Skill2LabelPos().getY());
		p1Skill1CDLabel.setAlignment(Align.center);
		p1Skill2CDLabel.setAlignment(Align.center);
		p2Skill1CDLabel.setAlignment(Align.center);
		p2Skill2CDLabel.setAlignment(Align.center);
		
		timerLabel = new Label(String.valueOf((int) trackTime), Utils.gameScreenSkin, "imagineFontTimer", Color.WHITE);
		timerLabel.setPosition(GameScreenHUD.getTimerLabel().getX(), GameScreenHUD.getTimerLabel().getY());
		
		// Pause & Victory
		winner20Label = new Label("Paused", Utils.victorySkin, "winner20", Color.WHITE);
		winner10Label = new Label("", Utils.victorySkin, "winner10", Color.WHITE);
		winner20Label.setPosition(Gdx.graphics.getWidth()*0.4f, Gdx.graphics.getHeight()*0.8f);
		winner10Label.setPosition(Gdx.graphics.getWidth()*0.5f, Gdx.graphics.getHeight()*0.75f);
		Utils.ButtonBG.setPosition((Gdx.graphics.getWidth()*0.5f)-Utils.ButtonBG.getWidth()*0.5f, (Gdx.graphics.getHeight()*0.5f)-Utils.ButtonBG.getHeight()*0.5f);
		Utils.exit.setPosition(Utils.ButtonBG.getX(), Utils.ButtonBG.getY()+Utils.exit.getHeight()*0.35f);
		Utils.rematch.setSize(256, 112);
		Utils.rematch.setPosition(Utils.ButtonBG.getX()+Utils.ButtonBG.getWidth()*0.2f, Gdx.graphics.getHeight()*0.57f);
		Utils.rematch.setChecked(true);
		Utils.repick.setSize(256, 112);
		Utils.repick.setPosition(Gdx.graphics.getWidth()*0.45f, Gdx.graphics.getHeight()*0.46f);
		winner20Label.setColor(1, 1, 1, 0);
		winner10Label.setColor(1, 1, 1, 0);
		Utils.ButtonBG.setColor(1, 1, 1, 0);
		Utils.exit.setColor(1, 1, 1, 0);
		Utils.repick.setColor(1, 1, 1, 0);
		Utils.rematch.setColor(1, 1, 1, 0);
				
		stage.addActor(winner20Label);
		stage.addActor(winner10Label);
		stage.addActor(Utils.ButtonBG);
		stage.addActor(Utils.exit);
		stage.addActor(Utils.repick);
		stage.addActor(Utils.rematch);
		stage.addActor(player1Label);
		stage.addActor(player2Label);
		stage.addActor(player1HPLabel);
		stage.addActor(player1MPLabel);
		stage.addActor(player2HPLabel);
		stage.addActor(player2MPLabel);
		stage.addActor(p1Skill1CDLabel);
		stage.addActor(p1Skill2CDLabel);
		stage.addActor(p2Skill1CDLabel);
		stage.addActor(p2Skill2CDLabel);
		stage.addActor(timerLabel);
	}
	
	private void renderPauseScreen(){
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(0, 0, 0, 0.7f);
		shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		shapeRenderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
		
		winner20Label.setColor(1, 1, 1, 1);
		winner10Label.setColor(1, 1, 1, 1);
		Utils.ButtonBG.setColor(1, 1, 1, 1);
		Utils.exit.setColor(1, 1, 1, 1);
		Utils.repick.setColor(1, 1, 1, 1);
		Utils.rematch.setColor(1, 1, 1, 1);
		
		pauseMenuChecker();
	}
	
	private void renderMatchFinished(){
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		shapeRenderer.begin(ShapeType.Filled);
		if(deadTime <= 0.7f){
			shapeRenderer.setColor(0, 0, 0, deadTime);
		}
		else{
			shapeRenderer.setColor(0, 0, 0, 0.7f);
		}
		shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		shapeRenderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
		
		winner10Label.setText("wins");
		
		if(deadTime<1){
			winner20Label.setColor(1, 1, 1, deadTime);
			winner10Label.setColor(1, 1, 1, deadTime);
			Utils.ButtonBG.setColor(1, 1, 1, deadTime);
			Utils.exit.setColor(1, 1, 1, deadTime);
			Utils.repick.setColor(1, 1, 1, deadTime);
			Utils.rematch.setColor(1, 1, 1, deadTime);
		}
		
		pauseMenuChecker();
	}
	
	private void renderDebugMode(){
		if(debugMode){
			shapeRenderer.begin(ShapeType.Line);
		    shapeRenderer.setColor(1, 1, 0, 1);
		    shapeRenderer.rect(player1.getHitbox().getX(), player1.getHitbox().getY(), player1.getHitbox().width, player1.getHitbox().height);
		    shapeRenderer.rect(player2.getHitbox().getX(), player2.getHitbox().getY(), player2.getHitbox().width, player2.getHitbox().height);
		    shapeRenderer.setColor(1, 0, 0, 0);
		    shapeRenderer.rect(player1.getAttackBox().getX(), player1.getAttackBox().getY(), player1.getAttackBox().getWidth(), player1.getAttackBox().getHeight());
		    shapeRenderer.rect(player1.getAttackBox2().getX(), player1.getAttackBox2().getY(), player1.getAttackBox2().getWidth(), player1.getAttackBox2().getHeight());
		    shapeRenderer.rect(player1.getAttackBox3().getX(), player1.getAttackBox3().getY(), player1.getAttackBox3().getWidth(), player1.getAttackBox3().getHeight());
		    shapeRenderer.rect(player1.getSkill1Box().getX(), player1.getSkill1Box().getY(), player1.getSkill1Box().getWidth(), player1.getSkill1Box().getHeight());
		    shapeRenderer.rect(player1.getSkill2Box().getX(), player1.getSkill2Box().getY(), player1.getSkill2Box().getWidth(), player1.getSkill2Box().getHeight());
		    shapeRenderer.rect(player2.getAttackBox().getX(), player2.getAttackBox().getY(), player2.getAttackBox().getWidth(), player2.getAttackBox().getHeight());
		    shapeRenderer.rect(player2.getAttackBox2().getX(), player2.getAttackBox2().getY(), player2.getAttackBox2().getWidth(), player2.getAttackBox2().getHeight());
		    shapeRenderer.rect(player2.getAttackBox3().getX(), player2.getAttackBox3().getY(), player2.getAttackBox3().getWidth(), player2.getAttackBox3().getHeight());
		    shapeRenderer.rect(player2.getSkill1Box().getX(), player2.getSkill1Box().getY(), player2.getSkill1Box().getWidth(), player2.getSkill1Box().getHeight());
		    shapeRenderer.rect(player2.getSkill2Box().getX(), player2.getSkill2Box().getY(), player2.getSkill2Box().getWidth(), player2.getSkill2Box().getHeight());
		    shapeRenderer.end();
		}
	}
	
	private void updateHitbox(Character player){
		player.setHitboxPosXLeft(player.getHitbox().getX()-player.getHitbox().getWidth()*0.8f);
		player.setHitboxPosXRight(player.getHitbox().getX()+player.getHitbox().getWidth()*0.8f);
		player.setSkillPosXLeft(player.getHitbox().getX()-player.getSkill1Box().getWidth()+player.getHitbox().getWidth()*1.2f);
		player.setSkillPosXRight(player.getHitbox().getX()-player.getHitbox().getWidth()*0.2f);
		player.setHitboxPosY(player.getHitbox().getY()+player.getPlayer().getSize().getY()*0.5f);
	}
	
	private void pauseMenuChecker(){
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
				dispose();
				((Game) Gdx.app.getApplicationListener()).setScreen(new GameScreen());
				break;
			case 1:
				dispose();
				((Game) Gdx.app.getApplicationListener()).setScreen(new CharacterSelectScreen());
				break;
			case 2:
				dispose();
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen());
				break;
			}
		}
	}
}
