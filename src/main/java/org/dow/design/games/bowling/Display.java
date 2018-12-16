package org.dow.design.games.bowling;

public final class Display {
	
	private Display() {}

	public static void printMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("****************************************************************************");
		sb.append("\n*                    Welcome to the World of Bowling                       *");
		sb.append("\n*           a place of fun with occasional over engineering.               *");
		sb.append("\n****************************************************************************");
		sb.append("\n*   Enter a series of frames up to 10.                                     *");
		sb.append("\n*   Enter x or X for a strike.                                             *");
		sb.append("\n*   Enter / for a spare.                                                   *");
		sb.append("\n*   Enter 0-9 for each shot if it is not a strike or spare.                *");
		sb.append("\n*   Enter any other character to Quit.                                     *");
		sb.append("\n****************************************************************************");
		System.out.println(sb);
		sb = null;
	}
	
	public static void printEnterShot(int shot) {
		StringBuilder sb = new StringBuilder();
		sb.append("\rEnter shot :");
		System.out.println(sb);
		sb = null;
	}

	public static void printRetry() {
		StringBuilder sb = new StringBuilder();
		sb.append("\rPlease retry. Greater than 10 pins were entered.");
		System.out.println(sb);
		sb = null;
	}
	
	public static void printIncomplete() {
		System.out.print("Incomplete Game");
	}

	public static void printScore(int sum) {
		StringBuilder sb = new StringBuilder();
		sb.append("\rGame Score : ");
		sb.append(sum);
		sb.append("\rThank you for playing.");
		System.out.print(sb);
		sb = null;
	}
}
