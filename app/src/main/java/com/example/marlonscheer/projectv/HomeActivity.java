//Project created on Friday the 26.05.19 at Jugendhackt Köln.

package com.example.marlonscheer.projectv;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
    TextView s;
   ConstraintLayout v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //get current date time with Date() and Date
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        //Initializing ImageView's  and Remaining
        v = (ConstraintLayout)  findViewById(R.id.nav);
        s = (TextView) v.findViewById(R.id.date_text);
        wv = (WebView) findViewById(R.id.webView);
        exit = (Button) findViewById(R.id.buttonExit);
        up = (ImageView) findViewById(R.id.arrowUp);
        down = (ImageView) findViewById(R.id.arrowDown);
        left = (ImageView) findViewById(R.id.arrowLeft);
        right = (ImageView) findViewById(R.id.arrowRight);
        //Exit Button for closing socket by destroying Activity
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Fetching Data
                    ConnEstablisher.in.close();
                    ConnEstablisher.socket.close();
                    finish();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        s.setText(dateFormat.format(cal.getTime()) );


        //Setting Webview for showing camera data
        wv.loadUrl("http://192.168.88.89/cam");
        wv.setScrollContainer(true);
        wv.setVerticalScrollBarEnabled(true);

        //Up, Down, Left, Right, WebView and ImageViews for controlling Camera through socket from Baran our teammate

        up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Snackbar snackbar = Snackbar.make(v, "UP Pressed", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Snackbar snackbar = Snackbar.make(v, "Up Released", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
return true;
            }
        });
        down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Snackbar snackbar = Snackbar.make(v, "Down Pressed", Snackbar.LENGTH_LONG);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Snackbar snackbar = Snackbar.make(v, "Down Released", Snackbar.LENGTH_LONG);
                }
                return true;
            }
        });
        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Snackbar snackbar = Snackbar.make(v, "Left Pressed", Snackbar.LENGTH_LONG);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Snackbar snackbar = Snackbar.make(v, "Left Released", Snackbar.LENGTH_LONG);
                }
                return true;
            }
        });
        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Snackbar snackbar = Snackbar.make(v, "Right Pressed", Snackbar.LENGTH_LONG);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Snackbar snackbar = Snackbar.make(v, "Right Released", Snackbar.LENGTH_LONG);
                }
                return true;
            }
        });


    }
}
