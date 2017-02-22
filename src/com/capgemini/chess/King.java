package com.capgemini.chess;

public class King extends Piece {
	// TODO write check validation
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
