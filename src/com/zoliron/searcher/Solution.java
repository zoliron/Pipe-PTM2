package com.zoliron.searcher;

import com.zoliron.searchable.State;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Solution<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	Collection<State<T>> collection;

	public Solution(){
		this.collection = new ArrayList<State<T>>();

	}

	public Solution(Collection<State<T>> collection){
		this.collection = collection;
	}
	public Collection<State<T>> getCollection(){
		return collection;
	}
	public void setCollection(Collection<State<T>> collection){
		this.collection = collection;
	}
}

