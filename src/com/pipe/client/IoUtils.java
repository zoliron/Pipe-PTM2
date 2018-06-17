package com.pipe.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IoUtils {


    public static String readAsString(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream(1024);

        pump(is, os);

        return os.toString("UTF-8");
    }


    public static byte[] readToEnd(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream(1024);

        pump(is, os);

        return os.toByteArray();
    }

    public static void pump(InputStream is, OutputStream os) throws IOException {
        byte[] buffer = new byte[1024];

        int length;
        while ((length = is.read(buffer)) != -1)
            os.write(buffer, 0, length);
    }


}