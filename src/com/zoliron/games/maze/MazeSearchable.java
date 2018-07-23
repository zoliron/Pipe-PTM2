package com.zoliron.games.maze;

import com.zoliron.searchable.Searchable;
import com.zoliron.searcher.SearcherNode;

import java.util.List;



/**
 * The maze searchable.
 *
 * @author Ronen Zolicha
 */
public class MazeSearchable implements Searchable<MazeSearchableState>{



	@Override
	public MazeSearchableState getInitialState(){
		return null;
	}



	@Override
	public boolean isGoal(SearcherNode<MazeSearchableState> node){
		return false;
	}



	@Override
	public List<MazeSearchableState> getAllPossibleStates(MazeSearchableState state){
		return null;
	}



	@Override
	public double calculateCost(MazeSearchableState fromState, MazeSearchableState toState){
		return 0;
	}



	@Override
	public double calculateEstimation(MazeSearchableState state){
		return 0;
	}



}