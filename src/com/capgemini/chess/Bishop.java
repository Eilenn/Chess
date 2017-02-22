package com.capgemini.chess;

/**
 * Bishop class represents Bishop chess piece. Every created Bishop must be
 * white or black. Bishop validates its moves - it can only move diagonally and
 * cannot jump over other pieces. Bishop captures same way it moves.
 * 
 * @author BOWROBEL
 *
 */
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

	/**
	 * Checks if move is in accordance to bishop moving rules. For diagonal
	 * moves returns true, for other types of moves - false.
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	private boolean isMoveAllowed(Coordinate from, Coordinate to) {
		int rowDiff = Math.abs(from.getRow() - to.getRow());
		int colDiff = Math.abs(from.getColumn() - to.getColumn());
		return rowDiff == colDiff;
	}

	/**
	 * Checks if there is any piece on diagonal path from the point of origin to
	 * destination. Returns true for blocked path, false for free path.
	 * 
	 * @param from
	 * @param to
	 * @param chessboard
	 * @return
	 */
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
