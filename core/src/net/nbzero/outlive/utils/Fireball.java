package net.nbzero.outlive.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Fireball {
	
	public static final int speed = 600;
	private static Texture texture;
	
	float x, y, z, px;
	
	boolean isRight;
	public boolean remove = false;
	boolean isBig;
	
	public Fireball (float x, float y, boolean isRight, boolean isBig){
		z = x;
		px = 150;
		this.x = x;
		this.y = y;
		this.isRight = isRight;
		this.isBig = isBig;
		
		if (texture == null){
			texture = new Texture("spritesheet/fireball.png");
		}
	}
	
	public void update (float deltaTime){
		if(isBig){
			if(isRight){
				x += speed * deltaTime;
				if (x > z+350){
					remove = true;
				}
			}else{
				x -= speed * deltaTime;
				if (x < z-350){
					remove = true;
				}
			}
		} else{
			if(isRight){
				x += speed * deltaTime;
				if (x > z+250){
					remove = true;
				}
			}else{
				x -= speed * deltaTime;
				if (x < z-250){
					remove = true;
				}
			}
		}
		
	}
	
	public void render (SpriteBatch batch){
		if(isBig){
			if(isRight){
				batch.draw(texture, x+200, y, px+50, px);
			}else{
				batch.draw(texture, x+100, y, -px-50, px);
			}
		} else{
			px = 50;
			if(isRight){
				batch.draw(texture, x+200, y+50, px, px);
			}else{
				batch.draw(texture, x+100, y+50, -px, px);
			}
		}

		
	}

}
