package com.pipe.client;

import java.io.*;

public class MyCHandler implements ClientHandler {

    @Override
    public void handleClient(InputStream inFromClient, OutputStream outToClient) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inFromClient));
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println("Msg: " + line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
