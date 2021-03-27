package com.example.quitquick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton btnAppBarAchievement,btnAppBarHealth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar=findViewById(R.id.customActionBar);
        setSupportActionBar(toolbar);

        btnAppBarAchievement=findViewById(R.id.btnappBarAchievement);
        btnAppBarHealth=findViewById(R.id.btnAppBarHealth);

        btnAppBarHealth.setOnClickListener(v -> {
            Intent health = new Intent(HomeActivity.this,HealthActivity.class);
            startActivity(health);
        });

        btnAppBarAchievement.setOnClickListener(v -> {
            Intent achievement = new Intent(HomeActivity.this,AchievementActivity.class);
            startActivity(achievement);

        });
    }
}