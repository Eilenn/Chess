package com.capgemini.chess;

import java.awt.Color;

/**
 * Square represents single tile of the game.
 * 
 * @author BOWROBEL
 *
 */
public class Square {
	private Color color;
	private Piece piece;

	public Square(Color color, Piece piece) {
		this.color = color;
		this.piece = piece;
	}

	public Color getColor() {
		return color;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}
