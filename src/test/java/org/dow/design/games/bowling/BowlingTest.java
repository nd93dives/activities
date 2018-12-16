package org.dow.design.games.bowling;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import org.dow.design.games.bowling.Bowling;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BowlingTest {

	private static final byte[] shots = { '8', '\n', '2', '\n', '5', '\n', '4', '\n', '9', '\n', '0', '\n', 'X', '\n',
			'0', '\n', 'X', '\n', '0', '\n', '5', '\n', '5', '\n', '5', '\n', '3', '\n', '6', '\n', '3', '\n', '9',
			'\n', '1', '\n', '9', '\n', '1', '\n', 'X', '\n' };

	private static final byte[] incompleteShots = { '8', '\n', '2', '\n', '5', '\n', '4', '\n', '9', '\n', '0', '\n',
			'g' };

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final PrintStream systemOut = new PrintStream(out);
	ByteArrayInputStream in = new ByteArrayInputStream(shots);

	private Bowling uat;
	private Field shotsField;

	@Before
	public void setUp() throws Exception {
		System.setIn(in);
		System.setOut(systemOut);

		uat = new Bowling();

		shotsField = uat.getClass().getDeclaredField("shots");
		shotsField.setAccessible(true);
	}

	@Test
	public void testCalculateScore() {
		int result = uat.calculateScore();
		assertEquals(149, result);
	}

	@Test
	public void testEnterShotsForIncompleteGame() throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(incompleteShots);
		System.setIn(in);
		uat.enterShots();
		assertTrue(out.toString().contains("Incomplete Game"));
	}

	@Test
	public void testSetDigitShot() throws Exception {
		uat.setShot("7", 3);
		int[] result = (int[]) shotsField.get(uat);
		assertEquals(7, result[3]);
	}

	@Test
	public void testSetStrikeShot() throws Exception {
		uat.setShot("x", 20);
		int[] result = (int[]) shotsField.get(uat);
		assertEquals(10, result[20]);
	}

	@Test
	public void testSetSpareShot() throws Exception {
		uat.setShot("/", 3);
		int[] result = (int[]) shotsField.get(uat);
		assertEquals(5, result[3]);
	}

	@After
	public void tearDown() {
		System.setIn(in);
		System.setOut(systemOut);
		uat = null;
	}
}
