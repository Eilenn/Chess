package com.capgemini.chess;

/**
 * King class represents King chess piece. Every created King must be white or
 * black. King validates its moves - king can only move one field in any
 * direction. King cannot jump over pieces. King captures same way it moves.
 * King class doesn't implement castling move.
 * 
 * @author BOWROBEL
 *
 */
public class King extends Piece {
	private Coordinate[] allowedMoves = { new Coordinate(1, 1), new Coordinate(-1, 1), new Coordinate(-1, -1),
			new Coordinate(1, -1), new Coordinate(1, 0), new Coordinate(0, 1), new Coordinate(-1, 0),
			new Coordinate(0, -1) };

	public King(ColorChess color) {
		super(color);
	}

	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to, Square[][] chessboard) {
		if (wouldMoveCauseCheck(from, to, chessboard)) {
			return false;
		} else {
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

}
