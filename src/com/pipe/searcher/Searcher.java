package com.pipe.searcher;

import com.pipe.searchable.Searchable;
import com.pipe.searchable.State;



/**
 * @author Yaniv Zolicha
 */
public interface Searcher<T>{



	State<T> search(Searchable<T> searchable);



}