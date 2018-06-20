package com.pipe.model;

import com.pipe.utils.Point;



/**
 * @author Yaniv Zolicha
 */
public class SourceCell extends PipeCell{



	public SourceCell(Point coordinates){
		super(coordinates);
	}



	@Override
	public boolean isSource(){
		return true;
	}



	@Override
	public boolean isConnectedWith(PipeCell cell){
		return true;
	}



	@Override
	public String toString(){
		return "s";
	}



	@Override
	public PipeCell deepCopy(){
		return new SourceCell(getCoordinates());
	}



}