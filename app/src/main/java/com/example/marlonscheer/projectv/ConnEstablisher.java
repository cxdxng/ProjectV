package com.example.marlonscheer.projectv;

import android.os.AsyncTask;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ConnEstablisher extends AsyncTask<Void, Void, String> {
    private static final int port = 6232;
    private static final String host = "192.168.88.207";
    static List<byte[]> list = new ArrayList<>();
    public static Socket socket;
    public static InputStream in;


    @Override
    protected String doInBackground(Void... voids) {
        try {
            socket = new Socket(host, port);
            socket.getOutputStream().write("3001".getBytes(Charset.defaultCharset()));
            in = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return new String(list.get(0));
        return null;
    }
}
