package com.zoliron.searcher;

import java.util.List;



/**
 * Encapsulate the {@link Searcher} solution.
 */
public class Solution<S>{



	/**
	 * The solution cost.
	 */
	private final double cost;



	/**
	 * The solution states.
	 */
	private final List<S> states;



	/**
	 * Creates new {@link Solution} with the specified cost and states.
	 */
	Solution(double cost, List<S> states){
		this.cost = cost;
		this.states = states;
	}



	/**
	 * Returns the solution cost.
	 */
	public double getCost(){
		return cost;
	}



	/**
	 * Returns the solution states.
	 */
	public List<S> getStates(){
		return states;
	}



	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();

		sb.append("Cost: ").append(cost).append("\n");
		sb.append("States:\n");
		for (S state : states)
			sb.append(state).append("\n");

		return sb.toString();
	}



}
