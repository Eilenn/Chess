package com.capgemini.chess;

import java.awt.Color;

public class Pawn extends Piece {
	private ColorChess white = ColorChess.WHITE;
	private ColorChess black = ColorChess.BLACK;

	Pawn(ColorChess color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isBlack() {
		if (this.getColor() == black)
			return true;
		else
			return false;
	}

}
