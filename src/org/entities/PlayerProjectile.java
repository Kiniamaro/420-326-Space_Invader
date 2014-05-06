package org.entities;

import java.util.ArrayList;

import org.Game;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;
import org.scenes.InvaderScene;

public class PlayerProjectile extends Entity {
	
	private final int SPEED = 10;
	
	private int x;
	private int y;
	
	private Rectangle hitBox;
	
	public PlayerProjectile(int initX, int initY){
		this.x = initX;
		this.y = initY;
		
		this.hitBox = new Rectangle(initX + 11, initY, 5, 15);
		
	}

	@Override
	public void update(GameContainer gc, int delta) {
		this.move();
		this.checkCollision(InvaderScene.aliens);
		if (this.y > Game.HEIGHT){
			this.die();
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame scene, Graphics g) {
		g.setColor(new Color(0, 168, 255));
		g.fill(hitBox);
		
	}
	
	private void checkCollision(ArrayList<Entity> entities){
		for(Entity e : entities){
			if(this.hitBox.intersects(e.getHitBox()));
			e.die();
			this.die();
		}
	}
	
	public void move(){
		this.hitBox.setY(this.y -= SPEED);
	}

	public Rectangle getHitBox() {
		return this.hitBox;
	}

	@Override
	public void die() {
		InvaderScene.playerLazors.remove(this);
	}

}
