package com.pipe.server;

import com.pipe.client.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServer implements Server {
    private int port;
    private ClientHandler ch;
    private volatile boolean stop;

    private void runServer() throws Exception {
        ServerSocket listener = new ServerSocket(port);
        listener.setSoTimeout(1000);
        while (!stop) {
            try {
                Socket socket = listener.accept();
                try {
                    ch.handleClient(socket.getInputStream(), socket.getOutputStream());

                    socket.getInputStream().close();
                    socket.getOutputStream().close();
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (SocketTimeoutException e) {
                e.printStackTrace();
            }
        }
        listener.close();
    }

    public void MyServer(int port, ClientHandler ch) {
        this.port = port;
        this.ch = ch;
        stop = false;
    }

    public void start() throws Exception {
        runServer();
    }

    public void stop() {
        stop = true;
    }
}

//public void start(){
//    ServerSocket server = new ServerSocket(port);
//    server.setSoTimeout(1000);
//    try{
//        Socket aClient=server.accept(); // blocking call
//        InputStream inFromClient = aClient.getInputStream();
//        OutputStream outToClient = aClient.getOutputStream();
//// interact (read & write) with the client according to protocol
//        inFromClient.close();
//        outToClient.close();
//        aClient.close();
//        server.close();
//    }catch(SocketTimeoutException e) {e.printStackTrace();}
//}