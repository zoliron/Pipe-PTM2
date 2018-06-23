package com.zoliron.cachemanager;

import java.io.IOException;



public interface CacheManager{



	void save(String newProblem) throws IOException;



	String load() throws IOException, ClassNotFoundException;
}
