package com.example.quitquick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.AndroidViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton btnAppBarAchievement,btnAppBarHealth;
    android.view.View ProfilLayout;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar=findViewById(R.id.customActionBar);
        setSupportActionBar(toolbar);

        btnAppBarAchievement=findViewById(R.id.btnappBarAchievement);
        btnAppBarHealth=findViewById(R.id.btnAppBarHealth);

        ProfilLayout = (android.view.View)findViewById(R.id.lytProfile);

        ProfilLayout.setOnClickListener(v -> {
            Intent Profile = new Intent(this,ProfileActivity.class);
            startActivity(Profile);
        });

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