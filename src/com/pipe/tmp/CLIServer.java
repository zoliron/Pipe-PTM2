package com.pipe.tmp;

import com.pipe.client.PrintHandler;
import com.pipe.server.MyServer;
import com.pipe.server.Server;



/**
 * @author Yaniv Zolicha
 */
public class CLIServer{



	public static void main(String[] args) throws Exception{
		Server server = new MyServer();
		server.start(new PrintHandler());
	}



}
