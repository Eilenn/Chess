package com.capgemini.chess;

/**
 * Knight class represents Knight chess piece. Every created Knight must be
 * white or black. Knight validates its moves - knight can only move in L shape
 * (one field horizontally and two vertically or one field vertically and one
 * horizontally. Knight can jump over pieces. Knight captures the same way it
 * moves.
 * 
 * @author BOWROBEL
 *
 */
public class Knight extends Piece {
	private Coordinate[] allowedMoves = { new Coordinate(2, 1), new Coordinate(-2, 1), new Coordinate(-2, -1),
			new Coordinate(2, -1), new Coordinate(1, 2), new Coordinate(1, -2), new Coordinate(-1, 2),
			new Coordinate(-1, -2) };

	public Knight(ColorChess color) {
		super(color);
	}

	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to, Square[][] chessboard) {

		if (isPieceAtDestinationTheSameColorAsPieceMoved(from, to, chessboard)) {
			return false;
		} else {
			int distanceRow = to.getRow() - from.getRow();
			int distanceColumn = to.getColumn() - from.getColumn();
			Coordinate distance = new Coordinate(distanceRow, distanceColumn);
			for (Coordinate diff : allowedMoves) {
				if (distance.equals(diff)) {
					return true;
				}
			}
			return false;
		}

	}

}
