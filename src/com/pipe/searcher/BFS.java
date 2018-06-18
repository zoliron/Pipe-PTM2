package com.pipe.searcher;

import com.pipe.searchable.Searchable;
import com.pipe.searchable.State;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;



/**
 * @author Yaniv Zolicha
 */
public class BFS<T> implements Searcher<T>{



	private final PriorityQueue<State<T>> openQueue = new PriorityQueue<>();



	@Override
	public State<T> search(Searchable<T> searchable){
		openQueue.add(searchable.getInitialState());

		Set<State<T>> closed = new HashSet<>();

		while (!openQueue.isEmpty()){
			// Poll the head.
			State<T> state = openQueue.poll();

			// Mark as closed.
			closed.add(state);

			// Check if we are on the goal state.
			if (searchable.isGoal(state))
				return state;

			List<State<T>> possibleStates = searchable.getAllPossibleStates(state);
			for (State<T> possibleState : possibleStates){

				// Case 1: The possible state were never visited.
				if (!closed.contains(possibleState) && !openQueue.contains(possibleState)){
					// Set came from.
					possibleState.setCameFrom(state);

					// Add to open queue.
					openQueue.offer(possibleState);
				}


				// Case 2: The possible state is better than the current one.
				else if (possibleState.getLength() < state.getLength()){

					// Case 2.1: The
					if (!openQueue.contains(state))
						openQueue.offer(state);


				}
			}
		}

		return null;
	}



}
