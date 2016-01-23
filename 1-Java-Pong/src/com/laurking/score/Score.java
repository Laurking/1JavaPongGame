package com.laurking.score;

import com.laurking.ball.Ball;
import com.laurking.game.Game;

public class Score {
	
	private Game game;
	private Ball ball;
	public Score(Ball ball,Game game) {
		this.ball=ball;
		this.game=game;
	}
	
	public void tick(){
		if(ball.getX()<=game.getLine1().getX()){
			game.setScore2(game.getScore2()+3);
		}
		else if(ball.getX()+ball.getWIDTH()>=game.getLine2().getX()){
			game.setScore1(game.getScore1()+1);
		}
	}
	
	
}
