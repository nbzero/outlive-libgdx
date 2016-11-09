package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.Animation;

import net.nbzero.outlive.player.PlayerData;

abstract public class Character {
	// Player data
	protected PlayerData player;
	
	// Constructors	
	public Character(PlayerData playerData){
		setPlayer(playerData);
	}

	public PlayerData getPlayer() {
		return player;
	}

	public final void setPlayer(PlayerData player) {
		this.player = player;
	}
	
	protected abstract Animation drawStanding();
	protected abstract Animation drawRunning();
}
