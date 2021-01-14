package com.example.privvio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Foregroundservice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foregroundservice);
        Button startServiceButton = (Button) findViewById(R.id.start_foreground_service_button);
        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Foregroundservice.this, MyService.class);
                intent.setAction(MyService.ACTION_START_FOREGROUND_SERVICE);
                startService(intent);

            }
        });
        Button stopServiceButton = (Button) findViewById(R.id.stop_foreground_service_button);
        stopServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Foregroundservice.this, MyService.class);
                intent.setAction(MyService.ACTION_STOP_FOREGROUND_SERVICE);
                startService(intent);
            }
        });
    }
}