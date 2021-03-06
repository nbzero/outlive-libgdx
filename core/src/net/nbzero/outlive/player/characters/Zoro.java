	package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;

import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.utils.PositionHandler;

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
	private static Animation getHit;
	
	private static PositionHandler whiteSize = new PositionHandler(125, 20);
	private Rectangle defaultAttackBox = new Rectangle(-110, -150, 110, 150);
	private Rectangle defaultAttackBox2 = new Rectangle(-110, -130, 110, 130);
	private Rectangle defaultAttackBox3 = new Rectangle(-100, -80, 100, 80);
	private Rectangle defaultSkill1Box = new Rectangle(-140, -130, 140, 130);
	private Rectangle defaultSkill2Box = new Rectangle(-120, -180, 120, 180);
	private Rectangle defaultHitBox = new Rectangle(0, 0, 50, 90);
	
	private static float moveSpeed = 5f;
	private static float atkSpeed = 20f;
	private static float skill1Speed = 40f;
	private static float skill2Speed = 100f;
	private static float skill1HitboxDelay = 0.2f;
	private static float skill2HitboxDelay = 0.5f;
	private static String nameCharacter = "Zoro";
	private static float[] skillCooldown = {4f, 6f};
	
	private static float maxHP = 150;
	private static float maxMP = 100;
	private static float atkPower = 12;
	private static float skill1Power = 20;
	private static float skill2Power = 30;
	private static float skill1MP = 20;
	private static float skill2MP = 30;
	private static float defPower = 0.7f;
	private static int criticalChance = 12;
	
	private static float offsetX = -60f;
	private static float offsetX2 = -60f;
	private static float offsetX3 = -30f;
	private static float offsetX4 = 0f;
	private static float offsetX5 = 0f;
	private static float offsetX6 = 0f;
	private static float offsetY = -50f;
	private static float offsetY2 = 0f;
	private static float offsetY3 = -50f;
	private static float offsetY4 = 0f;
	private static float offsetY5 = -70f;
	private static float offsetY6 = 0f;
	
	private static Sound atk1 = Gdx.audio.newSound(Gdx.files.internal("sound/SFX/sword1.mp3"));
	private static Sound atk2 = Gdx.audio.newSound(Gdx.files.internal("sound/SFX/sword3.mp3"));
	private static Sound atk3 = Gdx.audio.newSound(Gdx.files.internal("sound/SFX/sword1.mp3"));
	private static Sound skill1 = Gdx.audio.newSound(Gdx.files.internal("sound/SFX/Zoro_skill1.mp3"));
	private static Sound skill2 = Gdx.audio.newSound(Gdx.files.internal("sound/SFX/Zoro_skill2.mp3"));
	
	
	public Zoro(PlayerData playerData){
		super(playerData, new PositionHandler(50, 90));
		setAttackBox(new Rectangle(defaultAttackBox.x, defaultAttackBox.y, defaultAttackBox.width, defaultAttackBox.height));
		setAttackBox2(new Rectangle(defaultAttackBox2.x, defaultAttackBox2.y, defaultAttackBox2.width, defaultAttackBox2.height));
		setAttackBox3(new Rectangle(defaultAttackBox3.x, defaultAttackBox3.y, defaultAttackBox3.width, defaultAttackBox3.height));
		setSkill1Box(new Rectangle(defaultSkill1Box.x, defaultSkill1Box.y, defaultSkill1Box.width, defaultSkill1Box.height));
		setSkill2Box(new Rectangle(defaultSkill2Box.x, defaultSkill2Box.y, defaultSkill2Box.width, defaultSkill2Box.height));
		setHitbox(new Rectangle(playerData.getPos().getX()+whiteSize.getX(), playerData.getPos().getY()+whiteSize.getY(), defaultHitBox.getWidth(), defaultHitBox.getHeight()));
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
	
	@Override
	protected Animation drawGetHit() {
		return new Animation(1f/8f, CharacterFactory.Zoro.getGetHitFrames());
	}
	
	public Animation getGetHit(){
		return Zoro.getHit;
	}
	
	public Animation getDefending(){
		return Zoro.defending;
	}
	
	public void setWhiteSize(PositionHandler whiteSize){
		Zoro.whiteSize = new PositionHandler(whiteSize);
	}
	
	public PositionHandler getWhiteSize(){
		return Zoro.whiteSize;
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
		Zoro.maxHP = maxHP;
	}

	public float getMaxMP() {
		return maxMP;
	}

	public void setMaxMP(float maxMP) {
		Zoro.maxMP = maxMP;
	}

	public float getAtkPower() {
		return atkPower;
	}

	public void setAtkPower(float atkPower) {
		Zoro.atkPower = atkPower;
	}
	
	public float getSkill1Power() {
		return skill1Power;
	}
	
	public float getSkill2Power() {
		return skill2Power;
	}
	
	public float getSkill1MP() {
		return skill1MP;
	}

	public float getSkill2MP() {
		return skill2MP;
	}

	public float[] getSkillCooldown() {
		return skillCooldown;
	}

	public float getDefPower() {
		return defPower;
	}

	public void setDefPower(float defPower) {
		Zoro.defPower = defPower;
	}

	public int getCriticalChance() {
		return criticalChance;
	}

	public void setCriticalChance(int criticalChance) {
		Zoro.criticalChance = criticalChance;
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
	
	public float getOffsetX(){
		return offsetX;
	}
	
	public float getOffsetX2(){
		return offsetX2;
	}
	
	public float getOffsetX3(){
		return offsetX3;
	}
	
	public float getOffsetX4(){
		return offsetX4;
	}
	
	public float getOffsetX5(){
		return offsetX5;
	}
	
	public float getOffsetX6(){
		return offsetX6;
	}
	
	public float getOffsetY(){
		return offsetY;
	}
	
	public float getOffsetY2(){
		return offsetY2;
	}
	
	public float getOffsetY3(){
		return offsetY3;
	}
	
	public float getOffsetY4(){
		return offsetY4;
	}
	
	public float getOffsetY5(){
		return offsetY5;
	}
	
	public float getOffsetY6(){
		return offsetY6;
	}
	
	public Sound getSoundAtk1(){
		return atk1;
	}
	
	public Sound getSoundAtk2(){
		return atk2;
	}
	
	public Sound getSoundAtk3(){
		return atk3;
	}
	
	public Sound getSoundSkill1(){
		return skill1;
	}

	public Sound getSoundSkill2() {
		return skill2;
	}
	
}
