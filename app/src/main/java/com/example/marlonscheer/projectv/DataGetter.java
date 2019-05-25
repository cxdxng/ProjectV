package com.example.marlonscheer.projectv;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.Charset;

public class DataGetter extends AsyncTask<Void, Void, String> {
    private static final int port = 6232;
    private static final String host = "192.168.88.207";
    private static byte[] bytes = null;
    public static Socket socket;
    public static InputStream in;

    public String getBytesString(){
        return new String(bytes);
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            socket = new Socket(host, port);
            socket.getOutputStream().write("3001".getBytes(Charset.defaultCharset()));
            in = socket.getInputStream();
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }
}
