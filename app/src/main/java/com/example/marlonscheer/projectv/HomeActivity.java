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
        wv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "UP", Snackbar.LENGTH_LONG);
                snackbar.show();
               /* try {
                    ConnEstablisher.socket.getOutputStream().write("2".getBytes(Charset.defaultCharset()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                */

            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "LEFT", Snackbar.LENGTH_LONG);
                snackbar.show();

               /* try {
                    ConnEstablisher.socket.getOutputStream().write("3".getBytes(Charset.defaultCharset()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                */
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "DOWN", Snackbar.LENGTH_LONG);
                snackbar.show();
              /*  try {
                    ConnEstablisher.socket.getOutputStream().write("4".getBytes(Charset.defaultCharset()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                */
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "RIGHT", Snackbar.LENGTH_LONG);
                snackbar.show();
               /* try {
                    ConnEstablisher.socket.getOutputStream().write("5".getBytes(Charset.defaultCharset()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                */
            }
        });

    }
}
