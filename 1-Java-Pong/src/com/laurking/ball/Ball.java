package com.laurking.ball;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.laurking.game.Game;

public class Ball {
	private Random rand;
	private int velX,velY;
	private final int WIDTH=60,HEIGHT=60;
	private int x, y;
	private Game game;
	public Ball(int x, int y,Game game) {
		this.x=x;
		this.y=y;
		this.game=game;
		velX=7;
		velY=7;
	}
	
	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void tick(){
		x+=velX;
		y+=velY;
		if(x+WIDTH>=game.getWidth()){
			velX=-7;
		}
		else if(x<=0){
			velX=7;
		}
		else if(y+HEIGHT>=game.getHeight()){
			velY=-7;
		}
		else if(y<=0){
			velY=7;
		}
		
	}
	public void render(Graphics g){
		g.setColor(Color.WHITE);
		g.fillOval(x, y, WIDTH, WIDTH);
	}
	
}
