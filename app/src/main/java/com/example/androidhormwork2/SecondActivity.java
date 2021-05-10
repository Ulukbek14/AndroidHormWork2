package com.example.androidhormwork2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    Button browser, camera, galleries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        browser = (Button) findViewById(R.id.browser_btn);
        camera = (Button) findViewById(R.id.camera_btn);
        galleries = (Button) findViewById(R.id.galleries_btn);

        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browse = new Intent(Intent.ACTION_WEB_SEARCH);
                startActivity(browse);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(camera);
            }
        });

        galleries.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.CATEGORY_APP_GALLERY);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, 20);
                startActivity(intent);
            }

        });


    }
}