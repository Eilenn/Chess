package com.capgemini.chess;

import java.awt.Color;

public class EmptyPiece extends Piece{

	EmptyPiece(ColorChess color) {
		super(color);
		// TODO Auto-generated constructor stub
	}
	EmptyPiece(){
		
	}
	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to) {
		// TODO Auto-generated method stub
		return false;
	}
	



}
