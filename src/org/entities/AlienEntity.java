package org.entities;

import org.Game;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.scenes.InvaderScene;

public class AlienEntity extends Entity {
	
	private final int XOFFSET = 8;
	private final int YOFFSET = 4;
	
	private int x;
	private int y;
	private int[] pos; //to see if it can shoot
	
	private int animationFrames;
	private int shotCoolDown;
	
	private Rectangle hitBox;
	
	private Image[] sprites;
	private Image currentSprite;

	public AlienEntity(int initX, int initY, int[] pos){
		this.x = initX;
		this.y = initY;
		this.pos = pos;
		
		animationFrames = 0;
		shotCoolDown = 120;
		
		this.hitBox = new Rectangle(initX + XOFFSET, initY + YOFFSET, 25, 25);
		
		this.sprites = new Image[]{ Game.spriteSheet.getSprite(0, 0),
									Game.spriteSheet.getSprite(1, 0)};
		this.currentSprite = sprites[0];
	}
	

	@Override
	public void update(GameContainer gc, int delta) {
		this.animate();
		this.move();
		this.updateHitBox();
		shoot();
		this.shotCoolDown++;
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame scene, Graphics g) {
		g.drawImage(currentSprite, x, y);
	}

	@Override
	public Rectangle getHitBox() {
		return this.hitBox;
	}
	
	public int[] getPos(){
		return this.pos;
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
	
	private void move(){
		if(animationFrames % 10 == 0){
			this.x -= 20;
			if(this.hitBox.getX() <= 0){
				this.x = Game.WIDTH;
				this.y += 50;
			}
		}
	}
	
	private void updateHitBox(){
		hitBox.setX(this.x + XOFFSET);
		hitBox.setY(this.y + YOFFSET);
	}
	
	private void shoot(){
		
		if( this.isPlayerUnder() && isLast() && this.shotCoolDown >= 60){
			InvaderScene.alienLazors.add(new InvaderProjectile(this.x + XOFFSET, this.y + YOFFSET));
			this.shotCoolDown = 0;
		}
	}
	
	private boolean isLast(){
		boolean last = true;
		
		for(AlienEntity a : InvaderScene.aliens){
			if(this.getPos()[0] == a.getPos()[0] &&
			   this.getPos()[1] < a.getPos()[1]){
				last = false;
				break;
			}
		}
		return last;
	}
	

	
	private boolean isPlayerUnder(){
		if(this.hitBox.getCenterX() >= InvaderScene.player.getHitBox().getMinX() 
				&& this.hitBox.getCenterX() <= InvaderScene.player.getHitBox().getMaxX())
				return true;
		return false;
	}

}
