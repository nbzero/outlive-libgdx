package net.nbzero.outlive.utils.screenutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

import net.nbzero.outlive.hud.GameScreenHUD;
import net.nbzero.outlive.screen.CharacterSelectScreen;
import net.nbzero.outlive.screen.GameScreen;
import net.nbzero.outlive.utils.Utils;

public class GameScreenRenderUtils {
	
	public static Label player1HPLabel;
	public static Label player2HPLabel;
	public static Label player1MPLabel;
	public static Label player2MPLabel;
	public static Label p1Skill1CDLabel;
	public static Label p1Skill2CDLabel;
	public static Label p2Skill1CDLabel;
	public static Label p2Skill2CDLabel;
	public static Label p1Skill1Label;
	public static Label p1Skill2Label;
	public static Label p2Skill1Label;
	public static Label p2Skill2Label;
	public static Label timerLabel;
	public static Label player1Label;
	public static Label player2Label; 
	public static Label winner20Label;
	public static Label winner10Label;
	
	public static void renderDebugMode(){
		if(GameScreen.debugMode){
			GameScreen.shapeRenderer.begin(ShapeType.Line);
			GameScreen.shapeRenderer.setColor(1, 1, 0, 1);
			GameScreen.shapeRenderer.rect(GameScreen.player1.getHitbox().getX(), GameScreen.player1.getHitbox().getY(), GameScreen.player1.getHitbox().width, GameScreen.player1.getHitbox().height);
			GameScreen.shapeRenderer.rect(GameScreen.player2.getHitbox().getX(), GameScreen.player2.getHitbox().getY(), GameScreen.player2.getHitbox().width, GameScreen.player2.getHitbox().height);
			GameScreen.shapeRenderer.setColor(1, 0, 0, 0);
			GameScreen.shapeRenderer.rect(GameScreen.player1.getAttackBox().getX(), GameScreen.player1.getAttackBox().getY(), GameScreen.player1.getAttackBox().getWidth(), GameScreen.player1.getAttackBox().getHeight());
			GameScreen. shapeRenderer.rect(GameScreen.player1.getAttackBox2().getX(), GameScreen.player1.getAttackBox2().getY(), GameScreen.player1.getAttackBox2().getWidth(), GameScreen.player1.getAttackBox2().getHeight());
			GameScreen.shapeRenderer.rect(GameScreen.player1.getAttackBox3().getX(), GameScreen.player1.getAttackBox3().getY(), GameScreen.player1.getAttackBox3().getWidth(), GameScreen.player1.getAttackBox3().getHeight());
			GameScreen.shapeRenderer.rect(GameScreen.player1.getSkill1Box().getX(), GameScreen.player1.getSkill1Box().getY(), GameScreen.player1.getSkill1Box().getWidth(), GameScreen.player1.getSkill1Box().getHeight());
			GameScreen.shapeRenderer.rect(GameScreen.player1.getSkill2Box().getX(), GameScreen.player1.getSkill2Box().getY(), GameScreen.player1.getSkill2Box().getWidth(), GameScreen.player1.getSkill2Box().getHeight());
			GameScreen.shapeRenderer.rect(GameScreen.player2.getAttackBox().getX(), GameScreen.player2.getAttackBox().getY(), GameScreen.player2.getAttackBox().getWidth(), GameScreen.player2.getAttackBox().getHeight());
			GameScreen.shapeRenderer.rect(GameScreen.player2.getAttackBox2().getX(), GameScreen.player2.getAttackBox2().getY(), GameScreen.player2.getAttackBox2().getWidth(), GameScreen.player2.getAttackBox2().getHeight());
			GameScreen.shapeRenderer.rect(GameScreen.player2.getAttackBox3().getX(), GameScreen.player2.getAttackBox3().getY(), GameScreen.player2.getAttackBox3().getWidth(), GameScreen.player2.getAttackBox3().getHeight());
			GameScreen.shapeRenderer.rect(GameScreen.player2.getSkill1Box().getX(), GameScreen.player2.getSkill1Box().getY(), GameScreen.player2.getSkill1Box().getWidth(), GameScreen.player2.getSkill1Box().getHeight());
			GameScreen.shapeRenderer.rect(GameScreen.player2.getSkill2Box().getX(), GameScreen.player2.getSkill2Box().getY(), GameScreen.player2.getSkill2Box().getWidth(), GameScreen.player2.getSkill2Box().getHeight());
			GameScreen.shapeRenderer.end();
		}
	}
	
