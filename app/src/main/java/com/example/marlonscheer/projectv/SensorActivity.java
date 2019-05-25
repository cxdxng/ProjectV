package com.example.marlonscheer.projectv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.sql.BatchUpdateException;

public class SensorActivity extends AppCompatActivity {

    ImageView up;
    ImageView down;
    ImageView left;
    ImageView right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        up = (ImageView)findViewById(R.id.arrowUp);
        down =(ImageView)findViewById(R.id.arrowDown);
        left= (ImageView)findViewById(R.id.arrowLeft);
        right =(ImageView)findViewById(R.id.arrowRight);



    }
}
