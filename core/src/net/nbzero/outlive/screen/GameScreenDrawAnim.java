package net.nbzero.outlive.screen;

import net.nbzero.outlive.player.characters.Character;
import net.nbzero.outlive.player.characters.Fireball;
import net.nbzero.outlive.utils.CollideHandler;

public class GameScreenDrawAnim {
	protected static void idleAnim(Character player){
		player.getPlayer().setHasControl(true);
		player.getPlayer().setHitted(false);
		player.getAttackBox().set(player.getDefaultAttackBox());
		player.getAttackBox2().set(player.getDefaultAttackBox2());
		player.getAttackBox3().set(player.getDefaultAttackBox3());
		player.getSkill1Box().set(player.getDefaultSkill1Box());
		player.getSkill2Box().set(player.getDefaultSkill2Box());
		GameScreen.keyFrame = player.getStanding().getKeyFrame(GameScreen.elapsedTime, true);
		if(!player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
		else if(player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}
	}
	
	protected static void moveLeftAnim(Character player){
		GameScreen.keyFrame = player.getRunning().getKeyFrame(GameScreen.elapsedTime, true);
		player.getPlayer().setRight(false);
		if(!CollideHandler.checkMapCollide("left", player.getHitbox())){
			player.moveX(player.getPlayer().getPos().getX(), player.getHitbox().getX(), -5);
		}
		GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
	}
	
	protected static void moveRightAnim(Character player){
		GameScreen.keyFrame = player.getRunning().getKeyFrame(GameScreen.elapsedTime, true);
		player.getPlayer().setRight(true);
		if(!CollideHandler.checkMapCollide("right", player.getHitbox())){
			player.moveX(player.getPlayer().getPos().getX(), player.getHitbox().getX(), 5);
		}
		GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
	}
	
	protected static void moveUpAnim(Character player){
		GameScreen.keyFrame = player.getRunning().getKeyFrame(GameScreen.elapsedTime, true);
		if(!CollideHandler.checkMapCollide("up", player.getHitbox())){
			player.moveY(player.getPlayer().getPos().getY(), player.getHitbox().getY(), 5);
		}
		if(player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}else{
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
	}
	
	protected static void moveDownAnim(Character player){
		GameScreen.keyFrame = player.getRunning().getKeyFrame(GameScreen.elapsedTime, true);
		if(!CollideHandler.checkMapCollide("down", player.getHitbox())){
			player.moveY(player.getPlayer().getPos().getY(), player.getHitbox().getY(), -5);
		}
		if(player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}else{
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
	}
	
	protected static void dashingAnim(Character player){
		player.getPlayer().setHitable(false);
		GameScreen.keyFrame = player.getDashing().getKeyFrame(player.getPlayer().getDelayTime());
		if(!player.getPlayer().isRight()){
			if(!CollideHandler.checkMapCollide("left", player.getHitbox())){
				player.getPlayer().getPos().setX(player.getPlayer().getPos().getX()-16);
				player.getHitbox().setX(player.getHitbox().getX()-16);
			}
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
		else if(player.getPlayer().isRight()){
			if(!CollideHandler.checkMapCollide("right", player.getHitbox())){
				player.getPlayer().getPos().setX(player.getPlayer().getPos().getX()+16);
				player.getHitbox().setX(player.getHitbox().getX()+16);
			}
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}
		if(player.getPlayer().getDelayTime()>=0.1f){
			player.getPlayer().setDashing(false);
			player.getPlayer().setHitable(true);
			player.getPlayer().setDelayTime(0);
		}
	}
	
	protected static void getHitAnim(Character player){
		GameScreen.keyFrame = player.getGetHit().getKeyFrame(GameScreen.elapsedTime, true);
		if(!player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
		else if(player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}
	}
	
	protected static void defenseAnim(Character player){
		player.getPlayer().setHasControl(false);
		GameScreen.keyFrame = player.getDefending().getKeyFrame(GameScreen.elapsedTime);
		if(!player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
		else if(player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}
	}
	
	protected static void attackingAnim(Character player){
		if(player.getNameCharacter() == "Sabo"){
			if(!player.getPlayer().isRight() && player.getAtkCount()%3==0){
				player.getAttackBox().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*player.getAtkSpeed()-10, player.getHitboxPosY()-50);
				GameScreen.keyFrame = player.getAttacking().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(!player.getPlayer().isRight() && player.getAtkCount()%3==1){
				GameScreen.checkFireball++;
				if (GameScreen.checkFireball==1){
					GameScreen.checkFireball++;
					GameScreen.fireballs.add(new Fireball(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), false));
				}
				//TODO
//				Sabo.getFireballBox().setPosition(player.getHitboxPosXLeft(), player.getHitboxPosY());
				
				player.getAttackBox2().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*player.getAtkSpeed()-10, player.getHitboxPosY()-50);
				GameScreen.keyFrame = player.getAttacking2().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(!player.getPlayer().isRight() && player.getAtkCount()%3==2){
				GameScreen.checkFireball++;
				if (GameScreen.checkFireball==1){
					GameScreen.checkFireball++;
					GameScreen.fireballs.add(new Fireball(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), false));
				}
				player.getAttackBox3().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*player.getAtkSpeed()-10, player.getHitboxPosY()-50);
				GameScreen.keyFrame = player.getAttacking3().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==0){
				player.getAttackBox().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==1){
				GameScreen.checkFireball++;
				if (GameScreen.checkFireball==1){
					GameScreen.checkFireball++;
					GameScreen.fireballs.add(new Fireball(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), false));
				}
				player.getAttackBox2().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking2().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==2){
				GameScreen.checkFireball++;
				if (GameScreen.checkFireball==1){
					GameScreen.checkFireball++;
					GameScreen.fireballs.add(new Fireball(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), false));
				}
				player.getAttackBox3().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking3().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
		} else{
			if(!player.getPlayer().isRight() && player.getAtkCount()%3==0){
				player.getAttackBox().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(!player.getPlayer().isRight() && player.getAtkCount()%3==1){
				player.getAttackBox2().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking2().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(!player.getPlayer().isRight() && player.getAtkCount()%3==2){
				player.getAttackBox3().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking3().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==0){
				player.getAttackBox().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==1){
				player.getAttackBox2().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking2().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==2){
				player.getAttackBox3().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking3().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
		}
		if(player.getAttacking().isAnimationFinished(player.getPlayer().getAttackTime())){
			player.getAttackBox().set(player.getDefaultAttackBox());
			player.getAttackBox2().set(player.getDefaultAttackBox2());
			player.getAttackBox3().set(player.getDefaultAttackBox3());
			player.getPlayer().setAttacking(false);
			player.setAtkCount(player.getAtkCount()+1);
		}
	}
	
	protected static void skill1Anim(Character player){
		if(player.getNameCharacter() == "Sabo"){
			GameScreen.keyFrame = player.getSkilling1().getKeyFrame(player.getPlayer().getDelayTime());
			if(!player.getPlayer().isRight()){
				if (player.getPlayer().getDelayTime()<0.02f){
					GameScreen.fireballs.add(new Fireball(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), true));
				}
				if(player.getPlayer().getDelayTime()>=player.getSkill1HitboxDelay())
					player.getSkill1Box().setPosition(player.getSkillPosXLeft()-((player.getPlayer().getDelayTime()*player.getSkill1Speed())), player.getHitboxPosY());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(player.getPlayer().isRight()){
				if (player.getPlayer().getDelayTime()<0.02f){
					GameScreen.fireballs.add(new Fireball(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), true));
				}
				if(player.getPlayer().getDelayTime()>=player.getSkill1HitboxDelay())
					player.getSkill1Box().setPosition(player.getSkillPosXRight()+((player.getPlayer().getDelayTime()*player.getSkill1Speed())%510), player.getHitboxPosY()-15);
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			if(player.getSkilling1().isAnimationFinished(player.getPlayer().getDelayTime())){
				player.getSkill1Box().set(player.getDefaultSkill1Box());
				player.getPlayer().setSkilling1(false);
			}
		} else{
			GameScreen.keyFrame = player.getSkilling1().getKeyFrame(player.getPlayer().getDelayTime());
			if(!player.getPlayer().isRight()){
				if(player.getPlayer().getDelayTime()>=player.getSkill1HitboxDelay())
					player.getSkill1Box().setPosition(player.getSkillPosXLeft()-player.getPlayer().getDelayTime()*player.getSkill1Speed(), player.getHitboxPosY());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(player.getPlayer().isRight()){
				if(player.getPlayer().getDelayTime()>=player.getSkill1HitboxDelay())
					player.getSkill1Box().setPosition(player.getSkillPosXRight()+player.getPlayer().getDelayTime()*player.getSkill1Speed(), player.getHitboxPosY());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			if(player.getSkilling1().isAnimationFinished(player.getPlayer().getDelayTime())){
				player.getSkill1Box().set(player.getDefaultSkill1Box());
				player.getPlayer().setSkilling1(false);
			}
		}
		
	}
	
	protected static void skill2Anim(Character player){
		GameScreen.keyFrame = player.getSkilling2().getKeyFrame(player.getPlayer().getDelayTime());
		if(!player.getPlayer().isRight()){
			if(player.getPlayer().getDelayTime() >= player.getSkill2HitboxDelay())
				player.getSkill2Box().setPosition(player.getSkillPosXLeft()+player.getHitbox().getWidth()-player.getPlayer().getDelayTime()*player.getSkill2Speed(), player.getHitboxPosY());
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
		else if(player.getPlayer().isRight()){
			if(player.getPlayer().getDelayTime() >= player.getSkill2HitboxDelay())
				player.getSkill2Box().setPosition(player.getSkillPosXLeft()+player.getHitbox().getWidth()+player.getPlayer().getDelayTime()*player.getSkill2Speed(), player.getHitboxPosY());
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}
		if(player.getSkilling2().isAnimationFinished(player.getPlayer().getDelayTime())){
			player.getSkill2Box().set(player.getDefaultSkill2Box());
			player.getPlayer().setSkilling2(false);
		}
	}
	
	protected static void deadAnim(Character player){
		GameScreen.keyFrame = player.getDead().getKeyFrame(player.getPlayer().getDeadTime());
		if(!player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
		else if(player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}
	}
}
