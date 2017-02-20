package com.capgemini.chess;

import java.awt.Color;

public abstract class Piece {
	private Color color;
	
	Piece(Color color){
		this.color=color;
	}
	Piece(){
		
	}

	public abstract boolean isMoveValid(Coordinate from, Coordinate to);

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}


}
