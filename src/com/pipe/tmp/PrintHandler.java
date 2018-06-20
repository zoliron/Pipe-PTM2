package com.pipe.tmp;

import com.pipe.client.ClientHandler;
import com.pipe.client.PipeBoardParser;
import com.pipe.model.PipeBoard;
import com.pipe.searchable.PipeSearchable;
import com.pipe.searchable.PipeState;
import com.pipe.searchable.State;
import com.pipe.searcher.BFS;
import com.pipe.searcher.DFS;

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

			System.out.println("\n\n");

			State<PipeState> g = new DFS<PipeState>().search(p);

			System.out.println("\n\n");

			System.out.println(g.getStateObject().board);

			p.isGoal(g);

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
