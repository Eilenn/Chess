package com.capgemini.chess;

/**
 * Queen class represents Queen chess piece. Every created Queen must be white
 * or black. Queen validates its moves - queen can move like bishop and like
 * rook (diagonally, horizontally or vertically). Queen cannot jump over other
 * pieces. Queen captures same way it moves.
 * 
 * @author BOWROBEL
 *
 */
public class Queen extends Piece {

	public Queen(ColorChess color) {
		super(color);
	}

	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to, Square[][] chessboard) {
		Rook rook = new Rook(this.getColor());
		Bishop bishop = new Bishop(this.getColor());
		boolean isValidRook = rook.isMoveValid(from, to, chessboard);
		boolean isValidBishop = bishop.isMoveValid(from, to, chessboard);
		return isValidBishop || isValidRook;
	}

}
