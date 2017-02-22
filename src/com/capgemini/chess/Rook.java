package com.capgemini.chess;

/**
 * Rook class represents Rook chess piece. Every created Rook must be white or
 * black. Rook validates its moves - rook can only move horizontally or
 * vertically. Rook cannot jump over other pieces. Rook captures the same way it
 * moves. Rook class doesn't implement castling move.
 * 
 * @author BOWROBEL
 *
 */
public class Rook extends Piece {

	public Rook(ColorChess color) {
		super(color);
	}

	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to, Square[][] chessboard) {
		if (isPieceAtDestinationTheSameColorAsPieceMoved(from, to, chessboard)) {
			return false;
		} else {
			if (isMoveAllowedForRook(from, to)) {
				if (isPathToDestinationOccupied(from, to, chessboard)) {
					return false;
				} else
					return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * Checks if move is in accordance to rook moving rules. For horizontal or
	 * vertical moves returns true, for other types of moves - false.
	 * 
	 * @param from
	 * @param to
	 * @return
	 */

	private boolean isMoveAllowedForRook(Coordinate from, Coordinate to) {
		return isDestinationInTheSameRow(from, to) || isDestinationInTheSameColumn(from, to);
	}

	/**
	 * Checks if destination is in the same row. Returns true for the same row
	 * and false for destination in other row then origin.
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	private boolean isDestinationInTheSameRow(Coordinate from, Coordinate to) {
		int fromX = from.getRow();
		int toX = to.getRow();
		return toX == fromX;
	}

	/**
	 * Checks if destination is in the same column. Returns true for the same
	 * column and false for destination in other column then origin.
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	private boolean isDestinationInTheSameColumn(Coordinate from, Coordinate to) {
		int fromY = from.getColumn();
		int toY = to.getColumn();
		return toY == fromY;
	}

	/**
	 * Checks if there is any piece on horizontal or vertical path from the
	 * point of origin to destination. Returns true for blocked path, false for
	 * free path.
	 * 
	 * @param from
	 * @param to
	 * @param chessboard
	 * @return
	 */
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
