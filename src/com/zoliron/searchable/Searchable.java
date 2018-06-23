package com.zoliron.searchable;

import java.util.List;



/**
 * @author Ronen Zolicha
 */
public interface Searchable<T>{



	State<T> getInitialState();



	boolean isGoal(State<T> state);



	List<State<T>> getAllPossibleStates(State<T> state);



}
