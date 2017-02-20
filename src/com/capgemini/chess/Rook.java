package com.capgemini.chess;

public class Rook extends Piece {

	Rook(ColorChess color) {
		super(color);
	}

	@Override
	public boolean isMoveValid(Coordinate from, Coordinate to) {
		//TODO fix to think about occupied fields
		return isDestinationInTheSameRow(from, to)||isDestinationInTheSameColumn(from, to);
	}

	private boolean isDestinationInTheSameRow(Coordinate from, Coordinate to) {
		int fromX = from.getRow();
		int toX = to.getRow();
		return toX == fromX;
	}

	private boolean isDestinationInTheSameColumn(Coordinate from, Coordinate to) {
		int fromY = from.getColumn();
		int toY = to.getColumn();
		return toY==fromY;
	}
	// is this move allowed for rook
	private boolean isMoveAllowed(Coordinate from, Coordinate to){
		return isDestinationInTheSameRow(from, to)||isDestinationInTheSameColumn(from, to);
	}
	//TODO check if occupied on the way
	private boolean isPathToDestinationFree(Coordinate from, Coordinate to,Square[][] chessboard){
		int fromRow=from.getRow();
		int fromCol=from.getColumn();
		int toRow=to.getRow();
		int toCol=to.getColumn();
		int rowStart, rowEnd, colStart,colEnd;
		if(fromRow<=toRow){
			rowStart=fromRow;
			rowEnd=toRow;
		}
		else{
			rowStart=toRow;
			rowEnd=fromRow;
		}
		//(from.getRow()<=to.getRow())?from.getRow():to.getRow();
		if(isMoveAllowed(from, to)){
			
		}
		return false;
	}
}
