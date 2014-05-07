package org.entities;

import java.util.ArrayList;

import org.Game;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.scenes.InvaderScene;

public class InvaderProjectile extends Entity {
	
	private final int SPEED = 5;
	
	private int x;
	private int y;
	
	private Rectangle hitBox;
	
	public InvaderProjectile(int initX, int initY){
		this.x = initX;
		this.y = initY;
		
		this.hitBox = new Rectangle(initX + 11, initY, 5, 15);
		
	}

	@Override
	public void update(GameContainer gc, int delta) {
		this.move();
		this.checkCollision();
		if (this.y >= Game.HEIGHT){
			this.die();
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame scene, Graphics g) {
		g.setColor(new Color(102, 228, 77));
		g.fill(hitBox);
		
	}
	
	private void checkCollision(){
		if(this.getHitBox().intersects(InvaderScene.player.getHitBox())){
			this.die();
		}
	}
	
	public void move(){
		this.hitBox.setY(this.y += SPEED);
	}

	public Rectangle getHitBox() {
		return this.hitBox;
	}

	@Override
	public void die() {
		InvaderScene.aliens.remove(this);
	}
}