package com.capgemini.chess;

import java.awt.Color;

public class Pawn extends Piece {
	private ColorChess white = ColorChess.WHITE;
	private ColorChess black = ColorChess.BLACK;
	private boolean isFirstMove = true;
	private Coordinate[] allowedAnyMoveWhite = { new Coordinate(1, 0) };
	private Coordinate[] allowedFirstMoveWhite = { new Coordinate(1, 0), new Coordinate(2, 0) };
	private Coordinate[] allowedAnyMoveBlack = { new Coordinate(-1, 0) };
	private Coordinate[] allowedFirstMoveBlack = { new Coordinate(-1, 0), new Coordinate(-2, 0) };
	private Coordinate[] allowedCaptureWhite = { new Coordinate(1, -1), new Coordinate(1, 1) };
	private Coordinate[] allowedCaptureBlack = { new Coordinate(-1, 1), new Coordinate(-1, -1) };

	public boolean isFirstMove() {
		return isFirstMove;
	}

	public void setFirstMove(boolean isFirstMove) {
		this.isFirstMove = isFirstMove;
	}

	Pawn(ColorChess color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	private boolean isBlack() {
		if (this.getColor() == black)
			return true;
		else
			return false;
	}

	/**
	 * checks rules for moving forward 1 field or 1 if first move
	 * 
	 * @param from
	 * @param to
	 * @param chessboard
	 * @return
	 */
	// TODO change to private
	public boolean isAllowed(Coordinate from, Coordinate to, Square[][] chessboard) {
		if (isBlack() && isFirstMove) {
			return isOnListOfAllowedMoves(from, to, allowedFirstMoveBlack);
		} else if (isBlack() && !isFirstMove) {
			return isOnListOfAllowedMoves(from, to, allowedAnyMoveBlack);
		} else if (!isBlack() && isFirstMove) {
			return isOnListOfAllowedMoves(from, to, allowedFirstMoveWhite);
		} else {
			return isOnListOfAllowedMoves(from, to, allowedAnyMoveWhite);
		}
	}
// TODO change to private
	public boolean isAttemptToCapture(Coordinate from, Coordinate to, Square[][] chessboard) {
		if (isPieceAtDestinationTheSameColorAsPieceMoved(from, to, chessboard)) {
			return false;
		} else {
			if (isBlack()) {
				return isOnListOfAllowedMoves(from, to, allowedCaptureBlack);
			} else
				return isOnListOfAllowedMoves(from, to, allowedCaptureWhite);
		}
	}

	private boolean isOnListOfAllowedMoves(Coordinate from, Coordinate to, Coordinate[] allowedMoves) {
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

	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to, Square[][] chessboard) {

		return false;
	}

}
