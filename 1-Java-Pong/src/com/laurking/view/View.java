package com.laurking.view;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
public class View {
	
	private JFrame window;
	private Canvas canvas;
	private int WIDTH, HEIGHT;
	private String TITLE;
	
	public View(String title, int width, int height) {
		TITLE=title;
		WIDTH=width;
		HEIGHT=height ;
		createDisplay();
	}
	
	private void createDisplay(){
		window=new JFrame();
		window.setSize(WIDTH, HEIGHT);
		window.setTitle(TITLE);
		canvas=new Canvas();
		canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		canvas.setFocusable(true);
		window.add(canvas);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
	
		window.setVisible(true);
	}
	public JFrame getWindow(){
		return window;
	}
	public Canvas getCanvas(){
		return canvas;
	}
	
	
}
