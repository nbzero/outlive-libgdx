package net.nbzero.outlive.screen;

import com.badlogic.gdx.Gdx;

import net.nbzero.outlive.player.characters.Character;
import net.nbzero.outlive.utils.CollideHandler;

public class GameScreenAtkUtils {
	
	public static void checkAtkHit(Character attacker, Character defender){
		if(attacker.getPlayer().isRight() && CollideHandler.checkCollide("Right", attacker.getAttackBox(), defender.getHitbox())
				|| CollideHandler.checkCollide("Right", attacker.getAttackBox2(), defender.getHitbox())
				|| CollideHandler.checkCollide("Right", attacker.getAttackBox3(), defender.getHitbox())
				&& defender.getPlayer().isHitable()){
			defender.getPlayer().setHasControl(false);
			if(!defender.getPlayer().isHitted() && defender.getPlayer().isDefending()){
				defender.getPlayer().setHp(defender.getPlayer().getHp()-(attacker.getAtkPower()*defender.getDefPower()));
			}
			else if(!defender.getPlayer().isHitted()){
				defender.getPlayer().setHp(defender.getPlayer().getHp()-attacker.getAtkPower());
			}
			defender.getPlayer().setHitted(true);
			defender.getPlayer().setHitable(false);
			defender.getPlayer().setAttacking(false);
			defender.getPlayer().setSkilling1(false);
			defender.getPlayer().setSkilling2(false);
			defender.getPlayer().setAttackTime(0);
			defender.getPlayer().setDelayTime(0);
		}
		else if(!attacker.getPlayer().isRight() && CollideHandler.checkCollide("Left", attacker.getAttackBox(), defender.getHitbox()) 
				|| CollideHandler.checkCollide("Right", attacker.getAttackBox2(), defender.getHitbox())
				|| CollideHandler.checkCollide("Right", attacker.getAttackBox3(), defender.getHitbox())
				&& defender.getPlayer().isHitable()){
			if(!defender.getPlayer().isHitted()){
				defender.getPlayer().setHp(defender.getPlayer().getHp()-attacker.getAtkPower());
			}
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
	
	
	public static float getAtkTime(Character player, float attackTime){
		if(player.getAttacking().isAnimationFinished(attackTime)){
			return 0;
		}
		return attackTime;
	}
	
	public static void checkSkill1Hit(Character attacker, Character defender){
		if(attacker.getPlayer().isRight() && CollideHandler.checkCollide("Right", attacker.getSkill1Box(), defender.getHitbox()) && defender.getPlayer().isHitable()){
			if(!defender.getPlayer().isHitted() && defender.getPlayer().isDefending()){
				defender.getPlayer().setHp(defender.getPlayer().getHp()-(attacker.getSkill1Power()*defender.getDefPower()));
			}
			else if(!defender.getPlayer().isHitted()){
				defender.getPlayer().setHp(defender.getPlayer().getHp()-attacker.getSkill1Power());
			}
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
			if(!defender.getPlayer().isHitted() && defender.getPlayer().isDefending()){
				defender.getPlayer().setHp(defender.getPlayer().getHp()-(attacker.getSkill1Power()*defender.getDefPower()));
			}
			else if(!defender.getPlayer().isHitted()){
				defender.getPlayer().setHp(defender.getPlayer().getHp()-attacker.getSkill1Power());
			}
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
	
	public static float getSkill1Time(Character player, float skillTime){
		if(player.getSkilling1().isAnimationFinished(player.getPlayer().getDelayTime())){
			GameScreenAtkUtils.deceaseMP(player, 1);
			return 0;
		}
		return skillTime;
	}
	
	public static void checkSkill2Hit(Character attacker, Character defender){
		if(attacker.getPlayer().isRight() && CollideHandler.checkCollide("Right", attacker.getSkill2Box(), defender.getHitbox()) && defender.getPlayer().isHitable()){
			if(!defender.getPlayer().isHitted() && defender.getPlayer().isDefending()){
				defender.getPlayer().setHp(defender.getPlayer().getHp()-(attacker.getSkill2Power()*defender.getDefPower()));
			}
			else if(!defender.getPlayer().isHitted()){
				defender.getPlayer().setHp(defender.getPlayer().getHp()-attacker.getSkill2Power());
			}
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
			if(!defender.getPlayer().isHitted() && defender.getPlayer().isDefending()){
				defender.getPlayer().setHp(defender.getPlayer().getHp()-(attacker.getSkill2Power()*defender.getDefPower()));
			}
			else if(!defender.getPlayer().isHitted()){
				defender.getPlayer().setHp(defender.getPlayer().getHp()-attacker.getSkill2Power());
			}
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
	
	public static float getSkill2Time(Character player, float skillTime){
		if(player.getSkilling2().isAnimationFinished(player.getPlayer().getDelayTime())){
			GameScreenAtkUtils.deceaseMP(player, 2);
			return 0;
		}
		return skillTime;
	}
	
	public static void checkSkillCD(Character player){
		if(!player.getPlayer().isSkill1Ready()){
			player.getPlayer().setSkill1CDTime(player.getPlayer().getSkill1CDTime()-Gdx.graphics.getDeltaTime());
			if(player.getPlayer().getSkill1CDTime() <= 0){
				player.getPlayer().setSkill1CDTime(player.getPlayer().getSkillCD(0));
				player.getPlayer().setSkill1Ready(true);
			}
		}
		if(!player.getPlayer().isSkill2Ready()){
			player.getPlayer().setSkill2CDTime(player.getPlayer().getSkill2CDTime()-Gdx.graphics.getDeltaTime());
			if(player.getPlayer().getSkill2CDTime() <= 0){
				player.getPlayer().setSkill2CDTime(player.getPlayer().getSkillCD(1));
				player.getPlayer().setSkill2Ready(true);
			}
		}
	}
	
	public static void deceaseMP(Character player, int num){
		switch(num){
		case 1:
			player.getPlayer().setMp(player.getPlayer().getMp()-player.getSkill1MP());
			break;
		case 2:
			player.getPlayer().setMp(player.getPlayer().getMp()-player.getSkill2MP());
			break;
		}
	}
	
	public static void regenMP(Character player){
		if(player.getPlayer().getMp()+4 <= player.getMaxMP()){
			player.getPlayer().setMp(player.getPlayer().getMp()+4);
		}
		else{
			player.getPlayer().setMp(player.getMaxMP());
		}
	}
}
