package com.pipe.server;

import com.pipe.client.ClientHandler;
import com.pipe.client.MyCHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class MyServer implements Server {
    private int port;
    private ClientHandler ch;
    private volatile boolean stop;


    public MyServer(int port, ClientHandler ch) {
        this.port = port;
        this.ch = ch;
        this.stop = false;
    }

    public void start() throws Exception {
        runServer();
    }

    public void stop() {
        stop = true;
    }

    private void runServer() throws Exception {
        ServerSocket listener = new ServerSocket(port);
//        listener.setSoTimeout(1000);

        while (!stop) {
            try {
                Socket socket = listener.accept();

                ch.handleClient(socket.getInputStream(), socket.getOutputStream());

                socket.getInputStream().close();
                socket.getOutputStream().close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        listener.close();
    }


    public static void main(String[] args) throws Exception {
        ClientHandler ch = new MyCHandler();
        Server server = new MyServer(8080, ch);
        server.start();
    }



}