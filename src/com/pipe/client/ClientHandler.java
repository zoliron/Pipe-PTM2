package com.pipe.client;

import java.io.InputStream;
import java.io.OutputStream;

public interface ClientHandler {
    void handleClient(InputStream inFromClient, OutputStream outToClient);
}
