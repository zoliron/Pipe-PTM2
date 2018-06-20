package com.pipe.searchable;

import java.util.Objects;



/**
 * @author Yaniv Zolicha
 */
public class State<T>{



	/**
	 * The state object.
	 */
	private final T obj;



	/**
	 * The state we came from.
	 */
	private State<T> cameFrom;



	/**
	 * Creates new {@link State} with the specified object.
	 */
	public State(T obj){
		this.obj = obj;
		this.cameFrom = null;
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
	}



	@Override
	public int hashCode(){
		return Objects.hash(obj, cameFrom);
	}



	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof State))
			return false;

		State<?> other = (State<?>)obj;
		return Objects.equals(obj, other.obj)
				&& Objects.equals(cameFrom, other.cameFrom);
	}



}