package com.pipe.model;

import com.pipe.utils.Point;



/**
 * An empty {@link PipeCell}.
 *
 * @author Yaniv Zolicha
 */
public class EmptyCell extends PipeCell{



	/**
	 * Creates new {@link EmptyCell} with the specified coordinates.
	 */
	public EmptyCell(Point coordinates){
		super(coordinates);
	}



	@Override
	public void rotate(){
		// Do nothing.
	}



	@Override
	public Point walkThrough(Point fromPoint){
		return null;
	}



	@Override
	public String toString(){
		return " ";
	}


}