package net.nbzero.outlive.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import net.nbzero.outlive.utils.PositionHandler;
import net.nbzero.outlive.utils.Utils;

public class GameScreenHUD {
	private static Rectangle p1PlayerBarBG1;
	private static Rectangle p1PlayerBarBG2;
	private static Rectangle p1BaseHPBar;
	private static Rectangle p1BaseMPBar;
	
	private static Rectangle p2PlayerBarBG1;
	private static Rectangle p2PlayerBarBG2;
	private static Rectangle p2BaseHPBar;
	private static Rectangle p2BaseMPBar;
	
	private static PositionHandler p1NameLabel;
	private static PositionHandler p2NameLabel;
	private static PositionHandler p1HPLabel;
	private static PositionHandler p2HPLabel;
	private static PositionHandler p1MPLabel;
	private static PositionHandler p2MPLabel;
	private static PositionHandler timerLabel;

	public static void load(){
		Utils.loadGameHUD();
		p1PlayerBarBG1 = new Rectangle(0, Gdx.graphics.getHeight()-130, 25, 130);
		p1PlayerBarBG2 = new Rectangle(30, Gdx.graphics.getHeight()-130, 330, 130);
		p1BaseHPBar = new Rectangle(60, Gdx.graphics.getHeight()*0.91f, 250, 20);
		p1BaseMPBar = new Rectangle(60, Gdx.graphics.getHeight()*0.86f, 250, 20);
		p2PlayerBarBG1 = new Rectangle(Gdx.graphics.getWidth()-25, Gdx.graphics.getHeight()-130, 25, 130);
		p2PlayerBarBG2 = new Rectangle(Gdx.graphics.getWidth()-360, Gdx.graphics.getHeight()-130, 330, 130);
		p2BaseHPBar = new Rectangle(Gdx.graphics.getWidth()-310, Gdx.graphics.getHeight()*0.91f, 250, 20);
		p2BaseMPBar = new Rectangle(Gdx.graphics.getWidth()-310, Gdx.graphics.getHeight()*0.86f, 250, 20);
		p1NameLabel = new PositionHandler(60, (Gdx.graphics.getHeight()*0.91f)+p1BaseHPBar.height);
		p2NameLabel = new PositionHandler(Gdx.graphics.getWidth()-310, (Gdx.graphics.getHeight()*0.91f)+p2BaseHPBar.height);
		p1HPLabel = new PositionHandler(p1BaseHPBar.width, Gdx.graphics.getHeight()*0.90f);
		p1MPLabel = new PositionHandler(p1BaseMPBar.width, Gdx.graphics.getHeight()*0.85f);
		p2HPLabel = new PositionHandler(Gdx.graphics.getWidth()-p2BaseMPBar.width*0.6f, Gdx.graphics.getHeight()*0.90f);
		p2MPLabel = new PositionHandler(Gdx.graphics.getWidth()-p2BaseMPBar.width*0.6f, Gdx.graphics.getHeight()*0.85f);
		timerLabel = new PositionHandler(Gdx.graphics.getWidth()*0.48f, Gdx.graphics.getHeight()*0.92f);
	}
	
	public static void drawHPBar(){
		
	}
	
	public static void drawMPBar(){
		
	}

	public static Rectangle getP1PlayerBarBG1() {
		return p1PlayerBarBG1;
	}

	public static Rectangle getP1PlayerBarBG2() {
		return p1PlayerBarBG2;
	}

	public static Rectangle getP1BaseHPBar() {
		return p1BaseHPBar;
	}

	public static Rectangle getP1BaseMPBar() {
		return p1BaseMPBar;
	}

	public static Rectangle getP2PlayerBarBG1() {
		return p2PlayerBarBG1;
	}

	public static Rectangle getP2PlayerBarBG2() {
		return p2PlayerBarBG2;
	}

	public static Rectangle getP2BaseHPBar() {
		return p2BaseHPBar;
	}

	public static Rectangle getP2BaseMPBar() {
		return p2BaseMPBar;
	}

	public static PositionHandler getP1NameLabel() {
		return p1NameLabel;
	}

	public static PositionHandler getP2NameLabel() {
		return p2NameLabel;
	}
	
	public static PositionHandler getP1HPLabel() {
		return p1HPLabel;
	}

	public static PositionHandler getP2HPLabel() {
		return p2HPLabel;
	}
	
	public static PositionHandler getP1MPLabel() {
		return p1MPLabel;
	}
	public static PositionHandler getP2MPLabel() {
		return p2MPLabel;
	}

	public static PositionHandler getTimerLabel() {
		return timerLabel;
	}

	public static void setTimerLabel(PositionHandler timerLabel) {
		GameScreenHUD.timerLabel = timerLabel;
	}
}
