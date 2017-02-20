package com.capgemini.chess;

public abstract class Piece {
	private ColorChess color;
	
	Piece(ColorChess color){
		this.color=color;
	}
	Piece(){
		
	}

	public abstract boolean isMoveValid(Coordinate from, Coordinate to);

	public ColorChess getColor() {
		return color;
	}

	public void setColor(ColorChess color) {
		this.color = color;
	}


}
