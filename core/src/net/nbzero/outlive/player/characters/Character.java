package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;

import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.positon.PositionHandler;

abstract public class Character {
	// Player data
	protected PlayerData player;
	protected Rectangle hitbox;
	
	// Constructors	
	public Character(PlayerData playerData, PositionHandler size){
		setPlayer(playerData);
		setHitbox(new PositionHandler(),size);
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

	public void setHitbox(PositionHandler xy, PositionHandler size) {
		this.hitbox = new Rectangle(xy.getX(), xy.getY(), size.getX(), size.getY());
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
}
