package com.pipe.searchable;

/**
 * @author Yaniv Zolicha
 */
public class State<T> implements Comparable<State<T>>{



	/**
	 * The state object.
	 */
	private final T obj;



	/**
	 * The state we came from.
	 */
	private State<T> cameFrom;



	/**
	 * The state length (path size).
	 */
	private int length;



	/**
	 * Creates new {@link State} with the specified object.
	 */
	public State(T obj){
		this.obj = obj;
		this.cameFrom = null;
		this.length = 0;
	}



	/**
	 * Returns the state object.
	 */
	public T getObj(){
		return obj;
	}



	/**
	 * Returns the state which we came from to this state.
	 */
	public State<T> getCameFrom(){
		return cameFrom;
	}



	/**
	 * Sets the state which we came from to this state.
	 */
	public void setCameFrom(State<T> cameFrom){
		this.cameFrom = cameFrom;
		this.length = calculateLength(this);
	}



	/**
	 * Returns the state length (path size).
	 */
	public int getLength(){
		return length;
	}



	@Override
	public int compareTo(State<T> other){
		return Integer.compare(length, other.length);
	}



	@Override
	public int hashCode(){
		return obj.hashCode();
	}



	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof State))
			return false;

		State<?> other = (State<?>)obj;
		return this.obj.equals(other.obj);
	}



	/**
	 * Calculate the state length.
	 */
	private static int calculateLength(State<?> state){
		return (state == null)
				? 0
				: state.length + 1;
	}



}