package com.capgemini.chess;

import java.awt.Color;

/**
 * Square represents single tile of the game, @rank corresponds to boards' row
 * (x coordinate),
 * 
 * @file corresponds to boards' column (y coordinate), @color corresponds to
 *       tile's color (black or white). Ranks are in range of "A" to "H", files
 *       in range of 1 to 8.
 * @author BOWROBEL
 *
 */
public class Square {
	private char rank;
	private int file;
	private Color color;

	public Square(char rank, int file, Color color) {
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
	}

	public Color getColor() {
		return color;
	}

	public void setRank(char rank) {
		this.rank = rank;
	}

	public void setFile(int file) {
		this.file = file;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + file;
		result = prime * result + rank;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Square other = (Square) obj;
/*		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;*/
		if (file != other.file)
			return false;
		if (rank != other.rank)
			return false;
		return true;
	}

}
