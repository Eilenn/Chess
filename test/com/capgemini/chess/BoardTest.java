package com.capgemini.chess;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class BoardTest {

	private Board board;

	@Before
	public void init() {
		board = new Board();
	}

	@Test
	public void shouldCreateEmptyBoard() {
		// given
		// Board board = new Board();
		// when
		int boardRankSize = board.getChessboard()[0].length;
		int boardFileSize = board.getChessboard().length;
		// then
		assertEquals(81, boardRankSize * boardFileSize);
	}
	
	@Ignore // visual check if pieces were put correctly
	@Test
	public void shouldPutPiecesCorrectly(){
	board.initializeBoard();
		Square[][] chessboard=board.getChessboard();
		for(int i=1;i<chessboard.length;i++){
			for(int j=1;j<chessboard[0].length;j++){
				System.out.println(chessboard[i][j].getPiece().toString());
			}
		}
		
	}
	/**
	 * help in display - so that color is not in rgb form
	 * 
	 * @param color
	 * @return
	 */
	private String getColorFromRGB(Color color) {
		if (color.equals(Color.BLACK))
			return "Black";
		else if (color.equals(Color.WHITE))
			return "White";
		else
			return "unknown";
	}

}
