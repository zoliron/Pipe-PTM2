package com.zoliron.searcher.algorithms;

import com.zoliron.searchable.Searchable;
import com.zoliron.searcher.AbstractSearcher;
import com.zoliron.searcher.SearcherNode;
import com.zoliron.searcher.Solution;

import java.util.*;



/**
 * The best first search algorithm implementation.
 */
public class BestFirstSearch<S> extends AbstractSearcher<S>{



	@Override
	public Solution<S> search(Searchable<S> searchable){
		Queue<SearcherNode<S>> queue = new PriorityQueue<>();
		Set<SearcherNode<S>> visited = new HashSet<>();

		// Add the initial state.
		SearcherNode<S> initialNode = getInitialNode(searchable);
		queue.add(initialNode);

		while (!queue.isEmpty()){
			incremntIteration();

			SearcherNode<S> node = queue.remove();
			visited.add(initialNode);

//			System.out.println(node.getState());
//			System.out.println("Score: " + node.getScore());
//			System.out.println("Cost: " + node.getCost());
//			System.out.println("Estimation: " + node.getEstimation());
//			System.out.println();

			// Check if we are on the goal state.
			if (searchable.isGoal(node))
				return toSolution(node);

			List<SearcherNode<S>> possibleNodes = getAllPossibleNodes(searchable, node);
			for (SearcherNode<S> possibleNode : possibleNodes){
				if (!visited.contains(possibleNode) && !queue.contains(possibleNode))
					queue.add(possibleNode);
				else if (queue.removeIf(testNode -> isBetterThan(possibleNode, testNode)))
					queue.add(possibleNode);
			}
		}

		return null;
	}



	/**
	 * Returns {@code true} if {@param n1} is better than {@code n2} and have the same state, otherwise
	 * returns {@code true}.
	 */
	private boolean isBetterThan(SearcherNode<S> n1, SearcherNode<S> n2){
		return n1.equals(n2) && (n1.getCost() < n2.getCost());
	}



}