package com.pipe.searcher;

import com.pipe.searchable.Searchable;
import com.pipe.searchable.State;

import java.util.*;



/**
 * @author Yaniv Zolicha
 */
public class DFS<T> implements Searcher<T>{



	@Override
	public State<T> search(Searchable<T> searchable){
		int n = 0;

		Deque<State<T>> deque = new LinkedList<>();
		Set<State<T>> visited = new HashSet<>();

		// Add the initial state.
		deque.addLast(searchable.getInitialState());

		while (!deque.isEmpty()){
			// Poll the head.
			State<T> state = deque.removeLast();

			// Mark as visited.
			visited.add(state);

			System.out.print("\rsteps=" + (++n));

			// Check if we are on the goal state.
			if (searchable.isGoal(state))
				return state;

			List<State<T>> possibleStates = searchable.getAllPossibleStates(state);
			for (State<T> possibleState : possibleStates){
				if (!visited.contains(possibleState))
					deque.addLast(possibleState);
			}
		}

		return null;
//		return dfs(searchable, searchable.getInitialState(), new ArrayList<>());
	}



	private State<T> dfs(Searchable<T> searchable, State<T> state, Collection<State<T>> visited){
		// Mark as visited.
		visited.add(state);

		// Check if we are on the goal state.
		if (searchable.isGoal(state))
			return state;

		List<State<T>> possibleStates = searchable.getAllPossibleStates(state);
		for (State<T> possibleState : possibleStates){
			if (!visited.contains(possibleState)){
				State<T> goal = dfs(searchable, possibleState, visited);
				if (goal != null)
					return goal;
			}
		}

		return null;
	}



}