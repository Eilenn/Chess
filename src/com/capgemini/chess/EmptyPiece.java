package com.capgemini.chess;

import java.awt.Color;

public class EmptyPiece extends Piece{
	String empty;
	EmptyPiece(ColorChess color) {
		super(color);
		// TODO Auto-generated constructor stub
	}
	EmptyPiece(){
		this.empty="empty";
		
	}
	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empty == null) ? 0 : empty.hashCode());
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
		EmptyPiece other = (EmptyPiece) obj;
		if (empty == null) {
			if (other.empty != null)
				return false;
		} else if (!empty.equals(other.empty))
			return false;
		return true;
	}
	



}
