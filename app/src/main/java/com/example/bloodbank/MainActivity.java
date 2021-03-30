package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(4000);

                } catch (Exception e) {
                    e.fillInStackTrace();

                } finally {
                    Intent intent = new Intent(MainActivity.this, signup.class);
                    startActivity(intent);

                }
            }


        };thread.start();

    }
}