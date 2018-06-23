package com.zoliron.searcher;

import com.zoliron.searchable.Searchable;
import com.zoliron.searchable.State;



/**
 * @author Ronen Zolicha
 */
public interface Searcher<T>{



	State<T> search(Searchable<T> searchable);
//
//    public Solution<T> search(Searchable<T> s);
//
//    public int getNumberOfNodesEvaluated();
}
