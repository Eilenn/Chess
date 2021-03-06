package com.capgemini.chess;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RookTest {
	private ColorChess white = ColorChess.WHITE;
	private ColorChess black = ColorChess.BLACK;
	private Rook rook;
	private Coordinate from, to;
	private Board board;
	private Square[][] chessboard;

	@Before
	public void init() {
		rook = new Rook(white);
		board = new Board();
		board.initializeBoard();
		chessboard = board.getChessboard();
	}

	@Test
	public void shouldReturnTrueForRookMovedInTheSameColumn() {
		// given
		from = new Coordinate(3, 4);
		to = new Coordinate(5, 4);
		chessboard[from.getRow()][from.getColumn()].setPiece(rook);
		// when
		boolean isInTheSameColumn = rook.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isInTheSameColumn);
	}

	@Test
	public void shouldReturnTrueForRookMovedInTheSameRow() {
		// given
		from = new Coordinate(4, 2);
		to = new Coordinate(4, 4);
		chessboard[from.getRow()][from.getColumn()].setPiece(rook);
		// when
		boolean isInTheSameRow = rook.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isInTheSameRow);
	}

	@Test
	public void shouldReturnFalseForPiecesInPath() {
		// given
		from = new Coordinate(1, 1);
		to = new Coordinate(4, 1);
		Piece piece = chessboard[from.getRow()][from.getColumn()].getPiece();
		// when
		boolean isValid = piece.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnTrueForNoPiecesInPathMoveInColumn() {
		// given
		from = new Coordinate(1, 1);
		to = new Coordinate(4, 1);
		Piece piece = chessboard[from.getRow()][from.getColumn()].getPiece();
		chessboard[2][from.getColumn()].setPiece(new EmptyPiece());
		;
		// when
		boolean isValid = piece.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnFalseForRookMovedNotInRowNorInColumnWithBlockedPath() {
		// given
		from = new Coordinate(1, 1);
		to = new Coordinate(4, 4);
		Piece piece = chessboard[from.getRow()][from.getColumn()].getPiece();
		// when
		boolean isValid = piece.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnFalseForRookMovedNotInRowNorInColumnWithFreePath() {
		// given
		from = new Coordinate(1, 1); // index of first rook
		to = new Coordinate(4, 4);
		Piece piece = chessboard[from.getRow()][from.getColumn()].getPiece();
		// freeing path from pawn
		chessboard[from.getRow() + 1][from.getColumn()].setPiece(new EmptyPiece());
		// when
		boolean isValid = piece.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnFalseForCapturingTheSameColorMoveOne() {
		// given
		from = new Coordinate(1, 1);
		to = new Coordinate(2, 1);
		chessboard[1][1].setPiece(new Rook(white));
		chessboard[2][1].setPiece(new Rook(white));
		// when
		boolean isValid = rook.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnTrueForCapturingOtherColorMoveOne() {
		// given
		from = new Coordinate(1, 1);
		to = new Coordinate(2, 1);
		chessboard[1][1].setPiece(new Rook(white));
		chessboard[2][1].setPiece(new Rook(black));
		// when
		boolean isValid = rook.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isValid);
	}
}
