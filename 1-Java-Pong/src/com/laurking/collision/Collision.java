package com.laurking.collision;

import java.util.ArrayList;
import java.util.Random;

import com.laurking.ball.Ball;
import com.laurking.bat.Bat;

public class Collision {
	private Random rand;
	private ArrayList<Bat> bats=new ArrayList<Bat>();
	private Ball ball;
	public Collision(Ball ball,ArrayList<Bat> bats) {
		this.ball=ball;
		this.bats=bats;
	}
	
	public void tick(){
		rand=new Random();
		if(ball.getX()<=bats.get(1).getX() && (ball.getY()>=bats.get(1).getY()) && (ball.getY()+ball.getHEIGHT()<=bats.get(1).getY()+bats.get(1).getHEIGHT())){
			ball.setVelX(rand.nextInt(7)+10);
			ball.setVelY(-rand.nextInt(5)+10);
		}
		else if((ball.getX()+ball.getWIDTH()>=bats.get(0).getX()) && (ball.getY()>=bats.get(0).getY()) && (ball.getY()+ball.getHEIGHT()<=bats.get(0).getY()+bats.get(0).getHEIGHT())){
			ball.setVelX(-rand.nextInt(10)-12);
			ball.setVelY(-rand.nextInt(12)-9);
		}
		
	}

}
