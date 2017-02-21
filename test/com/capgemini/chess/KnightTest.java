package com.capgemini.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KnightTest {
//TODO improve tests
	private ColorChess white=ColorChess.WHITE;
	private Knight knight;
	private Coordinate from,to;
	private Board board;
	private Square[][] chessboard;
	private int rowDiff, colDiff, rowStart, colStart;
	@Before
	public void init(){
		knight=new Knight(white);
		rowStart=3;
		colStart=3;
		board = new Board();
		board.initializeBoard();
		chessboard = board.getChessboard();
		chessboard[rowStart][colStart].setPiece(knight);
	}
	@Test
	public void shouldReturnFalseForOneUpTwoLeftDestinationOccupied() {
		//given
		rowDiff=-1;
		colDiff=-2;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to,chessboard);
		// then
		assertFalse(canMove);
	}
	
	@Test
	public void shouldReturnTrueForOneDownTwoLeftDestinationFree() {
		//given
		rowDiff=1;
		colDiff=-2;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to,chessboard);
		// then
		assertTrue(canMove);
	}
	
	@Test
	public void shouldReturnTrueForOneDownTwoRightDestinationFree() {
		//given
		rowDiff=1;
		colDiff=2;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to,chessboard);
		// then
		assertTrue(canMove);
	}
	
	@Test
	public void shouldReturnFalseForOneUpTwoRightDestinationOccupied() {
		//given
		rowDiff=-1;
		colDiff=2;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to,chessboard);
		// then
		assertFalse(canMove);
	}
	
	@Test
	public void shouldReturnFalseForTwoUpOneRightDestinationOccupied() {
		//given
		rowDiff=-2;
		colDiff=1;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to,chessboard);
		// then
		assertFalse(canMove);
	}
	
	@Test
	public void shouldReturnFalseForTwoUpOneLeftDestinationOccupied() {
		//given
		rowDiff=-2;
		colDiff=-1;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to,chessboard);
		// then
		assertFalse(canMove);
	}
	
	@Test
	public void shouldReturnTrueForTwoDownOneLeft() {
		//given
		rowDiff=2;
		colDiff=-1;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to,chessboard);
		// then
		assertTrue(canMove);
	}
	
	@Test
	public void shouldReturnTrueForTwoDownOneRight() {
		//given
		rowDiff=2;
		colDiff=1;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to,chessboard);
		// then
		assertTrue(canMove);
	}
	
	@Test
	public void shouldReturnFalseForThreeDownOneLeft() {
		//given
		rowDiff=3;
		colDiff=-1;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to,chessboard);
		// then
		assertFalse(canMove);
	}

}
