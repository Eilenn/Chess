package com.capgemini.chess;

public class Knight extends Piece {

	Knight(ColorChess color) {
		super(color);
	}
// TODO check corners?
	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to) {
		int distanceRow=to.getRow()-from.getRow();
		int distanceColumn=to.getColumn()-from.getColumn();
		Coordinate distance=new Coordinate(distanceRow, distanceColumn);
		for(Coordinate diff:allowedMoves){
			if(distance.equals(diff)){
				return true;
			}
		}
		return false;
		
/*		boolean canUpLeft = isMoveUpLeftAllowed(from, to);
		boolean canUpRight = isMoveUpRightAllowed(from, to);
		boolean canDownLeft = isMoveDownLeftAllowed(from, to);
		boolean canDownRight = isMoveDownRightAllowed(from, to);
		return canUpLeft || canUpRight || canDownLeft || canDownRight;*/
	}
	
	private Coordinate[] allowedMoves={new Coordinate(2,1), new Coordinate(-2,1),new Coordinate(-2,-1),new Coordinate(2,-1),
			new Coordinate(1, 2),new Coordinate(1, -2),new Coordinate(-1, 2),new Coordinate(-1, -2) };
/**
 * checks if move is allowed for Knight - it can only move two fields horizontally and one vertically
 * or two fields vertically and one horizontally; every method checks one of the combinations
 * @param from
 * @param to
 * @return
 */
	private boolean isMoveUpLeftAllowed(Coordinate from, Coordinate to) {
		int fromX = from.getRow();
		int fromY = from.getColumn();
		int toX = to.getRow();
		int toY = to.getColumn();
		return toX == fromX - 2 && toY == fromY - 1;
	}

	private boolean isMoveUpRightAllowed(Coordinate from, Coordinate to) {
		int fromX = from.getRow();
		int fromY = from.getColumn();
		int toX = to.getRow();
		int toY = to.getColumn();
		return toX == fromX - 2 && toY == fromY + 1;
	}

	private boolean isMoveDownLeftAllowed(Coordinate from, Coordinate to) {
		int fromX = from.getRow();
		int fromY = from.getColumn();
		int toX = to.getRow();
		int toY = to.getColumn();
		return toX == fromX + 2 && toY == fromY - 1;
	}

	private boolean isMoveDownRightAllowed(Coordinate from, Coordinate to) {
		int fromX = from.getRow();
		int fromY = from.getColumn();
		int toX = to.getRow();
		int toY = to.getColumn();
		return toX == fromX + 2 && toY == fromY + 1;
	}

}
