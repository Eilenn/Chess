package com.capgemini.chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmptyPieceTest {

	@Test
	public void shouldReturnFalseForValidatingEmptyPieceMove() {
		// given
		Board board=new Board();
		Square[][] chessboard=board.getChessboard();
		Coordinate from=new Coordinate(3, 3);
		Coordinate to=new Coordinate(4, 4);
		Piece empty=new EmptyPiece();
		// when
		boolean canMove=empty.isMoveValid(from, to, chessboard);
		// then
		assertFalse(canMove);
	}

}
