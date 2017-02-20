package com.capgemini.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KnightTest {

	private ColorChess white=ColorChess.WHITE;
	private ColorChess black=ColorChess.BLACK;
	private Knight knight;
	private Coordinate from,to;
	private int rowDiff, colDiff, rowStart, colStart;
	@Before
	public void init(){
		knight=new Knight(white);
		rowStart=3;
		colStart=3;
	}
	@Test
	public void shouldReturnTrueForOneUpTwoLeft() {
		//given
		rowDiff=-1;
		colDiff=-2;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to);
		// then
		assertTrue(canMove);
	}
	
	@Test
	public void shouldReturnTrueForOneDownTwoLeft() {
		//given
		rowDiff=1;
		colDiff=-2;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to);
		// then
		assertTrue(canMove);
	}
	
	@Test
	public void shouldReturnTrueForOneDownTwoRight() {
		//given
		rowDiff=1;
		colDiff=2;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to);
		// then
		assertTrue(canMove);
	}
	
	@Test
	public void shouldReturnTrueForOneUpTwoRight() {
		//given
		rowDiff=-1;
		colDiff=2;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to);
		// then
		assertTrue(canMove);
	}
	
	@Test
	public void shouldReturnTrueForTwoUpOneRight() {
		//given
		rowDiff=-2;
		colDiff=1;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to);
		// then
		assertTrue(canMove);
	}
	
	@Test
	public void shouldReturnTrueForTwoUpOneLeft() {
		//given
		rowDiff=-2;
		colDiff=-1;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to);
		// then
		assertTrue(canMove);
	}
	
	@Test
	public void shouldReturnTrueForTwoDownOneLeft() {
		//given
		rowDiff=2;
		colDiff=-1;
		from=new Coordinate(rowStart,colStart);
		to=new Coordinate(rowStart+rowDiff,colStart+colDiff);
		// when
		boolean canMove=knight.isMoveValid(from, to);
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
		boolean canMove=knight.isMoveValid(from, to);
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
		boolean canMove=knight.isMoveValid(from, to);
		// then
		assertFalse(canMove);
	}

}
