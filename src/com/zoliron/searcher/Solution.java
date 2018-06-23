package com.zoliron.searcher;

import java.util.List;



/**
 * Encapsulate the {@link Searcher} solution.
 */
public class Solution<S>{



	/**
	 * The solution states.
	 */
	private final List<S> states;



	/**
	 * The solution cost.
	 */
	private final double cost;



	/**
	 * The solution total number of iterations.
	 */
	private final int numOfIteration;



	/**
	 * The solution duration, in milliseconds.
	 */
	private final long duration;



	/**
	 * Creates new {@link Solution} with the specified cost and states.
	 */
	Solution(List<S> states, double cost, int numOfIteration, long duration){
		this.states = states;
		this.cost = cost;
		this.numOfIteration = numOfIteration;
		this.duration = duration;
	}



	/**
	 * Returns the solution states.
	 */
	public List<S> getStates(){
		return states;
	}



	/**
	 * Returns the solution cost.
	 */
	public double getCost(){
		return cost;
	}



	/**
	 * Returns the solution total number of iterations.
	 */
	public int getNumOfIteration(){
		return numOfIteration;
	}



	/**
	 * Returns the solution duration, in milliseconds.
	 */
	public long getDuration(){
		return duration;
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
