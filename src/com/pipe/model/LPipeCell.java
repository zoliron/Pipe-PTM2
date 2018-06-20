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
	public Point walkThrough(Point fromPoint){
		switch (getDegrees()){
			case 0: // 'L' case
				if (isTop(fromPoint))
					return getRight();

				if (isRight(fromPoint))
					return getTop();

				return null;

			case 90: // 'F' case
				if (isRight(fromPoint))
					return getBottom();

				if (isBottom(fromPoint))
					return getRight();

				return null;

			case 180: // '7' case
				if (isLeft(fromPoint))
					return getBottom();

				if (isBottom(fromPoint))
					return getLeft();

				return null;

			case 270: // 'J' case
				if (isTop(fromPoint))
					return getLeft();

				if (isLeft(fromPoint))
					return getTop();

				return null;
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
		return new IPipeCell(getCoordinates(), getDegrees());
	}


}
