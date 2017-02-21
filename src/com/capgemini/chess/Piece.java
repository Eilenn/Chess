package com.capgemini.chess;

public abstract class Piece {
	private ColorChess color;

	Piece(ColorChess color) {
		this.color = color;
	}

	Piece() {

	}

	public ColorChess getColor() {
		return color;
	}

	public void setColor(ColorChess color) {
		this.color = color;
	}

	public abstract boolean isMoveValid(Coordinate from, Coordinate to, Square[][] chessboard);

	public boolean doesMoveCauseCapturingOfTheSameColor(Coordinate from, Coordinate to, Square[][] chessboard) {
		Piece pieceMove = chessboard[from.getRow()][from.getColumn()].getPiece();
		ColorChess movedPieceColor = pieceMove.getColor();
		Piece pieceAtDestination = chessboard[to.getRow()][to.getColumn()].getPiece();
		ColorChess destinationPieceColor = pieceAtDestination.getColor();
		if (pieceAtDestination.equals(new EmptyPiece())) {
			return false;
		} else if (destinationPieceColor != movedPieceColor) {
			return false;
		} else
			return true;
	}

}
