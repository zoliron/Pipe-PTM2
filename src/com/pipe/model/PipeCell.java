package com.pipe.model;

import com.pipe.utils.Point;



/**
 * Encapsulate cell within {@link PipeBoard}.
 *
 * @author Yaniv Zolicha
 */
public abstract class PipeCell{



	/**
	 * The pipe cell coordinates.
	 */
	private final Point coordinates;



	/**
	 * Creates new {@link PipeCell} with the specified coordinates.
	 */
	public PipeCell(Point coordinates){
		this.coordinates = coordinates;
	}


	/**
	 * Returns the pipe cell coordinates.
	 */
	public Point getCoordinates(){
		return coordinates;
	}



	/**
	 * Returns whether the pipe cell is the source cell.
	 */
	public boolean isSource(){
		return false;
	}



	/**
	 * Returns whether the pipe cell is the goal cell.
	 */
	public boolean isGoal(){
		return false;
	}



	/**
	 * Rotate the cell (clockwise).
	 */
	public abstract void rotate();



	/**
	 * Walk through the given point.
	 */
	public abstract Point walkThrough(Point fromPoint);



}
