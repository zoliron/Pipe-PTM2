package com.zoliron.solver;

import java.io.InputStream;



/**
 * The solver interface.
 *
 * @author Ronen Zolicha
 */
public interface Solver<P>{



	/**
	 * Creates the problem from the specified {@link InputStream}.
	 */
	P createProblem(String problem);



	/**
	 * Solve and return the problem solution.
	 */
	String solve(P problem);



}