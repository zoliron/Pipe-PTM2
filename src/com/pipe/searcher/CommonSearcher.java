package com.pipe.searcher;

import com.pipe.searchable.Searchable;
import com.pipe.searchable.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public abstract class CommonSearcher<T> implements Searcher<T> {

    protected Collection<State<T>> openList;
    private int evaluatedNodes;

    public CommonSearcher() {
        newSearch();
    }

    public abstract void newSearch();
    protected abstract boolean addToOpenList(State<T> initialState);
    protected abstract State<T> popOpenList();

    protected int getEvaluatedNodes() {
        return this.evaluatedNodes;
    }

    protected void setEvaluatedNodes(int evaluatedNodes){
        this.evaluatedNodes = evaluatedNodes;
    }

    protected Solution<T> backTrace(State<T> goalState, State<T> sourceState) throws Exception{
        ArrayList<State<T>> arrayList = new ArrayList<>();
        arrayList.add(goalState);

        while(arrayList.get(0) != null && !arrayList.get(0).equals(sourceState) && arrayList.get(0).getCameFrom() != null){
            arrayList.add(0, (State<T>) arrayList.get(0).getCameFrom());
        }
        if arrayList.isEmpty(){
            throw new Exception("Backtrace is empty !");
        }
        return new Solution<T>(arrayList);
    }
    @Override
    public Solution<T> search(Searchable<T> s){
        newSearch();
        addToOpenList(s.getInitialState());
        Set<State<T>> closedSet = new HashSet<State<T>>();

        while(!openList.isEmpty()){
            State<T> n = popOpenList();
            closedSet.add(n);
            if(s.isGoal(n)){
                try{
                    return backTrace(n, s.getInitialState());
                } catch (Exception e) {e.printStackTrace();}
            }
            Collection<State<T>> successors = s.getAllPossibleStates(n);
            for(State<T> state : successors){
                if(!closedSet.contains(state)){
                    if(!openList.contains(state)){
                        addToOpenList(state);
                    }
                    else {
                        if(openList.removeIf(new Predicate<State<T>>() {
                            @Override
                            public boolean test(State<T> tState) {
                                return false;
                            }
                        })) {
                            @Override
                            public boolean test(State<T> tState) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    @Override
    public int getNumberOfNodesEvaluated(){
        return getEvaluatedNodes();
    }
}
