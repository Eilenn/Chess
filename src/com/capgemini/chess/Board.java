package com.capgemini.chess;

import java.util.ArrayList;

/**
 * Board represents chess board with 64 square tiles.
 * 
 * @author BOWROBEL
 *
 */
public class Board {

	private Square[][] chessboard;
	private ColorChess white = ColorChess.WHITE;
	private ColorChess black = ColorChess.BLACK;
	private ArrayList<Piece> whitePiecesInGame;
	private ArrayList<Piece> blackPiecesInGame;

	/**
	 * Creates empty board with 81 squares, used only 64 named from 11 to 88
	 * with interchangeable colors, 81 to simplify specifying moves
	 */
	public Board() {
		chessboard = new Square[9][9];
		boolean isBlack = true;
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

	public Square[][] getChessboard() {
		return chessboard;
	}

	/**
	 * Puts all types of pieces in their correct starting position.
	 */
	public void initializeBoard() {
		createWhitePieces();
		createBlackPieces();
		int rowOfWhitePawnsIndex = 8;
		int rowOfBlackPawnsIndex = 8;
		for (int file = 1; file <= 8; file++) {
			Piece whitePieceToAdd = whitePiecesInGame.get(file - 1);
			Piece whitePieceToAddSecondRow = whitePiecesInGame.get(rowOfWhitePawnsIndex++);
			chessboard[1][file].setPiece(whitePieceToAdd);
			chessboard[2][file].setPiece(whitePieceToAddSecondRow);
			Piece blackPieceToAdd = blackPiecesInGame.get(file - 1);
			Piece blackPieceToAddSeventhRow = blackPiecesInGame.get(rowOfBlackPawnsIndex++);
			chessboard[8][file].setPiece(blackPieceToAdd);
			chessboard[7][file].setPiece(blackPieceToAddSeventhRow);
		}
	}

	/**
	 * Creates list of white pieces in the beginning - 16 of them: 2 rooks, 2
	 * knights, 2 bishops, King, Queen and 8 pawns.
	 */

	private void createWhitePieces() {
		whitePiecesInGame = new ArrayList<>();
		whitePiecesInGame.add(new Rook(white));
		whitePiecesInGame.add(new Knight(white));
		whitePiecesInGame.add(new Bishop(white));
		whitePiecesInGame.add(new Queen(white));
		whitePiecesInGame.add(new King(white));
		whitePiecesInGame.add(new Bishop(white));
		whitePiecesInGame.add(new Knight(white));
		whitePiecesInGame.add(new Rook(white));
		for (int numberOfPawns = 0; numberOfPawns < 8; numberOfPawns++) {
			whitePiecesInGame.add(new Pawn(white));
		}
	}

	/**
	 * Creates list of black pieces in the beginning - 16 of them: 2 rooks, 2
	 * knights, 2 bishops, King, Queen and 8 pawns.
	 */
	private void createBlackPieces() {
		blackPiecesInGame = new ArrayList<>();
		blackPiecesInGame.add(new Rook(black));
		blackPiecesInGame.add(new Knight(black));
		blackPiecesInGame.add(new Bishop(black));
		blackPiecesInGame.add(new Queen(black));
		blackPiecesInGame.add(new King(black));
		blackPiecesInGame.add(new Bishop(black));
		blackPiecesInGame.add(new Knight(black));
		blackPiecesInGame.add(new Rook(black));
		for (int numberOfPawns = 0; numberOfPawns < 8; numberOfPawns++) {
			blackPiecesInGame.add(new Pawn(black));
		}

	}

	/**
	 * Helps in assigning correct colors on the board, changes value from true
	 * for black to false for white
	 * 
	 * @param isSquareBlack
	 * @return
	 */
	private boolean changeColorToOpposite(boolean isSquareBlack) {
		return !isSquareBlack;
	}

}
