package com.example.quitquick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageButton;

public class HealthActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton btnReturnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);


        toolbar = findViewById(R.id.actionBarReturnHome);
        btnReturnHome=findViewById(R.id.btnAppBarReturnHome);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btnReturnHome.setOnClickListener(v -> {
            this.finish();
        });

    }
}