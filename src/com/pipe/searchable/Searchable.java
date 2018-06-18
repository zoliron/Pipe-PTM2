package com.pipe.searchable;

import java.util.List;



/**
 * @author Yaniv Zolicha
 */
public interface Searchable<T>{



	State<T> getInitialState();



	boolean isGoal(State<T> state);



	List<State<T>> getAllPossibleStates(State<T> state);



}
