package com.zoliron.games.eightpuzzle;

import com.zoliron.utils.Point;

import java.util.Arrays;



/**
 * @author Yaniv Zolicha
 */
public class EightPuzzle{



	/**
	 * The goal puzzle.
	 */
	public static final EightPuzzle GOAL = new EightPuzzle(new String[][]{{" ", "1", "2"}, {"3", "4", "5"}, {"6", "7", "8"}});



	/**
	 * The row count.
	 */
	private static final int ROW_COUNT = 3;



	/**
	 * The column.
	 */
	private static final int COLUMN_COUNT = 3;



	/**
	 * The puzzle board.
	 */
	private final String[][] board;



	/**
	 * Creates new {@link EightPuzzle} with the specified board.
	 */
	public EightPuzzle(String[][] board){
		this.board = board;
	}



	/**
	 * Returns the puzzle empty point.
	 */
	public Point getEmptyPoint(){
		for (int x = 0; x < COLUMN_COUNT; x++){
			for (int y = 0; y < ROW_COUNT; y++){
				if (" ".equals(board[x][y]))
					return new Point(x, y);
			}
		}

		throw new IllegalStateException("Unsupported board: " + Arrays.toString(board));
	}



	/**
	 * Returns {@code true} if the specified point within the puzzle, otherwise returns {@code false}.
	 */
	public boolean isValidPoint(Point p){
		return (0 <= p.x && p.x < COLUMN_COUNT) && (0 <= p.y && p.y < ROW_COUNT);
	}



	/**
	 * Resolve the point we need to perform the action upon.
	 */
	public Point getPointForAction(Point empty, Action action){
		switch (action){
			case TOP:
				return new Point(empty.x, empty.y + 1);  // Move bottom point top.
			case BOTTOM:
				return new Point(empty.x, empty.y - 1); // Move top point bottom.
			case LEFT:
				return new Point(empty.x + 1, empty.y);  // Move right point left.
			case RIGHT:
				return new Point(empty.x - 1, empty.y); // Move left point right.
			default:
				throw new IllegalStateException("Unknown action: " + action);
		}
	}



	/**
	 * Swaps between the 2 points.
	 */
	public void swap(Point p1, Point p2){
		String tmp = board[p1.x][p1.y];
		board[p1.x][p1.y] = board[p2.x][p2.y];
		board[p2.x][p2.y] = tmp;
	}



	/**
	 * Deep copy the specified board.
	 */
	public EightPuzzle deepCopy(){
		String[][] copy = new String[COLUMN_COUNT][ROW_COUNT];

		for (int x = 0; x < COLUMN_COUNT; x++)
			for (int y = 0; y < ROW_COUNT; y++)
				copy[x][y] = board[x][y];

		return new EightPuzzle(copy);
	}



	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(ROW_COUNT * COLUMN_COUNT);
		for (int x = 0; x < COLUMN_COUNT; x++)
			for (int y = 0; y < ROW_COUNT; y++)
				sb.append(board[x][y]);

		return sb.toString();
	}



	@Override
	public int hashCode(){
		return Arrays.deepHashCode(board);
	}



	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof EightPuzzle))
			return false;

		EightPuzzle other = (EightPuzzle)obj;
		return Arrays.deepEquals(board, other.board);
	}



	/**
	 * The puzzle actions.
	 */
	public enum Action{

		LEFT, TOP, RIGHT, BOTTOM

	}



}
