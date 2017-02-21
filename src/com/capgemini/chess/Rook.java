package com.capgemini.chess;

public class Rook extends Piece {
	private ColorChess white = ColorChess.WHITE;
	private ColorChess black = ColorChess.BLACK;

	Rook(ColorChess color) {
		super(color);
	}

	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to, Square[][] chessboard) {
		// check if move causes capturing of the same team, if so - it is not
		// valid
		if (doesMoveCauseCapturingOfTheSameColor(from, to, chessboard)) {
			return false;
		}
		// if it doesn't
		else {
			// check if the move is horizontal or vertical - if it's not, return false
			if (isMoveAllowedForRook(from, to)) {
				// check if the move doesn't cause leaping over a piece, if it
				// does - return false
				if (isPathToDestinationOccupied(from, to, chessboard)) {
					return false;
				} else
					return true;
			} 
			else {
				return false;
			}
		}
	}

	private boolean isDestinationInTheSameRow(Coordinate from, Coordinate to) {
		int fromX = from.getRow();
		int toX = to.getRow();
		return toX == fromX;
	}

	private boolean isDestinationInTheSameColumn(Coordinate from, Coordinate to) {
		int fromY = from.getColumn();
		int toY = to.getColumn();
		return toY == fromY;
	}

	// is this move allowed for rook
	private boolean isMoveAllowedForRook(Coordinate from, Coordinate to) {
		return isDestinationInTheSameRow(from, to) || isDestinationInTheSameColumn(from, to);
	}

	private boolean isPathToDestinationOccupied(Coordinate from, Coordinate to, Square[][] chessboard) {
		Piece emptyPiece = new EmptyPiece();
		int rowStart = from.getRow();
		int rowEnd = to.getRow();
		int colStart = from.getColumn();
		int colEnd = to.getColumn();
		if (isDestinationInTheSameColumn(from, to)) {
			if (from.getRow() > to.getRow()) {
				rowStart = to.getRow();
				rowEnd = from.getRow();
			}
			boolean isOccupied = false;
			for (int row = rowStart + 1; row < rowEnd; row++) {
				Square sq = chessboard[row][from.getColumn()];
				if (!sq.getPiece().equals(emptyPiece)) {
					isOccupied = true;
				}
			}
			return isOccupied;
		} else {
			if (from.getColumn() > to.getColumn()) {
				colStart = to.getColumn();
				colEnd = from.getColumn();
			}
			boolean isOccupied = false;
			for (int col = colStart + 1; col < colEnd; col++) {
				Square sq = chessboard[from.getRow()][col];
				if (!sq.getPiece().equals(emptyPiece)) {
					isOccupied = true;
				}
			}
			return isOccupied;
		}
	}

}
