package com.capgemini.chess;

public class Knight extends Piece {

	Knight(ColorChess color) {
		super(color);
	}

	// TODO check corners?
	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to) {
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

	private Coordinate[] allowedMoves = { new Coordinate(2, 1), new Coordinate(-2, 1), new Coordinate(-2, -1),
			new Coordinate(2, -1), new Coordinate(1, 2), new Coordinate(1, -2), new Coordinate(-1, 2),
			new Coordinate(-1, -2) };

}