	public static void renderMatchFinished(){
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		GameScreen.shapeRenderer.begin(ShapeType.Filled);
		if(GameScreenUtils.deadTime*0.5f <= 0.7f){
			GameScreen.shapeRenderer.setColor(0, 0, 0, GameScreenUtils.deadTime*0.5f);
		}
		else{
			GameScreen.shapeRenderer.setColor(0, 0, 0, 0.7f);
		}
		GameScreen.shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		GameScreen.shapeRenderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
		
		winner10Label.setText("wins");
		
		fadeLabels();
		
		if(GameScreenUtils.deadTime<1){
			winner20Label.setColor(1, 1, 1, GameScreenUtils.deadTime);
			winner10Label.setColor(1, 1, 1, GameScreenUtils.deadTime);
			Utils.ButtonBG.setColor(1, 1, 1, GameScreenUtils.deadTime);
			Utils.exit.setColor(1, 1, 1, GameScreenUtils.deadTime);
			Utils.repick.setColor(1, 1, 1, GameScreenUtils.deadTime);
			Utils.rematch.setColor(1, 1, 1, GameScreenUtils.deadTime);
		}
		
		GameScreenUtils.pauseMenuChecker();
	}
	
	public static void fadeLabels(){
		timerLabel.setColor(1, 1, 1, 0.7f);
		p1Skill1Label.setColor(1, 1, 1, 0.7f);
		p1Skill2Label.setColor(1, 1, 1, 0.7f);
		p2Skill1Label.setColor(1, 1, 1, 0.7f);
		p2Skill2Label.setColor(1, 1, 1, 0.7f);
		p1Skill1CDLabel.setColor(1, 1, 1, 0.7f);
		p1Skill2CDLabel.setColor(1, 1, 1, 0.7f);
		p2Skill1CDLabel.setColor(1, 1, 1, 0.7f);
		p2Skill2CDLabel.setColor(1, 1, 1, 0.7f);
		player1HPLabel.setColor(1, 1, 1, 0.7f);
		player1MPLabel.setColor(1, 1, 1, 0.7f);
		player2HPLabel.setColor(1, 1, 1, 0.7f);
		player2MPLabel.setColor(1, 1, 1, 0.7f);
	}
	
	public static void unfadeLabels(){
		timerLabel.setColor(1, 1, 1, 1);
		p1Skill1Label.setColor(1, 1, 1, 1);
		p1Skill2Label.setColor(1, 1, 1, 1);
		p2Skill1Label.setColor(1, 1, 1, 1);
		p2Skill2Label.setColor(1, 1, 1, 1);
		p1Skill1CDLabel.setColor(1, 1, 1, 1);
		p1Skill2CDLabel.setColor(1, 1, 1, 1);
		p2Skill1CDLabel.setColor(1, 1, 1, 1);
		p2Skill2CDLabel.setColor(1, 1, 1, 1);
		player1HPLabel.setColor(1, 1, 1, 1);
		player1MPLabel.setColor(1, 1, 1, 1);
		player2HPLabel.setColor(1, 1, 1, 1);
		player2MPLabel.setColor(1, 1, 1, 1);
	}
	
