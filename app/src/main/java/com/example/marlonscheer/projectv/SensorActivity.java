package com.example.marlonscheer.projectv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.BatchUpdateException;

public class SensorActivity extends AppCompatActivity {

    TextView heat;
    TextView humid;
    TextView gas;
    TextView ultra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        heat = (TextView) findViewById(R.id.Waerme);
        humid = (TextView) findViewById(R.id.humidity);
        gas = (TextView) findViewById(R.id.ultra);
        ultra = (TextView) findViewById(R.id.gas);


    }
}
