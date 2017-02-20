package com.capgemini.chess;

public class Queen extends Piece {

	private Coordinate[] allowedMoves = { new Coordinate(1, 1), new Coordinate(-1, 1), new Coordinate(-1, -1),
			new Coordinate(1, -1), new Coordinate(1, 0), new Coordinate(0, 1), new Coordinate(-1, 0),
			new Coordinate(0, -1) };
	Queen(ColorChess color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

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


}
