package com.zoliron.server;

import com.zoliron.client.ClientHandler;

import java.net.ServerSocket;
import java.net.Socket;



/**
 * The {@link Server} implementation.
 *
 * @author Ronen Zolicha
 */
public class MyServer implements Server{



	/**
	 * The server port.
	 */
	private final int port;



	/**
	 * The {@link ClientHandler}.
	 */
	private ClientHandler clientHandler;



	/**
	 * Indicates whether the server is stopped.
	 */
	private volatile boolean stop;



	/**
	 * Creates new {@link MyServer} with the specified port.
	 */
	public MyServer(int port){
		this.port = port;
	}



	@Override
	public void start(ClientHandler clientHandler){
		this.clientHandler = clientHandler;
		this.stop = false;

		try{
			runServer();
		} catch (Exception e){
			e.printStackTrace();
		}
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
		ServerSocket listener = new ServerSocket(port);

		System.out.println("Waiting for clients on port: " + port);
		while (!stop){
			try{
				Socket socket = listener.accept();

				clientHandler.handleClient(socket.getInputStream(), socket.getOutputStream());

//				socket.getInputStream().close();
//				socket.getOutputStream().close();
				socket.close();
			} catch (Exception e){
				e.printStackTrace();
			}
		}

		listener.close();
	}



}