package com.example.marlonscheer.projectv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Calendar;


import java.sql.Time;

public class HomeActivity extends AppCompatActivity {

    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        wv = (WebView) findViewById(R.id.webView);

        wv.loadUrl("https://github.com");
        RelativeLayout v = (RelativeLayout)  findViewById(R.id.nav);

        TextView s = (TextView) v.findViewById(R.id.date_text);
        s.setText(Calendar.getInstance().getTime().toString());



    }
}
