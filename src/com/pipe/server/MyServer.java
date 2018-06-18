package com.pipe.server;

import com.pipe.client.ClientHandler;
import com.pipe.client.PrintHandler;

import java.net.ServerSocket;
import java.net.Socket;



/**
 * The {@link Server} implementation.
 *
 * @author Ronen Zolicha
 */
public class MyServer implements Server{



	/**
	 * The {@link ClientHandler}.
	 */
	private ClientHandler clientHandler;



	/**
	 * Indicates whether the server is stopped.
	 */
	private volatile boolean stop;



	@Override
	public void start(ClientHandler clientHandler) throws Exception{
		this.clientHandler = clientHandler;
		this.stop = false;

		runServer();
	}



	@Override
	public void stop(){
		this.clientHandler = null;
		this.stop = true;
	}



	/**
	 * Run & listen on the server port.
	 */
	private void runServer() throws Exception{
		ServerSocket listener = new ServerSocket(6400);

		System.out.println("Waiting for clients on port 6400");
		while (!stop){
			try{
				Socket socket = listener.accept();

				clientHandler.handleClient(socket.getInputStream(), socket.getOutputStream());

				socket.getInputStream().close();
				socket.getOutputStream().close();
				socket.close();
			} catch (Exception e){
				e.printStackTrace();
			}
		}

		listener.close();
	}



}