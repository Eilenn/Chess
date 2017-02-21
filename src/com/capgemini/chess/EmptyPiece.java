package com.capgemini.chess;

public class EmptyPiece extends Piece {
	private String empty;

	public EmptyPiece() {
		this.empty = "empty";

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
//TODO fix implementation?
	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to, Square[][] chessboard) {
		return false;
	}

}
