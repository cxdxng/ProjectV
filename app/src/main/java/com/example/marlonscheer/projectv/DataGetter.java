package com.example.marlonscheer.projectv;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.Charset;

public class DataGetter {
    private static final int port = 4100;
    private static final String host = "192.168.88.207";
    private static final byte[] bytes = null;
    public static String getData(){

        try {
            Socket socket = new Socket(host, port);
            socket.getOutputStream().write("3001".getBytes(Charset.defaultCharset()));
            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(bytes);
    }
}
