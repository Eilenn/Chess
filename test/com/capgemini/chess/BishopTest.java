package com.capgemini.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BishopTest {
	private ColorChess white = ColorChess.WHITE;
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
		from = new Coordinate(3, 3);
	}

	@Test
	public void shouldReturnFalseForUpAndLeftDestinationOccupied() {
		// given
		chessboard[from.getRow()][from.getColumn()].setPiece(bishop);
		to = new Coordinate(2, 2);
		// when
		boolean isAllowed = bishop.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}

	@Test
	public void shouldReturnFalseForUpAndRightDestinationOccupied() {
		// given
		chessboard[from.getRow()][from.getColumn()].setPiece(bishop);
		to = new Coordinate(2, 4);
		// when
		boolean isAllowed = bishop.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}

	@Test
	public void shouldReturnTrueForDownAndLeft() {
		// given
		chessboard[from.getRow()][from.getColumn()].setPiece(bishop);
		to = new Coordinate(4, 2);
		// when
		boolean isAllowed = bishop.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}

	@Test
	public void shouldReturnTrueForDownAndRight() {
		// given
		chessboard[from.getRow()][from.getColumn()].setPiece(bishop);
		to = new Coordinate(4, 4);
		// when
		boolean isAllowed = bishop.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}

	@Test
	public void shouldReturnTrueForDiagonalMoreThan1FieldMove() {
		// given
		chessboard[from.getRow()][from.getColumn()].setPiece(bishop);
		to = new Coordinate(6, 6);
		// when
		boolean isAllowed = bishop.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}

	@Test
	public void shouldReturnFalseForNotDiagonal() {
		// given
		chessboard[from.getRow()][from.getColumn()].setPiece(bishop);
		to = new Coordinate(3, 4);
		// when
		boolean isAllowed = bishop.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}

	@Test
	public void shouldReturnTrueForUpAndLeftUnoccupied() {
		// given
		from = new Coordinate(5, 5);
		to = new Coordinate(4, 4);
		chessboard[from.getRow()][from.getColumn()].setPiece(bishop);
		// when
		boolean isValid = bishop.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnFalseForUpAndLeftOccupied() {
		// given
		from = new Coordinate(5, 5);
		to = new Coordinate(1, 1);
		chessboard[from.getRow()][from.getColumn()].setPiece(bishop);
		// when
		boolean isValid = bishop.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnTrueForUpAndRightUnoccupied() {
		// given
		from = new Coordinate(5, 5);
		to = new Coordinate(4, 6);
		chessboard[from.getRow()][from.getColumn()].setPiece(bishop);
		// when
		boolean isValid = bishop.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnFalseForUpAndRightOccupied() {
		// given
		from = new Coordinate(5, 4);
		to = new Coordinate(1, 8);
		chessboard[from.getRow()][from.getColumn()].setPiece(bishop);
		// when
		boolean isValid = bishop.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}
}
