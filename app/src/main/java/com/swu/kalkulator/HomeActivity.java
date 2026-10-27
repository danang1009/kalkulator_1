
package com.swu.kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button buttonKalkulator;
    Button buttonTentang;
    Button buttonRiwayat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        buttonKalkulator = findViewById(R.id.buttonKalkulator);
        buttonTentang = findViewById(R.id.buttonTentang);
        buttonRiwayat = findViewById(R.id.buttonRiwayat);

        buttonKalkulator.setOnClickListener(v -> {
            Intent intent = new Intent(
                    HomeActivity.this,
                    MainActivity.class
            );
            startActivity(intent);
        });

        buttonTentang.setOnClickListener(v -> {
            Intent intent = new Intent(
                    HomeActivity.this,
                    AboutActivity.class
            );
            startActivity(intent);
        });

        buttonRiwayat.setOnClickListener(v -> {
            Intent intent = new Intent(
                    HomeActivity.this,
                    HistoryActivity.class
            );
            startActivity(intent);
        });
    }
}
