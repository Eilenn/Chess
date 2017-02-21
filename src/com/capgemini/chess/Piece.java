package com.capgemini.chess;

public abstract class Piece {
	// TODO remove declarations of color from every class
	public ColorChess white = ColorChess.WHITE;
	public ColorChess black = ColorChess.BLACK;
	private ColorChess color;

	Piece(ColorChess color) {
		this.color = color;
	}

	public Piece() {

	}

	public abstract boolean isMoveValid(Coordinate from, Coordinate to, Square[][] chessboard);

	public ColorChess getColor() {
		return color;
	}

	public void setColor(ColorChess color) {
		this.color = color;
	}

	public boolean isPieceAtDestinationTheSameColorAsPieceMoved(Coordinate from, Coordinate to, Square[][] chessboard) {
		Square origin = chessboard[from.getRow()][from.getColumn()];
		Piece pieceMoved = origin.getPiece();
		ColorChess movedPieceColor = pieceMoved.getColor();
		Square destination = chessboard[to.getRow()][to.getColumn()];
		Piece pieceAtDestination = destination.getPiece();
		ColorChess destinationPieceColor = pieceAtDestination.getColor();
		if (destination.isEmpty()) {
			return false;
		} else if (destinationPieceColor != movedPieceColor) {
			return false;
		} else
			return true;
	}

	public boolean wouldMoveCauseCheck(Coordinate from, Coordinate to, Square[][] chessboard) {
		// move piece to target, set empty at origin
		Piece pieceBeingMoved=chessboard[from.getRow()][from.getColumn()].getPiece();
		chessboard[to.getRow()][to.getColumn()].setPiece(pieceBeingMoved);
		Piece empty=new EmptyPiece();
		chessboard[from.getRow()][from.getColumn()].setPiece(empty);
		return false;
	}

	private ColorChess returnOpponentColor(ColorChess pieceColor) {
		if (pieceColor == black)
			return white;
		else
			return black;
	}

}
