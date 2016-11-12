package net.nbzero.outlive.screen;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import net.nbzero.outlive.InputsControl;
import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.player.characters.Character;
import net.nbzero.outlive.player.characters.CharacterFactory;
import net.nbzero.outlive.player.characters.Fireball;
import net.nbzero.outlive.positon.PositionHandler;
import net.nbzero.outlive.utils.CollideHandler;

public class GameScreen implements Screen {
	public static SpriteBatch batch;
	protected static float elapsedTime;
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
	protected static String p2Char = "Law";
	private static String bgPath = "Stage/forest.png";
	protected static ArrayList<Fireball> fireballs; 
	protected static int checkFireball=1;
	
	@Override
	public void show() {
		debugMode = true;
		initialize();
	}

	@Override
	public void render(float delta) {
		// To keep track of time and animation
		elapsedTime += Gdx.graphics.getDeltaTime();
		// To update every character hitbox every render
		updateHitbox(player1);
		updateHitbox(player2);
		
		Gdx.gl.glClearColor(1, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		batch.draw(bg, 0, 0);
		
		//// Player1
		// Start check input
		if(Gdx.input.isKeyPressed(InputsControl.P1_LEFT) && player1.getPlayer().hasControl()) {
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
		else if(Gdx.input.isKeyPressed(InputsControl.P1_RIGHT) && player1.getPlayer().hasControl()) {
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
		else if(Gdx.input.isKeyPressed(InputsControl.P1_UP) && player1.getPlayer().hasControl()) {
			GameScreenDrawAnim.moveUpAnim(player1);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_DOWN) && player1.getPlayer().hasControl()) {
			GameScreenDrawAnim.moveDownAnim(player1);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P1_DASH) && !player1.getPlayer().isDashing() && player1.getPlayer().hasControl()){
			player1.getPlayer().setDashing(true);
			player1.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P1_ATTACK) && !player1.getPlayer().isAttacking() && player1.getPlayer().hasControl()){
			player1.getPlayer().setAttacking(true);
			player1.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_DEFENSE) && !player1.getPlayer().isAttacking()
				&& !player1.getPlayer().isDead() && !player2.getPlayer().isHitted() 
				&& !player1.getPlayer().isSkilling1() && !player1.getPlayer().isSkilling2()){
			GameScreenDrawAnim.defenseAnim(player1);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_SKILL1) && !player1.getPlayer().isSkilling1()&& player1.getPlayer().hasControl()){// Need to check cooldown skill1
			player1.getPlayer().setSkilling1(true);
			player1.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_SKILL2)&& !player1.getPlayer().isSkilling2()&& player1.getPlayer().hasControl()){// Need to check cooldown skill2
			player1.getPlayer().setSkilling2(true);
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
		else if(player1.getPlayer().isSkilling1()){ // Need to check cooldown skill1
			player1.getPlayer().setDelayTime(player1.getPlayer().getDelayTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.skill1Anim(player1);
			GameScreenAtkUtils.checkSkill1Hit(player1, player2);
			player1.getPlayer().setDelayTime(GameScreenAtkUtils.getSkill1Time(player1, player1.getPlayer().getDelayTime()));
		}
		else if(player1.getPlayer().isSkilling2()){ // Need to check cooldown skill2
			player1.getPlayer().setDelayTime(player1.getPlayer().getDelayTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.skill2Anim(player1);
			GameScreenAtkUtils.checkSkill2Hit(player1, player2);
			player1.getPlayer().setDelayTime(GameScreenAtkUtils.getSkill2Time(player1, player1.getPlayer().getDelayTime()));
		}
		else if(player1.getPlayer().isDead()){
			player1.getPlayer().setDeadTime(player1.getPlayer().getDeadTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.deadAnim(player1);
		}
		else if(player1.getPlayer().isHitted()){
			GameScreenDrawAnim.getHitAnim(player1);
		}
		else {
			GameScreenDrawAnim.idleAnim(player1);
		}
		
		//// Player2
		// Start check input
		if(Gdx.input.isKeyPressed(InputsControl.P2_LEFT) && player2.getPlayer().hasControl()) {
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
		else if(Gdx.input.isKeyPressed(InputsControl.P2_RIGHT) && player2.getPlayer().hasControl()) {
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
		else if(Gdx.input.isKeyPressed(InputsControl.P2_UP) && player2.getPlayer().hasControl()) {
			GameScreenDrawAnim.moveUpAnim(player2);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_DOWN) && player2.getPlayer().hasControl()) {
			GameScreenDrawAnim.moveDownAnim(player2);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P2_DASH) && !player2.getPlayer().isDashing() && player2.getPlayer().hasControl()){
			player2.getPlayer().setDashing(true);
			player2.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P2_ATTACK) && !player2.getPlayer().isAttacking() && player2.getPlayer().hasControl() && !player2.getPlayer().isHitted()){
			player2.getPlayer().setAttacking(true);
			player2.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_DEFENSE) && !player2.getPlayer().isAttacking()
				&& !player2.getPlayer().isDead() && !player2.getPlayer().isHitted() 
				&& !player2.getPlayer().isSkilling1() && !player2.getPlayer().isSkilling2()){
			GameScreenDrawAnim.defenseAnim(player2);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_SKILL1) && !player2.getPlayer().isSkilling1()&& player2.getPlayer().hasControl()){// Need to check cooldown skill1
			player2.getPlayer().setSkilling1(true);
			player2.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_SKILL2)&& !player2.getPlayer().isSkilling2()&& player2.getPlayer().hasControl()){// Need to check cooldown skill2
			player2.getPlayer().setSkilling2(true);
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
		else if(player2.getPlayer().isSkilling1()){ // Need to check cooldown skill1
			player2.getPlayer().setDelayTime(player2.getPlayer().getDelayTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.skill1Anim(player2);
			GameScreenAtkUtils.checkSkill1Hit(player2, player1);
			player2.getPlayer().setDelayTime(GameScreenAtkUtils.getSkill1Time(player2, player2.getPlayer().getDelayTime()));
		}
		else if(player2.getPlayer().isSkilling2()){ // Need to check cooldown skill2
			player2.getPlayer().setDelayTime(player2.getPlayer().getDelayTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.skill2Anim(player2);
			GameScreenAtkUtils.checkSkill2Hit(player2, player1);
			player2.getPlayer().setDelayTime(GameScreenAtkUtils.getSkill2Time(player2, player2.getPlayer().getDelayTime()));
		}
		else if(player2.getPlayer().isDead()){
			player2.getPlayer().setDeadTime(player2.getPlayer().getDeadTime()+Gdx.graphics.getDeltaTime());
			GameScreenDrawAnim.deadAnim(player2);
		}
		else if(player2.getPlayer().isHitted()){
			GameScreenDrawAnim.getHitAnim(player2);
		}
		else {
			GameScreenDrawAnim.idleAnim(player2);
		}
		if (!player2.getPlayer().isSkilling1()&&!player2.getPlayer().isAttacking()){
			checkFireball = 0;
		}
//		if (Gdx.input.isKeyJustPressed(Keys.B)){
//			fireballs.add(new Fireball(player2.getPlayer().getPos().getX(), player2.getHitbox().getY(), player2.getPlayer().isRight(), false));
//			
//		}
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
		
		
		batch.end();
		
		renderDebugMode();
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
	
	private void initialize(){
		p1 = new PlayerData(100, 100, 0, new PositionHandler(), "Right");
		p2 = new PlayerData(100, 100, 0, new PositionHandler(500, 50), "Left");
		player1 = CharacterFactory.valueOf(p1Char).getNew(p1);
		player2 = CharacterFactory.valueOf(p2Char).getNew(p2);
		bg = new Texture(bgPath);
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		elapsedTime = 0;
		fireballs = new ArrayList<Fireball>();
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
// TODO
//		    shapeRenderer.rect(Sabo.getFireballBox().getX(), Sabo.getFireballBox().getY(), Sabo.getFireballBox().getWidth(), Sabo.getFireballBox().getHeight());
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
}
