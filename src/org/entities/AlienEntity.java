package org.entities;

import org.Game;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.scenes.InvaderScene;

public class AlienEntity extends Entity {
	
	private final int XOFFSET = 8;
	private final int YOFFSET = 4;
	
	private int x;
	private int y;
	
	private int animationFrames;
	
	private Rectangle hitBox;
	
	private Image[] sprites;
	private Image currentSprite;

	public AlienEntity(int initX, int initY){
		this.x = initX;
		this.y = initY;
		
		animationFrames = 0;
		
		this.hitBox = new Rectangle(initX + XOFFSET, initY + YOFFSET, 25, 25);
		
		this.sprites = new Image[]{ Game.spriteSheet.getSprite(0, 0),
									Game.spriteSheet.getSprite(1, 0)};
		this.currentSprite = sprites[0];
	}
	

	@Override
	public void update(GameContainer gc, int delta) {
		this.animate();
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame scene, Graphics g) {
		g.drawImage(currentSprite, x, y);
		
	}

	@Override
	public Rectangle getHitBox() {
		return this.hitBox;
	}

	@Override
	public void die() {
		InvaderScene.aliens.remove(this);
	}
	
	private void animate(){
		if(animationFrames <= 30){
			this.currentSprite = sprites[1];
		} else if(animationFrames <= 60){
			this.currentSprite = sprites[0];
		} else {
			animationFrames = 0;
		}
		animationFrames++;
	}

}
