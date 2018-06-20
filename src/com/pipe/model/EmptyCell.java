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
	public boolean isConnectedWith(PipeCell cell){
		return false;
	}



	@Override
	public String toString(){
		return " ";
	}



	@Override
	public PipeCell deepCopy(){
		return new EmptyCell(getCoordinates());
	}



}