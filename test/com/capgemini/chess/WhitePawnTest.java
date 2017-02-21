package com.capgemini.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhitePawnTest {

	private Board board;
	private Pawn pawn;
	private ColorChess white = ColorChess.WHITE;
	private ColorChess black = ColorChess.BLACK;
	private Coordinate from, to;
	private Square[][] chessboard;
	
	@Before
	public void init() {
		board=new Board();
		board.initializeBoard();
		chessboard=board.getChessboard();
		pawn=new Pawn(white);
		from=new Coordinate(2, 3);
	}

	@Test
	public void shouldReturnTrueSecondMove1Forward() {
		// given
		pawn.setFirstMove(false);
		to=new Coordinate(from.getRow()+1, from.getColumn());
		// when
		boolean isAllowed=pawn.isAllowed(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}

	@Test
	public void shouldReturnFalseSecondMove1Backwards() {
		pawn.setFirstMove(false);
		to=new Coordinate(from.getRow()-1, from.getColumn());
		// when
		boolean isAllowed=pawn.isAllowed(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}

	@Test
	public void shouldReturnTrueFirstMove2Forward() {
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()+2, from.getColumn());
		// when
		boolean isAllowed=pawn.isAllowed(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}

	@Test
	public void shouldReturnFalseFirstMove2Backwards() {
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()-2, from.getColumn());
		// when
		boolean isAllowed=pawn.isAllowed(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}

	@Test
	public void shouldReturnTrueFirstMove1Forward() {
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()+1, from.getColumn());
		// when
		boolean isAllowed=pawn.isAllowed(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}

	@Test
	public void shouldReturnFalseFirstMove1Backwards() {
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()-1, from.getColumn());
		// when
		boolean isAllowed=pawn.isAllowed(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}
	
	@Test
	public void shouldReturnTrueForAttemptToCaptureBlack(){
		// given
		to=new Coordinate(from.getRow()+1, from.getColumn()-1);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(black));
		// when
		boolean isCapture=pawn.isAttemptToCapture(from, to, chessboard);
		// then
		assertTrue(isCapture);
	}
	
	@Test
	public void shouldReturnFalseForAttemptToCaptureWhite(){
		// given
		to=new Coordinate(from.getRow()+1, from.getColumn()-1);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(white));
		// when
		boolean isCapture=pawn.isAttemptToCapture(from, to, chessboard);
		// then
		assertFalse(isCapture);
	}
	
	@Test
	public void shouldReturnFalseForAttemptToCaptureBlackOnUnallowedField(){
		// given
		to=new Coordinate(from.getRow()+2, from.getColumn()+2);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(black));
		// when
		boolean isCapture=pawn.isAttemptToCapture(from, to, chessboard);
		// then
		assertFalse(isCapture);
	}
	
/*	@Test
	public void shouldReturnTrueFor1DiagonalForwardLeftSecondMove(){
		// given
		pawn.setFirstMove(false);
		to=new Coordinate(from.getRow()+1, from.getColumn()-1);
		// when
		boolean isAllowed=pawn.isAllowed(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}
	
	@Test
	public void shouldReturnFalseFor2DiagonalForwardLeftSecondMove(){
		// given
		pawn.setFirstMove(false);
		to=new Coordinate(from.getRow()+2, from.getColumn()-2);
		// when
		boolean isAllowed=pawn.isAllowed(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}
	
	@Test
	public void shouldReturnTrueFor1DiagonalForwardRightSecondMove(){
		// given
		pawn.setFirstMove(false);
		to=new Coordinate(from.getRow()+1, from.getColumn()+1);
		// when
		boolean isAllowed=pawn.isAllowed(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}
	
	@Test
	public void shouldReturnTrueFor1DiagonalForwardLeftFirstMove(){
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()+1, from.getColumn()-1);
		// when
		boolean isAllowed=pawn.isAllowed(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}
	
	@Test
	public void shouldReturnTrueFor1DiagonalForwardRightFirstMove(){
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()+1, from.getColumn()+1);
		// when
		boolean isAllowed=pawn.isAllowed(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}*/
}
