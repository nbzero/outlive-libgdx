package net.nbzero.outlive.utils.screenutils;

import net.nbzero.outlive.player.characters.Character;
import net.nbzero.outlive.screen.GameScreen;
import net.nbzero.outlive.utils.CollideHandler;
import net.nbzero.outlive.utils.Fireball;
import net.nbzero.outlive.utils.Stone;

public class GameScreenDrawAnim {
	
	public static void idleAnim(Character player){
		player.getPlayer().setHasControl(true);
		player.getPlayer().setHitted(false);
		player.setUping(false);
		player.setDowning(false);
		player.getAttackBox().set(player.getDefaultAttackBox());
		player.getAttackBox2().set(player.getDefaultAttackBox2());
		player.getAttackBox3().set(player.getDefaultAttackBox3());
		player.getSkill1Box().set(player.getDefaultSkill1Box());
		player.getSkill2Box().set(player.getDefaultSkill2Box());
		GameScreen.keyFrame = player.getStanding().getKeyFrame(GameScreenUtils.elapsedTime, true);
		if(!player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
		else if(player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}
	}
	
	public static void moveLeftAnim(Character player){
		GameScreen.keyFrame = player.getRunning().getKeyFrame(GameScreenUtils.elapsedTime, true);
		player.setUping(false);
		player.setDowning(false);
		player.getPlayer().setRight(false);
		if(!CollideHandler.checkMapCollide("left", player.getHitbox())){
			player.moveX(player.getPlayer().getPos().getX(), player.getHitbox().getX(), -player.getMoveSpeed());
		}
		GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
	}
	
	public static void moveRightAnim(Character player){
		GameScreen.keyFrame = player.getRunning().getKeyFrame(GameScreenUtils.elapsedTime, true);
		player.setUping(false);
		player.setDowning(false);
		player.getPlayer().setRight(true);
		if(!CollideHandler.checkMapCollide("right", player.getHitbox())){
			player.moveX(player.getPlayer().getPos().getX(), player.getHitbox().getX(), player.getMoveSpeed());
		}
		GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
	}
	
	public static void moveUpAnim(Character player){
		GameScreen.keyFrame = player.getRunning().getKeyFrame(GameScreenUtils.elapsedTime, true);
		if(!CollideHandler.checkMapCollide("up", player.getHitbox())){
			player.moveY(player.getPlayer().getPos().getY(), player.getHitbox().getY(), player.getMoveSpeed());
		}
		if(player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}else{
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
	}
	
	public static void moveDownAnim(Character player){
		GameScreen.keyFrame = player.getRunning().getKeyFrame(GameScreenUtils.elapsedTime, true);
		if(!CollideHandler.checkMapCollide("down", player.getHitbox())){
			player.moveY(player.getPlayer().getPos().getY(), player.getHitbox().getY(), -player.getMoveSpeed());
		}
		if(player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}else{
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
	}
	
	public static void dashingAnim(Character player){
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
			GameScreenAtkUtils.deceaseMPDash(player);
			player.getPlayer().setDashing(false);
			player.getPlayer().setHitable(true);
			player.getPlayer().setDelayTime(0);
		}
	}
	
	public static void getHitAnim(Character player){
		GameScreen.keyFrame = player.getGetHit().getKeyFrame(GameScreenUtils.elapsedTime, true);
		if(!player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
		else if(player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}
	}
	
	public static void defenseAnim(Character player){
		player.getPlayer().setDefending(true);
		player.getPlayer().setHasControl(false);
		GameScreen.keyFrame = player.getDefending().getKeyFrame(GameScreenUtils.elapsedTime);
		if(!player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
		else if(player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}
	}
	
	public static void attackingAnim(Character player){
		
		//-------------------Sabo---
		if(player.getNameCharacter() == "Sabo"){
			if(!player.getPlayer().isRight() && player.getAtkCount()%3==0){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk1().play();
				}
				player.getAttackBox().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*player.getAtkSpeed()-10, player.getHitboxPosY()-50);
				GameScreen.keyFrame = player.getAttacking().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(!player.getPlayer().isRight() && player.getAtkCount()%3==1){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk2().play();
					GameScreenUtils.fireballs.add(new Fireball(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), false));
				}
				player.getAttackBox2().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*(player.getAtkSpeed()*34), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking2().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(!player.getPlayer().isRight() && player.getAtkCount()%3==2){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk3().play();
					GameScreenUtils.fireballs.add(new Fireball(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), false));
				}
				player.getAttackBox3().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*(player.getAtkSpeed()*34), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking3().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			
			//^^^^^^^^^^^^^^left^^^^^
			
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==0){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk1().play();
				}
				player.getAttackBox().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==1){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk2().play();
					GameScreenUtils.fireballs.add(new Fireball(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), false));
				}
				player.getAttackBox2().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*(player.getAtkSpeed()*34), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking2().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==2){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk3().play();
					GameScreenUtils.fireballs.add(new Fireball(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), false));
				}
				player.getAttackBox3().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*(player.getAtkSpeed()*34), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking3().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			//^^^^^^^^^^^^^^Right^^^^^
			
			
		// ---------------------Usopp--------------
		} else if(player.getNameCharacter() == "Usopp"){
			if(!player.getPlayer().isRight() && player.getAtkCount()%3==0){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk1().play();
				}
				player.getAttackBox().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*player.getAtkSpeed()+player.getOffsetX(), player.getHitboxPosY()+player.getOffsetY());
				GameScreen.keyFrame = player.getAttacking().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(!player.getPlayer().isRight() && player.getAtkCount()%3==1){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk2().play();
					GameScreenUtils.stones.add(new Stone(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), false));
				}
				player.getAttackBox2().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*(player.getAtkSpeed()*34), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking2().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(!player.getPlayer().isRight() && player.getAtkCount()%3==2){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk3().play();
					GameScreenUtils.stones.add(new Stone(player.getPlayer().getPos().getX(), player.getHitbox().getY()+40, player.getPlayer().isRight(), false));
				}
				player.getAttackBox2().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*(player.getAtkSpeed()*34), player.getHitboxPosY()+30);
				GameScreen.keyFrame = player.getAttacking3().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			
			//^^^^^^^^^^^^^^Left^^^^^
			
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==0){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk1().play();
				}
				player.getAttackBox().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY()+player.getOffsetY());
				GameScreen.keyFrame = player.getAttacking().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==1){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk2().play();
				}
				if (player.getPlayer().getAttackTime()<0.02f){
					GameScreenUtils.stones.add(new Stone(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), false));
				}
				player.getAttackBox3().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*(player.getAtkSpeed()*34), player.getHitboxPosY());
				GameScreen.keyFrame = player.getAttacking2().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==2){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk3().play();
				}
				if (player.getPlayer().getAttackTime()<0.02f){
					GameScreenUtils.stones.add(new Stone(player.getPlayer().getPos().getX(), player.getHitbox().getY()+40, player.getPlayer().isRight(), false));
				}
				player.getAttackBox3().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*(player.getAtkSpeed()*34), player.getHitboxPosY()+30);
				GameScreen.keyFrame = player.getAttacking3().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
		}
		//^^^^^^^^^^^^^^Right^^^^^
		//-------------------------else
		
		else{
			if(!player.getPlayer().isRight() && player.getAtkCount()%3==0){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk1().play();
				}
				player.getAttackBox().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*player.getAtkSpeed()+player.getOffsetX(), player.getHitboxPosY()+player.getOffsetY());
				GameScreen.keyFrame = player.getAttacking().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(!player.getPlayer().isRight() && player.getAtkCount()%3==1){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk2().play();
				}
				player.getAttackBox2().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*player.getAtkSpeed()+player.getOffsetX2(), player.getHitboxPosY()+player.getOffsetY2());
				GameScreen.keyFrame = player.getAttacking2().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(!player.getPlayer().isRight() && player.getAtkCount()%3==2){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk3().play();
				}
				player.getAttackBox3().setPosition(player.getHitboxPosXLeft()-player.getPlayer().getAttackTime()*player.getAtkSpeed()+player.getOffsetX3(), player.getHitboxPosY()+player.getOffsetY3());
				GameScreen.keyFrame = player.getAttacking3().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
		
			//^^^^^^^^^^^^^^Left^^^^^
			
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==0){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk1().play();
				}
				player.getAttackBox().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY()+player.getOffsetY());
				GameScreen.keyFrame = player.getAttacking().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==1){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk2().play();
				}
				player.getAttackBox2().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY()+player.getOffsetY2());
				GameScreen.keyFrame = player.getAttacking2().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			else if(player.getPlayer().isRight() && player.getAtkCount()%3==2){
				if (player.getPlayer().getAttackTime()<0.02f){
					player.getSoundAtk3().play();
				}
				player.getAttackBox3().setPosition(player.getHitboxPosXRight()+player.getPlayer().getAttackTime()*player.getAtkSpeed(), player.getHitboxPosY()+player.getOffsetY3());
				GameScreen.keyFrame = player.getAttacking3().getKeyFrame(player.getPlayer().getAttackTime());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
		}
		//^^^^^^^^^^^^^^Right^^^^^
		
		
		if(player.getAttacking().isAnimationFinished(player.getPlayer().getAttackTime())){
			player.getAttackBox().set(player.getDefaultAttackBox());
			player.getAttackBox2().set(player.getDefaultAttackBox2());
			player.getAttackBox3().set(player.getDefaultAttackBox3());
			player.getPlayer().setAttacking(false);
			player.setAtkCount(player.getAtkCount()+1);
		}
		
	}
	
	public static void skill1Anim(Character player){
		if(player.getNameCharacter() == "Sabo"){
			GameScreen.keyFrame = player.getSkilling1().getKeyFrame(player.getPlayer().getDelayTime());
			if(!player.getPlayer().isRight()){
				if (player.getPlayer().getDelayTime()<0.02f){
					player.getSoundSkill1().play();
					GameScreenUtils.fireballs.add(new Fireball(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), true));
				}
				if(player.getPlayer().getDelayTime()>=player.getSkill1HitboxDelay() && player.getPlayer().getDelayTime()<=player.getSkill1HitboxDelay()+0.5f)
					player.getSkill1Box().setPosition(player.getSkillPosXLeft()-((player.getPlayer().getDelayTime()*player.getSkill1Speed())+130), player.getHitboxPosY()-15);
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(player.getPlayer().isRight()){
				if (player.getPlayer().getDelayTime()<0.02f){
					player.getSoundSkill1().play();
					GameScreenUtils.fireballs.add(new Fireball(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), true));
				}
				if(player.getPlayer().getDelayTime()>=player.getSkill1HitboxDelay() && player.getPlayer().getDelayTime()<=player.getSkill1HitboxDelay()+0.5f)
					player.getSkill1Box().setPosition(player.getSkillPosXRight()+((player.getPlayer().getDelayTime()*player.getSkill1Speed())+130), player.getHitboxPosY()-15);
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			if(player.getSkilling1().isAnimationFinished(player.getPlayer().getDelayTime())){
				player.getSkill1Box().set(player.getDefaultSkill1Box());
				player.getPlayer().setSkilling1(false);
			}
			//-------------------------------
		} else if (player.getNameCharacter() == "Usopp"){
			GameScreen.keyFrame = player.getSkilling1().getKeyFrame(player.getPlayer().getDelayTime());
			if(!player.getPlayer().isRight()){
				if (1.0f<player.getPlayer().getDelayTime() && player.getPlayer().getDelayTime()<1.02f){
					player.getSoundSkill1().play();
					GameScreenUtils.stones.add(new Stone(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), true));
				}
				if(player.getPlayer().getDelayTime()>=player.getSkill1HitboxDelay()+0.2f){
					player.getSkill1Box().setPosition(player.getSkillPosXLeft()-player.getPlayer().getDelayTime()*player.getSkill1Speed()+player.getOffsetX4()+400, player.getHitboxPosY()+player.getOffsetY4());
				}
					
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(player.getPlayer().isRight()){
				if (1.0f<player.getPlayer().getDelayTime() && player.getPlayer().getDelayTime()<1.02f){
					player.getSoundSkill1().play();
					GameScreenUtils.stones.add(new Stone(player.getPlayer().getPos().getX(), player.getHitbox().getY(), player.getPlayer().isRight(), true));
				}
				if(player.getPlayer().getDelayTime()>=player.getSkill1HitboxDelay()+0.2f)
					player.getSkill1Box().setPosition(player.getSkillPosXRight()+player.getPlayer().getDelayTime()*player.getSkill1Speed()-400, player.getHitboxPosY()+player.getOffsetY4());
				
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			if(player.getSkilling1().isAnimationFinished(player.getPlayer().getDelayTime())){
				player.getSkill1Box().set(player.getDefaultSkill1Box());
				player.getPlayer().setSkilling1(false);
			}
		}else{
			if (player.getPlayer().getDelayTime()<0.02f){
				player.getSoundSkill1().play();
			}
			GameScreen.keyFrame = player.getSkilling1().getKeyFrame(player.getPlayer().getDelayTime());
			if(!player.getPlayer().isRight()){
				if(player.getPlayer().getDelayTime()>=player.getSkill1HitboxDelay()){
					player.getSkill1Box().setPosition(player.getSkillPosXLeft()-player.getPlayer().getDelayTime()*player.getSkill1Speed()+player.getOffsetX4(), player.getHitboxPosY()+player.getOffsetY4());
				}
					
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
			}
			else if(player.getPlayer().isRight()){
				if(player.getPlayer().getDelayTime()>=player.getSkill1HitboxDelay())
					player.getSkill1Box().setPosition(player.getSkillPosXRight()+player.getPlayer().getDelayTime()*player.getSkill1Speed(), player.getHitboxPosY()+player.getOffsetY4());
				GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
			}
			if(player.getSkilling1().isAnimationFinished(player.getPlayer().getDelayTime())){
				player.getSkill1Box().set(player.getDefaultSkill1Box());
				player.getPlayer().setSkilling1(false);
			}
		}
		
	}
	
	public static void skill2Anim(Character player){
		if (player.getPlayer().getDelayTime()<0.02f){
			player.getSoundSkill2().play();
		}
		GameScreen.keyFrame = player.getSkilling2().getKeyFrame(player.getPlayer().getDelayTime());
		if(!player.getPlayer().isRight()){
			if(player.getPlayer().getDelayTime() >= player.getSkill2HitboxDelay())
				player.getSkill2Box().setPosition(player.getSkillPosXLeft()+player.getHitbox().getWidth()-player.getPlayer().getDelayTime()*player.getSkill2Speed()-player.getOffsetX5(), player.getHitboxPosY()+player.getOffsetY5());
			//-------------------
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
		else if(player.getPlayer().isRight()){
			if(player.getPlayer().getDelayTime() >= player.getSkill2HitboxDelay())
				player.getSkill2Box().setPosition(player.getSkillPosXLeft()+player.getHitbox().getWidth()+player.getPlayer().getDelayTime()*player.getSkill2Speed()-player.getOffsetX5(), player.getHitboxPosY()+player.getOffsetY5());
			//-------------------
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}
		if(player.getSkilling2().isAnimationFinished(player.getPlayer().getDelayTime())){
			player.getSkill2Box().set(player.getDefaultSkill2Box());
			player.getPlayer().setSkilling2(false);
		}
	}
	
	public static void deadAnim(Character player){
		GameScreen.keyFrame = player.getDead().getKeyFrame(player.getPlayer().getDeadTime());
		if(!player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX(), player.getPlayer().getPos().getY(), 300, 300);
		}
		else if(player.getPlayer().isRight()){
			GameScreen.batch.draw(GameScreen.keyFrame, player.getPlayer().getPos().getX()+300, player.getPlayer().getPos().getY(), -300, 300);
		}
	}
}
