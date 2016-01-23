package com.laurking.movement.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.laurking.game.Game;

public class MovementListener implements KeyListener {
	private Game game;
	public MovementListener(Game game) {
		this.game=game;
	}
	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_S) {
			game.getBat().get(0).setVelY(-10);
		}
		else if (key == KeyEvent.VK_D) {
			game.getBat().get(0).setVelY(10);
		}
		else if (key == KeyEvent.VK_UP) {
			game.getBat().get(1).setVelY(-10);
		}
		else if (key == KeyEvent.VK_DOWN) {
			game.getBat().get(1).setVelY(10);
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_S) {
			game.getBat().get(0).setVelY(0);
		}
		else if (key == KeyEvent.VK_D) {
			game.getBat().get(0).setVelY(0);
		}
		else if (key == KeyEvent.VK_UP) {
			game.getBat().get(1).setVelY(0);
		}
		else if (key == KeyEvent.VK_DOWN) {
			game.getBat().get(1).setVelY(0);
		}
	}

}
