package net.nbzero.outlive.utils.screenutils;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import net.nbzero.outlive.screen.MainMenuScreen;
import net.nbzero.outlive.tween.ActorAccessor;
import net.nbzero.outlive.utils.Utils;

public class MainMenuUtils {
	// Select Button Checker
	public static void checkSelectButton(int selected){
		switch(selected){
		case 0:
			Utils.startButton.setChecked(true);
			Utils.tutorialButton.setChecked(false);
			break;
		case 1:
			Utils.startButton.setChecked(false);
			Utils.tutorialButton.setChecked(true);
			Utils.configButton.setChecked(false);
			break;
		case 2:
			Utils.tutorialButton.setChecked(false);
			Utils.configButton.setChecked(true);
			Utils.creditsButton.setChecked(false);
			break;
		case 3:
			Utils.configButton.setChecked(false);
			Utils.creditsButton.setChecked(true);
			Utils.exitButton.setChecked(false);
			break;
		case 4:
			Utils.creditsButton.setChecked(false);
			Utils.exitButton.setChecked(true);
			break;
		}
	}
	
	public static void fadeOutButton(){
		Timeline.createParallel().beginParallel()
		.push(Tween.set(Utils.startButton, ActorAccessor.ALPHA).target(1))
		.push(Tween.set(Utils.tutorialButton, ActorAccessor.ALPHA).target(1))
		.push(Tween.set(Utils.configButton, ActorAccessor.ALPHA).target(1))
		.push(Tween.set(Utils.creditsButton, ActorAccessor.ALPHA).target(1))
		.push(Tween.set(Utils.exitButton, ActorAccessor.ALPHA).target(1))
		.push(Tween.to(Utils.startButton, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
		.push(Tween.to(Utils.tutorialButton, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
		.push(Tween.to(Utils.configButton, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
		.push(Tween.to(Utils.creditsButton, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
		.push(Tween.to(Utils.exitButton, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
		.end().start(MainMenuScreen.tweenManager);
	}
	
	public static void fadeInButton(){
		Timeline.createSequence().beginSequence()
		.push(Tween.set(Utils.startButton, ActorAccessor.ALPHA).target(0))
		.push(Tween.set(Utils.tutorialButton, ActorAccessor.ALPHA).target(0))
		.push(Tween.set(Utils.configButton, ActorAccessor.ALPHA).target(0))
		.push(Tween.set(Utils.creditsButton, ActorAccessor.ALPHA).target(0))
		.push(Tween.set(Utils.exitButton, ActorAccessor.ALPHA).target(0))
		.push(Tween.to(Utils.startButton, ActorAccessor.ALPHA, Utils.FADE_TIME).target(1))
		.push(Tween.to(Utils.tutorialButton, ActorAccessor.ALPHA, Utils.FADE_TIME).target(1))
		.push(Tween.to(Utils.configButton, ActorAccessor.ALPHA, Utils.FADE_TIME).target(1))
		.push(Tween.to(Utils.creditsButton, ActorAccessor.ALPHA, Utils.FADE_TIME).target(1))
		.push(Tween.to(Utils.exitButton, ActorAccessor.ALPHA, Utils.FADE_TIME).target(1))
		.end().start(MainMenuScreen.tweenManager);
	}
	
	public static void fadeInConfig(){
		Timeline.createParallel().beginParallel()
		.push(Tween.set(MainMenuScreen.configTable, ActorAccessor.ALPHA).target(0))
		.push(Tween.to(MainMenuScreen.configTable, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(1))
		.end().start(MainMenuScreen.tweenManager);
	}
	
	public static void fadeOutConfig(){
		Timeline.createParallel().beginParallel()
		.push(Tween.set(MainMenuScreen.configTable, ActorAccessor.ALPHA).target(1))
		.push(Tween.to(MainMenuScreen.configTable, ActorAccessor.ALPHA, Utils.GLIDE_TIME).target(0))
		.end().start(MainMenuScreen.tweenManager);
	}
}
