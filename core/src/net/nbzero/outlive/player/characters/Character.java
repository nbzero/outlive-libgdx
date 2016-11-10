package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;

import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.positon.PositionHandler;

abstract public class Character {
	// Player data
	protected PlayerData player;
	protected Rectangle hitbox;
	
	protected PositionHandler size;
	
	// Constructors	
	public Character(PlayerData playerData, PositionHandler size){
		setPlayer(playerData);
		setHitbox(new Rectangle(0, 0, size.getX(), size.getY()));
		
		setSize(size);
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

	protected abstract Animation drawStanding();
	protected abstract Animation drawRunning();
	protected abstract Animation drawAttacking();
	protected abstract Animation drawAttacking2();
	protected abstract Animation drawAttacking3();
	protected abstract Animation drawSkilling1();
	protected abstract Animation drawSkilling2();
	protected abstract Animation drawDefending();
	protected abstract Animation drawDashing();
	
	protected void setSize(PositionHandler size){
		this.size = new PositionHandler(size);
	}
	protected PositionHandler getSize(){
		return size;
	}
}
