package com.capgemini.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BishopTest {
	private ColorChess white = ColorChess.WHITE;
	private ColorChess black = ColorChess.BLACK;
	private Bishop bishop;
	private Coordinate from, to;
	private Board board;
	private Square[][] chessboard;

	@Before
	public void init() {
		bishop = new Bishop(white);
		board = new Board();
		board.initializeBoard();
		chessboard = board.getChessboard();
		from=new Coordinate(3, 3);
	}

	@Test
	public void shouldReturnTrueForUpAndLeft() {
		// given
		
		to=new Coordinate(2, 2);
		// when
		boolean isAllowed=bishop.isMoveAllowed(from, to);
		// then
		assertTrue(isAllowed);
	}
	
	@Test
	public void shouldReturnTrueForUpAndRight() {
		// given
		to=new Coordinate(2, 4);
		// when
		boolean isAllowed=bishop.isMoveAllowed(from, to);
		// then
		assertTrue(isAllowed);
	}
	@Test
	public void shouldReturnTrueForDownAndLeft() {
		// given
		to=new Coordinate(4, 2);
		// when
		boolean isAllowed=bishop.isMoveAllowed(from, to);
		// then
		assertTrue(isAllowed);
	}
	@Test
	public void shouldReturnTrueForDownAndRight() {
		// given
		to=new Coordinate(4, 4);
		// when
		boolean isAllowed=bishop.isMoveAllowed(from, to);
		// then
		assertTrue(isAllowed);
	}
	@Test
	public void shouldReturnTrueForDiagonalMoreThan1FieldMove() {
		// given
		to=new Coordinate(6, 6);
		// when
		boolean isAllowed=bishop.isMoveAllowed(from, to);
		// then
		assertTrue(isAllowed);
	}
	@Test
	public void shouldReturnFalseForNotDiagonal() {
		// given
		to=new Coordinate(3, 4);
		// when
		boolean isAllowed=bishop.isMoveAllowed(from, to);
		// then
		assertFalse(isAllowed);
	}
}
