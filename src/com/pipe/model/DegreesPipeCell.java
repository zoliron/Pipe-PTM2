package com.pipe.model;

import com.pipe.utils.Point;



/**
 * A degrees rotateable {@link PipeCell}.
 *
 * @author Yaniv Zolicha
 */
public abstract class DegreesPipeCell extends PipeCell{



	/**
	 * The rotation degrees.
	 */
	private int degrees;



	/**
	 * Creates new {@link DegreesPipeCell} with the specified coordinates and degrees.
	 */
	public DegreesPipeCell(Point coordinates, int degrees){
		super(coordinates);

		this.degrees = degrees;
	}



	@Override
	public boolean isRotateable(){
		return true;
	}



	@Override
	public final void rotate(){
		this.degrees = (degrees + 90) % 360;
	}



	/**
	 * Returns the rotation degrees.
	 */
	protected int getDegrees(){
		return degrees;
	}


}