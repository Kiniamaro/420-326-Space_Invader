package org;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import org.scenes.*;
import org.entities.*;

public class game extends StateBasedGame {
	
	public static int menu     = 0;
	public static int invader  = 1;
	public static int gameOver = 2;
	

	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new game());
			app.setDisplayMode(800, 600, false);
			app.setVSync(true);
			app.setTargetFrameRate(60);
			app.setMinimumLogicUpdateInterval(20);
			app.setMaximumLogicUpdateInterval(20);
			app.start();
		} catch (SlickException e) {

			e.printStackTrace();
		}

	}
	
	public game(){
		super("Victor's Space Invader");
		addState(new MenuScene(menu));
		addState(new InvaderScene(invader));
		addState(new GameOverScene(gameOver));
		
		
	}	
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(invader).init(gc, this);
		this.getState(gameOver).init(gc, this);
		
		this.enterState(invader); // to change
		
	}





}
