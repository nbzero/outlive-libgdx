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
import net.nbzero.outlive.player.characters.Luffy;
import net.nbzero.outlive.positon.PositionHandler;

public class GameScreen implements Screen {
	private static SpriteBatch batch;
	private static float elapsedTime;
	private static PlayerData p1;
	private static float x=0;
	private static TextureRegion keyFrame;
	private static Texture bg;
	private Luffy luffy;
	private static int count;
	private static float delayTime;
	
	@Override
	public void show() {
		p1 = new PlayerData(100, 100, 0, new PositionHandler(), "Right");
		luffy = new Luffy(p1);
		luffy.getPlayer().setLeft(true);
		bg = new Texture("MainMenu/bg.png");
		batch = new SpriteBatch();
		count=0;
	}

	@Override
	public void render(float delta) {
		elapsedTime += Gdx.graphics.getDeltaTime();
//		System.out.println(elapsedTime);
		
		Gdx.gl.glClearColor(1, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		batch.draw(bg, 0, 0);
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			keyFrame = luffy.getRunning().getKeyFrame(elapsedTime, true);
			luffy.getPlayer().setRight(false);
			luffy.getPlayer().getPos().setX(luffy.getPlayer().getPos().getX()-5);
			if(Gdx.input.isKeyPressed(Keys.UP)){
				luffy.getPlayer().getPos().setY(luffy.getPlayer().getPos().getY()+5);
			}
			else if(Gdx.input.isKeyPressed(Keys.DOWN)){
				luffy.getPlayer().getPos().setY(luffy.getPlayer().getPos().getY()-5);
			}
			batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
		} 
		else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			keyFrame = luffy.getRunning().getKeyFrame(elapsedTime, true);
			luffy.getPlayer().setRight(true);
			luffy.getPlayer().getPos().setX(luffy.getPlayer().getPos().getX()+5);
			if(Gdx.input.isKeyPressed(Keys.UP)){
				luffy.getPlayer().getPos().setY(luffy.getPlayer().getPos().getY()+5);
			}
			else if(Gdx.input.isKeyPressed(Keys.DOWN)){
				luffy.getPlayer().getPos().setY(luffy.getPlayer().getPos().getY()-5);
			}
			batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
		}
		else if(Gdx.input.isKeyPressed(Keys.UP)) {
			keyFrame = luffy.getRunning().getKeyFrame(elapsedTime, true);
			luffy.getPlayer().getPos().setY(luffy.getPlayer().getPos().getY()+5);
			if(luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}else{
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}	
		}
		else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			keyFrame = luffy.getRunning().getKeyFrame(elapsedTime, true);
			luffy.getPlayer().getPos().setY(luffy.getPlayer().getPos().getY()-5);
			if(luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}else{
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
		}
		else if(Gdx.input.isKeyPressed(Keys.X)){
			keyFrame = luffy.getDefending().getKeyFrame(elapsedTime);
			if(!luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
		}
		else if(Gdx.input.isKeyPressed(Keys.Z) && delayTime < elapsedTime){
			delayTime = elapsedTime+1;
			if (count%3==0){
				keyFrame = luffy.getAttacking().getKeyFrame(elapsedTime, true);
			}
			else if (count%3==1){
				keyFrame = luffy.getAttacking2().getKeyFrame(elapsedTime, true);
			}
			else if (count%3==2){
				keyFrame = luffy.getAttacking3().getKeyFrame(elapsedTime, true);
			}
			if(!luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
			count++;
		}
		else if(Gdx.input.isKeyPressed(Keys.SPACE)){
			keyFrame = luffy.getDashing().getKeyFrame(elapsedTime);
			if(!luffy.getPlayer().isRight()){
				luffy.getPlayer().getPos().setX(luffy.getPlayer().getPos().getX()-9);
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(luffy.getPlayer().isRight()){
				luffy.getPlayer().getPos().setX(luffy.getPlayer().getPos().getX()+9);
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
		}
		else {
			keyFrame = luffy.getStanding().getKeyFrame(elapsedTime, true);
			if(!luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX(), luffy.getPlayer().getPos().getY(), 300, 300);
			}
			else if(luffy.getPlayer().isRight()){
				batch.draw(keyFrame, luffy.getPlayer().getPos().getX()+300, luffy.getPlayer().getPos().getY(), -300, 300);
			}
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
