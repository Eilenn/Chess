package com.capgemini.chess;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlackPawnTest {

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
		pawn=new Pawn(black);
		from=new Coordinate(7, 3);
	}
	@Test
	public void shouldReturnTrueSecondMove1Forward() {
		pawn.setFirstMove(false);
		to=new Coordinate(from.getRow()-1, from.getColumn());
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}
	
	@Test
	public void shouldReturnFalseSecondMove1Backwards() {
		// given
		pawn.setFirstMove(false);
		to=new Coordinate(from.getRow()+1, from.getColumn());
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}
	
	@Test
	public void shouldReturnTrueFirstMove2Forward() {
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()-2, from.getColumn());
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}
	
	@Test
	public void shouldReturnTrueFirstMove1Forward() {
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()-1, from.getColumn());
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}
	@Test
	public void shouldReturnFalseFirstMove1Backwards() {
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()+1, from.getColumn());
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}
	
	@Test
	public void shouldReturnFalseForAttemptToCaptureBlack(){
		// given
		to=new Coordinate(from.getRow()-1, from.getColumn()+1);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(black));
		// when
		boolean isCapture=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isCapture);
	}
	
	@Test
	public void shouldReturnTrueForAttemptToCaptureWhite(){
		// given
		to=new Coordinate(from.getRow()-1, from.getColumn()+1);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(white));
		// when
		boolean isCapture=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isCapture);
	}
	
	@Test
	public void shouldReturnFalseForAttemptToCaptureBlackOnUnallowedField(){
		// given
		to=new Coordinate(from.getRow()-2, from.getColumn()+2);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(black));
		// when
		boolean isCapture=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isCapture);
	}
	
	@Test
	public void shouldReturnTrueFor1DiagonalForwardLeftSecondMoveNonEmptyWhite(){
		// given
		pawn.setFirstMove(false);
		to=new Coordinate(from.getRow()-1, from.getColumn()-1);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(white));
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}
	@Test
	public void shouldReturnFalseFor1DiagonalForwardLeftSecondMoveNonEmptyBlack(){
		// given
		pawn.setFirstMove(false);
		to=new Coordinate(from.getRow()-1, from.getColumn()-1);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(black));
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}
	
	@Test
	public void shouldReturnFalseFor2DiagonalForwardLeftSecondMove(){
		// given
		pawn.setFirstMove(false);
		to=new Coordinate(from.getRow()-2, from.getColumn()-2);
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}
	
	@Test
	public void shouldReturnTrueFor1DiagonalForwardRightSecondMoveNonEmptyWhite(){
		// given
		pawn.setFirstMove(false);
		to=new Coordinate(from.getRow()-1, from.getColumn()+1);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(white));
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}
	
	@Test
	public void shouldReturnFalseFor1DiagonalForwardRightSecondMoveNonEmptyBlack(){
		// given
		pawn.setFirstMove(false);
		to=new Coordinate(from.getRow()-1, from.getColumn()+1);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(black));
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}
	
	@Test
	public void shouldReturnFalseFor1DiagonalForwardRightSecondMoveEmpty(){
		// given
		pawn.setFirstMove(false);
		to=new Coordinate(from.getRow()-1, from.getColumn()+1);
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}
	
	@Test
	public void shouldReturnTrueFor1DiagonalForwardLeftFirstMoveNonEmptyWhite(){
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()-1, from.getColumn()-1);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(white));
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}
	@Test
		public void shouldReturnFalseFor1DiagonalForwardLeftFirstMoveNonEmptyBlack(){
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()-1, from.getColumn()-1);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(black));
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}
	
	@Test
	public void shouldReturnFalseFor1DiagonalForwardLeftFirstMoveEmpty(){
	// given
	pawn.setFirstMove(true);
	to=new Coordinate(from.getRow()-1, from.getColumn()-1);
	// when
	boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
	// then
	assertFalse(isAllowed);
}
		
	@Test
	public void shouldReturnTrueFor1DiagonalForwardRightFirstMoveNonEmptyWhite(){
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()-1, from.getColumn()+1);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(white));
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertTrue(isAllowed);
	}
	
	@Test
	public void shouldReturnFalseFor1DiagonalForwardRightFirstMoveNonEmptyBlack(){
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()-1, from.getColumn()+1);
		chessboard[to.getRow()][to.getColumn()].setPiece(new Pawn(black));
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}
	
	@Test
	public void shouldReturnFalseFor1DiagonalForwardRightFirstMoveEmpty(){
		// given
		pawn.setFirstMove(true);
		to=new Coordinate(from.getRow()-1, from.getColumn()+1);
		// when
		boolean isAllowed=pawn.canMoveBeMade(from, to, chessboard);
		// then
		assertFalse(isAllowed);
	}
	
	@Test
	public void shouldReturnTrueForFirstMove(){
		// given
		to=new Coordinate(from.getRow()-1, from.getColumn());
		// when
		boolean isFirst=pawn.isFirstMove();
		// then
		assertTrue(isFirst);
	}
	
	@Test
	public void shouldReturnFalseForSecondMove(){
		// given
		to=new Coordinate(from.getRow()-1, from.getColumn());
		// when
		pawn.setFirstMove(false);
		boolean isFirst=pawn.isFirstMove();
		// then
		assertFalse(isFirst);
	}
}
