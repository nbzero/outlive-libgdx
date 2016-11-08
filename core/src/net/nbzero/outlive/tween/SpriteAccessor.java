package net.nbzero.outlive.tween;

import aurelienribon.tweenengine.TweenAccessor;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteAccessor implements TweenAccessor<Sprite> {

	public static final int ALPHA = 0;

	@Override
	public int getValues(Sprite sprite, int tweenType, float[] returnValues) {
		if(tweenType == ALPHA){
			returnValues[0] = sprite.getColor().a;
			return 1;
		}
		else {
			assert false;
			return 0;
		}
	}

	@Override
	public void setValues(Sprite sprite, int tweenType, float[] newValues) {
		if(tweenType == ALPHA) {
			sprite.setColor(sprite.getColor().r, sprite.getColor().g, sprite.getColor().b, newValues[0]);
		}
		else {
			assert false;
		}
		
	}

}
