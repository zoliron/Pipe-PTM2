package com.zoliron.tmp;

import com.zoliron.client.ClientHandler;
import com.zoliron.games.pipe.PipeBoardParser;
import com.zoliron.games.pipe.model.PipeBoard;
import com.zoliron.games.pipe.searchable.PipeSearchable;
import com.zoliron.games.pipe.searchable.PipeSearchableState;
import com.zoliron.searcher.Solution;
import com.zoliron.searcher.algorithms.BFS;
import com.zoliron.searcher.algorithms.BestFirstSearch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class PrintHandler implements ClientHandler{



	@Override
	public void handleClient(InputStream inFromClient, OutputStream outToClient){
		try{
			List<String> rawBoard = readUntilDone(inFromClient);

			PipeBoard board = new PipeBoardParser().parse(rawBoard);
			System.out.println(board);

			PipeSearchable p = new PipeSearchable(board);
//			System.out.println(p.getInitialState().getReachablePointsFromSource());
//			System.out.println("\n\n");

			long t, diff;

			t = System.currentTimeMillis();
			Solution<PipeSearchableState> s1 = new BFS<PipeSearchableState>().search(p);
			diff = System.currentTimeMillis() - t;

			System.out.println("BFS: Time=" + diff);
			System.out.println();
			System.out.println(s1);
			System.out.println("\n\n");

			t = System.currentTimeMillis();
			Solution<PipeSearchableState> s2 = new BestFirstSearch<PipeSearchableState>().search(p);
			diff = System.currentTimeMillis() - t;

			System.out.println("BestFirstSearch: Time=" + diff);
			System.out.println();
			System.out.println(s2);
			System.out.println("\n\n");



//			List<State<PipeState>> states = p.getAllPossibleStates(p.getInitialState());
//			for (State<PipeState> state : states){
//				System.out.println("\n\n\n\n");
//				System.out.println(state.getStateObject().board);
//			}

		} catch (Exception e){
			e.printStackTrace();
		}
	}



	/**
	 * Read the specified {@link InputStream} lines until rich 'done' line.
	 */
	private static List<String> readUntilDone(InputStream inFromClient) throws IOException{
		List<String> lines = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(inFromClient));
		String line;
		while ((line = reader.readLine()) != null){
			if ("done".equals(line))
				return lines;

			lines.add(line);
		}

		return lines;
	}



}
