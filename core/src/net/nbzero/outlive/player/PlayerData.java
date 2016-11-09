package net.nbzero.outlive.player;

import net.nbzero.outlive.positon.PositionHandler;

public class PlayerData {
	
	// Basic info
	private float hp;
	private float mp;
	
	// Position
	private PositionHandler pos;
	private PositionHandler size;
	
	// Team ID
	private int team;
	
	// Skills
	private int[] skillCD;
	
	// Flip state
	private String flip;
	
	// Character states
	private boolean isDead;
	private boolean isRunning;
	private boolean isAttacking;
	private boolean isDefending;
	private boolean isHitable;
	private boolean hasControl;
	
	// Skills states
	private boolean isSkill1Ready;
	private boolean isSkill2Ready;
	
	// Input states
	private boolean isLeft;
	private boolean isRight;
	
	// Collision
	private boolean collideUp;
	private boolean collideDown;
	private boolean collideLeft;
	private boolean collideRight;
	
	public PlayerData(float maxHP, float maxMP, int team, PositionHandler pos, String flip) {
		// Basic Info
		setHp(maxHP);
		setMp(maxMP);
		
		// Position
		setPos(pos);
		setSize(new PositionHandler());
		
		// Team ID
		setTeam(team);
		
		// Flip
		setFlip(flip);
		
		// Character states
		setDead(false);
		setRunning(false);
		setAttacking(false);
		setDefending(false);
		setHitable(true);
		setHasControl(true);
		
		// Skills states
		setSkill1Ready(false);
		setSkill2Ready(false);
		
		// Input states
		setLeft(false);
		setRight(false);
		
		// Collision
		setCollideUp(false);
		setCollideDown(false);
		setCollideLeft(false);
		setCollideRight(false);
	}

	public float getHp() {
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

	public int[] getSkillCD() {
		return skillCD;
	}

	public void setSkillCD(int[] skillCD) {
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

	public boolean isHasControl() {
		return hasControl;
	}

	public void setHasControl(boolean hasControl) {
		this.hasControl = hasControl;
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

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
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
}
