package com.capgemini.chess;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;


public class BoardTest {

	/*
	 * @Test public void test() { char c='A'; System.out.println(c);
	 * System.out.println((char)(c+1)); fail("Not yet implemented"); }
	 */

	@Test
	public void shouldCreateEmptyBoard() {
		// given
		Board board = new Board();
		// when
		board.createBoard();
		int boardSize = board.getBoard().size();
		// then
		assertEquals(64, boardSize);
	}

	@Ignore // for testing proper color assignment during creation of the board;
			// A1 is black, B1 is white etc.
	@Test
	public void shouldHaveInterchangeableColorsForCreatedBoard() {
		// given
		Board board = new Board();
		// when
		board.createBoard();
		int boardSize = board.getBoard().size();
		displayEmptyBoard(board.getBoard());
	}

	private void displayEmptyBoard(Map<Square, Piece> emptyBoard) {
		for (Square s : emptyBoard.keySet()) {
			System.out.println(s.getRank() + " " + s.getFile() + " " + getColorFromRGB(s.getColor()));
		}
	}
/**
 * help in display - so that color is not in rgb form
 * @param color
 * @return
 */
	private String getColorFromRGB(Color color) {
		if (color.equals(Color.BLACK))
			return "Black";
		else if (color.equals(Color.WHITE))
			return "White";
		else
			return "unknown";
	}

}
