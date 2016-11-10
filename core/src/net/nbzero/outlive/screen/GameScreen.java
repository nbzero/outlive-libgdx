package net.nbzero.outlive.screen;

import java.awt.Rectangle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.player.characters.Luffy;
import net.nbzero.outlive.positon.PositionHandler;

public class GameScreen implements Screen {
	private static SpriteBatch batch;
	private static float elapsedTime;
	private static PlayerData p1;
	private static TextureRegion keyFrame;
	private static Texture bg;
	private Luffy luffy;
	private static int count;
	private static float delayTime;
	private static float attackTime;
	private static float deadTime;
	private static ShapeRenderer shapeRenderer;
	private static boolean debugMode;
	
	@Override
	public void show() {
		p1 = new PlayerData(100, 100, 0, new PositionHandler(), "Right");
		luffy = new Luffy(p1);
		luffy.getPlayer().setLeft(true);
		bg = new Texture("Stage/forest.png");
		batch = new SpriteBatch();
		count=0;
		delayTime=0;
		shapeRenderer = new ShapeRenderer();
		debugMode = true;
	}

	@Override
	public void render(float delta) {
		elapsedTime += Gdx.graphics.getDeltaTime();
//		System.out.println(elapsedTime);
		
		Gdx.gl.glClearColor(1, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		batch.draw(bg, 0, 0);
		
		//Start check input
		
		// Movement
		if(Gdx.input.isKeyPressed(Keys.LEFT) && luffy.getPlayer().hasControl()) {
			keyFrame = luffy.getRunning().getKeyFrame(elapsedTime, true);
			luffy.getPlayer().setRight(false);
			luffy.getPlayer().getPos().setX(luffy.getPlayer().getPos().getX()-5);
			luffy.getHitbox().setX(luffy.getHitbox().getX()-5);
			if(Gdx.input.isKeyPressed(Keys.UP)){
				luffy.getPlayer().getPos().setY(luffy.getPlayer().getPos().getY()+5);
				luffy.getHitbox().setY(luffy.getHitbox().getY()+5);
			}
			else if(Gdx.input.isKeyPressed(Keys.DOWN)){
				luffy.getPlayer().getPos().setY(luffy.getPlayer().getPos().getY()-5);
				luffy.getHitbox().setY(luffy.getHitbox().getY()-5);
			}
			batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
		} 
		else if(Gdx.input.isKeyPressed(Keys.RIGHT) && luffy.getPlayer().hasControl()) {
			keyFrame = luffy.getRunning().getKeyFrame(elapsedTime, true);
			luffy.getPlayer().setRight(true);
			luffy.getPlayer().getPos().setX(luffy.getPlayer().getPos().getX()+5);
			luffy.getHitbox().setX(luffy.getHitbox().getX()+5);
			if(Gdx.input.isKeyPressed(Keys.UP)){
				luffy.getPlayer().getPos().setY(luffy.getPlayer().getPos().getY()+5);
				luffy.getHitbox().setY(luffy.getHitbox().getY()+5);
			}
			else if(Gdx.input.isKeyPressed(Keys.DOWN)){
				luffy.getPlayer().getPos().setY(luffy.getPlayer().getPos().getY()-5);
				luffy.getHitbox().setY(luffy.getHitbox().getY()-5);
			}
			batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
		}
		else if(Gdx.input.isKeyPressed(Keys.UP) && luffy.getPlayer().hasControl()) {
			keyFrame = luffy.getRunning().getKeyFrame(elapsedTime, true);
			luffy.getPlayer().getPos().setY(luffy.getPlayer().getPos().getY()+5);
			luffy.getHitbox().setY(luffy.getHitbox().getY()+5);
			if(luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}else{
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}	
		}
		else if(Gdx.input.isKeyPressed(Keys.DOWN) && luffy.getPlayer().hasControl()) {
			keyFrame = luffy.getRunning().getKeyFrame(elapsedTime, true);
			luffy.getPlayer().getPos().setY(luffy.getPlayer().getPos().getY()-5);
			luffy.getHitbox().setY(luffy.getHitbox().getY()-5);
			if(luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}else{
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
		}
		
		// Attacking & Skilling
		else if(Gdx.input.isKeyPressed(Keys.X) && !luffy.getPlayer().isAttacking() && !luffy.getPlayer().isDead()){
			luffy.getPlayer().setHasControl(false);
			keyFrame = luffy.getDefending().getKeyFrame(elapsedTime);
			if(!luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
		}
		else if(Gdx.input.isKeyJustPressed(Keys.Z) && !luffy.getPlayer().isAttacking() && luffy.getPlayer().hasControl()){
			luffy.getPlayer().setAttacking(true);
			luffy.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyJustPressed(Keys.SPACE) && !luffy.getPlayer().isDashing() && luffy.getPlayer().hasControl()){
			luffy.getPlayer().setDashing(true);
			luffy.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(Keys.A) && !luffy.getPlayer().isSkilling1()&& luffy.getPlayer().hasControl()){// Need to check cooldown skill1
			luffy.getPlayer().setSkilling1(true);
			luffy.getPlayer().setHasControl(false);
			
		}
		else if(Gdx.input.isKeyPressed(Keys.S)&& !luffy.getPlayer().isSkilling2()&& luffy.getPlayer().hasControl()){// Need to check cooldown skill2
			luffy.getPlayer().setSkilling2(true);
			luffy.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(Keys.D)){
			keyFrame = luffy.getDead().getKeyFrame(elapsedTime, true);
			if(!luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
		}
		// End check input
		
		// Start check states
		else if(luffy.getPlayer().isAttacking()){
			attackTime += Gdx.graphics.getDeltaTime();
			if(!luffy.getPlayer().isRight() && count%3==0){
				luffy.getAttackBox().setCenter(luffy.getHitbox().getX()-luffy.getHitbox().getWidth()/2, luffy.getHitbox().getY()+luffy.getPlayer().getSize().getY()*0.75f);
				keyFrame = luffy.getAttacking().getKeyFrame(attackTime);
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(!luffy.getPlayer().isRight() && count%3==1){
				luffy.getAttackBox().setCenter(luffy.getHitbox().getX()-luffy.getHitbox().getWidth()/2, luffy.getHitbox().getY()+luffy.getPlayer().getSize().getY()*0.75f);
				keyFrame = luffy.getAttacking2().getKeyFrame(attackTime);
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(!luffy.getPlayer().isRight() && count%3==2){
				luffy.getAttackBox().setCenter(luffy.getHitbox().getX()-luffy.getHitbox().getWidth()/2, luffy.getHitbox().getY()+luffy.getPlayer().getSize().getY()*0.75f);
				keyFrame = luffy.getAttacking3().getKeyFrame(attackTime);
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(luffy.getPlayer().isRight() && count%3==0){
				luffy.getAttackBox().setCenter(luffy.getHitbox().getX()+luffy.getHitbox().getWidth()*1.5f, luffy.getHitbox().getY()+luffy.getPlayer().getSize().getY()*0.75f);
				keyFrame = luffy.getAttacking().getKeyFrame(attackTime);
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
			else if(luffy.getPlayer().isRight() && count%3==1){
				luffy.getAttackBox().setCenter(luffy.getHitbox().getX()+luffy.getHitbox().getWidth()*1.5f, luffy.getHitbox().getY()+luffy.getPlayer().getSize().getY()*0.75f);
				keyFrame = luffy.getAttacking2().getKeyFrame(attackTime);
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
			else if(luffy.getPlayer().isRight() && count%3==2){
				luffy.getAttackBox().setCenter(luffy.getHitbox().getX()+luffy.getHitbox().getWidth()*1.5f, luffy.getHitbox().getY()+luffy.getPlayer().getSize().getY()*0.75f);
				keyFrame = luffy.getAttacking3().getKeyFrame(attackTime);
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
			if(luffy.getAttacking().isAnimationFinished(attackTime)){
				luffy.getAttackBox().setCenter(-luffy.getAttackBox().getWidth(), -luffy.getAttackBox().getHeight());
				luffy.getPlayer().setAttacking(false);
				attackTime = 0;
				count++;
			}
		}
		else if(luffy.getPlayer().isDashing()){
			delayTime += Gdx.graphics.getDeltaTime();
			keyFrame = luffy.getDashing().getKeyFrame(delayTime);
			if(!luffy.getPlayer().isRight()){
				luffy.getPlayer().getPos().setX(luffy.getPlayer().getPos().getX()-18);
				luffy.getHitbox().setX(luffy.getHitbox().getX()-18);
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(luffy.getPlayer().isRight()){
				luffy.getPlayer().getPos().setX(luffy.getPlayer().getPos().getX()+18);
				luffy.getHitbox().setX(luffy.getHitbox().getX()+18);
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
			if(delayTime>=0.1f){
				luffy.getPlayer().setDashing(false);
				delayTime = 0;
			}
		}
		else if(luffy.getPlayer().isSkilling1()){ // Need to check cooldown skill1
			delayTime += Gdx.graphics.getDeltaTime();
			keyFrame = luffy.getSkilling1().getKeyFrame(delayTime);
			if(!luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
			if(luffy.getSkilling1().isAnimationFinished(delayTime)){
				luffy.getPlayer().setSkilling1(false);
				delayTime = 0;
			}
		}
		else if(luffy.getPlayer().isSkilling2()){ // Need to check cooldown skill2
			delayTime += Gdx.graphics.getDeltaTime();
			keyFrame = luffy.getSkilling2().getKeyFrame(delayTime);
			if(!luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
			if(luffy.getSkilling2().isAnimationFinished(delayTime)){
				luffy.getPlayer().setSkilling2(false);
				delayTime = 0;
			}
		}
		else if(luffy.getPlayer().isDead()){
			deadTime += Gdx.graphics.getDeltaTime();
			keyFrame = luffy.getDead().getKeyFrame(deadTime);
			if(!luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
		}
		else {
			luffy.getPlayer().setHasControl(true);
			keyFrame = luffy.getStanding().getKeyFrame(elapsedTime, true);
			if(!luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
		}
		if(count == 3){
			count = 0;
		}
		if(luffy.getHitbox().getX()+luffy.getWhiteSize().getX()+luffy.getPlayer().getSize().getX() >= 1000){
			luffy.getPlayer().setHasControl(false);
			luffy.getPlayer().setDead(true);
		}
		batch.end();
	    
		if(debugMode){
		    shapeRenderer.begin(ShapeType.Line);
		    shapeRenderer.setColor(1, 1, 0, 1);
		    shapeRenderer.rect(luffy.getHitbox().getX(), luffy.getHitbox().getY(), luffy.getHitbox().width, luffy.getHitbox().height);
		    shapeRenderer.setColor(1, 0, 0, 0);
		    shapeRenderer.rect(luffy.getAttackBox().getX(), luffy.getAttackBox().getY(), luffy.getAttackBox().getWidth(), luffy.getAttackBox().getHeight());
		    shapeRenderer.end();
		}
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
}
