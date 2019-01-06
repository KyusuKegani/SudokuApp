package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_SHOW_RESULT = 2;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Called when the user taps the Start button
     */
    public void startCamera(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    /**
     * カメラで画像を撮影後、結果表示画面に遷移する。
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            // cancelした場合
            if (data.getExtras() == null) {
                Log.d("debug", "cancel ?");
                return;
            }

            bitmap = (Bitmap) data.getExtras().get("data");

            if (bitmap != null) {
                int bmpWidth = bitmap.getWidth();
                int bmpHeight = bitmap.getHeight();
                Log.d("debug", String.format("w= %d", bmpWidth));
                Log.d("debug", String.format("h= %d", bmpHeight));
            }

            setContentView(R.layout.activity_camera);

            ImageView screenView = findViewById(R.id.screenView);
            screenView.setImageBitmap(bitmap);
        }
    }



}
