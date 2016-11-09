package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.Animation;

import net.nbzero.outlive.player.PlayerData;
//import net.nbzero.outlive.utils.TextureHandler;
import net.nbzero.outlive.positon.PositionHandler;

public class Sanji extends Character {
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
	
	
	public Sanji(PlayerData playerData){
		super(playerData);
		CharacterFactory.Sanji.load();
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
		return new Animation(1f/8f, CharacterFactory.Sanji.getDeadFrames());
	}
	
	public Animation getDead(){
		return Sanji.dead;
	}
	
	@Override
	public Animation drawSkilling1() {
		return new Animation(1f/8f, CharacterFactory.Sanji.getSkill1Frames());
	}
	
	public Animation getSkilling1(){
		return Sanji.skilling1;
	}
	
	@Override
	public Animation drawSkilling2() {
		return new Animation(1f/8f, CharacterFactory.Sanji.getSkill2Frames());
	}
	
	public Animation getSkilling2(){
		return Sanji.skilling2;
	}
	
	@Override
	public Animation drawStanding() {
		return new Animation(1f/5f, CharacterFactory.Sanji.getStandFrames());
	}
	
	public Animation getStanding(){
		return Sanji.standing;
	}

	@Override
	protected Animation drawDashing() {
		return new Animation(1f/8f, CharacterFactory.Sanji.getDashFrames());
	}
	
	public Animation getDashing(){
		return Sanji.dashing;
	}
	
	@Override
	protected Animation drawRunning() {
		return new Animation(1f/6f, CharacterFactory.Sanji.getRunFrames());
	}
	
	public Animation getRunning(){
		return Sanji.running;
	}

	@Override
	protected Animation drawAttacking() {
		return new Animation(1f/16f, CharacterFactory.Sanji.getAttackFrames());
	}
	
	public Animation getAttacking(){
		return Sanji.attacking;
	}
	
	@Override
	protected Animation drawAttacking2() {
		return new Animation(1f/14f, CharacterFactory.Sanji.getAttackFrames2());
	}
	
	public Animation getAttacking2(){
		return Sanji.attacking2;
	}
	
	@Override
	protected Animation drawAttacking3() {
		return new Animation(1f/12f, CharacterFactory.Sanji.getAttackFrames3());
	}
	
	public Animation getAttacking3(){
		return Sanji.attacking3;
	}

	@Override
	protected Animation drawDefending() {
		return new Animation(1f/8f, CharacterFactory.Sanji.getDefenseFrames());
	}
	
	public Animation getDefending(){
		return Sanji.defending;
	}
}
