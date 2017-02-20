package com.capgemini.chess;

import java.awt.Color;

/**
 * Square represents single tile of the game.
 * @author BOWROBEL
 *
 */
public class Square {
	//private char rank;
	//private int file;
	private Color color;
	private Piece piece;
	
	public Square(Color color, Piece piece){
		this.color=color;
		this.piece=piece;
	}

/*	public Square(char rank, int file, Color color) {
		this.rank = rank;
		this.file = file;
		this.color = color;
	}
	
	public Square(char rank, int file) {
		this.rank = rank;
		this.file = file;
	}

	public char getRank() {
		return rank;
	}

	public int getFile() {
		return file;
	}*/

	public Color getColor() {
		return color;
	}

	/*public void setRank(char rank) {
		this.rank = rank;
	}

	public void setFile(int file) {
		this.file = file;
	}

	public void setColor(Color color) {
		this.color = color;
	}*/

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}
