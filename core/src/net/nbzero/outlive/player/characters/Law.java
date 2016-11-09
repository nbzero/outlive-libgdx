package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.Animation;

import net.nbzero.outlive.player.PlayerData;
//import net.nbzero.outlive.utils.TextureHandler;
import net.nbzero.outlive.positon.PositionHandler;

public class Law extends Character {
	private static Animation standing;
	private static Animation running;
	private static Animation attacking;
	private static Animation attacking2;
	private static Animation attacking3;
	private static Animation defending;
	private static Animation dashing;
	private static Animation skilling1;
	private static Animation skilling2;
	private static Animation dead;
	
	
	public Law(PlayerData playerData){
		super(playerData);
		CharacterFactory.Law.load();
		standing = drawStanding();
		running = drawRunning();
		attacking = drawAttacking();
		attacking2 = drawAttacking2();
		attacking3 = drawAttacking3();
		skilling1 = drawSkilling1();
		skilling2 = drawSkilling2();
		defending = drawDefending();
		dashing = drawDashing();
		dead = drawDead();
	}

	@Override
	public Animation drawDead() {
		return new Animation(1f/8f, CharacterFactory.Law.getDeadFrames());
	}
	
	public Animation getDead(){
		return Law.dead;
	}
	
	@Override
	public Animation drawSkilling1() {
		return new Animation(1f/8f, CharacterFactory.Law.getSkill1Frames());
	}
	
	public Animation getSkilling1(){
		return Law.skilling1;
	}
	
	@Override
	public Animation drawSkilling2() {
		return new Animation(1f/8f, CharacterFactory.Law.getSkill2Frames());
	}
	
	public Animation getSkilling2(){
		return Law.skilling2;
	}
	
	@Override
	public Animation drawStanding() {
		return new Animation(1f/5f, CharacterFactory.Law.getStandFrames());
	}
	
	public Animation getStanding(){
		return Law.standing;
	}

	@Override
	protected Animation drawDashing() {
		return new Animation(1f/8f, CharacterFactory.Law.getDashFrames());
	}
	
	public Animation getDashing(){
		return Law.dashing;
	}
	
	@Override
	protected Animation drawRunning() {
		return new Animation(1f/6f, CharacterFactory.Law.getRunFrames());
	}
	
	public Animation getRunning(){
		return Law.running;
	}

	@Override
	protected Animation drawAttacking() {
		return new Animation(1f/16f, CharacterFactory.Law.getAttackFrames());
	}
	
	public Animation getAttacking(){
		return Law.attacking;
	}
	
	@Override
	protected Animation drawAttacking2() {
		return new Animation(1f/14f, CharacterFactory.Law.getAttackFrames2());
	}
	
	public Animation getAttacking2(){
		return Law.attacking2;
	}
	
	@Override
	protected Animation drawAttacking3() {
		return new Animation(1f/12f, CharacterFactory.Law.getAttackFrames3());
	}
	
	public Animation getAttacking3(){
		return Law.attacking3;
	}

	@Override
	protected Animation drawDefending() {
		return new Animation(1f/8f, CharacterFactory.Law.getDefenseFrames());
	}
	
	public Animation getDefending(){
		return Law.defending;
	}
}
