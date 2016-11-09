package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.Animation;

import net.nbzero.outlive.player.PlayerData;
//import net.nbzero.outlive.utils.TextureHandler;

public class Luffy extends Character {
	private static Animation animation;
	private static Animation standing;
	public Luffy(PlayerData playerData){
		super(playerData);
		CharacterFactory.Luffy.load();
	}

	@Override
	public Animation drawStanding() {
		animation = new Animation(1f/8f, CharacterFactory.Luffy.getStandFrames());
		return animation;
	}
	
	public void setStanding(Animation standing) {
		Luffy.standing = standing;
	}
	
	public Animation getStanding(){
		return Luffy.standing;
	}

	@Override
	protected Animation drawRunning() {
		// TODO Auto-generated method stub
		return null;
	}
}
