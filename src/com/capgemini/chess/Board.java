package com.capgemini.chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.awt.Color;

/**
 * Board represents chess board with 64 square tiles, numbered with combination
 * of letters A-H and numbers 1-8.
 * 
 * @author BOWROBEL
 *
 */
public class Board {

	private Map<Square, Piece> board = new HashMap<>();
	private Color white = Color.WHITE;
	private Color black = Color.BLACK;
	private ArrayList<Piece> piecesInGame;

	public Map<Square, Piece> getBoard() {
		return board;
	}

	public void setBoard(Map<Square, Piece> board) {
		this.board = board;
	}
/**
 * creates empty board with 64 squares named from A1 to H8 with interchangeable colors
 */
	// private? invoked in run?
	public void createBoard() {
		boolean isBlack = true;
		// rank++ changes letters, incrementing them by one: A B C...
		for (char rank = 'A'; rank <= 'H'; rank++) {
			for (int file = 1; file <= 8; file++) {
				if (isBlack){
					board.put(new Square(rank, file, black), new EmptyPiece());
					isBlack=changeColorToOpposite(isBlack);
				}
				else{
					board.put(new Square(rank, file, white), new EmptyPiece());
					isBlack=changeColorToOpposite(isBlack);
				}
			}
			isBlack=changeColorToOpposite(isBlack);
		}
	}
	/**
	 * puts all types of pieces in their correct starting position.
	 */
	public void initializeBoard(){
		//TODO create pieces in white and black
		//board.put(Square('A',1), new Rook(white));
		Piece whiteKing=new King(white);
		Piece blackKing=new King(black);
		Piece whiteQueen=new Queen(white);
		Piece blackQueen=new Queen(black);
		//TODO put pieces in their places
		//TODO add them to the list of pieces
	}
	
	/**
	 * helps in assigning correct colors on the board, changes value from true for black to false for white
	 * @param isBlack
	 * @return
	 */
	private boolean changeColorToOpposite(boolean isBlack){
		return !isBlack;
	}
}
