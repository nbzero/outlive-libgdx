package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;

import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.positon.PositionHandler;

abstract public class Character {
	// Player data
	protected PlayerData player;
	protected Rectangle hitbox;
	protected Rectangle attackBox;
	
	// Constructors	
	public Character(PlayerData playerData, PositionHandler size, PositionHandler whiteSize){
		playerData.setSize(size);
		setPlayer(playerData);
		setHitbox(new Rectangle(playerData.getPos().getX()+whiteSize.getX(), playerData.getPos().getY()+whiteSize.getY(), size.getX(), size.getY()));
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

	public Rectangle getAttackBox() {
		return attackBox;
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
	
	public abstract Rectangle getDefaultAttackBox();
}
