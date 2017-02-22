package com.capgemini.chess;

/**
 * Pawn class represents Pawn chess piece. Every created Pawn must be white or
 * black. Pawn validates its moves - pawn can only move one field forward or two
 * forward if it hasn't moved yet. Pawn cannot jump over pieces. Pawn captures
 * diagonally forward one field. Pawn class doesn't implement en passant
 * capture.
 * 
 * @author BOWROBEL
 *
 */
public class Pawn extends Piece {

	private boolean isFirstMove = true;
	private Coordinate[] allowedAnyMoveWhite = { new Coordinate(1, 0) };
	private Coordinate[] allowedFirstMoveWhite = { new Coordinate(1, 0), new Coordinate(2, 0) };
	private Coordinate[] allowedAnyMoveBlack = { new Coordinate(-1, 0) };
	private Coordinate[] allowedFirstMoveBlack = { new Coordinate(-1, 0), new Coordinate(-2, 0) };
	private Coordinate[] allowedCaptureWhite = { new Coordinate(1, -1), new Coordinate(1, 1) };
	private Coordinate[] allowedCaptureBlack = { new Coordinate(-1, 1), new Coordinate(-1, -1) };

	public Pawn(ColorChess color) {
		super(color);
	}

	/**
	 * Checks if pawn has already moved. If it has moved before, returns false;
	 * if it's pawn's first move, returns true.
	 * 
	 * @return
	 */
	public boolean isFirstMove() {
		return isFirstMove;
	}

	public void setFirstMove(boolean isFirstMove) {
		this.isFirstMove = isFirstMove;
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

	/**
	 * Checks if the pawn is black. Returns true for black pawn and false for
	 * white pawn.
	 * 
	 * @return
	 */
	private boolean isBlack() {
		if (this.getColor() == black)
			return true;
		else
			return false;
	}

	/**
	 * Checks if there is a piece on field in front of the pawn. Returns true
	 * for occupied field and false for empty field.
	 * 
	 * @param from
	 * @param to
	 * @param chessboard
	 * @return
	 */
	private boolean isPathBlocked(Coordinate from, Coordinate to, Square[][] chessboard) {
		Square sq;
		if (isBlack()) {
			sq = chessboard[from.getRow() - 1][from.getColumn()];
		} else {
			sq = chessboard[from.getRow() + 1][from.getColumn()];
		}
		if (!sq.isEmpty()) {
			return true;
		} else
			return false;
	}

	/**
	 * Checks rules for moving forward 1 field or 2 if it is the first move.
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

	/**
	 * Checks if the move is on the list of allowed moves. The list depends on
	 * the type of pawn (its color and it's status - if it's its first move).
	 * 
	 * @param from
	 * @param to
	 * @param allowedMoves
	 * @return
	 */
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

	/**
	 * Checks if attempted move is a capture - if pawn tries to capture
	 * opponent, it can move diagonally instead of forward. Returns true if
	 * pawns tried to capture another and false if it doesn't.
	 * 
	 * @param from
	 * @param to
	 * @param chessboard
	 * @return
	 */
	private boolean isAttemptToCapture(Coordinate from, Coordinate to, Square[][] chessboard) {
		Square sq = chessboard[to.getRow()][to.getColumn()];
		if (sq.isEmpty()) {
			return false;
		} else {
			if (isBlack()) {
				return isOnListOfAllowedMoves(from, to, allowedCaptureBlack);
			} else
				return isOnListOfAllowedMoves(from, to, allowedCaptureWhite);
		}
	}

}
