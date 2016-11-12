package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;

import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.positon.PositionHandler;

public class Sabo extends Character {
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
	private static Animation getHit;
	
	protected Rectangle fireballBox;
	
	private static PositionHandler whiteSize = new PositionHandler(125, 20);
	private Rectangle defaultAttackBox = new Rectangle(-70, -150, 70, 150);
	private Rectangle defaultAttackBox2 = new Rectangle(-100, -100, 100, 100);
	private Rectangle defaultAttackBox3 = new Rectangle(-100, -100, 100, 100);
	private Rectangle defaultFireballBox = new Rectangle(-50, -50, 50, 50);
	private Rectangle defaultSkill1Box = new Rectangle(-140, -100, 140, 90);
	private Rectangle defaultSkill2Box = new Rectangle(-90, -80, 90, 80);
	private Rectangle defaultHitBox = new Rectangle(0, 0, 50, 90);
	
	private static float moveSpeed = 5f;
	private static float atkSpeed = 20f;
	private static float skill1Speed = 495f;
	private static float skill2Speed = 100f;
	private static float skill1HitboxDelay = 0.2f;
	private static float skill2HitboxDelay = 0.2f;
	private static String nameCharacter = "Sabo";
	private static float[] skillCooldown = {4f, 6f};
	
	private static float maxHP = 150;
	private static float maxMP = 100;
	private static float atkPower = 12;
	private static float skill1Power = 20;
	private static float skill2Power = 30;
	private static float defPower = 12;
	private static int criticalChance = 12;
	
	public Sabo(PlayerData playerData){
		super(playerData, new PositionHandler(50, 90));
		setAttackBox(new Rectangle(defaultAttackBox.x, defaultAttackBox.y, defaultAttackBox.width, defaultAttackBox.height));
		setAttackBox2(new Rectangle(defaultAttackBox2.x, defaultAttackBox2.y, defaultAttackBox2.width, defaultAttackBox2.height));
		setAttackBox3(new Rectangle(defaultAttackBox3.x, defaultAttackBox3.y, defaultAttackBox3.width, defaultAttackBox3.height));
		setFireballBox(new Rectangle(defaultFireballBox.x, defaultFireballBox.y, defaultFireballBox.width, defaultFireballBox.height));
		setSkill1Box(new Rectangle(defaultSkill1Box.x, defaultSkill1Box.y, defaultSkill1Box.width, defaultSkill1Box.height));
		setSkill2Box(new Rectangle(defaultSkill2Box.x, defaultSkill2Box.y, defaultSkill2Box.width, defaultSkill2Box.height));
		setHitbox(new Rectangle(playerData.getPos().getX()+whiteSize.getX(), playerData.getPos().getY()+whiteSize.getY(), defaultHitBox.getWidth(), defaultHitBox.getHeight()));
		CharacterFactory.Sabo.load();
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
		getHit = drawGetHit();
	}

	@Override
	public Rectangle getDefaultAttackBox2() {
		return defaultAttackBox2;
	}
	
	@Override
	public Rectangle getDefaultAttackBox3() {
		return defaultAttackBox3;
	}
	
	public void setFireballBox(Rectangle fireballBox) {
		this.fireballBox = fireballBox;
	}
	
	public Rectangle getFireballBox() {
		return defaultFireballBox;
	}

	public String getNameCharacter(){
		return nameCharacter;
	}
	
	@Override
	public Animation drawDead() {
		return new Animation(1f/8f, CharacterFactory.Sabo.getDeadFrames());
	}
	
	public Animation getDead(){
		return Sabo.dead;
	}
	
	@Override
	public Animation drawSkilling1() {
		return new Animation(1f/8f, CharacterFactory.Sabo.getSkill1Frames());
	}
	
	public Animation getSkilling1(){
		return Sabo.skilling1;
	}
	
	@Override
	public Animation drawSkilling2() {
		return new Animation(1f/8f, CharacterFactory.Sabo.getSkill2Frames());
	}
	
	public Animation getSkilling2(){
		return Sabo.skilling2;
	}
	
	@Override
	public Animation drawStanding() {
		return new Animation(1f/5f, CharacterFactory.Sabo.getStandFrames());
	}
	
	public Animation getStanding(){
		return Sabo.standing;
	}

	@Override
	protected Animation drawDashing() {
		return new Animation(1f/8f, CharacterFactory.Sabo.getDashFrames());
	}
	
	public Animation getDashing(){
		return Sabo.dashing;
	}
	
