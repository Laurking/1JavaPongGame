package com.laurking.launcher;

import com.laurking.game.Game;

public class Launcher {

	public static void main(String[] args) {
		Game game=new Game("Pong",1250,680);
		game.start();

	}

}
