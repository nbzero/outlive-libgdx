package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.Animation;

import net.nbzero.outlive.player.PlayerData;
//import net.nbzero.outlive.utils.TextureHandler;

public class Luffy extends Character {
	private static Animation standing;
	private static Animation running;
	private static Animation attacking;
	private static Animation defending;
	public Luffy(PlayerData playerData){
		super(playerData);
		CharacterFactory.Luffy.load();
		standing = drawStanding();
		running = drawRunning();
		attacking = drawAttacking();
		defending = drawDefending();
	}

	@Override
	public Animation drawStanding() {
		return new Animation(1f/8f, CharacterFactory.Luffy.getStandFrames());
	}
	
	public Animation getStanding(){
		return Luffy.standing;
	}

	@Override
	protected Animation drawRunning() {
		return new Animation(1f/8f, CharacterFactory.Luffy.getRunFrames());
	}
	
	public Animation getRunning(){
		return Luffy.running;
	}

	@Override
	protected Animation drawAttacking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Animation drawDefending() {
		// TODO Auto-generated method stub
		return null;
	}
}
