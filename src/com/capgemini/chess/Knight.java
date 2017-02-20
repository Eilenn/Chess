package com.capgemini.chess;

import java.awt.Color;

public class Knight extends Piece {

	Knight(Color color) {
		super(color);
	}
// TODO check corners?
	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to) {
		boolean canUpLeft = isMoveUpLeftAllowed(from, to);
		boolean canUpRight = isMoveUpRightAllowed(from, to);
		boolean canDownLeft = isMoveDownLeftAllowed(from, to);
		boolean canDownRight = isMoveDownRightAllowed(from, to);
		return canUpLeft || canUpRight || canDownLeft || canDownRight;
	}

	private boolean isMoveUpLeftAllowed(Coordinate from, Coordinate to) {
		int fromX = from.getRow();
		int fromY = from.getColumn();
		int toX = to.getRow();
		int toY = to.getColumn();
		return toX == fromX - 2 && toY == fromY - 1;
	}

	private boolean isMoveUpRightAllowed(Coordinate from, Coordinate to) {
		int fromX = from.getRow();
		int fromY = from.getColumn();
		int toX = to.getRow();
		int toY = to.getColumn();
		return toX == fromX - 2 && toY == fromY + 1;
	}

	private boolean isMoveDownLeftAllowed(Coordinate from, Coordinate to) {
		int fromX = from.getRow();
		int fromY = from.getColumn();
		int toX = to.getRow();
		int toY = to.getColumn();
		return toX == fromX + 2 && toY == fromY - 1;
	}

	private boolean isMoveDownRightAllowed(Coordinate from, Coordinate to) {
		int fromX = from.getRow();
		int fromY = from.getColumn();
		int toX = to.getRow();
		int toY = to.getColumn();
		return toX == fromX + 2 && toY == fromY + 1;
	}

}
