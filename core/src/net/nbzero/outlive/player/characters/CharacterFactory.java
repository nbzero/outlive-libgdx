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
			setAttackFrames2(getSprite(0, , 6, 9));
			setAttackFrames3(getSprite(0, 9, 6, 10));
			setSkill1Frames(getSprite(0, 10, 11, 11));
			setSkill2Frames(getSprite(0, 11, 7, 12));
			setAttackFrames2(getSprite(0, 8, 6, 9));