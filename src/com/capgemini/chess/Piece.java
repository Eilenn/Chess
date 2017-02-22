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
		Piece pieceBeingMoved = chessboard[from.getRow()][from.getColumn()].getPiece();
		ColorChess pieceBeingMovedColor = pieceBeingMoved.getColor();
		ColorChess opponentColor = returnOpponentColor(pieceBeingMovedColor);
		Piece pieceAtDestination = chessboard[to.getRow()][to.getColumn()].getPiece();
		chessboard[to.getRow()][to.getColumn()].setPiece(pieceBeingMoved);
		Piece empty = new EmptyPiece();
		chessboard[from.getRow()][from.getColumn()].setPiece(empty);
		// find King of this team position
		Coordinate kingsPosition = getSameTeamKingsPosition(pieceBeingMovedColor, chessboard);
		// iterate over board
		for (int row = 1; row <= 8; row++) {
			for (int col = 1; col <= 8; col++) {
				Coordinate fromOpponent = new Coordinate(row, col);
				Square sq = chessboard[row][col];
				Piece piece = sq.getPiece();
				ColorChess pieceColor = piece.getColor();
				if (!sq.isEmpty() && (pieceColor == opponentColor)) {
					if (piece.isMoveValid(fromOpponent, kingsPosition, chessboard)) {
						// return piece to original position because move is
						// impossible as it causes self check
						chessboard[from.getRow()][from.getColumn()].setPiece(pieceBeingMoved);
						chessboard[to.getRow()][to.getColumn()].setPiece(pieceAtDestination);
						return true;
					}
				}
			}
		}
		chessboard[from.getRow()][from.getColumn()].setPiece(pieceBeingMoved);
		chessboard[to.getRow()][to.getColumn()].setPiece(pieceAtDestination);
		return false;
	}

	private ColorChess returnOpponentColor(ColorChess pieceColor) {
		if (pieceColor == black)
			return white;
		else
			return black;
	}

	private Coordinate getSameTeamKingsPosition(ColorChess kingsColor, Square[][] chessboard) {
		Coordinate kingsPosition = new Coordinate(0, 0);
		Square sq;
		ColorChess pieceColor;
		Piece piece;
		for (int row = 1; row <= 8; row++) {
			for (int col = 1; col <= 8; col++) {
				sq = chessboard[row][col];
				piece = sq.getPiece();
				pieceColor = piece.getColor();
				if (!sq.isEmpty() && (pieceColor == kingsColor) && (piece instanceof King)) {
					kingsPosition = new Coordinate(row, col);
				}
			}
		}
		return kingsPosition;
	}
}
