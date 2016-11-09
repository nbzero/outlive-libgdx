package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.Animation;

import net.nbzero.outlive.player.PlayerData;
//import net.nbzero.outlive.utils.TextureHandler;
import net.nbzero.outlive.positon.PositionHandler;

public class Zoro extends Character {
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
	
	
	public Zoro(PlayerData playerData){
		super(playerData);
		CharacterFactory.Zoro.load();
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
		return new Animation(1f/8f, CharacterFactory.Zoro.getDeadFrames());
	}
	
	public Animation getDead(){
		return Zoro.dead;
	}
	
	@Override
	public Animation drawSkilling1() {
		return new Animation(1f/8f, CharacterFactory.Zoro.getSkill1Frames());
	}
	
	public Animation getSkilling1(){
		return Zoro.skilling1;
	}
	
	@Override
	public Animation drawSkilling2() {
		return new Animation(1f/8f, CharacterFactory.Zoro.getSkill2Frames());
	}
	
	public Animation getSkilling2(){
		return Zoro.skilling2;
	}
	
	@Override
	public Animation drawStanding() {
		return new Animation(1f/5f, CharacterFactory.Zoro.getStandFrames());
	}
	
	public Animation getStanding(){
		return Zoro.standing;
	}

	@Override
	protected Animation drawDashing() {
		return new Animation(1f/8f, CharacterFactory.Zoro.getDashFrames());
	}
	
	public Animation getDashing(){
		return Zoro.dashing;
	}
	
	@Override
	protected Animation drawRunning() {
		return new Animation(1f/6f, CharacterFactory.Zoro.getRunFrames());
	}
	
	public Animation getRunning(){
		return Zoro.running;
	}

	@Override
	protected Animation drawAttacking() {
		return new Animation(1f/16f, CharacterFactory.Zoro.getAttackFrames());
	}
	
	public Animation getAttacking(){
		return Zoro.attacking;
	}
	
	@Override
	protected Animation drawAttacking2() {
		return new Animation(1f/14f, CharacterFactory.Zoro.getAttackFrames2());
	}
	
	public Animation getAttacking2(){
		return Zoro.attacking2;
	}
	
	@Override
	protected Animation drawAttacking3() {
		return new Animation(1f/12f, CharacterFactory.Zoro.getAttackFrames3());
	}
	
	public Animation getAttacking3(){
		return Zoro.attacking3;
	}

	@Override
	protected Animation drawDefending() {
		return new Animation(1f/8f, CharacterFactory.Zoro.getDefenseFrames());
	}
	
	public Animation getDefending(){
		return Zoro.defending;
	}
}
