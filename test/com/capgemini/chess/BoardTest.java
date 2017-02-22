package com.capgemini.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
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
		int boardRankSize = board.getChessboard()[0].length;
		int boardFileSize = board.getChessboard().length;
		// when
		int size = boardRankSize * boardFileSize;
		// then
		assertEquals(81, size);
	}

}
