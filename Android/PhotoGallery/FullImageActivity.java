package com.example.swimcw2;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FullImageActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView fullImage;
    private Integer data;
    private String[] lista = {"Wybierz", "Udostępnij", "Ustaw jako tapetę"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        fullImage = (ImageView) findViewById(R.id.full_image);
        data = getIntent().getExtras().getInt("img");
        fullImage.setImageResource(data);

        Spinner opcje = (Spinner) findViewById(R.id.spinner2);
        if (opcje != null) {
            opcje.setOnItemSelectedListener(FullImageActivity.this);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            opcje.setAdapter(adapter);
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (position == 2) {
            WallpaperManager myWallpaperManager
                    = WallpaperManager.getInstance(getApplicationContext());
            try {
                myWallpaperManager.setResource(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (position == 1) {
            File file = new File("drawable://" + R.drawable.img1);
            Uri U = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/jpg");
            intent.putExtra(Intent.EXTRA_STREAM, U);
            startActivity(Intent.createChooser(intent, "Email:"));
        }
    }

        @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
