package com.capgemini.chess;

import java.util.ArrayList;

public class ChessBoard {
	private Square[][] chessboard;
	private ArrayList<Piece> whitePiecesInGame;
	private ArrayList<Piece> blackPiecesInGame;

	public Square[][] getChessboard() {
		return chessboard;
	}

	public void initializeBoard(){
		//TODO move board creation here, give it to Board in constructor
	}

	public ArrayList<Piece> getWhitePiecesInGame() {
		return whitePiecesInGame;
	}

	public ArrayList<Piece> getBlackPiecesInGame() {
		return blackPiecesInGame;
	}
	
}
