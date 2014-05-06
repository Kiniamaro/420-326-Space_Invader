package org.scenes;

import org.game;
import org.entities.PlayerEntity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class InvaderScene extends BasicGameState {
	
	private int id;
	
	private PlayerEntity player;

	public InvaderScene(int id) {
		this.id = id;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame scene) throws SlickException {
		player = new PlayerEntity(300,game.HEIGHT - 40);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame scene, Graphics g) throws SlickException {
		player.render(gc, scene, g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame scene, int delta) throws SlickException {
		 player.update(gc, delta);
		
	}

	@Override
	public int getID() {return id;}
	
	
}
