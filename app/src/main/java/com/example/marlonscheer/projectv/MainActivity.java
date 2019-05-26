package com.example.marlonscheer.projectv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    EditText uname;
    EditText pass;
    Button login;
    public String username;
    public String passwd;
    public static ConnEstablisher dg = new ConnEstablisher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = (EditText) findViewById(R.id.editTextUname);
        pass = (EditText) findViewById(R.id.editTextPass);
        login = (Button) findViewById(R.id.buttonLogin);


        username = "axelvoss";
        passwd = "artikel13";


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String realuname = uname.getText().toString();
                String realpasswd = pass.getText().toString();


                if (username.equals(realuname) && passwd.equals(realpasswd)) {
                    new Thread(new Runnable() {
                        public void run() {
                          dg.execute();

                        }
                    }).start();
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);


                    overridePendingTransition(R.anim.enter, R.anim.exit);

                }else {
                    Snackbar snackbar = Snackbar.make(view, "Wrong Login Credentials, Try again", Snackbar.LENGTH_LONG);
                    snackbar.show();

                }
            }
        });



    }

}
