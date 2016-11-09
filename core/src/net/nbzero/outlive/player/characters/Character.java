package net.nbzero.outlive.player.characters;

import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.positon.PositionHandler;

public class Character {
	// Player data
	protected PlayerData player;
	
	// Size
	protected PositionHandler size;
	
	// Protected
	
	// Constructors
	public Character(PlayerData playerData, PositionHandler size) {
		setPlayer(playerData);
		setSize(size);
	}
	
	public Character(PlayerData playerData){
		this(playerData, new PositionHandler(200,135));
	}

	public PlayerData getPlayer() {
		return player;
	}

	public void setPlayer(PlayerData player) {
		this.player = player;
	}

	public PositionHandler getSize() {
		return size;
	}

	public void setSize(PositionHandler size) {
		this.size = size;
	}
}
