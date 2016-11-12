package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Stone {
	
	public static final int speed = 600;
	private static Texture texture;
	
	float x, y, z, px;
	
	boolean isRight;
	public boolean remove = false;
	boolean isBig;
	
	public Stone (float x, float y, boolean isRight, boolean isBig){
		z = x;
		px = 50;
		this.x = x;
		this.y = y;
		this.isRight = isRight;
		this.isBig = isBig;
		
		if (texture == null){
			texture = new Texture("spritesheet/stone.png");
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
				batch.draw(texture, x+200, y+50, px, px);
			}else{
				batch.draw(texture, x+100, y+50, -px, px);
			}
		} else{
			px = 20;
			if(isRight){
				batch.draw(texture, x+200, y+50, px, px);
			}else{
				batch.draw(texture, x+100, y+50, -px, px);
			}
		}

		
	}

}
