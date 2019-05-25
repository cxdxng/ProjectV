package com.example.marlonscheer.projectv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceLandmark;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

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


        wv.setScrollContainer(false);

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
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "DOWN", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "LEFT", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "RIGHT", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

    }
}
