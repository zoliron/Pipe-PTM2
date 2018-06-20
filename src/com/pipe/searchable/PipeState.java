package com.pipe.searchable;

import com.pipe.model.PipeBoard;
import com.pipe.utils.Point;

import java.util.Objects;



/**
 * @author Ronen Zolicha
 */
public class PipeState{



	public final PipeBoard board;



	public final Point point;



	public PipeState(PipeBoard board, Point point){
		this.board = board;
		this.point = point;
	}



	@Override
	public int hashCode(){
		return Objects.hash(board);
	}



	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof PipeState))
			return false;

		PipeState other = (PipeState)obj;
		return Objects.equals(board, other.board);
	}



}
