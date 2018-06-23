package com.zoliron.tmp;

import com.zoliron.games.eightpuzzle.EightPuzzle;
import com.zoliron.games.eightpuzzle.EightPuzzleSearchable;
import com.zoliron.games.eightpuzzle.EightPuzzleState;
import com.zoliron.searcher.Solution;
import com.zoliron.searcher.algorithms.BFS;



/**
 * @author Yaniv Zolicha
 */
public class EightPuzzleTest{



	public static void main(String[] args) throws Exception{
		EightPuzzle puzzle = new EightPuzzle(new String[][]{{" ", "8", "7"}, {"6", "5", "4"}, {"3", "2", "1"}});
		EightPuzzleSearchable searchable = new EightPuzzleSearchable(EightPuzzle.GOAL);

		Solution<EightPuzzleState> solution = new BFS<EightPuzzleState>().search(searchable);
		System.out.println(solution);
	}



}
