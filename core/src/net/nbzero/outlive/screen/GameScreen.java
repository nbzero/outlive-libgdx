package net.nbzero.outlive.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

import net.nbzero.outlive.InputsControl;
import net.nbzero.outlive.player.characters.Character;
import net.nbzero.outlive.sound.BGM;
import net.nbzero.outlive.utils.Utils;
import net.nbzero.outlive.utils.screenutils.GameScreenControlsUtils;
import net.nbzero.outlive.utils.screenutils.GameScreenDrawAnim;
import net.nbzero.outlive.utils.screenutils.GameScreenRenderUtils;
import net.nbzero.outlive.utils.screenutils.GameScreenUtils;

public class GameScreen implements Screen {
	public static SpriteBatch batch;
	public static Stage stage;
	public static ShapeRenderer shapeRenderer;
	public static TextureRegion keyFrame;
	public static Character player1;
	public static Character player2;
	protected static int atkCount;
	public static boolean debugMode;
	protected static float speed, hitboxPosXLeft, hitboxPosXRight, hitboxPosY, skillPosXLeft, skillPosXRight;
	// Set From Character select screen
	protected static String p1Char = "Luffy";
	protected static String p2Char = "Usopp";
	protected static int checkFireball=1;
	
	@Override
	public void show() {
		debugMode = false;
		GameScreenUtils.initialize();
		GameScreenRenderUtils.initialHUD();
		
	}

