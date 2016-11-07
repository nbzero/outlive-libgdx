package net.nbzero.outlive.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import net.nbzero.outlive.Outlive;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Windows.Initialize("Outlive", false);
		
		new LwjglApplication(new Outlive(), Windows.getCFG());
	}
}
