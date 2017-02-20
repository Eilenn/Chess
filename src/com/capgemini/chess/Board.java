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

	private Square[][] chessboard;
	// private Map<Square, Piece> board = new HashMap<>();
	private Color white = Color.WHITE;
	private Color black = Color.BLACK;
	private ArrayList<Piece> whitePiecesInGame;
	private ArrayList<Piece> blackPiecesInGame;
	// private Square sq;

	public Square[][] getBoard() {
		return chessboard;
	}

	public void setBoard(Square[][] board) {
		this.chessboard = board;
	}

	/**
	 * creates empty board with 64 squares named from A1 to H8 with
	 * interchangeable colors, but table is bigger (81 squares) to simplify specifying moves
	 */
	// private? invoked in run?
	Board() {
		chessboard = new Square[9][9];
		boolean isBlack = true;
		// rank++ changes letters, incrementing them by one: A B C...
		for (int rank = 1; rank <= 8; rank++) {
			for (int file = 1; file <= 8; file++) {
				if (isBlack) {
					chessboard[rank][file] = new Square(black, new EmptyPiece());
					isBlack = changeColorToOpposite(isBlack);
				} else {
					chessboard[rank][file] = new Square(white, new EmptyPiece());
					isBlack = changeColorToOpposite(isBlack);
				}
			}
			isBlack = changeColorToOpposite(isBlack);
		}
	}

	private void createWhitePieces() {
		whitePiecesInGame=new ArrayList<>();
		whitePiecesInGame.add(new Rook(white));
		whitePiecesInGame.add(new Knight(white));
		whitePiecesInGame.add(new Bishop(white));
		whitePiecesInGame.add(new King(white));
		whitePiecesInGame.add(new Queen(white));
		whitePiecesInGame.add(new Bishop(white));
		whitePiecesInGame.add(new Knight(white));
		whitePiecesInGame.add(new Rook(white));
		for (int numberOfPawns = 0; numberOfPawns < 8; numberOfPawns++) {
			whitePiecesInGame.add(new Pawn(white));
		}
	}

	private void createBlackPieces() {
		blackPiecesInGame=new ArrayList<>();
		blackPiecesInGame.add(new Rook(black));
		blackPiecesInGame.add(new Knight(black));
		blackPiecesInGame.add(new Bishop(black));
		blackPiecesInGame.add(new King(black));
		blackPiecesInGame.add(new Queen(black));
		blackPiecesInGame.add(new Bishop(black));
		blackPiecesInGame.add(new Knight(black));
		blackPiecesInGame.add(new Rook(black));
		for (int numberOfPawns = 0; numberOfPawns < 8; numberOfPawns++) {
			blackPiecesInGame.add(new Pawn(black));
		}

	}

	/**
	 * puts all types of pieces in their correct starting position.
	 */
	public void initializeBoard() {
		createWhitePieces();
		createBlackPieces();
		int rowOfPawnsIndex = 8;
		for (int file = 1; file <= 8; file++) {
			Piece whitePieceToAdd = whitePiecesInGame.get(file - 1);
			Piece whitePieceToAddSecondRow = whitePiecesInGame.get(rowOfPawnsIndex++);
			chessboard[1][file].setPiece(whitePieceToAdd);
			chessboard[2][file].setPiece(whitePieceToAddSecondRow);
			Piece blackPieceToAdd = blackPiecesInGame.get(file - 1);
			Piece blackPieceToAddSeventhRow = blackPiecesInGame.get(rowOfPawnsIndex++);
			chessboard[8][file].setPiece(blackPieceToAdd);
			chessboard[7][file].setPiece(blackPieceToAddSeventhRow);
		}
	}

	/**
	 * helps in assigning correct colors on the board, changes value from true
	 * for black to false for white
	 * 
	 * @param isBlack
	 * @return
	 */
	private boolean changeColorToOpposite(boolean isBlack) {
		return !isBlack;
	}

	public ArrayList<Piece> getWhitePiecesInGame() {
		return whitePiecesInGame;
	}

	public ArrayList<Piece> getBlackPiecesInGame() {
		return blackPiecesInGame;
	}

	public void setWhitePiecesInGame(ArrayList<Piece> whitePiecesInGame) {
		this.whitePiecesInGame = whitePiecesInGame;
	}

	public void setBlackPiecesInGame(ArrayList<Piece> blackPiecesInGame) {
		this.blackPiecesInGame = blackPiecesInGame;
	}
}
