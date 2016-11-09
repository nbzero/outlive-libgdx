package net.nbzero.outlive.player.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import net.nbzero.outlive.player.PlayerData;
import net.nbzero.outlive.utils.TextureHandler;

public enum CharacterFactory {
	
	Luffy() {
		@Override
		public Character getNew(PlayerData playerData){
			return new Luffy(playerData);
		}
		
		@Override
		public void loadSprite() {
			setStandFrames(getSprite(0, 0, 4, 1));
			setRunFrames(getSprite(0, 2, 6, 3));
		}
	};
	
	// Sprite
	protected TextureRegion[][] sprite;
	protected TextureRegion[] standFrames, runFrames, dashFrames, attackFrames, defenseFrames;
	
	protected void load() {
		initial();
		loadSprite();
	}

	protected void initial() {
		setSprite(TextureHandler.TextureSplit("spritesheet/" + name() + ".png", 300, 300, true));
	}

	public void setSprite(TextureRegion[][] sprite) {
		this.sprite = sprite;
	}
	
	public void setRunFrames(TextureRegion[] runFrames) {
		this.runFrames = runFrames;
	}

	public void setStandFrames(TextureRegion[] standFrames) {
		this.standFrames = standFrames;
	}
	
	public TextureRegion[] getStandFrames(){
		return standFrames;
	}
	
	public final TextureRegion[] getSprite(int sc, int sr, int fc, int fr){
		return TextureHandler.ApplyFrames(sc, sr, fc, fr, getSprite());
	}
	
	protected TextureRegion[][] getSprite() {
		return sprite;
	}
	
	public abstract Character getNew(PlayerData playerData);
	
	public abstract void loadSprite();
}