	@Override
	protected Animation drawRunning() {
		return new Animation(1f/6f, CharacterFactory.Sabo.getRunFrames());
	}
	
	public Animation getRunning(){
		return Sabo.running;
	}

	@Override
	protected Animation drawAttacking() {
		return new Animation(1f/16f, CharacterFactory.Sabo.getAttackFrames());
	}
	
	public Animation getAttacking(){
		return Sabo.attacking;
	}
	
	@Override
	protected Animation drawAttacking2() {
		return new Animation(1f/14f, CharacterFactory.Sabo.getAttackFrames2());
	}
	
	public Animation getAttacking2(){
		return Sabo.attacking2;
	}
	
	@Override
	protected Animation drawAttacking3() {
		return new Animation(1f/12f, CharacterFactory.Sabo.getAttackFrames3());
	}
	
	public Animation getAttacking3(){
		return Sabo.attacking3;
	}

	@Override
	protected Animation drawDefending() {
		return new Animation(1f/8f, CharacterFactory.Sabo.getDefenseFrames());
	}
	
	@Override
	protected Animation drawGetHit() {
		return new Animation(1f/8f, CharacterFactory.Sabo.getGetHitFrames());
	}
	
	public Animation getGetHit(){
		return Sabo.getHit;
	}
	
	public Animation getDefending(){
		return Sabo.defending;
	}
	
	public void setWhiteSize(PositionHandler whiteSize){
		Sabo.whiteSize = new PositionHandler(whiteSize);
	}
	
	public PositionHandler getWhiteSize(){
		return Sabo.whiteSize;
	}

	@Override
	public Rectangle getDefaultHitBox() {
		return defaultHitBox;
	}
	
	@Override
	public Rectangle getDefaultAttackBox() {
		return defaultAttackBox;
	}

	@Override
	public Rectangle getDefaultSkill1Box() {
		return defaultSkill1Box;
	}

	@Override
	public Rectangle getDefaultSkill2Box() {
		return defaultSkill2Box;
	}
	
	public float getMoveSpeed() {
		return moveSpeed;
	}

	public float getAtkSpeed() {
		return atkSpeed;
	}
	
	public float getSkill1Speed() {
		return skill1Speed;
	}
	
	public float getSkill2Speed() {
		return skill2Speed;
	}
	
	public float getSkill1HitboxDelay() {
		return skill1HitboxDelay;
	}
	
	public float getSkill2HitboxDelay() {
		return skill2HitboxDelay;
	}

	public float getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(float maxHP) {
		Sabo.maxHP = maxHP;
	}

	public float getMaxMP() {
		return maxMP;
	}

	public void setMaxMP(float maxMP) {
		Sabo.maxMP = maxMP;
	}

	public float getAtkPower() {
		return atkPower;
	}

	public void setAtkPower(float atkPower) {
		Sabo.atkPower = atkPower;
	}
	
	public float getSkill1Power() {
		return skill1Power;
	}
	
	public float getSkill2Power() {
		return skill2Power;
	}
	
	public float[] getSkillCooldown() {
		return skillCooldown;
	}

	public float getDefPower() {
		return defPower;
	}

	public void setDefPower(float defPower) {
		Sabo.defPower = defPower;
	}

	public int getCriticalChance() {
		return criticalChance;
	}

	public void setCriticalChance(int criticalChance) {
		Sabo.criticalChance = criticalChance;
	}

	@Override
	public float getHitboxPosXLeft() {
		return hitboxPosXLeft;
	}

	@Override
	public void setHitboxPosXLeft(float posXLeft) {
		this.hitboxPosXLeft = posXLeft;
	}

	@Override
	public float getHitboxPosXRight() {
		return hitboxPosXRight;
	}

	@Override
	public void setHitboxPosXRight(float posXRight) {
		this.hitboxPosXRight = posXRight;
	}

	@Override
	public float getHitboxPosY() {
		return hitboxPosY;
	}

	@Override
	public void setHitboxPosY(float posY) {
		this.hitboxPosY = posY;
	}

	@Override
	public float getSkillPosXLeft() {
		return skillPosXLeft;
	}

	@Override
	public void setSkillPosXLeft(float posXLeft) {
		this.skillPosXLeft = posXLeft;
	}

	@Override
	public float getSkillPosXRight() {
		return skillPosXRight;
	}

	@Override
	public void setSkillPosXRight(float posXRight) {
		this.skillPosXRight = posXRight;
	}
}
