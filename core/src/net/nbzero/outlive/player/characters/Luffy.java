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
	private static Animation getHit;
	
	private static PositionHandler whiteSize = new PositionHandler(125, 20);
	private Rectangle defaultAttackBox = new Rectangle(-50, -70, 50, 70);
	private Rectangle defaultAttackBox2 = new Rectangle(-100, -100, 100, 100);
	private Rectangle defaultAttackBox3 = new Rectangle(-100, -100, 100, 100);
	private Rectangle defaultSkill1Box = new Rectangle(-140, -100, 140, 90);
	private Rectangle defaultSkill2Box = new Rectangle(-90, -80, 90, 80);
	private Rectangle defaultHitBox = new Rectangle(0, 0, 50, 90);
	
	private static float moveSpeed = 5f;
	private static float atkSpeed = 20f;
	private static float skill1Speed = 40f;
	private static float skill2Speed = 100f;
	private static float skill1HitboxDelay = 0.2f;
	private static float skill2HitboxDelay = 0.5f;
	private static String nameCharacter = "Luffy";
	private static float[] skillCooldown = {4f, 6f};
	
	private static float maxHP = 150;
	private static float maxMP = 100;
	private static float atkPower = 12;
	private static float skill1Power = 20;
	private static float skill2Power = 30;
	private static float defPower = 12;
	private static int criticalChance = 12;
	
	public Luffy(PlayerData playerData){
		super(playerData, new PositionHandler(50, 90));
		setAttackBox(new Rectangle(defaultAttackBox.x, defaultAttackBox.y, defaultAttackBox.width, defaultAttackBox.height));
		setAttackBox2(new Rectangle(defaultAttackBox2.x, defaultAttackBox2.y, defaultAttackBox2.width, defaultAttackBox2.height));
		setAttackBox3(new Rectangle(defaultAttackBox3.x, defaultAttackBox3.y, defaultAttackBox3.width, defaultAttackBox3.height));
		setSkill1Box(new Rectangle(defaultSkill1Box.x, defaultSkill1Box.y, defaultSkill1Box.width, defaultSkill1Box.height));
		setSkill2Box(new Rectangle(defaultSkill2Box.x, defaultSkill2Box.y, defaultSkill2Box.width, defaultSkill2Box.height));
		setHitbox(new Rectangle(playerData.getPos().getX()+whiteSize.getX(), playerData.getPos().getY()+whiteSize.getY(), defaultHitBox.getWidth(), defaultHitBox.getHeight()));
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
	
	public String getNameCharacter(){
		return nameCharacter;
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
	
	@Override
	protected Animation drawGetHit() {
		return new Animation(1f/8f, CharacterFactory.Luffy.getGetHitFrames());
	}
	
	public Animation getGetHit(){
		return Luffy.getHit;
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
		Luffy.maxHP = maxHP;
	}

	public float getMaxMP() {
		return maxMP;
	}

	public void setMaxMP(float maxMP) {
		Luffy.maxMP = maxMP;
	}

	public float getAtkPower() {
		return atkPower;
	}

	public void setAtkPower(float atkPower) {
		Luffy.atkPower = atkPower;
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
		Luffy.defPower = defPower;
	}

	public int getCriticalChance() {
		return criticalChance;
	}

	public void setCriticalChance(int criticalChance) {
		Luffy.criticalChance = criticalChance;
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
