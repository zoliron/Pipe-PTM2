package com.pipe.searcher;

import com.pipe.searchable.Searchable;
import com.pipe.searchable.State;


/**
 * @author Ronen Zolicha
 */
public interface Searcher<T> {


    State<T> search(Searchable<T> searchable);
//
//    public Solution<T> search(Searchable<T> s);
//
//    public int getNumberOfNodesEvaluated();
//}
