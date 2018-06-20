package com.pipe.model;

import com.pipe.utils.Point;

import java.util.Arrays;
import java.util.Objects;



/**
 * Encapsulate the pipe game board.
 *
 * @author Yaniv Zolicha
 */
public class PipeBoard implements Cloneable{



	/**
	 * The {@link PipeCell}s' board.
	 */
	private final PipeCell[][] board;



	/**
	 * The source {@link PipeCell}.
	 */
	private final PipeCell source;



	/**
	 * The goal {@link PipeCell}.
	 */
	private final PipeCell goal;



	/**
	 * Creates new {@link PipeBoard} with the specified cells.
	 */
	public PipeBoard(PipeCell[][] board){
		this.board = board;
		this.source = findSourceCell(board);
		this.goal = findGoalCell(board);
	}



	/**
	 * Creates new deep copy {@link PipeBoard} from other board.
	 */
	public PipeBoard(PipeBoard other){
		int rowCount = other.getRowCount();
		int columnCount = other.getColumnCount();

		this.board = new PipeCell[rowCount][columnCount];
		for (int y = 0; y < rowCount; y++)
			for (int x = 0; x < columnCount; x++)
				board[y][x] = other.board[y][x].deepCopy();

		this.source = findSourceCell(board);
		this.goal = findGoalCell(board);
	}



	/**
	 * Returns the board row count.
	 */
	public int getRowCount(){
		return board.length;
	}



	/**
	 * Returns the board column count.
	 */
	public int getColumnCount(){
		return board[0].length;
	}



	/**
	 * Returns the source {@link PipeCell}.
	 */
	public PipeCell getSource(){
		return source;
	}



	/**
	 * Returns the goal {@link PipeCell}.
	 */
	public PipeCell getGoal(){
		return goal;
	}



	/**
	 * Returns the {@link PipeCell} at the specified position.
	 */
	public PipeCell get(Point position){
		return get(position.x, position.y);
	}



	/**
	 * Returns the {@link PipeCell} at the specified position.
	 */
	public PipeCell get(int x, int y){
		int columnCount = getColumnCount();
		int rowCount = getRowCount();

		return (0 <= x && x < columnCount && 0 <= y && y < rowCount)
				? board[y][x]
				: null;
	}



	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();

		for (PipeCell[] row : board){
			if (sb.length() > 0)
				sb.append("\n");

			sb.append("\"");
			for (PipeCell cell : row)
				sb.append(cell);
			sb.append("\"");
		}

		return sb.toString();
	}



	@Override
	public int hashCode(){
		return Arrays.deepHashCode(board);
	}



	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof PipeBoard))
			return false;

		PipeBoard other = (PipeBoard)obj;
		return Objects.deepEquals(board, other.board);
	}



	/**
	 * Returns the source {@link PipeCell}.
	 */
	private static PipeCell findSourceCell(PipeCell[][] board){
		for (PipeCell[] row : board)
			for (PipeCell cell : row)
				if (cell.isSource())
					return cell;

		throw new IllegalStateException("Missing source cell.");
	}



	/**
	 * Returns the goal {@link PipeCell}.
	 */
	private static PipeCell findGoalCell(PipeCell[][] board){
		for (PipeCell[] row : board)
			for (PipeCell cell : row)
				if (cell.isGoal())
					return cell;

		throw new IllegalStateException("Missing goal cell.");
	}


}