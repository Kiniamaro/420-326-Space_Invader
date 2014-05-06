package org.scenes;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import org.Game;
import org.entities.AlienEntity;
import org.entities.Entity;
import org.entities.PlayerEntity;
import org.lwjgl.opengl.Display;
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
		this.GenerateSwarm();
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame scene, Graphics g) throws SlickException {
		player.render(gc, scene, g);
	 	 Entity[] array = aliens.toArray(new Entity[0]);
	 	 for(Entity a : array){
	 		a.render(gc, scene, g);
	 	 }
	 	 Entity[] lazors = playerLazors.toArray(new Entity[0]);
	 	 for(Entity a : lazors){
	 		a.render(gc, scene, g);
	 	 }
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame scene, int delta) throws SlickException {
		 	player.update(gc, delta);
		 	 Entity[] array = aliens.toArray(new Entity[0]);
		 	 for(Entity a : array){
		 		 a.update(gc, delta);
		 	 }
		 	 Entity[] lazors = playerLazors.toArray(new Entity[0]);
		 	 for(Entity a : lazors){
		 		 a.update(gc, delta);
		 	 }
	}

	@Override
	public int getID() {return id;}
	
	private void GenerateSwarm(){
		for(int i = 0; i < 15; i++){
			for(int j = 0; j < 5; j++){
				InvaderScene.aliens.add(new AlienEntity((i * 50) + 20, j * 50));
			}
		}
	}
	
}
