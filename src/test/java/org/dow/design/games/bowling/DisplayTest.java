package org.dow.design.games.bowling;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.dow.design.games.bowling.Display;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DisplayTest {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final PrintStream systemOut = new PrintStream(out);

	@Before
	public void setUp() {
		System.setOut(new PrintStream(out));
	}

	@Test
	public void testPrint() {
		Display.printMenu();
		assertTrue(out.toString().contains("****************************************************************************"));
		assertTrue(out.toString().contains("*                    Welcome to the World of Bowling                       *"));
		assertTrue(out.toString().contains("*           a place of fun with occasional over engineering.               *"));
		assertTrue(out.toString().contains("****************************************************************************"));
		assertTrue(out.toString().contains("*   Enter a series of frames up to 10.                                     *"));
		assertTrue(out.toString().contains("*   Enter x or X for a strike.                                             *"));
		assertTrue(out.toString().contains("*   Enter / for a spare.                                                   *"));
		assertTrue(out.toString().contains("*   Enter 0-9 for each shot if it is not a strike or spare.                *"));
		assertTrue(out.toString().contains("*   Enter any other character to Quit.                                     *"));
		assertTrue(out.toString().contains("****************************************************************************"));
	}

	@Test
	public void testPrintEnterShot() {
		Display.printEnterShot(1);

		StringBuilder sb = new StringBuilder();
		sb.append("\rEnter shot :");

		assertTrue(out.toString().contains(sb));
	}

	@Test
	public void testRetry() {
		Display.printRetry();

		StringBuilder sb = new StringBuilder();
		sb.append("Please retry. Greater than 10 pins were entered.");

		assertTrue(out.toString().contains(sb));
	}

	@Test
	public void testIncomplete() {
		Display.printIncomplete();

		assertTrue(out.toString().contains("Incomplete Game"));
	}

	@Test
	public void testScore() {
		Display.printScore(34);

		StringBuilder sb = new StringBuilder();
		sb.append("\rGame Score : ");
		sb.append(34);
		sb.append("\rThank you for playing.");

		assertTrue(out.toString().contains(sb));
	}

	@After
	public void tearDown() {
		System.setOut(systemOut);
	}

}
