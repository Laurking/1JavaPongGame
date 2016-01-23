package com.laurking.bat;

import java.awt.Color;
import java.awt.Graphics;

import com.laurking.game.Game;

public class Bat {
	
	private int x,y, WIDTH=30,HEIGHT=200;
	private int velX,velY;
	private Game game;
	
	public Bat(int x,int y,Game game) {
		this.x=x;
		this.y=y;
		this.game=game;
	}
	public void tick(){
		y+=velY;
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
	public void render(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);
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
	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}
	public int getHEIGHT() {
		return HEIGHT;
	}
	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}
	
}

