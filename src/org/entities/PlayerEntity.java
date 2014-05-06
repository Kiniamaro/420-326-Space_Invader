package org.entities;

import org.game;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

public class PlayerEntity extends Entity {

	private final int SPEED = 6;
	
	private int x;
	private int y;
	private boolean isShooting;
	
	private Image[] sprites;
	private Sprites stylesheet;
	private Image currentSprite;
	
	public PlayerEntity(int initX, int initY){
		this.x = initX;
		this.y = initY;
		this.isShooting = false;
		
		try {
			this.stylesheet = new Sprites(new Image ("Ressources/SpriteSheet.png"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.sprites = new Image[]{ stylesheet.getSprite(0, 9),
									stylesheet.getSprite(1, 9) };
		this.currentSprite = sprites[0];
	}

	@Override
	public void update(GameContainer gc, int delta) {
		this.control();
		currentSprite = isShooting ? sprites[1] : sprites[0]; 
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame scene, Graphics g) {
		g.drawImage(this.currentSprite, x, y);
		
	}
	
	public void control(){
		Input input = new Input(game.HEIGHT);
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			if(x > 0)
			this.x -= SPEED;
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			if(x <= game.WIDTH - 20)
			this.x += SPEED;
		}
		
		if(input.isKeyDown(Input.KEY_Z)){
			shoot();
		} else {
			isShooting = false;
		}
		
		
	}
	
	private void shoot(){
		isShooting = true;
	}

	
	
}
