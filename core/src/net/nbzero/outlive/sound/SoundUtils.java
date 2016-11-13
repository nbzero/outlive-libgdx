package net.nbzero.outlive.sound;

public class SoundUtils {
	public static float masterVolume = 0.1f;

	public static float getMasterVolume() {
		return masterVolume;
	}

	public static void setMasterVolume(float masterVolume) {
		SoundUtils.masterVolume = masterVolume;
	}
}
