package com.in28minutes.spring.learnspringframework;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.spring.learnspringframework.game.GameRunner;
import com.in28minutes.spring.learnspringframework.game.PacManGame;
import com.in28minutes.spring.learnspringframework.game.SuperContraGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		//SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
		//MarioGame game = new MarioGame();
		//SuperContraGame game = new SuperContraGame();
		PacManGame game = new PacManGame();
		GameRunner runner = new GameRunner(game);
		
		runner.run();
	}

}
