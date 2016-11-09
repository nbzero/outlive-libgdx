package net.nbzero.outlive.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.player.characters.Character;
import net.nbzero.outlive.player.characters.Zoro;
import net.nbzero.outlive.positon.PositionHandler;

public class GameScreen implements Screen {
	private static SpriteBatch batch;
	private static float elapsedTime;
	private static PlayerData p1;
	private static float x=0;
	private static TextureRegion keyFrame;
	private static Texture bg;
	private Zoro zoro;
	private static int count;
	private static float delayTime;
	private static float attackTime;
	
	@Override
	public void show() {
		p1 = new PlayerData(100, 100, 0, new PositionHandler(), "Right");
		zoro = new Zoro(p1);
		zoro.getPlayer().setLeft(true);
		bg = new Texture("MainMenu/bg.png");
		batch = new SpriteBatch();
		count=0;
		delayTime=0;
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
		if(Gdx.input.isKeyPressed(Keys.LEFT) && zoro.getPlayer().hasControl()) {
			keyFrame = zoro.getRunning().getKeyFrame(elapsedTime, true);
			zoro.getPlayer().setRight(false);
			zoro.getPlayer().getPos().setX(zoro.getPlayer().getPos().getX()-5);
			if(Gdx.input.isKeyPressed(Keys.UP)){
				zoro.getPlayer().getPos().setY(zoro.getPlayer().getPos().getY()+5);
			}
			else if(Gdx.input.isKeyPressed(Keys.DOWN)){
				zoro.getPlayer().getPos().setY(zoro.getPlayer().getPos().getY()-5);
			}
			batch.draw(keyFrame, zoro.getPlayer().getPos().getX(), zoro.getPlayer().getPos().getY(), 300, 300);
		} 
		else if(Gdx.input.isKeyPressed(Keys.RIGHT) && zoro.getPlayer().hasControl()) {
			keyFrame = zoro.getRunning().getKeyFrame(elapsedTime, true);
			zoro.getPlayer().setRight(true);
			zoro.getPlayer().getPos().setX(zoro.getPlayer().getPos().getX()+5);
			if(Gdx.input.isKeyPressed(Keys.UP)){
				zoro.getPlayer().getPos().setY(zoro.getPlayer().getPos().getY()+5);
			}
			else if(Gdx.input.isKeyPressed(Keys.DOWN)){
				zoro.getPlayer().getPos().setY(zoro.getPlayer().getPos().getY()-5);
			}
			batch.draw(keyFrame, zoro.getPlayer().getPos().getX()+300, zoro.getPlayer().getPos().getY(), -300, 300);
		}
		else if(Gdx.input.isKeyPressed(Keys.UP) && zoro.getPlayer().hasControl()) {
			keyFrame = zoro.getRunning().getKeyFrame(elapsedTime, true);
			zoro.getPlayer().getPos().setY(zoro.getPlayer().getPos().getY()+5);
			if(zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX()+300, zoro.getPlayer().getPos().getY(), -300, 300);
			}else{
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX(), zoro.getPlayer().getPos().getY(), 300, 300);
			}	
		}
		else if(Gdx.input.isKeyPressed(Keys.DOWN) && zoro.getPlayer().hasControl()) {
			keyFrame = zoro.getRunning().getKeyFrame(elapsedTime, true);
			zoro.getPlayer().getPos().setY(zoro.getPlayer().getPos().getY()-5);
			if(zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX()+300, zoro.getPlayer().getPos().getY(), -300, 300);
			}else{
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX(), zoro.getPlayer().getPos().getY(), 300, 300);
			}
		}
		else if(Gdx.input.isKeyPressed(Keys.X) && !zoro.getPlayer().isAttacking()){
			zoro.getPlayer().setHasControl(false);
			keyFrame = zoro.getDefending().getKeyFrame(elapsedTime);
			if(!zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX(), zoro.getPlayer().getPos().getY(), 300, 300);
			}
			else if(zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX()+300, zoro.getPlayer().getPos().getY(), -300, 300);
			}
		}
		else if(Gdx.input.isKeyJustPressed(Keys.Z) && !zoro.getPlayer().isAttacking() && zoro.getPlayer().hasControl()){
			zoro.getPlayer().setAttacking(true);
			zoro.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyJustPressed(Keys.SPACE) && !zoro.getPlayer().isDashing() && zoro.getPlayer().hasControl()){
			zoro.getPlayer().setDashing(true);
			zoro.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(Keys.A) && !zoro.getPlayer().isSkilling1()&& zoro.getPlayer().hasControl()){// Need to check cooldown skill1
			zoro.getPlayer().setSkilling1(true);
			zoro.getPlayer().setHasControl(false);
			
		}
		else if(Gdx.input.isKeyPressed(Keys.S)&& !zoro.getPlayer().isSkilling2()&& zoro.getPlayer().hasControl()){// Need to check cooldown skill2
			zoro.getPlayer().setSkilling2(true);
			zoro.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(Keys.D)){
			keyFrame = zoro.getDead().getKeyFrame(elapsedTime, true);
			if(!zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX(), zoro.getPlayer().getPos().getY(), 300, 300);
			}
			else if(zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX()+300, zoro.getPlayer().getPos().getY(), -300, 300);
			}
		}
		// End check input
		
		// Start check states
		else if(zoro.getPlayer().isAttacking()){
			attackTime += Gdx.graphics.getDeltaTime();
			if (count%3==0){
				keyFrame = zoro.getAttacking().getKeyFrame(attackTime);
			}
			else if (count%3==1){
				keyFrame = zoro.getAttacking2().getKeyFrame(attackTime);
			}
			else if (count%3==2){
				keyFrame = zoro.getAttacking3().getKeyFrame(attackTime);
			}
			if(!zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX(), zoro.getPlayer().getPos().getY(), 300, 300);
			}
			else if(zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX()+300, zoro.getPlayer().getPos().getY(), -300, 300);
			}
			if(zoro.getAttacking().isAnimationFinished(attackTime)){
				zoro.getPlayer().setAttacking(false);
				attackTime = 0;
				count++;
			}
		}
		else if(zoro.getPlayer().isDashing()){
			delayTime += Gdx.graphics.getDeltaTime();
			keyFrame = zoro.getDashing().getKeyFrame(delayTime);
			if(!zoro.getPlayer().isRight()){
				zoro.getPlayer().getPos().setX(zoro.getPlayer().getPos().getX()-18);
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX(), zoro.getPlayer().getPos().getY(), 300, 300);
			}
			else if(zoro.getPlayer().isRight()){
				zoro.getPlayer().getPos().setX(zoro.getPlayer().getPos().getX()+18);
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX()+300, zoro.getPlayer().getPos().getY(), -300, 300);
			}
			if(delayTime>=0.1f){
				zoro.getPlayer().setDashing(false);
				delayTime = 0;
			}
		}
		else if(zoro.getPlayer().isSkilling1()){ // Need to check cooldown skill1
			delayTime += Gdx.graphics.getDeltaTime();
			keyFrame = zoro.getSkilling1().getKeyFrame(delayTime);
			if(!zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX(), zoro.getPlayer().getPos().getY(), 300, 300);
			}
			else if(zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX()+300, zoro.getPlayer().getPos().getY(), -300, 300);
			}
			if(zoro.getSkilling1().isAnimationFinished(delayTime)){
				zoro.getPlayer().setSkilling1(false);
				delayTime = 0;
			}
		}
		else if(zoro.getPlayer().isSkilling2()){ // Need to check cooldown skill2
			delayTime += Gdx.graphics.getDeltaTime();
			keyFrame = zoro.getSkilling2().getKeyFrame(delayTime);
			if(!zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX(), zoro.getPlayer().getPos().getY(), 300, 300);
			}
			else if(zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX()+300, zoro.getPlayer().getPos().getY(), -300, 300);
			}
			if(zoro.getSkilling2().isAnimationFinished(delayTime)){
				zoro.getPlayer().setSkilling2(false);
				delayTime = 0;
			}
		}
		else {
			zoro.getPlayer().setHasControl(true);
			keyFrame = zoro.getStanding().getKeyFrame(elapsedTime, true);
			if(!zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX(), zoro.getPlayer().getPos().getY(), 300, 300);
			}
			else if(zoro.getPlayer().isRight()){
				batch.draw(keyFrame, zoro.getPlayer().getPos().getX()+300, zoro.getPlayer().getPos().getY(), -300, 300);
			}
		}
		if(count == 3){
			count = 0;
		}
		batch.end();
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
