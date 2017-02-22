package com.capgemini.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KingMovingCheckTest {
	private King king;
	private Coordinate from, to;
	private Board board;
	private Square[][] chessboard;
	ColorChess black = ColorChess.BLACK;
	ColorChess white = ColorChess.WHITE;

	@Before
	public void init() {
		board = new Board();
		chessboard = board.getChessboard();
		king = new King(black);
	}

	@Test
	public void shouldReturnTrueForMovingBlackKingWithCausingCheckByWhiteQueen() {
		// given
		from = new Coordinate(8, 4);
		to = new Coordinate(8, 5);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		chessboard[4][1].setPiece(new Queen(white));
		chessboard[1][5].setPiece(new King(white));
		// when
		boolean wouldCauseCheck = king.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertTrue(wouldCauseCheck);
	}

	@Test
	public void shouldReturnFalseForMovingBlackKingOneLeftWithoutCausingCheckByWhiteQueen() {
		// given
		from = new Coordinate(8, 4);
		to = new Coordinate(8, 3);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		chessboard[4][1].setPiece(new Queen(white));
		chessboard[1][5].setPiece(new King(white));
		// when
		boolean wouldCauseCheck = king.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertFalse(wouldCauseCheck);
	}

	@Test
	public void shouldReturnTrueForMovingBlackKingWithCausingCheckByWhiteBishop() {
		// given
		from = new Coordinate(8, 5);
		to = new Coordinate(7, 5);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		chessboard[3][4].setPiece(new King(white));
		chessboard[6][6].setPiece(new Bishop(white));
		// when
		boolean wouldCauseCheck = king.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertTrue(wouldCauseCheck);
	}

	@Test
	public void shouldReturnFalseForMovingBlackKingOneRightWithoutCausingCheckByWhiteBishop() {
		// given
		from = new Coordinate(8, 5);
		to = new Coordinate(8, 6);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		chessboard[3][4].setPiece(new King(white));
		chessboard[6][6].setPiece(new Bishop(white));
		// when
		boolean wouldCauseCheck = king.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertFalse(wouldCauseCheck);
	}

	@Test
	public void shouldReturnTrueForMovingBlackKingWithCausingCheckByWhiteRook() {
		// given
		from = new Coordinate(8, 3);
		to = new Coordinate(8, 4);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		chessboard[1][5].setPiece(new King(white));
		chessboard[3][4].setPiece(new Rook(white));
		// when
		boolean wouldCauseCheck = king.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertTrue(wouldCauseCheck);
	}

	@Test
	public void shouldReturnFalseForMovingBlackKingOneLeftWithoutCausingCheckByWhiteRook() {
		// given
		from = new Coordinate(8, 3);
		to = new Coordinate(8, 2);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		chessboard[1][5].setPiece(new King(white));
		chessboard[3][4].setPiece(new Rook(white));
		// when
		boolean wouldCauseCheck = king.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertFalse(wouldCauseCheck);
	}

	@Test
	public void shouldReturnTrueForMovingBlackKingWithCausingCheckByWhiteKnight() {
		// given
		from = new Coordinate(2, 2);
		to = new Coordinate(2, 3);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		chessboard[5][2].setPiece(new King(white));
		chessboard[4][4].setPiece(new Knight(white));
		// when
		boolean wouldCauseCheck = king.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertTrue(wouldCauseCheck);
	}

	@Test
	public void shouldReturnFalseForMovingBlackKingOneUpWithoutCausingCheckByWhiteKnight() {
		// given
		from = new Coordinate(2, 2);
		to = new Coordinate(1, 2);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		chessboard[5][2].setPiece(new King(white));
		chessboard[4][4].setPiece(new Knight(white));
		// when
		boolean wouldCauseCheck = king.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertFalse(wouldCauseCheck);
	}

	@Test
	public void shouldReturnTrueForMovingKingWithCausingCheckByWhitePawn() {
		// given
		from = new Coordinate(4, 2);
		to = new Coordinate(3, 3);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		chessboard[7][2].setPiece(new King(white));
		chessboard[2][4].setPiece(new Pawn(white));
		// when
		boolean wouldCauseCheck = king.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertTrue(wouldCauseCheck);
	}

	@Test
	public void shouldReturnFalseForMovingKingOneUpWithoutCausingCheckByWhitePawn() {
		// given
		from = new Coordinate(4, 2);
		to = new Coordinate(3, 2);
		chessboard[from.getRow()][from.getColumn()].setPiece(king);
		chessboard[7][2].setPiece(new King(white));
		chessboard[2][4].setPiece(new Pawn(white));
		// when
		boolean wouldCauseCheck = king.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertFalse(wouldCauseCheck);
	}
}
