package com.example.marlonscheer.projectv;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    Button exit;
    WebView wv;
    ImageView up;
    ImageView down;
    ImageView left;
    ImageView right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        wv = (WebView) findViewById(R.id.webView);
        exit = (Button) findViewById(R.id.buttonExit);


        wv.loadUrl("http://192.168.88.89/cam");

        wv.setScrollContainer(true);

//Only hide the scrollbar, not disables the scrolling:
        wv.setVerticalScrollBarEnabled(false);
       // wv.setHorizontalScrollBarEnabled(true);

//Only disabled the horizontal scrolling:
      //  wv.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

//To disabled the horizontal and vertical scrolling:
       wv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });


        RelativeLayout v = (RelativeLayout)  findViewById(R.id.nav);

        TextView s = (TextView) v.findViewById(R.id.date_text);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();


        //get current date time with Calendar()
        Calendar cal = Calendar.getInstance();

        s.setText(dateFormat.format(cal.getTime()) );


        up = (ImageView) findViewById(R.id.arrowUp);
        down = (ImageView) findViewById(R.id.arrowDown);
        left = (ImageView) findViewById(R.id.arrowLeft);
        right = (ImageView) findViewById(R.id.arrowRight);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DataGetter.in.close();
                    DataGetter.socket.close();
                    finish();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "UP", Snackbar.LENGTH_LONG);
                snackbar.show();
                try {
                    DataGetter.socket.getOutputStream().write("2".getBytes(Charset.defaultCharset()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "LEFT", Snackbar.LENGTH_LONG);
                snackbar.show();
                try {
                    DataGetter.socket.getOutputStream().write("3".getBytes(Charset.defaultCharset()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "DOWN", Snackbar.LENGTH_LONG);
                snackbar.show();
                try {
                    DataGetter.socket.getOutputStream().write("4".getBytes(Charset.defaultCharset()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "RIGHT", Snackbar.LENGTH_LONG);
                snackbar.show();
                try {
                    DataGetter.socket.getOutputStream().write("5".getBytes(Charset.defaultCharset()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
