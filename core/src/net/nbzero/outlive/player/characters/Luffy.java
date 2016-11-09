package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.Animation;

import net.nbzero.outlive.player.PlayerData;
//import net.nbzero.outlive.utils.TextureHandler;
import net.nbzero.outlive.positon.PositionHandler;

public class Luffy extends Character {
	private static Animation standing;
	private static Animation running;
	private static Animation attacking;
	private static Animation attacking2;
	private static Animation attacking3;
	private static Animation defending;
	private static Animation dashing;
	public Luffy(PlayerData playerData){
		super(playerData, new PositionHandler(75, 115));
		CharacterFactory.Luffy.load();
		standing = drawStanding();
		running = drawRunning();
		attacking = drawAttacking();
		attacking2 = drawAttacking2();
		attacking3 = drawAttacking3();
		defending = drawDefending();
		dashing = drawDashing();
	}

	@Override
	public Animation drawStanding() {
		return new Animation(1f/5f, CharacterFactory.Luffy.getStandFrames());
	}
	
	public Animation getStanding(){
		return Luffy.standing;
	}

	@Override
	protected Animation drawDashing() {
		return new Animation(1f/8f, CharacterFactory.Luffy.getDashFrames());
	}
	
	public Animation getDashing(){
		return Luffy.dashing;
	}
	
	@Override
	protected Animation drawRunning() {
		return new Animation(1f/6f, CharacterFactory.Luffy.getRunFrames());
	}
	
	public Animation getRunning(){
		return Luffy.running;
	}

	@Override
	protected Animation drawAttacking() {
		return new Animation(1f/17f, CharacterFactory.Luffy.getAttackFrames());
	}
	
	public Animation getAttacking(){
		return Luffy.attacking;
	}
	
	@Override
	protected Animation drawAttacking2() {
		return new Animation(1f/16f, CharacterFactory.Luffy.getAttackFrames2());
	}
	
	public Animation getAttacking2(){
		return Luffy.attacking2;
	}
	
	@Override
	protected Animation drawAttacking3() {
		return new Animation(1f/16f, CharacterFactory.Luffy.getAttackFrames3());
	}
	
	public Animation getAttacking3(){
		return Luffy.attacking3;
	}

	@Override
	protected Animation drawDefending() {
		return new Animation(1f/8f, CharacterFactory.Luffy.getDefenseFrames());
	}
	
	public Animation getDefending(){
		return Luffy.defending;
	}
}
