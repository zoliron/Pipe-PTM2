package com.pipe.searchable;

import com.pipe.model.PipeBoard;
import com.pipe.model.PipeCell;
import com.pipe.utils.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * @author Yaniv Zolicha
 */
public class PipeSearchable implements Searchable<PipeState>{



	private final State<PipeState> initialState;



	public PipeSearchable(PipeBoard initialState){
		this.initialState = new State<>(new PipeState(initialState, initialState.getSource().getCoordinates()));
	}



	@Override
	public State<PipeState> getInitialState(){
		return initialState;
	}



	@Override
	public boolean isGoal(State<PipeState> state){
		PipeState pipeState = state.getObj();

		PipeCell cell = pipeState.board.get(pipeState.point);

		return (cell != null) && cell.isGoal();
	}



	/**
	 * Returns {@code true} if there is a pipes that lead to the goal cell, otherwise returns {@code false}.
	 */
	private static boolean isGoal(PipeBoard board, Set<Point> visited, Point position){
		if (visited.contains(position))
			return false;

		visited.add(position);
		PipeCell cell = board.get(position);
		if (cell == null)
			return false;

		return cell.isGoal()
				|| isGoal(board, visited, position, cell.getLeft())
				|| isGoal(board, visited, position, cell.getTop())
				|| isGoal(board, visited, position, cell.getRight())
				|| isGoal(board, visited, position, cell.getBottom());
	}



	/**
	 * Returns {@code true} if there is a pipes that lead to the goal cell through {@param toPoint}, otherwise returns {@code false}.
	 */
	private static boolean isGoal(PipeBoard board, Set<Point> visited, Point fromPoint, Point toPoint){
		PipeCell toCell = board.get(toPoint);
		if (toCell == null)
			return false;

		Point destPoint = toCell.walkThrough(fromPoint);
		if (destPoint == null)
			return false;

		return isGoal(board, visited, destPoint);
	}



	@Override
	public List<State<PipeState>> getAllPossibleStates(State<PipeState> state){
		PipeBoard current = state.getObj().board;
		int rowCount = current.getRowCount();
		int columnCount = current.getColumnCount();

		List<State<PipeState>> permotations = new ArrayList<>(rowCount * columnCount);
		for (int y = 0; y < rowCount; y++)
			for (int x = 0; x < columnCount; x++){
				PipeCell cell = current.get(x, y);
				if (!cell.isRotateable())
					continue;

				PipeBoard copy = new PipeBoard(current);

				PipeCell copyCell = copy.get(x, y);
				copyCell.rotate();

				permotations.add(new State<>(new PipeState(copy, copyCell.getCoordinates())));
			}

		return permotations;
	}



}
