package com.pipe.model;

import com.pipe.utils.Point;



/**
 * A 'L' or 'F' or '7' or 'J' {@link PipeCell}.
 *
 * @author Yaniv Zolicha
 */
public class LPipeCell extends DegreesPipeCell{



	/**
	 * Creates new {@link LPipeCell} with the specified coordinates and degrees.
	 */
	public LPipeCell(Point coordinates, int degrees){
		super(coordinates, degrees);
	}



	@Override
	public boolean isConnectedWith(PipeCell cell){
		Point point = cell.getCoordinates();

		switch (getDegrees()){
			case 0: // 'L' case
				return isBottomOf(point) || isLeftOf(point);

			case 90: // 'F' case
				return isTopOf(point) || isLeftOf(point);

			case 180: // '7' case
				return isTopOf(point) || isRightOf(point);

			case 270: // 'J' case
				return isBottomOf(point) || isRightOf(point);

			default:
				throw new IllegalStateException("Unsupported degrees: " + getDegrees());
		}
	}



	@Override
	public String toString(){
		switch (getDegrees()){
			case 0: // 'L' case
				return "L";

			case 90: // 'F' case
				return "F";

			case 180: // '7' case
				return "7";

			case 270: // 'J' case
				return "J";

			default:
				throw new IllegalStateException("Unsupported degrees: " + getDegrees());
		}
	}



	@Override
	public PipeCell deepCopy(){
		return new LPipeCell(getCoordinates(), getDegrees());
	}


}
