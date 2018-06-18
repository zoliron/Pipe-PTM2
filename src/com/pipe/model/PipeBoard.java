package com.pipe.model;

/**
 * Encapsulate the pipe game board.
 *
 * @author Yaniv Zolicha
 */
public class PipeBoard{



	/**
	 * The {@link PipeCell}s' board.
	 */
	private final PipeCell[][] board;



	/**
	 * Creates new {@link PipeBoard} with the specified cells.
	 */
	public PipeBoard(PipeCell[][] board){
		this.board = board;
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



}