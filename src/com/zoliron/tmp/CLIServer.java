package com.zoliron.tmp;

import com.zoliron.client.MyClientHandler;
import com.zoliron.server.MyServer;
import com.zoliron.server.Server;



/**
 * @author Ronen Zolicha
 */
public class CLIServer{



	public static void main(String[] args) throws Exception{
		Server server = new MyServer();
		server.start(new MyClientHandler());
	}



}
