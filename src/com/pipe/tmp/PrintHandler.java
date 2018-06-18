package com.pipe.tmp;

import com.pipe.client.ClientHandler;
import com.pipe.client.PipeBoardParser;
import com.pipe.model.PipeBoard;

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
