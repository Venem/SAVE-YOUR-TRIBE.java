package com.saveyourtribe.game;

public class Games {

	public static int lives = 5;
	public static int gold = 0;

	public static String[] positiveAnswers = {
		"y", "yes", "yeah", "aha", "affirmative", "true", "t", "sure", "yup",
		"yarp", "yeth", "yarrr, it's rewind time", "oui"
	};
	public static String[] negativeAnswers = {
		"n", "no", "nope", "negative", "false", "f", "nah", "narp", "non", "nyet",
    		"how dare you", "u stoopid"
	};
	public static String[][] quizQuestions = {
		{"10 + 9", "19", "true"},
		{"16 * 2", "49", "false"},
		{"5 * 3 - 1", "15", "false"},
    	{"9 + 10", "21", "false"},
    	{"10 + 2", "12", "true"},
   		{"100 + 100", "100 * 2", "true"},
   		{"10 - 4", "4", "false"}
	};

	public static void loseLife(int livesToLose) {
		lives = lives - livesToLose;
		Main.ui.print("You have lost " + livesToLose + " life/lives. You have " + lives + " left");
	}

	public static void removeQuizQuestionAtIndex(int index) {
		// Create a new 2D array
		String[][] arrayCopy = new String[quizQuestions.length-1][quizQuestions[0].length];

		int j=0;
		for (int i=0; i<arrayCopy.length; i++) {
			// if j is the index of item we are removing, skip it by incrementing again
			if (j==index)
				j++;
			arrayCopy[i] = quizQuestions[j];
			j++;
		}
		quizQuestions = arrayCopy;
	}

	public static void quiz() {
		String answer;
		boolean isCorrect = false;
		int qIndex = Main.randObj.nextInt(quizQuestions.length);

		while (lives > 0) {
			System.out.print("Is " + quizQuestions[qIndex][0] + " equal to " + quizQuestions[qIndex][1] +": ");
			answer = Main.scanObj.nextLine();
			if (quizQuestions[qIndex][2].equals("true")) {
				for (String i: positiveAnswers) {
					if (answer.toLowerCase().equals(i)) {
						Main.ui.print("Well done, Hero!");
						isCorrect = true;
					}
				}
			} else {
				for (String j: negativeAnswers) {
					if (answer.toLowerCase().equals(j)) {
						Main.ui.print("Well done, Hero!");
						isCorrect = true;
					}
				}
			}

			if (isCorrect) {
				removeQuizQuestionAtIndex(qIndex);
				break;
			} else {
				Main.ui.print("Try again");
				loseLife(1);
			}
		}
	}

}
