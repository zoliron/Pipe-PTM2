package com.zoliron.games.pipe;

import com.zoliron.games.pipe.model.PipeBoard;
import com.zoliron.games.pipe.searchable.PipeSearchable;
import com.zoliron.games.pipe.searchable.PipeSearchableState;
import com.zoliron.searcher.Solution;
import com.zoliron.searcher.algorithms.HillClimbing;
import com.zoliron.solver.Solver;



/**
 * The {@link PipeBoard} game solver.
 *
 * @author Yaniv Zolicha
 */
public class PipeSolver implements Solver<PipeBoard>{



	@Override
	public PipeBoard createProblem(String problem){
		return new PipeBoardParser().parse(problem);
	}



	@Override
	public String solve(PipeBoard problem){
		PipeSearchable searchable = new PipeSearchable(problem);

		Solution<PipeSearchableState> solution = new HillClimbing<PipeSearchableState>().search(searchable);

		String s = "dfgdsbg";

		return s;
	}



}