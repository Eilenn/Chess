package com.capgemini.chess;

public class Pawn extends Piece {

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
	private boolean isAllowed(Coordinate from, Coordinate to, Square[][] chessboard) {
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

	private boolean isAttemptToCapture(Coordinate from, Coordinate to, Square[][] chessboard) {
		if (isFieldEmpty(from, to, chessboard)) {
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

	private boolean isFieldEmpty(Coordinate from, Coordinate to, Square[][] chessboard) {
		Piece pieceAtDestination = chessboard[to.getRow()][to.getColumn()].getPiece();
		Piece empty = new EmptyPiece();
		return pieceAtDestination.equals(empty);
	}

	private boolean isPathBlocked(Coordinate from, Coordinate to, Square[][] chessboard) {
		Square sq;
		EmptyPiece empty = new EmptyPiece();
		if (isBlack()) {
			sq = chessboard[from.getRow() - 1][from.getColumn()];
		} else {
			sq = chessboard[from.getRow() + 1][from.getColumn()];
		}
		if (!sq.getPiece().equals(empty)) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to, Square[][] chessboard) {
		if (isPieceAtDestinationTheSameColorAsPieceMoved(from, to, chessboard)) {
			return false;
		} else {
			boolean isValid, freePath, isAllowed, isCapture;
			freePath = !isPathBlocked(from, to, chessboard);
			isAllowed = isAllowed(from, to, chessboard);
			isCapture = isAttemptToCapture(from, to, chessboard);
			isValid = (freePath && isAllowed) || isCapture;
			return isValid;
		}

	}
}
