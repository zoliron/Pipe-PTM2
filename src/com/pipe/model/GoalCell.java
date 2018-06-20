package com.pipe.model;

import com.pipe.utils.Point;



/**
 * A goal {@link PipeCell}.
 *
 * @author Yaniv Zolicha
 */
public class GoalCell extends PipeCell{



	/**
	 * Creates new {@link GoalCell} with the specified coordinates.
	 */
	public GoalCell(Point coordinates){
		super(coordinates);
	}



	@Override
	public boolean isGoal(){
		return true;
	}



	@Override
	public Point walkThrough(Point fromPoint){
		return null;
	}



	@Override
	public String toString(){
		return "g";
	}



	@Override
	public PipeCell deepCopy(){
		return new GoalCell(getCoordinates());
	}



}