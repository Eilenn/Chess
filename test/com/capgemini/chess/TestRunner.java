package com.capgemini.chess;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(BishopTest.class,BlackPawnTest.class, BoardTest.class,EmptyPieceTest.class,KnightTest.class, KingTest.class,
				 QueenTest.class, KingMovingCheckTest.class, PieceMovingCheckTest.class,RookTest.class, WhitePawnTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}
}
