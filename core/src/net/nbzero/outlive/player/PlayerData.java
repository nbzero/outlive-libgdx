package net.nbzero.outlive.player;

import net.nbzero.outlive.utils.PositionHandler;

public class PlayerData {
	
	// Basic info
	private float hp;
	private float maxHP;
	private float mp;
	private float maxMP;
	
	// Position
	private PositionHandler pos;
	private PositionHandler size;
	
	// Team ID
	private int team;
	
	// Skills
	private float[] skillCD;
	
	// Flip state
	private String flip;
	
	// Character states
	private boolean isDead;
	private boolean isRunning;
	private boolean isAttacking;
	private boolean isDefending;
	private boolean isDashing;
	private boolean isHitable;
	private boolean isHitted;
	private boolean hasControl;
	private boolean isSkilling1;
	private boolean isSkilling2;
	
	// Skills states
	private boolean isSkill1Ready;
	private boolean isSkill2Ready;
	
	// Input states
	private boolean isRight;
	
	// Collision
	private boolean collideUp;
	private boolean collideDown;
	private boolean collideLeft;
	private boolean collideRight;
	
	// Times
	private float delayTime, attackTime, deadTime, skill1CDTime, skill2CDTime;
	
	public PlayerData(float maxHP, float maxMP, int team, PositionHandler pos, String flip) {
		// Basic Info
		setHp(maxHP);
		setMp(maxMP);
		
		// Position
		setPos(pos);
		setSize(size);
		
		// Team ID
		setTeam(team);
		
		// Flip
		if(flip.equalsIgnoreCase("right")){
			setRight(true);
		}
		else{
			setRight(false);
		}
		
		// Character states
		setDead(false);
		setRunning(false);
		setAttacking(false);
		setDefending(false);
		setHitable(true);
		setHitted(false);
		setHasControl(true);
		
		// Skills states
		setSkill1Ready(false);
		setSkill2Ready(false);
		
		// Collision
		setCollideUp(false);
		setCollideDown(false);
		setCollideLeft(false);
		setCollideRight(false);
	}

	public float getHp() {
		if(hp<=0)
			return 0;
		return hp;
	}
	public boolean hasNoHP() {
		return hp <= 0;
	}
	public boolean hasHP() {
		return !hasNoHP();
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public float getMp() {
		if(mp<=0)
			return 0;
		return mp;
	}
	public boolean hasNoMP() {
		return mp <= 0;
	}
	public boolean hasMP() {
		return !hasNoMP();
	}

	public void setMp(float mp) {
		this.mp = mp;
	}

	public float getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(float maxHP) {
		this.maxHP = maxHP;
	}

	public float getMaxMP() {
		return maxMP;
	}

	public void setMaxMP(float maxMP) {
		this.maxMP = maxMP;
	}

	public PositionHandler getPos() {
		return pos;
	}

	public void setPos(PositionHandler pos) {
		this.pos = pos;
	}

	public PositionHandler getSize() {
		return size;
	}

	public void setSize(PositionHandler size) {
		this.size = size;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public float getSkillCD(int num) {
		return skillCD[num];
	}

	public void setSkillCD(float[] skillCD) {
		this.skillCD = skillCD;
	}

	public String getFlip() {
		return flip;
	}

	public void setFlip(String flip) {
		this.flip = flip;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	public boolean isDashing(){
		return isDashing;
	}
	
	public void setDashing(boolean isDashing){
		this.isDashing = isDashing;
	}

	public boolean hasControl() {
		return hasControl;
	}

	public void setHasControl(boolean hasControl) {
		this.hasControl = hasControl;
	}
	
	public boolean isSkilling1(){
		return isSkilling1;
	}
	
	public void setSkilling1(boolean isSkilling1){
		this.isSkilling1 = isSkilling1;
	}

	public boolean isSkilling2(){
		return isSkilling2;
	}
	
	public void setSkilling2(boolean isSkilling2){
		this.isSkilling2 = isSkilling2;
	}
	
	public boolean isSkill1Ready() {
		return isSkill1Ready;
	}

	public void setSkill1Ready(boolean isSkill1Ready) {
		this.isSkill1Ready = isSkill1Ready;
	}

	public boolean isSkill2Ready() {
		return isSkill2Ready;
	}

	public void setSkill2Ready(boolean isSkill2Ready) {
		this.isSkill2Ready = isSkill2Ready;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isAttacking() {
		return isAttacking;
	}

	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}

	public boolean isDefending() {
		return isDefending;
	}

	public void setDefending(boolean isDefending) {
		this.isDefending = isDefending;
	}

	public boolean isHitable() {
		return isHitable;
	}

	public void setHitable(boolean isHitable) {
		this.isHitable = isHitable;
	}

	public boolean isHitted() {
		return isHitted;
	}

	public void setHitted(boolean isHitted) {
		this.isHitted = isHitted;
	}

	public boolean isHasControl() {
		return hasControl;
	}

	public boolean isCollideUp() {
		return collideUp;
	}

	public void setCollideUp(boolean collideUp) {
		this.collideUp = collideUp;
	}

	public boolean isCollideDown() {
		return collideDown;
	}

	public void setCollideDown(boolean collideDown) {
		this.collideDown = collideDown;
	}

	public boolean isCollideLeft() {
		return collideLeft;
	}

	public void setCollideLeft(boolean collideLeft) {
		this.collideLeft = collideLeft;
	}

	public boolean isCollideRight() {
		return collideRight;
	}

	public void setCollideRight(boolean collideRight) {
		this.collideRight = collideRight;
	}

	public float getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(float delayTime) {
		this.delayTime = delayTime;
	}

	public float getAttackTime() {
		return attackTime;
	}

	public void setAttackTime(float attackTime) {
		this.attackTime = attackTime;
	}

	public float getDeadTime() {
		return deadTime;
	}

	public void setDeadTime(float deadTime) {
		this.deadTime = deadTime;
	}

	public float getSkill1CDTime() {
		return skill1CDTime;
	}

	public void setSkill1CDTime(float skill1CDTime) {
		this.skill1CDTime = skill1CDTime;
	}
	
	public float getSkill2CDTime() {
		return skill2CDTime;
	}

	public void setSkill2CDTime(float skill2CDTime) {
		this.skill2CDTime = skill2CDTime;
	}

	public float getHPPercentage() {
		if(this.hp<=0)
			return 0;
		return (this.hp/this.maxHP);
	}
	
	public float getMPPercentage() {
		if(this.mp<=0)
			return 0;
		return (this.mp/this.maxMP);
	}
}
