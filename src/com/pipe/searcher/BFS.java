package com.pipe.searcher;

import com.pipe.searchable.Searchable;
import com.pipe.searchable.State;

import java.util.*;



/**
 * @author Ronen Zolicha
 */
public class BFS<T> implements Searcher<T>{



	@Override
	public State<T> search(Searchable<T> searchable){
		Queue<State<T>> queue = new LinkedList<>();
		Set<State<T>> visited = new HashSet<>();

		// Add the initial state.
		State<T> initial = searchable.getInitialState();
		queue.add(searchable.getInitialState());
		visited.add(initial);

		while (!queue.isEmpty()){
			State<T> state = queue.remove();

			// Check if we are on the goal state.
			if (searchable.isGoal(state))
				return state;

			List<State<T>> possibleStates = searchable.getAllPossibleStates(state);
			for (State<T> possibleState : possibleStates){
				if (!visited.contains(possibleState)){
					visited.add(possibleState);
					queue.add(possibleState);
				}
			}
		}

		return null;
	}



}
