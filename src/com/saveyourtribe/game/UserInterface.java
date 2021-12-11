package com.saveyourtribe.game;

public class UserInterface {

	public void print(String text) {
		int words = text.split("\\s+").length;
		int timeInMs = 10000 * words - 4000;
		// Randomise waiting time
		int sleepFor = (timeInMs + Main.randObj.nextInt(4000)) / 42;
		// Temporary printing text to screen
		System.out.println(text);
		try {
			Thread.sleep(sleepFor);
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void printNoDelay(String text) {
		// TODO
		// This will be useful when we switch to a GUI
	}

}
