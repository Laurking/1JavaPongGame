package com.laurking.goal;

import java.awt.Color;
import java.awt.Graphics;

import com.laurking.game.Game;

public class Goal {
	private Game game;
	private int x,y;
	private final int WIDTH=10,HEIGHT;

	public Goal(int x, int y,Game game){
		this.x=x;
		this.y=y;
		this.game=game;
		this.HEIGHT=game.getHeight();
	}
	
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	public int getX(){
		return x;
	}
	public int getWidth(){
		return WIDTH;
	}
	public int getHeight(){
		return HEIGHT;
	}

}
