package com.capgemini.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KingTest {
	private ColorChess white = ColorChess.WHITE;
	private King king;
	private Coordinate from, to;
	private Board board;
	private Square[][] chessboard;

	@Before
	public void init() {
		board = new Board();
		board.initializeBoard();
		king = new King(white);
		chessboard = board.getChessboard();
		from = new Coordinate(5, 5);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
	}

	@Test
	public void shouldReturnTrueFor1Up() {
		// given
		to = new Coordinate(from.getRow() - 1, from.getColumn());
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnFalseFor2Up() {
		// given
		to = new Coordinate(from.getRow() - 2, from.getColumn());
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnTrueFor1Up1Left() {
		// given
		to = new Coordinate(from.getRow() - 1, from.getColumn() - 1);
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueFor1Up1Right() {
		// given
		to = new Coordinate(from.getRow() - 1, from.getColumn() + 1);
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueFor1Down() {
		// given
		chessboard[from.getRow()][from.getColumn()].setPiece(new EmptyPiece());
		from = new Coordinate(3, 3);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		to = new Coordinate(from.getRow() + 1, from.getColumn());
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnFalseFor1DownBecauseCheckByBlackPawn() {
		// given
		to = new Coordinate(from.getRow() + 1, from.getColumn());
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnTrueFor1Down1Left() {
		// given
		chessboard[from.getRow()][from.getColumn()].setPiece(new EmptyPiece());
		from = new Coordinate(3, 3);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		to = new Coordinate(from.getRow() + 1, from.getColumn() - 1);
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueFor1Down1Right() {
		// given
		chessboard[from.getRow()][from.getColumn()].setPiece(new EmptyPiece());
		from = new Coordinate(3, 3);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		to = new Coordinate(from.getRow() + 1, from.getColumn() + 1);
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueFor1Left() {
		// given
		chessboard[from.getRow()][from.getColumn()].setPiece(new EmptyPiece());
		from = new Coordinate(3, 3);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		to = new Coordinate(from.getRow(), from.getColumn() - 1);
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnFalseFor2Left() {
		// given
		to = new Coordinate(from.getRow(), from.getColumn() - 2);
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnTrueFor1Right() {
		// given
		chessboard[from.getRow()][from.getColumn()].setPiece(new EmptyPiece());
		from = new Coordinate(3, 3);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		to = new Coordinate(from.getRow(), from.getColumn() + 1);
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnFalseForRandomPlace() {
		// given
		to = new Coordinate(3, 8);
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	// tests for occupied places around king

	@Test
	public void shouldReturnFalseFor1DownOccupied() {
		// given
		from = new Coordinate(1, 5);
		to = new Coordinate(from.getRow() + 1, from.getColumn());
		chessboard[5][5].setPiece(new EmptyPiece());
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnFalseFor1LeftOccupied() {
		// given
		from = new Coordinate(1, 5);
		to = new Coordinate(from.getRow(), from.getColumn() - 1);
		chessboard[5][5].setPiece(new EmptyPiece());
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnFalseFor1RightOccupied() {
		// given
		from = new Coordinate(1, 5);
		to = new Coordinate(from.getRow(), from.getColumn() + 1);
		chessboard[5][5].setPiece(new EmptyPiece());
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnFalseFor1Down1RightOccupied() {
		// given
		from = new Coordinate(1, 5);
		to = new Coordinate(from.getRow() + 1, from.getColumn() + 1);
		chessboard[5][5].setPiece(new EmptyPiece());
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnFalseFor1Down1LeftOccupied() {
		// given
		from = new Coordinate(1, 5);
		to = new Coordinate(from.getRow() + 1, from.getColumn() - 1);
		chessboard[5][5].setPiece(new EmptyPiece());
		// when
		boolean isValid = king.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

}
