package org;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.scenes.*;
import org.entities.*;

public class Game extends StateBasedGame {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	public static Sprites spriteSheet;
	
	public static int menu     = 0;
	public static int invader  = 1;
	public static int gameOver = 2;
	

	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new Game());
			app.setDisplayMode(WIDTH, HEIGHT, false);
			app.setVSync(true);
			app.setMinimumLogicUpdateInterval(20);
			app.setMaximumLogicUpdateInterval(20);
			app.setIcon("Ressources/Icon.jpg");
			app.setShowFPS(false);
			app.start();
		} catch (SlickException e) {

			e.printStackTrace();
		}

	}
	
	public Game() throws SlickException{
		super("Victor's Space Invader");
		addState(new MenuScene(menu));
		addState(new InvaderScene(invader));
		addState(new GameOverScene(gameOver));
		
	}	
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		
		spriteSheet = new Sprites(new Image("Ressources/SpriteSheet.png"));
		
		this.getState(menu).init(gc, this);
		this.getState(invader).init(gc, this);
		this.getState(gameOver).init(gc, this);
		
		this.enterState(menu); // to change
		
	}





}
