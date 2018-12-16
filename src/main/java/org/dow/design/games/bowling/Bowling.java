package org.dow.design.games.bowling;

import java.util.Scanner;

public class Bowling {

	private int[] shots = new int[21];

	public Bowling() {
		Display.printMenu();

		enterShots();

		Display.printScore(calculateScore());
	}

	protected void enterShots() {
		Scanner scanner = new Scanner(System.in);
		for (int shot=0; shot <= 20; shot++) {

			Display.printEnterShot(shot);
			String ch = String.valueOf(new Character(scanner.next().charAt(0)));

			if (ch.matches("^[^0-9Xx\\/]")) {
				Display.printIncomplete();
				break;
			}
			setShot(ch, shot);	
		}
		scanner.close();
	}
	
	protected void setShot(String ch, int shot) {
		if (ch.matches("^[0-9]")) {
			shots[shot] = Integer.parseInt(ch);
		}

		if (ch.matches("^[Xx]")) {
			shots[shot] = 10;
		}

		if (ch.matches("^[\\/]")) {
			shots[shot] = 10 - shots[shot - 1];
		}
	}

	protected int calculateScore() {
		int score = 0;

		for (int frame = 1, shot = 1; frame <= 10; frame++, shot+=2) {
			if (shots[shot-1] == 10) {
				score += Scoring.STRIKE.getScore(shot, shots);
			} else if (shots[shot] + shots[shot - 1] == 10) {
				score += Scoring.SPARE.getScore(shot, shots);
			} else {
				score += Scoring.OPEN.getScore(shot, shots);
			}
		}

		return score;
	}
}
