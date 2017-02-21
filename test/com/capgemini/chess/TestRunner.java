package com.capgemini.chess;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(BoardTest.class, KnightTest.class,RookTest.class, BishopTest.class, KingTest.class,
				WhitePawnTest.class,BlackPawnTest.class, QueenTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}
}
