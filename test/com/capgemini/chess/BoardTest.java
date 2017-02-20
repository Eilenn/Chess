package com.capgemini.chess;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	private Board board;

	@Before
	public void init() {
		board = new Board();
	}

	@Test
	public void shouldCreateEmptyBoard() {
		// given
		// Board board = new Board();
		// when
		int boardRankSize = board.getBoard()[0].length;
		int boardFileSize = board.getBoard().length;
		// then
		assertEquals(81, boardRankSize * boardFileSize);
	}

	/**
	 * help in display - so that color is not in rgb form
	 * 
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
