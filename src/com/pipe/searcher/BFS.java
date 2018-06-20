package com.pipe.searcher;

import com.pipe.searchable.Searchable;
import com.pipe.searchable.State;

import java.util.*;



/**
 * @author Yaniv Zolicha
 */
public class BFS<T> implements Searcher<T>{



	@Override
	public State<T> search(Searchable<T> searchable){
		int n = 0;

		Queue<State<T>> queue = new LinkedList<>();
		Set<State<T>> visited = new HashSet<>();

		// Add the initial state.
		queue.add(searchable.getInitialState());

		while (!queue.isEmpty()){
			// Poll the head.
			State<T> state = queue.remove();

			// Mark as visited.
			visited.add(state);

			System.out.print("\rsteps=" + (++n));

			// Check if we are on the goal state.
			if (searchable.isGoal(state))
				return state;

			List<State<T>> possibleStates = searchable.getAllPossibleStates(state);
			for (State<T> possibleState : possibleStates){
				if (!visited.contains(possibleState))
					queue.add(possibleState);
			}
		}

		return null;
	}



}
