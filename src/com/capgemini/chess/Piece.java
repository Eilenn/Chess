package com.capgemini.chess;

import java.awt.Color;

public class Piece {
	private Color color;
	
	Piece(Color color){
		this.color=color;
	}

	public Piece() {
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
