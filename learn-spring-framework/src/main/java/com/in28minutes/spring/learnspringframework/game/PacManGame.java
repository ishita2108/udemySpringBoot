package com.in28minutes.spring.learnspringframework.game;

public class PacManGame implements GameConsoleInterface{
	
	public void up() {
		System.out.println("PacManGame UP");
	}
	
	public void down() {
		System.out.println("PacManGame DOWN");
	}
	
	public void left() {
		System.out.println("PacManGame LEFT");
	}
	
	public void right() {
		System.out.println("PacManGame RIGHT");
	}

}