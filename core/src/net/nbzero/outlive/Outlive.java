package net.nbzero.outlive;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import net.nbzero.outlive.resources.Assets;
import net.nbzero.outlive.screen.LogoScreen;

public class Outlive extends Game {
	public static Music bgm;
	@Override
	public void create () {
		// Load needed resources!
		Assets.LoadGlobalResources();
		setScreen(new LogoScreen());
	}
}
