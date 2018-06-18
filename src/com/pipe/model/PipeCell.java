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



	/**
	 * Returns whether the specified point it to top of the cell coordinates.
	 */
	final boolean isTop(Point point){
		return (coordinates.x == point.x) && (coordinates.y == point.y - 1);
	}



	/**
	 * Returns the point to top of the cell coordinates.
	 */
	final Point getTop(){
		return new Point(coordinates.x, coordinates.y - 1);
	}



	/**
	 * Returns whether the specified point it to bottom of the cell coordinates.
	 */
	final boolean isBottom(Point point){
		return (coordinates.x == point.x) && (coordinates.y == point.y + 1);
	}



	/**
	 * Returns the point to bottom of the cell coordinates.
	 */
	final Point getBottom(){
		return new Point(coordinates.x, coordinates.y + 1);
	}



	/**
	 * Returns whether the specified point it to left of the cell coordinates.
	 */
	final boolean isLeft(Point point){
		return (coordinates.x == point.x - 1) && (coordinates.y == point.y);
	}



	/**
	 * Returns the point to left of the cell coordinates.
	 */
	final Point getLeft(){
		return new Point(coordinates.x - 1, coordinates.y);
	}



	/**
	 * Returns whether the specified point it to right of the cell coordinates.
	 */
	final boolean isRight(Point point){
		return (coordinates.x == point.x + 1) && (coordinates.y == point.y);
	}



	/**
	 * Returns the point to right of the cell coordinates.
	 */
	final Point getRight(){
		return new Point(coordinates.x + 1, coordinates.y);
	}



}