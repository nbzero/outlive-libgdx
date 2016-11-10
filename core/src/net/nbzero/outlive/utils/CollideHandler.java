package net.nbzero.outlive.utils;

import com.badlogic.gdx.math.Rectangle;

public class CollideHandler {
	public static boolean checkCollide(String flip, Rectangle attackBox, Rectangle hitBox){
		if(flip.equalsIgnoreCase("right") && attackBox.getX()-hitBox.getWidth() <= hitBox.getX() && attackBox.getX()+attackBox.getWidth() >= hitBox.getX()
				&& attackBox.getY() <= hitBox.getY()+hitBox.getHeight() && attackBox.getY()+attackBox.getHeight() >= hitBox.getY()){
			return true;
		}
		if(flip.equalsIgnoreCase("left") && attackBox.getX()+attackBox.getWidth() >= hitBox.getX() && attackBox.getX() <= hitBox.getX()+hitBox.getWidth()
			&& attackBox.getY() <= hitBox.getY()+hitBox.getHeight() && attackBox.getY()+attackBox.getHeight() >= hitBox.getY()){
			return true;
		}
	else{
			return false;
		}
	}
}
