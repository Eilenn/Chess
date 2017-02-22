package com.capgemini.chess;

/**
 * Square represents single tile of the game.
 * 
 * @author BOWROBEL
 *
 */
public class Square {
	private ColorChess color;
	private Piece piece;

	public Square(ColorChess color, Piece piece) {
		this.color = color;
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	/**
	 * Checks if the field contains an instance of EmptyPiece class. Returns
	 * true for empty field and false for field containing piece from another
	 * class extending Piece.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.getPiece().equals(new EmptyPiece());
	}

}
