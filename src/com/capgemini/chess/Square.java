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

	public boolean isEmpty() {
		return this.getPiece().equals(new EmptyPiece());
	}

}
