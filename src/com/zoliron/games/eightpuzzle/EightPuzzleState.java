package com.zoliron.games.eightpuzzle;

import com.zoliron.games.eightpuzzle.EightPuzzle.Action;
import com.zoliron.utils.Point;



/**
 * @author Ronen Zolicha
 */
public class EightPuzzleState{



	private final EightPuzzle puzzle;



	private final Point point;



	private final Action action;



	public EightPuzzleState(EightPuzzle puzzle, Point point, Action action){
		this.puzzle = puzzle;
		this.point = point;
		this.action = action;
	}



	public EightPuzzle getPuzzle(){
		return puzzle;
	}



	public Point getPoint(){
		return point;
	}



	public Action getAction(){
		return action;
	}



	@Override
	public String toString(){
		return "Move " + point + " - " + action;
	}



}
