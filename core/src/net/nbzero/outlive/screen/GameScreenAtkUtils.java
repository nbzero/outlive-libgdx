package net.nbzero.outlive.screen;

import net.nbzero.outlive.player.characters.Character;
import net.nbzero.outlive.utils.CollideHandler;

public class GameScreenAtkUtils {
	protected static void checkAtkHit(Character attacker, Character defender){
		if(attacker.getPlayer().isRight() && CollideHandler.checkCollide("Right", attacker.getAttackBox(), defender.getHitbox()) && defender.getPlayer().isHitable()){
			defender.getPlayer().setHasControl(false);
			defender.getPlayer().setHitted(true);
			defender.getPlayer().setHitable(false);
			defender.getPlayer().setAttacking(false);
			defender.getPlayer().setSkilling1(false);
			defender.getPlayer().setSkilling2(false);
			defender.getPlayer().setAttackTime(0);
			defender.getPlayer().setDelayTime(0);
		}
		else if(!attacker.getPlayer().isRight() && CollideHandler.checkCollide("Left", attacker.getAttackBox(), defender.getHitbox()) && defender.getPlayer().isHitable()){
			defender.getPlayer().setHasControl(false);
			defender.getPlayer().setHitted(true);
			defender.getPlayer().setHitable(false);
			defender.getPlayer().setAttacking(false);
			defender.getPlayer().setSkilling1(false);
			defender.getPlayer().setSkilling2(false);
			defender.getPlayer().setAttackTime(0);
			defender.getPlayer().setDelayTime(0);
		}
		if(attacker.getAttacking().isAnimationFinished(attacker.getPlayer().getAttackTime())){
			defender.getPlayer().setHitted(false);
			defender.getPlayer().setHitable(true);
			defender.getPlayer().setHasControl(true);
		}
	}
	
	protected static float getAtkTime(Character player, float attackTime){
		if(player.getAttacking().isAnimationFinished(attackTime)){
			return 0;
		}
		return attackTime;
	}
	
	protected static void checkSkill1Hit(Character attacker, Character defender){
		if(attacker.getPlayer().isRight() && CollideHandler.checkCollide("Right", attacker.getSkill1Box(), defender.getHitbox()) && defender.getPlayer().isHitable()){
			defender.getPlayer().setHasControl(false);
			defender.getPlayer().setHitted(true);
			defender.getPlayer().setHitable(false);
			defender.getPlayer().setAttacking(false);
			defender.getPlayer().setSkilling1(false);
			defender.getPlayer().setSkilling2(false);
			defender.getPlayer().setAttackTime(0);
			defender.getPlayer().setDelayTime(0);
		}
		else if(!attacker.getPlayer().isRight() && CollideHandler.checkCollide("Left", attacker.getSkill1Box(), defender.getHitbox()) && defender.getPlayer().isHitable()){
			defender.getPlayer().setHasControl(false);
			defender.getPlayer().setHitted(true);
			defender.getPlayer().setHitable(false);
			defender.getPlayer().setAttacking(false);
			defender.getPlayer().setSkilling1(false);
			defender.getPlayer().setSkilling2(false);
			defender.getPlayer().setAttackTime(0);
			defender.getPlayer().setDelayTime(0);
		}
		if(attacker.getSkilling1().isAnimationFinished(attacker.getPlayer().getDelayTime())){
			defender.getPlayer().setHitted(false);
			defender.getPlayer().setHitable(true);
			defender.getPlayer().setHasControl(true);
		}
	}
	
	protected static float getSkill1Time(Character player, float skillTime){
		if(player.getSkilling1().isAnimationFinished(player.getPlayer().getDelayTime())){
			return 0;
		}
		return skillTime;
	}
	
	protected static void checkSkill2Hit(Character attacker, Character defender){
		if(attacker.getPlayer().isRight() && CollideHandler.checkCollide("Right", attacker.getSkill2Box(), defender.getHitbox()) && defender.getPlayer().isHitable()){
			defender.getPlayer().setHasControl(false);
			defender.getPlayer().setHitted(true);
			defender.getPlayer().setHitable(false);
			defender.getPlayer().setAttacking(false);
			defender.getPlayer().setSkilling1(false);
			defender.getPlayer().setSkilling2(false);
			defender.getPlayer().setAttackTime(0);
			defender.getPlayer().setDelayTime(0);
		}
		else if(!attacker.getPlayer().isRight() && CollideHandler.checkCollide("Left", attacker.getSkill2Box(), defender.getHitbox()) && defender.getPlayer().isHitable()){
			defender.getPlayer().setHasControl(false);
			defender.getPlayer().setHitted(true);
			defender.getPlayer().setHitable(false);
			defender.getPlayer().setAttacking(false);
			defender.getPlayer().setSkilling1(false);
			defender.getPlayer().setSkilling2(false);
			defender.getPlayer().setAttackTime(0);
			defender.getPlayer().setDelayTime(0);
		}
		if(attacker.getSkilling2().isAnimationFinished(attacker.getPlayer().getDelayTime())){
			defender.getPlayer().setHitted(false);
			defender.getPlayer().setHitable(true);
			defender.getPlayer().setHasControl(true);
		}
	}
	
	protected static float getSkill2Time(Character player, float skillTime){
		if(player.getSkilling2().isAnimationFinished(player.getPlayer().getDelayTime())){
			return 0;
		}
		return skillTime;
	}
}
