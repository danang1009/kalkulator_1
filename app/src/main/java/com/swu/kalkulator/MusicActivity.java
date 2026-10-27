package com.swu.kalkulator;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button buttonPlay, buttonPause, buttonStop, buttonKembali;
    private TextView textStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPause = findViewById(R.id.buttonPause);
        buttonStop = findViewById(R.id.buttonStop);
        buttonKembali = findViewById(R.id.buttonKembali);
        textStatus = findViewById(R.id.textStatus);

        buttonPlay.setOnClickListener(v -> putarLagu());
        buttonPause.setOnClickListener(v -> jedaLagu());
        buttonStop.setOnClickListener(v -> hentikanLagu());

        buttonKembali.setOnClickListener(v -> finish());
    }

    private void putarLagu() {
        try {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(
                        this, R.raw.lagu
                );

                if (mediaPlayer == null) {
                    Toast.makeText(this,
                            "Lagu gagal dimuat",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                mediaPlayer.setOnCompletionListener(mp -> {
                    textStatus.setText("Lagu selesai");
                    mp.seekTo(0);
                });
            }

            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                textStatus.setText("Sedang memutar lagu");
            }

        } catch (Exception e) {
            Toast.makeText(this,
                    "Terjadi kesalahan saat memutar lagu",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void jedaLagu() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            textStatus.setText("Lagu dijeda");
        }
    }

    private void hentikanLagu() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            textStatus.setText("Lagu dihentikan");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
