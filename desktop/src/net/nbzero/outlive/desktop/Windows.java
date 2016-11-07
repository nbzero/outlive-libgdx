package net.nbzero.outlive.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Windows {
	private static LwjglApplicationConfiguration cfg;
	
	public static void Initialize(String name, boolean isFullscreen){
		cfg = new LwjglApplicationConfiguration();
		cfg.title = name;
		cfg.width = 1280;
		cfg.height = 720;
		cfg.resizable = false;
		cfg.fullscreen = isFullscreen;
		cfg.foregroundFPS = 60;
		cfg.backgroundFPS = 20;
	}
	
	public static LwjglApplicationConfiguration getCFG() {
		return cfg;
	}
}
