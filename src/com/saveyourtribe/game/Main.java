package com.saveyourtribe.game;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static Random randObj = new Random();
	public static Scanner scanObj = new Scanner(System.in);

	public static UserInterface ui = new UserInterface();
	public static Games games = new Games();

	public static void main(String[] args) {
		while (true)
			Games.quiz();
	}

}
