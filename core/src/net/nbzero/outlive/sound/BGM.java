package net.nbzero.outlive.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public enum BGM {
	MainMenu(getBGM("Title.mp3")),
	Logo(getBGM("logo.mp3")),
	CharacterSelect(getBGM("CharacterSelect.mp3")),
	Battle1(getBGM("Battle1.mp3")),
	Battle2(getBGM("Battle2.mp3")),
	Battle3(getBGM("Battle3.mp3"));
	
	private static final float defaultVolume = 0.5f;
	
	private static float getDefaultvolume() {
		return defaultVolume;
	}

	private Music BGM;
	private float volume;
	
	private BGM(Music BGM, float volume){
		this.BGM = BGM;
		this.volume = volume;
	}
	
	private BGM(Music BGM){
		this(BGM, getDefaultvolume());
	}
	
	public Music getBGM(){
		return BGM;
	}
	
	public void play(){
		setVolume(volume);
		getBGM().play();
		getBGM().setLooping(true);
	}
	
	private static Music getBGM(String name) {
		return Gdx.audio.newMusic(Gdx.files.internal("sound/BGM/" + name));
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
		getBGM().setVolume(volume);
	}
	
}