	public static void renderHUD(){
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		GameScreen.shapeRenderer.begin(ShapeType.Filled);
		// BG
		GameScreen.shapeRenderer.setColor(new Color(1, 1, 1, 0.75f));
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP1PlayerBarBG1().getX(), GameScreenHUD.getP1PlayerBarBG1().getY(),
				GameScreenHUD.getP1PlayerBarBG1().getWidth(), GameScreenHUD.getP1PlayerBarBG1().getHeight());
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP1PlayerBarBG2().getX(), GameScreenHUD.getP1PlayerBarBG2().getY(),
				GameScreenHUD.getP1PlayerBarBG2().getWidth(), GameScreenHUD.getP1PlayerBarBG2().getHeight());
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP2PlayerBarBG1().getX(), GameScreenHUD.getP2PlayerBarBG1().getY(),
				GameScreenHUD.getP2PlayerBarBG1().getWidth(), GameScreenHUD.getP2PlayerBarBG1().getHeight());
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP2PlayerBarBG2().getX(), GameScreenHUD.getP2PlayerBarBG2().getY(),
				GameScreenHUD.getP2PlayerBarBG2().getWidth(), GameScreenHUD.getP2PlayerBarBG2().getHeight());
		// Base HP, MP
		GameScreen.shapeRenderer.setColor(0, 0, 0, 1);
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP1BaseHPBar().getX(), GameScreenHUD.getP1BaseHPBar().getY(),
				GameScreenHUD.getP1BaseHPBar().getWidth(), GameScreenHUD.getP1BaseHPBar().getHeight());
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP1BaseMPBar().getX(), GameScreenHUD.getP1BaseMPBar().getY(),
				GameScreenHUD.getP1BaseMPBar().getWidth(), GameScreenHUD.getP1BaseMPBar().getHeight());
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP2BaseHPBar().getX(), GameScreenHUD.getP2BaseHPBar().getY(),
				GameScreenHUD.getP2BaseHPBar().getWidth(), GameScreenHUD.getP2BaseHPBar().getHeight());
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP2BaseMPBar().getX(), GameScreenHUD.getP2BaseMPBar().getY(),
				GameScreenHUD.getP2BaseMPBar().getWidth(), GameScreenHUD.getP2BaseMPBar().getHeight());
		// Dynamic HP, MP
		GameScreen.shapeRenderer.setColor(0.54f, 0.71f, 0.18f, 1);
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP1BaseHPBar().getX(), GameScreenHUD.getP1BaseHPBar().getY(),
				GameScreen.player1.getPlayer().getHPPercentage()*250, GameScreenHUD.getP1BaseHPBar().getHeight());
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP2BaseHPBar().getX(), GameScreenHUD.getP2BaseHPBar().getY(),
				GameScreen.player2.getPlayer().getHPPercentage()*250, GameScreenHUD.getP2BaseHPBar().getHeight());
		GameScreen.shapeRenderer.setColor(0.22f, 0.63f, 0.65f, 1);
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP1BaseMPBar().getX(), GameScreenHUD.getP1BaseMPBar().getY(),
				GameScreen.player1.getPlayer().getMPPercentage()*250, GameScreenHUD.getP1BaseMPBar().getHeight());
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP2BaseMPBar().getX(), GameScreenHUD.getP2BaseMPBar().getY(),
				GameScreen.player2.getPlayer().getMPPercentage()*250, GameScreenHUD.getP2BaseMPBar().getHeight());
		// Skill Cooldown
		GameScreen.shapeRenderer.setColor(1, 1, 1, 0.8f);
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP1Skill1Bar().getX(), GameScreenHUD.getP1Skill1Bar().getY(),
				GameScreenHUD.getP1Skill1Bar().getWidth(), GameScreenHUD.getP1Skill1Bar().getHeight());
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP1Skill2Bar().getX(), GameScreenHUD.getP1Skill2Bar().getY(),
				GameScreenHUD.getP1Skill2Bar().getWidth(), GameScreenHUD.getP1Skill2Bar().getHeight());
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP2Skill1Bar().getX(), GameScreenHUD.getP2Skill1Bar().getY(),
				GameScreenHUD.getP2Skill1Bar().getWidth(), GameScreenHUD.getP2Skill1Bar().getHeight());
		GameScreen.shapeRenderer.rect(GameScreenHUD.getP2Skill2Bar().getX(), GameScreenHUD.getP2Skill2Bar().getY(),
				GameScreenHUD.getP2Skill2Bar().getWidth(), GameScreenHUD.getP2Skill2Bar().getHeight());
		GameScreen.shapeRenderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
		player1HPLabel.setText((int) GameScreen.player1.getPlayer().getHp()+"/"+(int) GameScreen.player1.getPlayer().getMaxHP());
		player1MPLabel.setText((int) GameScreen.player1.getPlayer().getMp()+"/"+(int) GameScreen.player1.getPlayer().getMaxMP());
		player2HPLabel.setText((int) GameScreen.player2.getPlayer().getHp()+"/"+(int) GameScreen.player2.getPlayer().getMaxHP());
		player2MPLabel.setText((int) GameScreen.player2.getPlayer().getMp()+"/"+(int) GameScreen.player2.getPlayer().getMaxMP());
		if(GameScreen.player1.getPlayer().getSkill1CDTime() >= GameScreen.player1.getPlayer().getSkillCD(0)){
			p1Skill1CDLabel.setText("Ready");
			p1Skill1CDLabel.setFontScale(1);
		}
		else{
			p1Skill1CDLabel.setText(String.valueOf((int) GameScreen.player1.getPlayer().getSkill1CDTime()+1));
			p1Skill1CDLabel.setFontScale(1.5f);
		}
		if(GameScreen.player1.getPlayer().getSkill2CDTime() >= GameScreen.player1.getPlayer().getSkillCD(1)){
			p1Skill2CDLabel.setText("Ready");
			p1Skill2CDLabel.setFontScale(1);
		}
		else{
			p1Skill2CDLabel.setText(String.valueOf((int) GameScreen.player1.getPlayer().getSkill2CDTime()+1));
			p1Skill2CDLabel.setFontScale(1.5f);
		}
		if(GameScreen.player2.getPlayer().getSkill1CDTime() >= GameScreen.player2.getPlayer().getSkillCD(0)){
			p2Skill1CDLabel.setText("Ready");
			p2Skill1CDLabel.setFontScale(1);
		}
		else{
			p2Skill1CDLabel.setText(String.valueOf((int) GameScreen.player2.getPlayer().getSkill1CDTime()+1));
			p2Skill1CDLabel.setFontScale(1.5f);
		}
		if(GameScreen.player2.getPlayer().getSkill2CDTime() >= GameScreen.player2.getPlayer().getSkillCD(1)){
			p2Skill2CDLabel.setText("Ready");
			p2Skill2CDLabel.setFontScale(1);
		}
		else{
			p2Skill2CDLabel.setText(String.valueOf((int) GameScreen.player2.getPlayer().getSkill2CDTime()+1));
			p2Skill2CDLabel.setFontScale(1.5f);
		}
		timerLabel.setText(String.valueOf((int) GameScreenUtils.trackTime));
	}
	
	public static void renderPauseScreen(){
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		GameScreen.shapeRenderer.begin(ShapeType.Filled);
		GameScreen.shapeRenderer.setColor(0, 0, 0, 0.7f);
		GameScreen.shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		GameScreen.shapeRenderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
		
		fadeLabels();
		
		winner20Label.setColor(1, 1, 1, 1);
		winner10Label.setColor(1, 1, 1, 1);
		Utils.ButtonBG.setColor(1, 1, 1, 1);
		Utils.exit.setColor(1, 1, 1, 1);
		Utils.repick.setColor(1, 1, 1, 1);
		Utils.rematch.setColor(1, 1, 1, 1);
		
		GameScreenUtils.pauseMenuChecker();
	}
	
	public static void initialHUD(){
		// HUD
		player1Label = new Label(CharacterSelectScreen.p1Char + " (P1)", Utils.gameScreenSkin, "imagineFontPlayer", Color.BLACK);
		player2Label = new Label(CharacterSelectScreen.p2Char + " (P2)", Utils.gameScreenSkin, "imagineFontPlayer", Color.BLACK);
		player1Label.setPosition(GameScreenHUD.getP1NameLabel().getX(), GameScreenHUD.getP1NameLabel().getY());
		player2Label.setPosition(GameScreenHUD.getP2NameLabel().getX(), GameScreenHUD.getP2NameLabel().getY());
		
		player1HPLabel = new Label((int) GameScreen.player1.getPlayer().getHp()+"/"+(int) GameScreen.player1.getPlayer().getMaxHP(), Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		player1MPLabel = new Label((int) GameScreen.player1.getPlayer().getMp()+"/"+(int) GameScreen.player1.getPlayer().getMaxMP(), Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		player2HPLabel = new Label((int) GameScreen.player2.getPlayer().getHp()+"/"+(int) GameScreen.player2.getPlayer().getMaxHP(), Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		player2MPLabel = new Label((int) GameScreen.player2.getPlayer().getMp()+"/"+(int) GameScreen.player2.getPlayer().getMaxMP(), Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		player1HPLabel.setPosition(GameScreenHUD.getP1HPLabel().getX(), GameScreenHUD.getP1HPLabel().getY());
		player1MPLabel.setPosition(GameScreenHUD.getP1MPLabel().getX(), GameScreenHUD.getP1MPLabel().getY());
		player2HPLabel.setPosition(GameScreenHUD.getP2HPLabel().getX(), GameScreenHUD.getP2HPLabel().getY());
		player2MPLabel.setPosition(GameScreenHUD.getP2MPLabel().getX(), GameScreenHUD.getP2MPLabel().getY());
		
		p1Skill1CDLabel = new Label("Ready", Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		p1Skill2CDLabel = new Label("Ready", Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		p2Skill1CDLabel = new Label("Ready", Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		p2Skill2CDLabel = new Label("Ready", Utils.gameScreenSkin, "imagineFontHpMp", Color.WHITE);
		p1Skill1Label = new Label("Skill1", Utils.gameScreenSkin, "imagineFontSkillName", Color.WHITE);
		p1Skill2Label = new Label("Skill2", Utils.gameScreenSkin, "imagineFontSkillName", Color.WHITE);
		p2Skill1Label = new Label("Skill1", Utils.gameScreenSkin, "imagineFontSkillName", Color.WHITE);
		p2Skill2Label = new Label("Skill2", Utils.gameScreenSkin, "imagineFontSkillName", Color.WHITE);
		p1Skill1CDLabel.setPosition(GameScreenHUD.getP1Skill1CDLabelPos().getX(), GameScreenHUD.getP1Skill1LabelPos().getY());
		p1Skill2CDLabel.setPosition(GameScreenHUD.getP1Skill2CDLabelPos().getX(), GameScreenHUD.getP1Skill2LabelPos().getY());
		p2Skill1CDLabel.setPosition(GameScreenHUD.getP2Skill1CDLabelPos().getX(), GameScreenHUD.getP2Skill1LabelPos().getY());
		p2Skill2CDLabel.setPosition(GameScreenHUD.getP2Skill2CDLabelPos().getX(), GameScreenHUD.getP2Skill2LabelPos().getY());
		p1Skill1Label.setPosition(GameScreenHUD.getP1Skill1LabelPos().getX(), GameScreenHUD.getP1Skill1LabelPos().getY());
		p1Skill2Label.setPosition(GameScreenHUD.getP1Skill2LabelPos().getX(), GameScreenHUD.getP1Skill2LabelPos().getY());
		p2Skill1Label.setPosition(GameScreenHUD.getP2Skill1LabelPos().getX(), GameScreenHUD.getP2Skill1LabelPos().getY());
		p2Skill2Label.setPosition(GameScreenHUD.getP2Skill2LabelPos().getX(), GameScreenHUD.getP2Skill2LabelPos().getY());
		p1Skill1CDLabel.setAlignment(Align.center);
		p1Skill2CDLabel.setAlignment(Align.center);
		p2Skill1CDLabel.setAlignment(Align.center);
		p2Skill2CDLabel.setAlignment(Align.center);
		
		timerLabel = new Label(String.valueOf((int) GameScreenUtils.trackTime), Utils.gameScreenSkin, "imagineFontTimer", Color.WHITE);
		timerLabel.setPosition(GameScreenHUD.getTimerLabel().getX(), GameScreenHUD.getTimerLabel().getY());
		
		// Pause & Victory
		winner20Label = new Label("GameScreenUtils.paused", Utils.victorySkin, "winner20", Color.WHITE);
		winner10Label = new Label("", Utils.victorySkin, "winner10", Color.WHITE);
		winner20Label.setPosition(Gdx.graphics.getWidth()*0.4f, Gdx.graphics.getHeight()*0.8f);
		winner10Label.setPosition(Gdx.graphics.getWidth()*0.5f, Gdx.graphics.getHeight()*0.75f);
		Utils.ButtonBG.setPosition((Gdx.graphics.getWidth()*0.5f)-Utils.ButtonBG.getWidth()*0.5f, (Gdx.graphics.getHeight()*0.5f)-Utils.ButtonBG.getHeight()*0.5f);
		Utils.exit.setPosition(Utils.ButtonBG.getX(), Utils.ButtonBG.getY()+Utils.exit.getHeight()*0.35f);
		Utils.rematch.setSize(256, 112);
		Utils.rematch.setPosition(Utils.ButtonBG.getX()+Utils.ButtonBG.getWidth()*0.2f, Gdx.graphics.getHeight()*0.57f);
		Utils.rematch.setChecked(true);
		Utils.repick.setSize(256, 112);
		Utils.repick.setPosition(Gdx.graphics.getWidth()*0.45f, Gdx.graphics.getHeight()*0.46f);
		winner20Label.setColor(1, 1, 1, 0);
		winner10Label.setColor(1, 1, 1, 0);
		Utils.ButtonBG.setColor(1, 1, 1, 0);
		Utils.exit.setColor(1, 1, 1, 0);
		Utils.repick.setColor(1, 1, 1, 0);
		Utils.rematch.setColor(1, 1, 1, 0);
				
		GameScreen.stage.addActor(winner20Label);
		GameScreen.stage.addActor(winner10Label);
		GameScreen.stage.addActor(Utils.ButtonBG);
		GameScreen.stage.addActor(Utils.exit);
		GameScreen.stage.addActor(Utils.repick);
		GameScreen.stage.addActor(Utils.rematch);
		GameScreen.stage.addActor(player1Label);
		GameScreen.stage.addActor(player2Label);
		GameScreen.stage.addActor(player1HPLabel);
		GameScreen.stage.addActor(player1MPLabel);
		GameScreen.stage.addActor(player2HPLabel);
		GameScreen.stage.addActor(player2MPLabel);
		GameScreen.stage.addActor(p1Skill1CDLabel);
		GameScreen.stage.addActor(p1Skill2CDLabel);
		GameScreen.stage.addActor(p2Skill1CDLabel);
		GameScreen.stage.addActor(p2Skill2CDLabel);
		GameScreen.stage.addActor(p1Skill1Label);
		GameScreen.stage.addActor(p1Skill2Label);
		GameScreen.stage.addActor(p2Skill1Label);
		GameScreen.stage.addActor(p2Skill2Label);
		GameScreen.stage.addActor(timerLabel);
	}
}
