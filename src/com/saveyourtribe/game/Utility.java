package com.saveyourtribe.game;

public class Utility {

	public void loseLife(int livesToLose) {
		Main.lives = Main.lives - livesToLose;
		Main.ui.print("You have lost " + livesToLose + " life/lives. You have " + Main.lives + " left");
	}

}
