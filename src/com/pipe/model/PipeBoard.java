package com.pipe.model;

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



	public int getRowCount(){
		return board.length;
	}



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



	public PipeCell get(int x, int y){
		return board[y][x];
	}





	/**
	 * Clone the {@link PipeBoard} cells.
	 */
	public PipeCell[][] cloneBoardCells(){
		int rowCount = getRowCount();
		int columnCount = getColumnCount();

		PipeCell[][] cloneBoard = new PipeCell[rowCount][columnCount];
		for (int y = 0; y < rowCount; y++)
			for (int x = 0; x < columnCount; x++)
				cloneBoard[y][x] = board[y][x];

		return cloneBoard;
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