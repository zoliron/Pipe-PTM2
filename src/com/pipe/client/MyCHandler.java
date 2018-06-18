package com.pipe.client;

import com.pipe.cachemanager.CacheManager;
import com.pipe.cachemanager.File;

import java.io.*;

public class MyCHandler implements ClientHandler {

    @Override
    public void handleClient(InputStream inFromClient, OutputStream outToClient) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inFromClient));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Msg: " + line);
                CacheManager cm = new File();
                cm.save(line);
                System.out.println(cm.load());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
