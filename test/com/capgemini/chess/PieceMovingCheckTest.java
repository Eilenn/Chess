package com.capgemini.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PieceMovingCheckTest {
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
		king = new King(white);
	}

	@Test
	public void shouldReturnTrueForMovingWhiteRookIntoCheck() {
		// given
		from = new Coordinate(2, 3);
		to = new Coordinate(2, 4);
		Rook whiteRook = new Rook(white);
		chessboard[from.getRow()][from.getColumn()].setPiece(whiteRook);
		chessboard[1][3].setPiece(king);
		chessboard[5][3].setPiece(new Rook(black));
		chessboard[8][5].setPiece(new King(black));
		// when
		boolean wouldCauseCheck = whiteRook.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertTrue(wouldCauseCheck);
	}

	@Test
	public void shouldReturnFalseForNotMovingWhiteTowerIntoCheck() {
		// given
		from = new Coordinate(2, 3);
		to = new Coordinate(3, 3);
		Piece whiteRook = new Rook(white);
		chessboard[from.getRow()][from.getColumn()].setPiece(whiteRook);
		chessboard[1][3].setPiece(king);
		chessboard[5][3].setPiece(new Rook(black));
		chessboard[8][5].setPiece(new King(black));
		// when
		boolean wouldCauseCheck = whiteRook.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertFalse(wouldCauseCheck);
	}

	@Test
	public void shouldReturnTrueForMovingWhiteQueenIntoCheck() {
		// given
		from = new Coordinate(2, 3);
		to = new Coordinate(3, 4);
		Piece whiteQueen = new Queen(white);
		chessboard[from.getRow()][from.getColumn()].setPiece(whiteQueen);
		chessboard[1][3].setPiece(king);
		chessboard[5][3].setPiece(new Rook(black));
		chessboard[8][5].setPiece(new King(black));
		// when
		boolean wouldCauseCheck = whiteQueen.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertTrue(wouldCauseCheck);
	}

	@Test
	public void shouldReturnFalseForNotMovingWhiteQueenIntoCheck() {
		// given
		from = new Coordinate(2, 3);
		to = new Coordinate(3, 3);
		Piece whiteQueen = new Queen(white);
		chessboard[from.getRow()][from.getColumn()].setPiece(whiteQueen);
		chessboard[1][3].setPiece(king);
		chessboard[5][3].setPiece(new Rook(black));
		chessboard[8][5].setPiece(new King(black));
		// when
		boolean wouldCauseCheck = whiteQueen.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertFalse(wouldCauseCheck);
	}
	
	@Test
	public void shouldReturnTrueForMovingWhiteBishopIntoCheck() {
		// given
		from = new Coordinate(2, 4);
		to = new Coordinate(3, 3);
		Piece whiteBishop = new Bishop(white);
		chessboard[from.getRow()][from.getColumn()].setPiece(whiteBishop);
		chessboard[1][3].setPiece(king);
		chessboard[5][7].setPiece(new Bishop(black));
		chessboard[8][5].setPiece(new King(black));
		// when
		boolean wouldCauseCheck = whiteBishop.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertTrue(wouldCauseCheck);
	}
	
	@Test
	public void shouldReturnFalseForNotMovingWhiteBishopIntoCheck() {
		// given
		from = new Coordinate(2, 4);
		to = new Coordinate(3, 5);
		Piece whiteBishop = new Bishop(white);
		chessboard[from.getRow()][from.getColumn()].setPiece(whiteBishop);
		chessboard[1][3].setPiece(king);
		chessboard[5][7].setPiece(new Bishop(black));
		chessboard[8][5].setPiece(new King(black));
		// when
		boolean wouldCauseCheck = whiteBishop.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertFalse(wouldCauseCheck);
	}
	
	@Test
	public void shouldReturnTrueForMovingWhiteKnightIntoCheck(){
		// given
		from = new Coordinate(2, 3);
		to = new Coordinate(3, 5);
		Piece whiteKnight = new Knight(white);
		chessboard[from.getRow()][from.getColumn()].setPiece(whiteKnight);
		chessboard[1][3].setPiece(king);
		chessboard[5][3].setPiece(new Rook(black));
		chessboard[8][5].setPiece(new King(black));
		// when
		boolean wouldCauseCheck = whiteKnight.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertTrue(wouldCauseCheck);
	}
	
	@Test
	public void shouldReturnTrueForMovingWhitePawnIntoCheck(){
		// given
		from = new Coordinate(2, 4);
		to = new Coordinate(3, 4);
		Piece whitePawn = new Pawn(white);
		chessboard[from.getRow()][from.getColumn()].setPiece(whitePawn);
		chessboard[1][3].setPiece(king);
		chessboard[5][7].setPiece(new Bishop(black));
		chessboard[8][5].setPiece(new King(black));
		// when
		boolean wouldCauseCheck = whitePawn.wouldMoveCauseCheck(from, to, chessboard);
		// then
		assertTrue(wouldCauseCheck);
	}
}
