package net.nbzero.outlive;

import com.badlogic.gdx.Game;

import net.nbzero.outlive.resources.Assets;
import net.nbzero.outlive.screen.LogoScreen;

public class Outlive extends Game {
	@Override
	public void create () {
		// Load needed resources!
		Assets.LoadGlobalResources();
		setScreen(new LogoScreen());
	}
}
