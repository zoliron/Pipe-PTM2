package com.pipe.searcher;

import com.pipe.searchable.State;

import java.util.PriorityQueue;

public class BestFirstSearch<T> extends CommonSearcher<T> {

    public BestFirstSearch() {
        newSearch();
    }

    @Override
    public void newSearch() {
        openList = new PriorityQueue<State<T>>();
        setEvaluatedNodes(0);
    }

    @Override
    protected boolean addToOpenList(State<T> initialState) {
        return ((PriorityQueue<State<T>>) openList).add(initialState);
    }

    @Override
    protected State<T> popOpenList() {
        setEvaluatedNodes(getNumberOfNodesEvaluated() + 1);
        State<T> state = ((PriorityQueue<State<T>>) openList).poll();
        return state;
    }
}
