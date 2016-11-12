package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;

import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.positon.PositionHandler;

abstract public class Character {
	// Player data
	protected PlayerData player;
	protected Rectangle hitbox;
	protected Rectangle fireballBox;
	protected Rectangle attackBox;
	protected Rectangle attackBox2;
	protected Rectangle attackBox3;
	protected Rectangle skill1Box;
	protected Rectangle skill2Box;
	protected float atkCount;
	
	protected float hitboxPosXLeft;
	protected float hitboxPosXRight;
	protected float hitboxPosY;
	protected float skillPosXLeft;
	protected float skillPosXRight;
	
	
	// Constructors	
	public Character(PlayerData playerData, PositionHandler size){
		playerData.setSize(size);
		playerData.setHp(this.getMaxHP());
		playerData.setMp(this.getMaxMP());
		playerData.setSkillCD(this.getSkillCooldown());
		playerData.setSkill1Ready(true);
		playerData.setSkill2Ready(true);
		setPlayer(playerData);
		setAtkCount(0);
	}

	public PlayerData getPlayer() {
		return player;
	}

	public final void setPlayer(PlayerData player) {
		this.player = player;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}

	public void setHitbox(Rectangle hitbox) {
		this.hitbox = new Rectangle(hitbox);
	}

	public void setAttackBox(Rectangle attackBox) {
		this.attackBox = attackBox;
	}

	public void setAttackBox2(Rectangle attackBox2) {
		this.attackBox2 = attackBox2;
	}
	public void setAttackBox3(Rectangle attackBox3) {
		this.attackBox3 = attackBox3;
	}
	public Rectangle getAttackBox() {
		return attackBox;
	}
	public Rectangle getAttackBox2() {
		return attackBox2;
	}
	public Rectangle getAttackBox3() {
		return attackBox3;
	}
	public Rectangle getSkill1Box() {
		return skill1Box;
	}

	public void setSkill1Box(Rectangle skill1Box) {
		this.skill1Box = skill1Box;
	}

	public Rectangle getSkill2Box() {
		return skill2Box;
	}

	public void setSkill2Box(Rectangle skill2Box) {
		this.skill2Box = skill2Box;
	}
	
	public void moveX(float playerPos, float hitboxPos, float toMove){
		this.getPlayer().getPos().setX(playerPos+toMove);
		this.getHitbox().setX(hitboxPos+toMove);
	}
	
	public void moveY(float playerPos, float hitboxPos, float toMove){
		this.getPlayer().getPos().setY(playerPos+toMove);
		this.getHitbox().setY(hitboxPos+toMove);
	}
	
	public void setAtkCount(float num){
		this.atkCount = num;
	}
	
	public float getAtkCount(){
		return atkCount;
	}

	protected abstract Animation drawStanding();
	protected abstract Animation drawRunning();
	protected abstract Animation drawAttacking();
	protected abstract Animation drawAttacking2();
	protected abstract Animation drawAttacking3();
	protected abstract Animation drawSkilling1();
	protected abstract Animation drawSkilling2();
	protected abstract Animation drawDefending();
	protected abstract Animation drawDashing();
	protected abstract Animation drawDead();
	protected abstract Animation drawGetHit();
	
	public abstract Animation getStanding();
	public abstract Animation getRunning();
	public abstract Animation getAttacking();
	public abstract Animation getAttacking2();
	public abstract Animation getAttacking3();
	public abstract Animation getSkilling1();
	public abstract Animation getSkilling2();
	public abstract Animation getDefending();
	public abstract Animation getDashing();
	public abstract Animation getDead();
	public abstract Animation getGetHit();
	public abstract String getNameCharacter();
	
	public abstract Rectangle getDefaultHitBox();
	public abstract Rectangle getDefaultAttackBox();
	public abstract Rectangle getDefaultAttackBox2();
	public abstract Rectangle getDefaultAttackBox3();
	public abstract Rectangle getDefaultSkill1Box();
	public abstract Rectangle getDefaultSkill2Box();
	
	public abstract float getMoveSpeed();
	public abstract float getAtkSpeed();
	public abstract float getSkill1Speed();
	public abstract float getSkill2Speed();
	public abstract float getSkill1HitboxDelay();
	public abstract float getSkill2HitboxDelay();
	
	public abstract float getMaxHP();
	public abstract void setMaxHP(float maxHP);
	public abstract float getMaxMP();
	public abstract void setMaxMP(float maxMP);
	public abstract float getAtkPower();
	public abstract void setAtkPower(float atkPower);
	public abstract float getSkill1Power();
	public abstract float getSkill2Power();
	public abstract float[] getSkillCooldown();
	public abstract float getDefPower();
	public abstract void setDefPower(float defPower);
	public abstract int getCriticalChance();
	public abstract void setCriticalChance(int CriticalChance);
	
	public abstract float getHitboxPosXLeft();
	public abstract void setHitboxPosXLeft(float posXLeft);
	public abstract float getHitboxPosXRight();
	public abstract void setHitboxPosXRight(float posXRight);
	public abstract float getHitboxPosY();
	public abstract void setHitboxPosY(float posY);
	public abstract float getSkillPosXLeft();
	public abstract void setSkillPosXLeft(float posXLeft);
	public abstract float getSkillPosXRight();
	public abstract void setSkillPosXRight(float posXRight);

	public abstract float getOffsetX();
	public abstract float getOffsetX2();
	public abstract float getOffsetX3();
	public abstract float getOffsetX4();
	public abstract float getOffsetX5();
	public abstract float getOffsetX6();
	public abstract float getOffsetY();
	public abstract float getOffsetY2();
	public abstract float getOffsetY3();
	public abstract float getOffsetY4();
	public abstract float getOffsetY5();
	public abstract float getOffsetY6();
}