	@Override
	public void render(float delta) {
		// To keep track of time and animation
		GameScreenUtils.elapsedTime += Gdx.graphics.getDeltaTime();
		if(!GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			GameScreenUtils.regenTime += Gdx.graphics.getDeltaTime();
			GameScreenUtils.trackTime += Gdx.graphics.getDeltaTime();
		}
		// To update every character hitbox every render
		GameScreenUtils.updateHitbox(player1);
		GameScreenUtils.updateHitbox(player2);
		
		Gdx.gl.glClearColor(1, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		batch.draw(GameScreenUtils.bg, 0, 0);
		//// Player1
		// Start check input
		if(Gdx.input.isKeyPressed(InputsControl.P1_LEFT) && player1.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished) {
			GameScreenDrawAnim.moveLeftAnim(player1);
			GameScreenControlsUtils.p1MultiCommand();
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_RIGHT) && player1.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished) {
			GameScreenDrawAnim.moveRightAnim(player1);
			GameScreenControlsUtils.p1MultiCommand();
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_UP) && player1.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished) {
			GameScreenDrawAnim.moveUpAnim(player1);
			player1.setUping(true);
			GameScreenControlsUtils.p1MultiCommand();
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_DOWN) && player1.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished) {
			GameScreenDrawAnim.moveDownAnim(player1);
			player1.setDowning(true);
			GameScreenControlsUtils.p1MultiCommand();
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P1_DASH) && !player1.getPlayer().isDashing()
				&& player1.getPlayer().hasControl() && !GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			player1.getPlayer().setDashing(true);
			player1.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P1_ATTACK) && !player1.getPlayer().isAttacking()
				&& player1.getPlayer().hasControl()	&& !player1.getPlayer().isHitted() && !GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			player1.getPlayer().setAttacking(true);
			player1.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_DEFENSE) && !player1.getPlayer().isAttacking()
				&& !player1.getPlayer().isDead() && !player2.getPlayer().isHitted()
				&& !player1.getPlayer().isSkilling1() && !player1.getPlayer().isSkilling2()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			GameScreenDrawAnim.defenseAnim(player1);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_SKILL1) && !player1.getPlayer().isSkilling1()&& player1.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished && player1.getPlayer().isSkill1Ready() && player1.getPlayer().getMp() >= player1.getSkill1MP()){
			player1.getPlayer().setSkilling1(true);
			player1.getPlayer().setSkill1Ready(false);
			player1.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_SKILL2) && !player1.getPlayer().isSkilling2()&& player1.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished && player1.getPlayer().isSkill2Ready() && player1.getPlayer().getMp() >= player1.getSkill2MP()){
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
			GameScreenUtils.deadTime += Gdx.graphics.getDeltaTime();
			// For animation
			player1.getPlayer().setDeadTime(player1.getPlayer().getDeadTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.deadAnim(player1);
			player2.getPlayer().setHitable(false);
			GameScreenUtils.matchFinished = true;
			GameScreenRenderUtils.winner20Label.setText(CharacterSelectScreen.p2Char + " (P2)");
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
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished) {
			GameScreenDrawAnim.moveLeftAnim(player2);
			GameScreenControlsUtils.p2MultiCommand();
		} 
		else if(Gdx.input.isKeyPressed(InputsControl.P2_RIGHT) && player2.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished) {
			GameScreenDrawAnim.moveRightAnim(player2);
			GameScreenControlsUtils.p2MultiCommand();
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_UP) && player2.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished) {
			GameScreenDrawAnim.moveUpAnim(player2);
			player2.setUping(true);
			GameScreenControlsUtils.p2MultiCommand();
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_DOWN) && player2.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished) {
			GameScreenDrawAnim.moveDownAnim(player2);
			player2.setDowning(true);
			GameScreenControlsUtils.p2MultiCommand();
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P2_DASH) && !player2.getPlayer().isDashing() 
				&& player2.getPlayer().hasControl() && !GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			player2.getPlayer().setDashing(true);
			player2.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P2_ATTACK) && !player2.getPlayer().isAttacking()
				&& player2.getPlayer().hasControl() && !player2.getPlayer().isHitted() && !GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			player2.getPlayer().setAttacking(true);
			player2.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_DEFENSE) && !player2.getPlayer().isAttacking()
				&& !player2.getPlayer().isDead() && !player1.getPlayer().isHitted()
				&& !player2.getPlayer().isSkilling1() && !player2.getPlayer().isSkilling2()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			GameScreenDrawAnim.defenseAnim(player2);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_SKILL1) && !player2.getPlayer().isSkilling1()&& player2.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished && player2.getPlayer().isSkill1Ready() && player2.getPlayer().getMp() >= player2.getSkill1MP()){
			player2.getPlayer().setSkilling1(true);
			player2.getPlayer().setSkill1Ready(false);
			player2.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_SKILL2) && !player2.getPlayer().isSkilling2()&& player2.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished && player2.getPlayer().isSkill2Ready() && player2.getPlayer().getMp() >= player2.getSkill2MP()){
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
		else if(player2.getPlayer().isDead() || player2.getPlayer().getHp()<=0){
			player2.getPlayer().setHp(0);
			player2.getPlayer().setDead(true);
			player2.getPlayer().setHasControl(false);
			// For Fade
			GameScreenUtils.deadTime += Gdx.graphics.getDeltaTime();
			// For Animation
			player2.getPlayer().setDeadTime(player2.getPlayer().getDeadTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.deadAnim(player2);
			player1.getPlayer().setHitable(false);
			GameScreenUtils.matchFinished = true;
			GameScreenRenderUtils.winner20Label.setText(CharacterSelectScreen.p1Char + " (P1)");
		}
		else if(player2.getPlayer().isHitted()){
			GameScreenDrawAnim.getHitAnim(player2);
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
		GameScreenUtils.updateFireball();

		//update stone
		GameScreenUtils.updateStones();
		
		batch.end();
		
		if(GameScreenUtils.regenTime>=1){
			GameScreenAtkUtils.regenMP(player1);
			GameScreenAtkUtils.regenMP(player2);
			GameScreenUtils.regenTime -= 1f;
		}
		// Check pause
		if(Gdx.input.isKeyJustPressed(InputsControl.ESCAPE_MENU) && !GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			GameScreenUtils.paused = true;
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.ESCAPE_MENU) && GameScreenUtils.paused){
			GameScreenUtils.paused = false;
			GameScreenRenderUtils.unfadeLabels();
			GameScreenRenderUtils.winner20Label.setColor(1, 1, 1, 0);
			GameScreenRenderUtils.winner10Label.setColor(1, 1, 1, 0);
			Utils.ButtonBG.setColor(1, 1, 1, 0);
			Utils.exit.setColor(1, 1, 1, 0);
			Utils.repick.setColor(1, 1, 1, 0);
			Utils.rematch.setColor(1, 1, 1, 0);
		}
		
		GameScreenRenderUtils.renderHUD();
		GameScreenRenderUtils.renderDebugMode();
		
		if(GameScreenUtils.paused){
			GameScreenRenderUtils.renderPauseScreen();
		}
		if(GameScreenUtils.matchFinished){
			GameScreenRenderUtils.renderMatchFinished();
		}
		
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
	
	public static void disposeAll() {
		batch.dispose();
		stage.dispose();
		BGM.Battle1.getBGM().dispose();
		BGM.Battle2.getBGM().dispose();
		BGM.Battle3.getBGM().dispose();
	}
}
