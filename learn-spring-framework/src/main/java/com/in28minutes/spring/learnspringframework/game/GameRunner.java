package com.in28minutes.spring.learnspringframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
	@Autowired
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
