package org.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class Sprites extends SpriteSheet {
	
	// height and width of a tile
	private final static int WIDTH  = 40;
	private final static int HEIGHT = 40;
	
	public Sprites(Image sheet){
		super(sheet, WIDTH, HEIGHT);
	}

}
