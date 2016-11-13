package net.nbzero.outlive.utils.screenutils;

import com.badlogic.gdx.Gdx;

import net.nbzero.outlive.InputsControl;
import net.nbzero.outlive.screen.GameScreen;
import net.nbzero.outlive.utils.CollideHandler;

public class GameScreenControlsUtils {
	public static void p1MultiCommand(){
		if(Gdx.input.isKeyPressed(InputsControl.P1_UP) && GameScreen.player1.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished && !GameScreen.player1.isUping()){
			if(!CollideHandler.checkMapCollide("up", GameScreen.player1.getHitbox())){
				GameScreen.player1.moveY(GameScreen.player1.getPlayer().getPos().getY(), GameScreen.player1.getHitbox().getY(), GameScreen.player1.getMoveSpeed());
			}
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_DOWN) && GameScreen.player1.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished && !GameScreen.player1.isDowning()){
			if(!CollideHandler.checkMapCollide("down", GameScreen.player1.getHitbox())){
				GameScreen.player1.moveY(GameScreen.player1.getPlayer().getPos().getY(), GameScreen.player1.getHitbox().getY(), -GameScreen.player1.getMoveSpeed());
			}
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P1_DASH) && !GameScreen.player1.getPlayer().isDashing()
				&& GameScreen.player1.getPlayer().hasControl() && !GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			GameScreen.player1.getPlayer().setDashing(true);
			GameScreen.player1.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P1_ATTACK) && !GameScreen.player1.getPlayer().isAttacking()
				&& GameScreen.player1.getPlayer().hasControl()	&& !GameScreen.player1.getPlayer().isHitted() && !GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			GameScreen.player1.getPlayer().setAttacking(true);
			GameScreen.player1.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P1_DEFENSE) && !GameScreen.player1.getPlayer().isAttacking()
				&& !GameScreen.player1.getPlayer().isDead() && !GameScreen.player2.getPlayer().isHitted()
				&& !GameScreen.player1.getPlayer().isSkilling1() && !GameScreen.player1.getPlayer().isSkilling2()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			GameScreenDrawAnim.defenseAnim(GameScreen.player1);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P1_SKILL1) && !GameScreen.player1.getPlayer().isSkilling1()&& GameScreen.player1.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished && GameScreen.player1.getPlayer().isSkill1Ready() && GameScreen.player1.getPlayer().getMp() >= GameScreen.player1.getSkill1MP()){
			GameScreen.player1.getPlayer().setSkilling1(true);
			GameScreen.player1.getPlayer().setSkill1Ready(false);
			GameScreen.player1.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P1_SKILL2) && !GameScreen.player1.getPlayer().isSkilling2()&& GameScreen.player1.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished && GameScreen.player1.getPlayer().isSkill2Ready() && GameScreen.player1.getPlayer().getMp() >= GameScreen.player1.getSkill2MP()){
			GameScreen.player1.getPlayer().setSkilling2(true);
			GameScreen.player1.getPlayer().setSkill2Ready(false);
			GameScreen.player1.getPlayer().setHasControl(false);
		}
	}
	public static void p2MultiCommand(){
		if(Gdx.input.isKeyPressed(InputsControl.P2_UP) && GameScreen.player2.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished && !GameScreen.player2.isUping()){
			if(!CollideHandler.checkMapCollide("up", GameScreen.player2.getHitbox())){
				GameScreen.player2.moveY(GameScreen.player2.getPlayer().getPos().getY(), GameScreen.player2.getHitbox().getY(), GameScreen.player2.getMoveSpeed());
			}
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_DOWN) && GameScreen.player2.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished && !GameScreen.player2.isDowning()){
			if(!CollideHandler.checkMapCollide("down", GameScreen.player2.getHitbox())){
				GameScreen.player2.moveY(GameScreen.player2.getPlayer().getPos().getY(), GameScreen.player2.getHitbox().getY(), -GameScreen.player2.getMoveSpeed());
			}
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P2_DASH) && !GameScreen.player2.getPlayer().isDashing()
				&& GameScreen.player2.getPlayer().hasControl() && !GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			GameScreen.player2.getPlayer().setDashing(true);
			GameScreen.player2.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P2_ATTACK) && !GameScreen.player2.getPlayer().isAttacking()
				&& GameScreen.player2.getPlayer().hasControl() && !GameScreen.player2.getPlayer().isHitted() && !GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			GameScreen.player2.getPlayer().setAttacking(true);
			GameScreen.player2.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyPressed(InputsControl.P2_DEFENSE) && !GameScreen.player2.getPlayer().isAttacking()
				&& !GameScreen.player2.getPlayer().isDead() && !GameScreen.player1.getPlayer().isHitted()
				&& !GameScreen.player2.getPlayer().isSkilling1() && !GameScreen.player2.getPlayer().isSkilling2()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished){
			GameScreenDrawAnim.defenseAnim(GameScreen.player2);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P2_SKILL1) && !GameScreen.player2.getPlayer().isSkilling1()&& GameScreen.player2.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished && GameScreen.player2.getPlayer().isSkill1Ready() && GameScreen.player2.getPlayer().getMp() >= GameScreen.player2.getSkill1MP()){
			GameScreen.player2.getPlayer().setSkilling1(true);
			GameScreen.player2.getPlayer().setSkill1Ready(false);
			GameScreen.player2.getPlayer().setHasControl(false);
		}
		else if(Gdx.input.isKeyJustPressed(InputsControl.P2_SKILL2) && !GameScreen.player2.getPlayer().isSkilling2()&& GameScreen.player2.getPlayer().hasControl()
				&& !GameScreenUtils.paused && !GameScreenUtils.matchFinished && GameScreen.player2.getPlayer().isSkill2Ready() && GameScreen.player2.getPlayer().getMp() >= GameScreen.player2.getSkill2MP()){
			GameScreen.player2.getPlayer().setSkilling2(true);
			GameScreen.player2.getPlayer().setSkill2Ready(false);
			GameScreen.player2.getPlayer().setHasControl(false);
		}
	}
}
