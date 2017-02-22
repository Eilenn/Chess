package com.capgemini.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueenTest {
	private ColorChess white = ColorChess.WHITE;
	private ColorChess black = ColorChess.BLACK;
	private Queen queen;
	private Coordinate from, to;
	private int fromRow, fromCol;
	private Board board;
	private Square[][] chessboard;

	@Before
	public void init() {
		queen = new Queen(white);
		board = new Board();
		board.initializeBoard();
		chessboard = board.getChessboard();
		from = new Coordinate(4, 4);
		chessboard[from.getRow()][from.getColumn()].setPiece(queen);
		fromRow = from.getRow();
		fromCol = from.getColumn();
	}

	@Test
	public void shouldReturnTrueFor1UpDestinationEmpty() {
		// given
		to = new Coordinate(fromRow - 1, fromCol);
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueFor2UpDestinationEmpty() {
		// given
		to = new Coordinate(fromRow - 2, fromCol);
		// freeing destination
		chessboard[to.getRow()][to.getColumn()].setPiece(new EmptyPiece());
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnFalseFor2UpDestinationNonEmpty() {
		// given
		to = new Coordinate(fromRow - 2, fromCol);
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnTrueFor1DownDestinationEmpty() {
		// given
		to = new Coordinate(fromRow + 1, fromCol);
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueFor2DownDestinationEmpty() {
		// given
		to = new Coordinate(fromRow + 2, fromCol);
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueFor3DownDestinationNonEmptyBlack() {
		// given
		to = new Coordinate(fromRow + 3, fromCol);
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnFalseFor3DownDestinationNonEmptyWhite() {
		// given
		to = new Coordinate(fromRow + 3, fromCol);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(white));
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnTrueFor3LeftDestinationEmpty() {
		// given
		to = new Coordinate(fromRow, fromCol - 3);
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueFor3RightDestinationEmpty() {
		// given
		to = new Coordinate(fromRow, fromCol + 3);
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnFalseFor3LeftDestinationNonEmptyWhite() {
		// given
		to = new Coordinate(fromRow, fromCol - 3);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(white));
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnFalseFor3RightDestinationNonEmptyWhite() {
		// given
		to = new Coordinate(fromRow, fromCol + 3);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(white));
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnTrueFor3LeftDestinationNonEmptyBlack() {
		// given
		to = new Coordinate(fromRow, fromCol - 3);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(black));
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueFor3RightDestinationNonEmptyBlack() {
		// given
		to = new Coordinate(fromRow, fromCol + 3);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(black));
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueForDiagonalDownLeftEmpty() {
		// given
		to = new Coordinate(fromRow + 2, fromCol - 2);
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueForDiagonalDownRightEmpty() {
		// given
		to = new Coordinate(fromRow + 2, fromCol + 2);
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueForDiagonalUpLeftEmpty() {
		// given
		to = new Coordinate(fromRow - 1, fromCol - 1);
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueForDiagonalUpRightEmpty() {
		// given
		to = new Coordinate(fromRow - 1, fromCol + 1);
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnFalseForDiagonalUpRightNonEmptyWhite() {
		// given
		to = new Coordinate(fromRow - 2, fromCol + 2);
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnTrueForDiagonalDownRightNonEmptyBlack() {
		// given
		to = new Coordinate(fromRow + 3, fromCol + 3);
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnFalseForDiagonalDownRightNonEmptyWhite() {
		// given
		to = new Coordinate(fromRow + 3, fromCol + 3);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(white));
		// when
		boolean isValid = queen.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}
}
