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
import net.nbzero.outlive.player.characters.Law;
import net.nbzero.outlive.positon.PositionHandler;

public class GameScreen implements Screen {
	private static SpriteBatch batch;
	private static float elapsedTime;
	private static PlayerData p1;
	private static float x=0;
	private static TextureRegion keyFrame;
	private static Texture bg;
	private Law law;
	private static int count;
	private static float delayTime;
	private static float attackTime;
	
	@Override
	public void show() {
		p1 = new PlayerData(100, 100, 0, new PositionHandler(), "Right");
		law = new Law(p1);
		law.getPlayer().setLeft(true);
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
		if(Gdx.input.isKeyPressed(Keys.LEFT) && law.getPlayer().hasControl()) {
			keyFrame = law.getRunning().getKeyFrame(elapsedTime, true);
			law.getPlayer().setRight(false);
			law.getPlayer().getPos().setX(law.getPlayer().getPos().getX()-5);
			if(Gdx.input.isKeyPressed(Keys.UP)){
				law.getPlayer().getPos().setY(law.getPlayer().getPos().getY()+5);
			}
			else if(Gdx.input.isKeyPressed(Keys.DOWN)){
				law.getPlayer().getPos().setY(law.getPlayer().getPos().getY()-5);
			}
			batch.draw(keyFrame, law.getPlayer().getPos().getX(), law.getPlayer().getPos().getY(), 300, 300);
		} 
		else if(Gdx.input.isKeyPressed(Keys.RIGHT) && law.getPlayer().hasControl()) {
			keyFrame = law.getRunning().getKeyFrame(elapsedTime, true);
			law.getPlayer().setRight(true);
			law.getPlayer().getPos().setX(law.getPlayer().getPos().getX()+5);
			if(Gdx.input.isKeyPressed(Keys.UP)){
				law.getPlayer().getPos().setY(law.getPlayer().getPos().getY()+5);
			}
			else if(Gdx.input.isKeyPressed(Keys.DOWN)){
				law.getPlayer().getPos().setY(law.getPlayer().getPos().getY()-5);
			}
			batch.draw(keyFrame, law.getPlayer().getPos().getX()+300, law.getPlayer().getPos().getY(), -300, 300);
		}
		else if(Gdx.input.isKeyPressed(Keys.UP) && law.getPlayer().hasControl()) {
			keyFrame = law.getRunning().getKeyFrame(elapsedTime, true);
			law.getPlayer().getPos().setY(law.getPlayer().getPos().getY()+5);
			if(law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX()+300, law.getPlayer().getPos().getY(), -300, 300);
			}else{
				batch.draw(keyFrame, law.getPlayer().getPos().getX(), law.getPlayer().getPos().getY(), 300, 300);
			}	
		}
		else if(Gdx.input.isKeyPressed(Keys.DOWN) && law.getPlayer().hasControl()) {
			keyFrame = law.getRunning().getKeyFrame(elapsedTime, true);
			law.getPlayer().getPos().setY(law.getPlayer().getPos().getY()-5);
			if(law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX()+300, law.getPlayer().getPos().getY(), -300, 300);
			}else{
				batch.draw(keyFrame, law.getPlayer().getPos().getX(), law.getPlayer().getPos().getY(), 300, 300);
			}
		}
		else if(Gdx.input.isKeyPressed(Keys.X) && !law.getPlayer().isAttacking()){
			law.getPlayer().setHasControl(false);
			keyFrame = law.getDefending().getKeyFrame(elapsedTime);
			if(!law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX(), law.getPlayer().getPos().getY(), 300, 300);
			}
			else if(law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX()+300, law.getPlayer().getPos().getY(), -300, 300);
			}
		}
		else if(Gdx.input.isKeyJustPressed(Keys.Z) && !law.getPlayer().isAttacking() && law.getPlayer().hasControl()){
			law.getPlayer().setAttacking(true);
			law.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyJustPressed(Keys.SPACE) && !law.getPlayer().isDashing() && law.getPlayer().hasControl()){
			law.getPlayer().setDashing(true);
			law.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(Keys.A) && !law.getPlayer().isSkilling1()&& law.getPlayer().hasControl()){// Need to check cooldown skill1
			law.getPlayer().setSkilling1(true);
			law.getPlayer().setHasControl(false);
			
		}
		else if(Gdx.input.isKeyPressed(Keys.S)&& !law.getPlayer().isSkilling2()&& law.getPlayer().hasControl()){// Need to check cooldown skill2
			law.getPlayer().setSkilling2(true);
			law.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(Keys.D)){
			keyFrame = law.getDead().getKeyFrame(elapsedTime, true);
			if(!law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX(), law.getPlayer().getPos().getY(), 300, 300);
			}
			else if(law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX()+300, law.getPlayer().getPos().getY(), -300, 300);
			}
		}
		// End check input
		
		// Start check states
		else if(law.getPlayer().isAttacking()){
			attackTime += Gdx.graphics.getDeltaTime();
			if (count%3==0){
				keyFrame = law.getAttacking().getKeyFrame(attackTime);
			}
			else if (count%3==1){
				keyFrame = law.getAttacking2().getKeyFrame(attackTime);
			}
			else if (count%3==2){
				keyFrame = law.getAttacking3().getKeyFrame(attackTime);
			}
			if(!law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX(), law.getPlayer().getPos().getY(), 300, 300);
			}
			else if(law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX()+300, law.getPlayer().getPos().getY(), -300, 300);
			}
			if(law.getAttacking().isAnimationFinished(attackTime)){
				law.getPlayer().setAttacking(false);
				attackTime = 0;
				count++;
			}
		}
		else if(law.getPlayer().isDashing()){
			delayTime += Gdx.graphics.getDeltaTime();
			keyFrame = law.getDashing().getKeyFrame(delayTime);
			if(!law.getPlayer().isRight()){
				law.getPlayer().getPos().setX(law.getPlayer().getPos().getX()-18);
				batch.draw(keyFrame, law.getPlayer().getPos().getX(), law.getPlayer().getPos().getY(), 300, 300);
			}
			else if(law.getPlayer().isRight()){
				law.getPlayer().getPos().setX(law.getPlayer().getPos().getX()+18);
				batch.draw(keyFrame, law.getPlayer().getPos().getX()+300, law.getPlayer().getPos().getY(), -300, 300);
			}
			if(delayTime>=0.1f){
				law.getPlayer().setDashing(false);
				delayTime = 0;
			}
		}
		else if(law.getPlayer().isSkilling1()){ // Need to check cooldown skill1
			delayTime += Gdx.graphics.getDeltaTime();
			keyFrame = law.getSkilling1().getKeyFrame(delayTime);
			if(!law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX()-100, law.getPlayer().getPos().getY(), 300, 300);
			}
			else if(law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX()+300+100, law.getPlayer().getPos().getY(), -300, 300);
			}
			if(law.getSkilling1().isAnimationFinished(delayTime)){
				law.getPlayer().setSkilling1(false);
				delayTime = 0;
			}
		}
		else if(law.getPlayer().isSkilling2()){ // Need to check cooldown skill2
			delayTime += Gdx.graphics.getDeltaTime();
			keyFrame = law.getSkilling2().getKeyFrame(delayTime);
			if(!law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX(), law.getPlayer().getPos().getY(), 300, 300);
			}
			else if(law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX()+300, law.getPlayer().getPos().getY(), -300, 300);
			}
			if(law.getSkilling2().isAnimationFinished(delayTime)){
				law.getPlayer().setSkilling2(false);
				delayTime = 0;
			}
		}
		else {
			law.getPlayer().setHasControl(true);
			keyFrame = law.getStanding().getKeyFrame(elapsedTime, true);
			if(!law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX(), law.getPlayer().getPos().getY(), 300, 300);
			}
			else if(law.getPlayer().isRight()){
				batch.draw(keyFrame, law.getPlayer().getPos().getX()+300, law.getPlayer().getPos().getY(), -300, 300);
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
