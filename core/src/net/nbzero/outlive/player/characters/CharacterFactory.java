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
			setDefenseFrames(getSprite(1, 1, 2, 2));
			setAttackFrames(getSprite(0, 7, 6, 8));
			setAttackFrames2(getSprite(0, 8, 6, 9));
			setAttackFrames3(getSprite(0, 9, 6, 10));
			setSkill1Frames(getSprite(0, 10, 13, 11));
			setSkill2Frames(getSprite(0, 11, 7, 12));
			setDashFrames(getSprite(1, 4, 2, 5));
			setDeadFrames(getSprite(0, 5, 4, 6));
			setGetHitFrames(getSprite(0, 6, 4, 7));
		}
	},
	Law() {
		@Override
		public Character getNew(PlayerData playerData){
			return new Law(playerData);
		}
		
		@Override
		public void loadSprite() {
			setStandFrames(getSprite(0, 0, 4, 1));
			setRunFrames(getSprite(0, 2, 6, 3));
			setDefenseFrames(getSprite(1, 1, 2, 2));
			setAttackFrames(getSprite(0, 7, 6, 8));
			setAttackFrames2(getSprite(0, 8, 6, 9));
			setAttackFrames3(getSprite(0, 9, 6, 10));
			setSkill1Frames(getSprite(0, 10, 13, 11));
			setSkill2Frames(getSprite(0, 11, 5, 12));
			setDashFrames(getSprite(1, 4, 2, 5));
			setDeadFrames(getSprite(0, 5, 4, 6));
			setGetHitFrames(getSprite(0, 6, 4, 7));
		}
	},
	Sanji() {
		@Override
		public Character getNew(PlayerData playerData){
			return new Sanji(playerData);
		}
		
		@Override
		public void loadSprite() {
			setStandFrames(getSprite(0, 0, 4, 1));
			setRunFrames(getSprite(0, 2, 6, 3));
			setDefenseFrames(getSprite(1, 1, 2, 2));
			setAttackFrames(getSprite(0, 7, 6, 8));
			setAttackFrames2(getSprite(0, 8, 6, 9));
			setAttackFrames3(getSprite(0, 9, 6, 10));
			setSkill1Frames(getSprite(0, 10, 12, 11));
			setSkill2Frames(getSprite(0, 11, 7, 12));
			setDashFrames(getSprite(1, 4, 2, 5));
			setDeadFrames(getSprite(0, 5, 4, 6));
			setGetHitFrames(getSprite(0, 6, 4, 7));
		}
	},
	Zoro() {
		@Override
		public Character getNew(PlayerData playerData){
			return new Zoro(playerData);
		}
		
		@Override
		public void loadSprite() {
			setStandFrames(getSprite(0, 0, 4, 1));
			setRunFrames(getSprite(0, 2, 6, 3));
			setDefenseFrames(getSprite(1, 1, 2, 2));
			setAttackFrames(getSprite(0, 7, 6, 8));
			setAttackFrames2(getSprite(0, 8, 5, 9));
			setAttackFrames3(getSprite(0, 9, 6, 10));
			setSkill1Frames(getSprite(0, 10, 13, 11));
			setSkill2Frames(getSprite(0, 11, 7, 12));
			setDashFrames(getSprite(1, 4, 2, 5));
			setDeadFrames(getSprite(0, 5, 4, 6));
			setGetHitFrames(getSprite(0, 6, 4, 7));
		}
	},
	Sabo() {
		@Override
		public Character getNew(PlayerData playerData){
			return new Sabo(playerData);
		}
		
		@Override
		public void loadSprite() {
			setStandFrames(getSprite(0, 0, 4, 1));
			setRunFrames(getSprite(0, 2, 6, 3));
			setDefenseFrames(getSprite(1, 1, 2, 2));
			setAttackFrames(getSprite(0, 7, 6, 8));
			setAttackFrames2(getSprite(0, 8, 6, 9));
			setAttackFrames3(getSprite(0, 9, 6, 10));
			setSkill1Frames(getSprite(0, 10, 12, 11));
			setSkill2Frames(getSprite(0, 11, 7, 12));
			setDashFrames(getSprite(1, 4, 2, 5));
			setDeadFrames(getSprite(0, 5, 4, 6));
			setGetHitFrames(getSprite(0, 6, 4, 7));
		}
	},
	Nami() {
		@Override
		public Character getNew(PlayerData playerData){
			return new Nami(playerData);
		}
		
		@Override
		public void loadSprite() {
			setStandFrames(getSprite(0, 0, 4, 1));
			setRunFrames(getSprite(0, 2, 6, 3));
			setDefenseFrames(getSprite(1, 1, 2, 2));
			setAttackFrames(getSprite(0, 7, 6, 8));
			setAttackFrames2(getSprite(0, 8, 6, 9));
			setAttackFrames3(getSprite(0, 9, 6, 10));
			setSkill1Frames(getSprite(0, 10, 13, 11));
			setSkill2Frames(getSprite(0, 11, 6, 12));
			setDashFrames(getSprite(1, 4, 2, 5));
			setDeadFrames(getSprite(0, 5, 4, 6));
			setGetHitFrames(getSprite(0, 6, 4, 7));
		}
	},
	Chopper() {
		@Override
		public Character getNew(PlayerData playerData){
			return new Chopper(playerData);
		}
		
		@Override
		public void loadSprite() {
			setStandFrames(getSprite(0, 0, 4, 1));
			setRunFrames(getSprite(0, 2, 6, 3));
			setDefenseFrames(getSprite(1, 1, 2, 2));
			setAttackFrames(getSprite(0, 7, 6, 8));
			setAttackFrames2(getSprite(0, 8, 5, 9));
			setAttackFrames3(getSprite(0, 9, 6, 10));
			setSkill1Frames(getSprite(0, 10, 12, 11));
			setSkill2Frames(getSprite(0, 11, 7, 12));
			setDashFrames(getSprite(1, 4, 2, 5));
			setDeadFrames(getSprite(0, 5, 4, 6));
			setGetHitFrames(getSprite(0, 6, 4, 7));
		}
	},
	Usopp() {
		@Override
		public Character getNew(PlayerData playerData){
			return new Usopp(playerData);
		}
		
		@Override
		public void loadSprite() {
			setStandFrames(getSprite(0, 0, 4, 1));
			setRunFrames(getSprite(0, 2, 6, 3));
			setDefenseFrames(getSprite(1, 1, 2, 2));
			setAttackFrames(getSprite(0, 7, 6, 8));
			setAttackFrames2(getSprite(0, 8, 6, 9));
			setAttackFrames3(getSprite(0, 9, 6, 10));
			setSkill1Frames(getSprite(0, 10, 13, 11));
			setSkill2Frames(getSprite(0, 11, 7, 12));
			setDashFrames(getSprite(1, 4, 2, 5));
			setDeadFrames(getSprite(0, 5, 4, 6));
			setGetHitFrames(getSprite(0, 6, 4, 7));
		}
	};
	
	// Sprite
	protected TextureRegion[][] sprite;
	protected TextureRegion[] standFrames, runFrames, dashFrames, attackFrames, defenseFrames, attackFrames2, attackFrames3, skill1Frames, skill2Frames, deadFrames, getHitFrames;
	
	protected void load() {
		initial();
		loadSprite();
	}

	protected void initial() {
		setSprite(TextureHandler.TextureSplit("spritesheet/" + name() + ".png", 300, 300, true));
	}
	
	public void setDeadFrames(TextureRegion[] deadFrames){
		this.deadFrames = deadFrames;
	}
	
	public TextureRegion[] getDeadFrames(){
		return deadFrames;
	}
	
	public void setSkill1Frames(TextureRegion[] skill1Frames){
		this.skill1Frames = skill1Frames;
	}
	
	public TextureRegion[] getSkill1Frames(){
		return skill1Frames;
	}
	
	public void setSkill2Frames(TextureRegion[] skill2Frames){
		this.skill2Frames = skill2Frames;
	}
	
	public TextureRegion[] getSkill2Frames(){
		return skill2Frames;
	}
	
	public void setDashFrames(TextureRegion[] dashFrames){
		this.dashFrames = dashFrames;
	}
	
	public TextureRegion[] getDashFrames(){
		return dashFrames;
	}
	
	public void setAttackFrames3(TextureRegion[] attackFrames3){
		this.attackFrames3 = attackFrames3;
	}
	
	public TextureRegion[] getAttackFrames3(){
		return attackFrames3;
	}
	
	public void setAttackFrames2(TextureRegion[] attackFrames2){
		this.attackFrames2 = attackFrames2;
	}
	
	public TextureRegion[] getAttackFrames2(){
		return attackFrames2;
	}
	
	public void setAttackFrames(TextureRegion[] attackFrames){
		this.attackFrames = attackFrames;
	}
	
	public TextureRegion[] getAttackFrames(){
		return attackFrames;
	}
	
	public void setDefenseFrames(TextureRegion[] defenseFrames){
		this.defenseFrames = defenseFrames;
	}
	
	public TextureRegion[] getDefenseFrames(){
		return defenseFrames;
	}

	public void setSprite(TextureRegion[][] sprite) {
		this.sprite = sprite;
	}
	
	public void setRunFrames(TextureRegion[] runFrames) {
		this.runFrames = runFrames;
	}

	public TextureRegion[] getRunFrames(){
		return runFrames;
	}
	
	public void setStandFrames(TextureRegion[] standFrames) {
		this.standFrames = standFrames;
	}
	
	public TextureRegion[] getStandFrames(){
		return standFrames;
	}
	
	public TextureRegion[] getGetHitFrames() {
		return getHitFrames;
	}

	public void setGetHitFrames(TextureRegion[] getHitFrames) {
		this.getHitFrames = getHitFrames;
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
