package com.example.marlonscheer.projectv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.BatchUpdateException;

public class SensorActivity extends AppCompatActivity {

    Button up;
    Button down;
    Button left;
    Button right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        up = (Button) findViewById(R.id.arrowUp);
        down = (Button) findViewById(R.id.arrowDown);
        left = (Button) findViewById(R.id.arrowLeft);
        right = (Button) findViewById(R.id.arrowRight);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

    }
}
