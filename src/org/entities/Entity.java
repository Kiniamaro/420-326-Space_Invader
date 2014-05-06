package org.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Entity {
		
	public abstract void update(GameContainer gc, int delta);
	
	public abstract void render(GameContainer gc, StateBasedGame scene, Graphics g);
	
	public abstract Rectangle getHitBox();
	
	public abstract void die();

}
