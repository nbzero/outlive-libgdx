package net.nbzero.outlive.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureHandler {
	
	public static Texture getTexture(String path) {
		Texture img = new Texture(Gdx.files.internal(path));
		return img;
	}
	
	public static TextureRegion[][] TextureSplit(String path, int width, int height, boolean flip){
		Texture texture = getTexture(path);
		
		TextureRegion[][] temp = TextureRegion.split(texture, width, height);
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp[i].length; j++) {
				temp[i][j].flip(false, flip);
			}
		}
		return temp;
	}
	
	public static TextureRegion[] ApplyFrames(int sc, int sr, int fc, int fr, TextureRegion[][] frames) {
		// SC = start column
		// SR = start row
		// FC = end column
		// FR = end row
		TextureRegion[] temp = new TextureRegion[(fr - sr) * (fc - sc)];
		int index = 0;
		for (int i = sr; i < fr; i++) {
            for (int j = sc; j < fc; j++) {
            	temp[index++] = frames[i][j];
            }
		}
		return temp;
	}
}
