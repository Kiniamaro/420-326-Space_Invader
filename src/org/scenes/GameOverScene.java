package org.scenes;


import org.Game;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverScene extends BasicGameState {
	
	public static String message;
	
	private int id;
	private Image[] playAgain;
	private Image[] quit;
	
	private int hoverPlay;
	private int hoverQuit;
	
	public GameOverScene(int id) {
		this.id = id;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame scene) throws SlickException {
		hoverPlay = 0;
		hoverQuit = 0;
		this.playAgain = new Image[]{new Image("Ressources/PlayAgain0.png"), new Image("Ressources/PlayAgain1.png")};
		this.quit = new Image[]{new Image("Ressources/Quit0.png"), new Image("Ressources/Quit1.png")};
	}

	@Override
	public void render(GameContainer gc, StateBasedGame scene, Graphics g) throws SlickException {
		g.drawString(message, 250, 200);
		g.drawImage(playAgain[hoverPlay], 225, 250);
		g.drawImage(quit[hoverQuit], 225, 350);
		 
	}

	@Override
	public void update(GameContainer gc, StateBasedGame scene, int delta) throws SlickException {
		 hoverPlay = playAgainButton(gc, scene);
		 hoverQuit = QuitButton(gc, scene);
	}

	@Override
	public int getID(){
		return this.id;
	}
	
	private int playAgainButton(GameContainer gc, StateBasedGame scene){
		int buttonState = 0;
		
		Input input = gc.getInput();
		int imageStartX = 225;
		int imageEndX = 225 + this.playAgain[0].getWidth();
		int imageStartY = 260;
		int imageEndY = 260 + this.playAgain[0].getHeight();
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		if(posX >= imageStartX && posX <= imageEndX &&
		   posY >= imageStartY && posY <= imageEndY){
			buttonState = 1;
			
			if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
				scene.enterState(Game.invader);
			}
		}
		
		return buttonState;
	}
	
	private int QuitButton(GameContainer gc, StateBasedGame scene){
		int buttonState = 0;
		
		Input input = gc.getInput();
		int imageStartX = 225;
		int imageEndX = 225 + this.quit[0].getWidth();
		int imageStartY = 160;
		int imageEndY = 160 + this.playAgain[0].getHeight();
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		if(posX >= imageStartX && posX <= imageEndX &&
		   posY >= imageStartY && posY <= imageEndY){
			buttonState = 1;
			
			if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
				System.exit(0);
			}
			
		}
		
		return buttonState;
	}

}
