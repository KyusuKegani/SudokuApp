package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** TODO:カメラを起動するボタン➡カメラ起動のルーティンを作る */
    /**
     * Called when the user taps the Send button
     */
    public void startCamera(View view) {
       Intent intent = new Intent(this, CameraActivity.class);
       startActivity(intent);
    }

}
