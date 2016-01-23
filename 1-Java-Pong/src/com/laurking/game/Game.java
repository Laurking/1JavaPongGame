package com.laurking.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

import com.laurking.ball.Ball;
import com.laurking.bat.Bat;
import com.laurking.collision.Collision;
import com.laurking.goal.Goal;
import com.laurking.movement.listener.MovementListener;
import com.laurking.score.Score;
import com.laurking.view.View;

public class Game implements Runnable {
	private Random rand=new Random();
	private BufferStrategy bs;
	private Graphics g;
	private Thread thread;
	private boolean running = false;
	private View view;
	private int WIDTH, HEIGHT;
	private String TITLE;
	private Ball ball;
	private Bat bat;
	private Collision collision;
	private Goal line1,line2;
	private MovementListener movement;
	private int player1=0;
	private int player2=0;
	private Score score;
	private ArrayList<Bat> bats = new ArrayList<Bat>();

	private int x;

	public Game(String title, int width, int height) {
		TITLE = title;
		WIDTH = width;
		HEIGHT = height;
	}

	public void init() {
		view = new View(TITLE, WIDTH, HEIGHT);
		ball = new Ball(rand.nextInt(100)+10,rand.nextInt(200)+20, this);
		bats.add(new Bat(WIDTH - 40, HEIGHT / 2 - 100, this));
		bats.add(new Bat(10, HEIGHT / 2 - 100, this));
		collision = new Collision(ball, bats);
		movement = new MovementListener(this);
		line1=new Goal(0,0,this);
		line2=new Goal(WIDTH-10,0,this);
		score=new Score(ball,this);
		view.getCanvas().addKeyListener(movement);

	}

	public void tick() {
		for (int i = 0; i < bats.size(); i++) {
			bat = bats.get(i);
			bat.tick();
		}
		
		collision.tick();
		
		ball.tick();
		score.tick();

	}

	public void render() {
		bs = view.getCanvas().getBufferStrategy();
		if (bs == null) {
			view.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.WHITE);
		g.fillRect(WIDTH / 2 - 2, 0, 4, HEIGHT);
		ball.render(g);
		for (int i = 0; i < bats.size(); i++) {
			bat = bats.get(i);
			bat.render(g);
		}
		line1.render(g);
		line2.render(g);
		g.setColor(Color.RED);
		Font font=new Font("Arial",Font.BOLD,20);
		g.setFont(font);
		g.drawString("Score "+player1,50,20);
		g.drawString("Score "+player2,WIDTH-140,20);
		bs.show();
		g.dispose();
	}

	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void run() {
		init();
		int fps = 60;
		double timePerTicks = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTicks;

			lastTime = now;
			if (delta >= 1) {
				tick();
				render();

				delta--;
			}

		}
		stop();
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public ArrayList<Bat> getBat() {
		return bats;
	}
	public int getScore1(){
		return player1;
	}
	public int getScore2(){
		return player2;
	}
	public void setScore1(int scores){
		 player1=scores;
	}
	public void setScore2(int score){
		 player2=score;
	}
	public Goal getLine1(){
		return line1;
	}
	public Goal getLine2(){
		return line2;
	}
}
