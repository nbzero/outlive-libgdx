package net.nbzero.outlive.utils;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationHandler {

	private static TextureRegion[][] texture;
	
	public static void movement() {
		TextureHandler.ApplyFrames(0, 2, 6, 3, texture);
	}
	
	public static void stay(){
		TextureHandler.ApplyFrames(0, 0, 4, 1, texture);
	}
}
