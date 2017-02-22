package com.capgemini.chess;

/**
 * Piece class is an abstract class representing a piece in chess. Other pieces
 * extend this class.
 * 
 * @author BOWROBEL
 *
 */
public abstract class Piece {
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

	/**
	 * Checks if the move is valid for the piece and if it doesn't cause check
	 * for the same team's king. Returns true for possible move and false for
	 * impossible move.
	 * 
	 * @param from
	 * @param to
	 * @param chessboard
	 * @return
	 */
	public boolean canMoveBeMade(Coordinate from, Coordinate to, Square[][] chessboard) {
		return isMoveValid(from, to, chessboard) && (!wouldMoveCauseCheck(from, to, chessboard));
	}

	/**
	 * Checks if the move would cause check for the king of the same color as
	 * the piece being moved. Returns true if the move would cause check and
	 * false for move not causing check.
	 * 
	 * @param from
	 * @param to
	 * @param chessboard
	 * @return
	 */
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
						// return piece to original position
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

	/**
	 * Checks if the destination is not occupied by a piece of the same color as
	 * piece being moved. Returns true for destination occupied by the piece of
	 * the same color and false for the other color or empty field.
	 * 
	 * @param from
	 * @param to
	 * @param chessboard
	 * @return
	 */
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

	/**
	 * Returns opponent's color. If the piece is black, returns white. If the
	 * piece is white, returns black.
	 * 
	 * @param pieceColor
	 * @return
	 */
	private ColorChess returnOpponentColor(ColorChess pieceColor) {
		if (pieceColor == black)
			return white;
		else
			return black;
	}

	/**
	 * Finds position of the king of specified color on the board. Returns the
	 * position as coordinate containing the row and column
	 * 
	 * @param kingsColor
	 * @param chessboard
	 * @return
	 */
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
