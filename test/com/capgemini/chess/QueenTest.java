package com.capgemini.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueenTest {
	private ColorChess white = ColorChess.WHITE;
	private ColorChess black = ColorChess.BLACK;
	private Queen queen;
	private Coordinate from, to;
	private Board board;
	private Square[][] chessboard;

	@Before
	public void init() {
		board=new Board();
		board.initializeBoard();
		queen=new Queen(white);
		chessboard=board.getChessboard();
		from=new Coordinate(5, 5);
		chessboard[from.getRow()][from.getColumn()].setPiece(queen);
	}

	@Test
	public void shouldReturnTrueFor1Up() {
		// given
		to=new Coordinate(from.getRow()-1, from.getColumn());
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertTrue(isValid);
	}
	
	@Test
	public void shouldReturnFalseFor2Up() {
		// given
		to=new Coordinate(from.getRow()-2, from.getColumn());
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertFalse(isValid);
	}
	
	@Test
	public void shouldReturnTrueFor1Up1Left() {
		// given
		to=new Coordinate(from.getRow()-1, from.getColumn()-1);
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertTrue(isValid);
	}
	
	@Test
	public void shouldReturnTrueFor1Up1Right() {
		// given
		to=new Coordinate(from.getRow()-1, from.getColumn()+1);
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertTrue(isValid);
	}
	
	@Test
	public void shouldReturnTrueFor1Down() {
		// given
		to=new Coordinate(from.getRow()+1, from.getColumn());
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertTrue(isValid);
	}
	
	@Test
	public void shouldReturnTrueFor1Down1Left() {
		// given
		to=new Coordinate(from.getRow()+1, from.getColumn()-1);
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnTrueFor1Down1Right() {
		// given
		to=new Coordinate(from.getRow()+1, from.getColumn()+1);
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertTrue(isValid);
	}
	@Test
	public void shouldReturnTrueFor1Left() {
		// given
		to=new Coordinate(from.getRow(), from.getColumn()-1);
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertTrue(isValid);
	}
	
	@Test
	public void shouldReturnFalseFor2Left() {
		// given
		to=new Coordinate(from.getRow(), from.getColumn()-2);
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertFalse(isValid);
	}
	
	@Test
	public void shouldReturnTrueFor1Right() {
		// given
		to=new Coordinate(from.getRow(), from.getColumn()+1);
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertTrue(isValid);
	}

	@Test
	public void shouldReturnFalseForRandomPlace() {
		// given
		to=new Coordinate(3, 8);
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertFalse(isValid);
	}
	
	//tests for occupied places around queen
	
	@Test
	public void shouldReturnFalseFor1DownOccupied(){
		// given
		from=new Coordinate(1,5);
		to=new Coordinate(from.getRow()+1, from.getColumn());
		chessboard[5][5].setPiece(new EmptyPiece());
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertFalse(isValid);
	}
	
	@Test
	public void shouldReturnFalseFor1LeftOccupied(){
		// given
		from=new Coordinate(1,5);
		to=new Coordinate(from.getRow(), from.getColumn()-1);
		chessboard[5][5].setPiece(new EmptyPiece());
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertFalse(isValid);
	}
	
	@Test
	public void shouldReturnFalseFor1RightOccupied(){
		// given
		from=new Coordinate(1,5);
		to=new Coordinate(from.getRow(), from.getColumn()+1);
		chessboard[5][5].setPiece(new EmptyPiece());
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertFalse(isValid);
	}
	
	@Test
	public void shouldReturnFalseFor1Down1RightOccupied(){
		// given
		from=new Coordinate(1,5);
		to=new Coordinate(from.getRow()+1, from.getColumn()+1);
		chessboard[5][5].setPiece(new EmptyPiece());
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

	@Test
	public void shouldReturnFalseFor1Down1LeftOccupied(){
		// given
		from=new Coordinate(1,5);
		to=new Coordinate(from.getRow()+1, from.getColumn()-1);
		chessboard[5][5].setPiece(new EmptyPiece());
		// when
		boolean isValid=queen.isMoveValid(from, to, chessboard);
		// then
		assertFalse(isValid);
	}

}
