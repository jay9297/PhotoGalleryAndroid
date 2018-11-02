package com.example.yajch.photogallery;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ZoomActivity extends AppCompatActivity {

    // final ImageView zoomedImage = findViewById(R.id.zoomImage);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);

        ImageView zoomedImage = findViewById(R.id.zoomImage);
        final Intent mainIntent = getIntent();
        int imageID = mainIntent.getIntExtra("thisImage", 0);
        Drawable passedDrawable = getResources().getDrawable(imageID);
        zoomedImage.setImageDrawable(passedDrawable);
        zoomedImage.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) getWallpaperDesiredMinimumWidth()));

        zoomedImage.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
