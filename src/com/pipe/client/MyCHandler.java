package com.pipe.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyCHandler implements ClientHandler {
    public void handleClient(InputStream inFromClient, OutputStream outToClient){
        try {
            System.out.println("Msg: " + IoUtils.readAsString(inFromClient));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
