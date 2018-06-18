package com.pipe.searchable;

import com.pipe.model.PipeBoard;
import com.pipe.model.PipeCell;

import java.util.ArrayList;
import java.util.List;



/**
 * @author Yaniv Zolicha
 */
public class PipeSearchable implements Searchable<PipeBoard>{



	private final State<PipeBoard> initialState;



	public PipeSearchable(PipeBoard initialState){
		this.initialState = new State<>(initialState);
	}



	@Override
	public State<PipeBoard> getInitialState(){
		return initialState;
	}



	@Override
	public boolean isGoal(State<PipeBoard> state){
		return false;
	}



	@Override
	public List<State<PipeBoard>> getAllPossibleStates(State<PipeBoard> state){
		PipeBoard current = state.getObj();
		int rowCount = current.getRowCount();
		int columnCount = current.getColumnCount();

		List<State<PipeBoard>> permotations = new ArrayList<>(rowCount * columnCount);

		for (int y = 0; y < rowCount; y++)
			for (int x = 0; x < columnCount; x++){
				PipeCell cell = current.get(x, y);
				cell.rotate();

				permotations.add(new State<>(current));
			}

		return permotations;
	}



}
