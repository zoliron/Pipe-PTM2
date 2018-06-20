package com.pipe.model;

import com.pipe.utils.Point;

import java.util.Objects;



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



	@Override
	public int hashCode(){
		return Objects.hash(super.hashCode(), degrees);
	}



	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof DegreesPipeCell))
			return false;

		DegreesPipeCell other = (DegreesPipeCell)obj;
		return super.equals(other) && (degrees == other.degrees);
	}



}