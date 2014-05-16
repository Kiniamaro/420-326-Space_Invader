package org.entities;


import java.awt.Color;

import org.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.scenes.InvaderScene;

public class PlayerEntity extends Entity {

	private final int SPEED = 6;
	
	private final int SHOTCOOLDOWN = 15; //frames;
	
	private final int XOFFSET = 6;
	private final int YOFFSET = 22;
	
	private int x;
	private int y;
	private int cooldownTime;
	private boolean canShot;
	
	private boolean alive = true;
	
	private Rectangle hitBox;
	
	private Image[] sprites;
	private Image currentSprite;
	
	
	public PlayerEntity(int initX, int initY){
		
		this.x = initX;
		this.y = initY;
		this.canShot = true;
		this.cooldownTime = 0;
		
		this.hitBox = new Rectangle(initX + XOFFSET, initY + YOFFSET, 30, 18);
		
		this.sprites = new Image[]{ Game.spriteSheet.getSprite(0, 9),
									Game.spriteSheet.getSprite(1, 9)};
		this.currentSprite = sprites[0];
	}

	@Override
	public void update(GameContainer gc, int delta) {
		currentSprite = sprites[0];
		this.checkCanShoot();
		this.control();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame scene, Graphics g) {
		g.drawImage(this.currentSprite, x, y);
	//	g.setColor(org.newdawn.slick.Color.red); // for testing
	//	g.draw(hitBox); // for testing
		
	}
	
	public void control(){
		Input input = new Input(Game.HEIGHT);
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			this.moveLeft();
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			this.moveRight();
		}
		
		if(input.isKeyDown(Input.KEY_Z))
			shoot();
		
		if(input.isKeyDown(Input.KEY_X))
			megaShot();
		
		
	}
	
	private void shoot(){
		if(this.canShot){
			InvaderScene.playerLazors.add(new PlayerProjectile(this.x + XOFFSET, this.y + YOFFSET));
			this.cooldownTime = SHOTCOOLDOWN;
			this.currentSprite = sprites[1];
			canShot = false;
		}
	}
	
	private void megaShot(){
		if (this.canShot){
			for(int i = 0; i < 25; i++){
				InvaderScene.playerLazors.add(new PlayerProjectile(this.x -25 +  (i * 3), this.y + YOFFSET));
			}
			
			this.cooldownTime = SHOTCOOLDOWN;
			this.currentSprite = sprites[1];
			canShot = false;
		}
	}
	
	private void checkCanShoot(){
		
		if(this.cooldownTime <= 0)
			canShot = true;
		else 
			this.cooldownTime--;
	}
	
	
	private void moveLeft(){
		if(hitBox.getX() >= 0){
			this.hitBox.setX(hitBox.getX() - SPEED);
			this.x -= SPEED;
		}
	}
	
	private void moveRight(){
		if(hitBox.getX() + hitBox.getWidth() <= Game.WIDTH){
			this.hitBox.setX(hitBox.getX() + SPEED );
			this.x += SPEED;
		}
	}
	
	public Rectangle getHitBox(){
		return this.hitBox;
	}

	@Override
	public void die() {
		this.alive = false;
	}

	public boolean isDead() {
		return this.alive;
	}
	
	
}
