package com.capgemini.chess;

public class Queen extends Piece {

	Queen(ColorChess color) {
		super(color);
	}

	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to, Square[][] chessboard) {
		Rook rook=new Rook(this.getColor());
		Bishop bishop=new Bishop(this.getColor());
		boolean isValidRook=rook.isMoveValid(from, to, chessboard);
		boolean isValidBishop=bishop.isMoveValid(from, to, chessboard);
		return isValidBishop||isValidRook;
	}

}
