package com.swu.kalkulator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button buttonKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.imageView);
        buttonKembali = findViewById(R.id.buttonKembali);

        buttonKembali.setOnClickListener(v -> finish());
    }
}
