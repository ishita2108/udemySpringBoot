package com.in28minutes.spring.learnspringframework.game;

public class GameRunner {
	
	private GameConsoleInterface game;
	
	public GameRunner(GameConsoleInterface game) {
		this.game = game;

	}
	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
		
	}

}
