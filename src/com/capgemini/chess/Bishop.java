package com.capgemini.chess;

public class Bishop extends Piece {
	Bishop(ColorChess color) {
		super(color);
	}

	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to, Square[][] chessboard) {
		if (isPieceAtDestinationTheSameColorAsPieceMoved(from, to, chessboard)) {
			return false;
		} else {
			if (isMoveAllowed(from, to) && !isPathToDestinationOccupied(from, to, chessboard)) {
				return true;
			} else
				return false;
		}
	}

	private boolean isMoveAllowed(Coordinate from, Coordinate to) {
		int rowDiff = Math.abs(from.getRow() - to.getRow());
		int colDiff = Math.abs(from.getColumn() - to.getColumn());
		return rowDiff == colDiff;
	}

	private boolean isPathToDestinationOccupied(Coordinate from, Coordinate to, Square[][] chessboard) {
		int fromRowIndex = from.getRow();
		int toRowIndex = to.getRow();
		int rowOffset = (fromRowIndex < toRowIndex) ? 1 : -1;
		int fromColumnIndex = from.getColumn();
		int toColumnIndex = to.getColumn();
		int colOffset = (fromColumnIndex < toColumnIndex) ? 1 : -1;
		boolean isOccupied = false;
		int column = fromColumnIndex + colOffset;
		for (int row = fromRowIndex + rowOffset; row != toRowIndex; row += rowOffset) {
			if (!chessboard[row][column].getPiece().equals(new EmptyPiece())) {
				isOccupied = true;
			}
			column += colOffset;
		}

		return isOccupied;
	}

}
