package com.swu.kalkulator;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class SensorActivity extends AppCompatActivity
        implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor gyroscope;
    private Sensor accelerometer;

    private TextView textGyroscope;
    private TextView textAccelerometer;
    private TextView textStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        textGyroscope = findViewById(R.id.textGyroscope);
        textAccelerometer = findViewById(R.id.textAccelerometer);
        textStatus = findViewById(R.id.textStatus);

        Button buttonKembali = findViewById(R.id.buttonKembali);

        buttonKembali.setOnClickListener(v -> finish());

        sensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);

        gyroscope = sensorManager.getDefaultSensor(
                Sensor.TYPE_GYROSCOPE
        );

        accelerometer = sensorManager.getDefaultSensor(
                Sensor.TYPE_ACCELEROMETER
        );

        if (gyroscope == null && accelerometer == null) {
            textStatus.setText("Sensor tidak tersedia");
        } else if (gyroscope == null) {
            textStatus.setText("Gyroscope tidak tersedia");
        } else if (accelerometer == null) {
            textStatus.setText("Accelerometer tidak tersedia");
        } else {
            textStatus.setText("Sensor siap digunakan");
        }

        if (gyroscope == null) {
            textGyroscope.setText(
                    "Gyroscope tidak tersedia pada perangkat ini"
            );
        }

        if (accelerometer == null) {
            textAccelerometer.setText(
                    "Accelerometer tidak tersedia pada perangkat ini"
            );
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (gyroscope != null) {
            sensorManager.registerListener(
                    this,
                    gyroscope,
                    SensorManager.SENSOR_DELAY_UI
            );
        }

        if (accelerometer != null) {
            sensorManager.registerListener(
                    this,
                    accelerometer,
                    SensorManager.SENSOR_DELAY_UI
            );
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        String nilai = String.format(
                Locale.US,
                "X: %.2f\nY: %.2f\nZ: %.2f",
                x, y, z
        );

        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            textGyroscope.setText(
                    "Gyroscope (rad/s)\n" + nilai
            );
        } else if (event.sensor.getType()
                == Sensor.TYPE_ACCELEROMETER) {
            textAccelerometer.setText(
                    "Accelerometer (m/s²)\n" + nilai
            );
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Tidak perlu tindakan khusus.
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }
}
