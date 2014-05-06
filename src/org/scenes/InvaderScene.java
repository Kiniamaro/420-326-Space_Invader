package org.scenes;

import java.util.ArrayList;

import org.Game;
import org.entities.Entity;
import org.entities.PlayerEntity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class InvaderScene extends BasicGameState {
	
	private int id;
	
	public static PlayerEntity player;
	public static ArrayList<Entity> aliens;
	
	public static ArrayList<Entity> playerLazors;

	public InvaderScene(int id) {
		this.id = id;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame scene) throws SlickException {
		player = new PlayerEntity(300,Game.HEIGHT - 40);
		playerLazors = new ArrayList<Entity>();
		aliens = new ArrayList<Entity>();
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame scene, Graphics g) throws SlickException {
		player.render(gc, scene, g);
		for(Entity lazer : playerLazors){
			lazer.render(gc, scene, g);
		}
		for(Entity alien : aliens){
			alien.render(gc, scene, g);
		}
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame scene, int delta) throws SlickException {
		 player.update(gc, delta);
			for(Entity lazer : playerLazors){
				lazer.update(gc, delta);
			}
			for(Entity alien : aliens){
				alien.update(gc, delta);
			}
		
	}

	@Override
	public int getID() {return id;}
	
	
}
