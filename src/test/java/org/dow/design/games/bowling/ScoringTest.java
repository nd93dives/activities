package org.dow.design.games.bowling;

import static org.junit.Assert.*;

import org.dow.design.games.bowling.Scoring;
import org.junit.Test;

public class ScoringTest {

	private static final int[] shots = { 8, 2, 5, 4, 9, 0, 10, 0, 10, 0, 5, 5, 5, 3, 6, 3, 9, 1, 9, 1, 10 };

	@Test
	public void testScoringOpen() {
		int uat = Scoring.OPEN.getScore(3, shots);
		assertEquals(9, uat);
	}

	@Test
	public void testScoringStrike() {
		int uat = Scoring.STRIKE.getScore(7, shots);
		assertEquals(25, uat);
	}

	@Test
	public void testScoringSpare() {
		int uat = Scoring.SPARE.getScore(11, shots);
		assertEquals(15, uat);
	}
}
