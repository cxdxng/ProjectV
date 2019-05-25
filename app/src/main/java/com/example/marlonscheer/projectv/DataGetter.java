package com.example.marlonscheer.projectv;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataGetter extends AsyncTask<Void, Void, String> {
    private static final int port = 6232;
    private static final String host = "192.168.88.207";
    static List<byte[]> list = new ArrayList<>();
    public static Socket socket;
    public static InputStream in;

    public String getBytesString(){
        return new String(list.get(0));
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            View view = null;
            socket = new Socket(host, port);
            socket.getOutputStream().write("3001".getBytes(Charset.defaultCharset()));
            in = socket.getInputStream();
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            list.add(bytes);
            Log.d("Megaluuuuuuuuuuuuul", "IT WORKS!!!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(list.get(0));
    }
}
