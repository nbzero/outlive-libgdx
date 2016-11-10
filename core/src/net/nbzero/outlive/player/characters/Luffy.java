package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;

import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.positon.PositionHandler;

public class Luffy extends Character {
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
	
	private static PositionHandler whiteSize = new PositionHandler(125, 20);
	
	public Luffy(PlayerData playerData){
		super(playerData, new PositionHandler(50, 90), whiteSize);
		setAttackBox(new Rectangle(-60, -70, 70, 70));
		CharacterFactory.Luffy.load();
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
		return new Animation(1f/8f, CharacterFactory.Luffy.getDeadFrames());
	}
	
	public Animation getDead(){
		return Luffy.dead;
	}
	
	@Override
	public Animation drawSkilling1() {
		return new Animation(1f/8f, CharacterFactory.Luffy.getSkill1Frames());
	}
	
	public Animation getSkilling1(){
		return Luffy.skilling1;
	}
	
	@Override
	public Animation drawSkilling2() {
		return new Animation(1f/8f, CharacterFactory.Luffy.getSkill2Frames());
	}
	
	public Animation getSkilling2(){
		return Luffy.skilling2;
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
		return new Animation(1f/16f, CharacterFactory.Luffy.getAttackFrames());
	}
	
	public Animation getAttacking(){
		return Luffy.attacking;
	}
	
	@Override
	protected Animation drawAttacking2() {
		return new Animation(1f/14f, CharacterFactory.Luffy.getAttackFrames2());
	}
	
	public Animation getAttacking2(){
		return Luffy.attacking2;
	}
	
	@Override
	protected Animation drawAttacking3() {
		return new Animation(1f/12f, CharacterFactory.Luffy.getAttackFrames3());
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
	
	public void setWhiteSize(PositionHandler whiteSize){
		Luffy.whiteSize = new PositionHandler(whiteSize);
	}
	
	public PositionHandler getWhiteSize(){
		return Luffy.whiteSize;
	}

}
