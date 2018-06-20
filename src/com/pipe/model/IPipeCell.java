package com.pipe.model;

import com.pipe.utils.Point;



/**
 * A '|' or '-' {@link PipeCell}.
 *
 * @author Yaniv Zolicha
 */
public class IPipeCell extends DegreesPipeCell{



	/**
	 * Creates new {@link IPipeCell} with the specified coordinates and degrees.
	 */
	public IPipeCell(Point coordinates, int degrees){
		super(coordinates, degrees);
	}



	@Override
	public boolean isConnectedWith(PipeCell cell){
		Point point = cell.getCoordinates();

		switch (getDegrees()){
			// '|' case
			case 0:
			case 180:
				return isTopOf(point) || isBottomOf(point);

			// '-' case
			case 90:
			case 270:
				return isLeftOf(point) || isRightOf(point);

			default:
				throw new IllegalStateException("Unsupported degrees: " + getDegrees());
		}
	}



	@Override
	public String toString(){
		switch (getDegrees()){
			// '|' case
			case 0:
			case 180:
				return "|";

			// '-' case
			case 90:
			case 270:
				return "-";

			default:
				throw new IllegalStateException("Unsupported degrees: " + getDegrees());
		}
	}



	@Override
	public PipeCell deepCopy(){
		return new IPipeCell(getCoordinates(), getDegrees());
	}


}