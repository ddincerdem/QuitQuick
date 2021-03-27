package com.example.quitquick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HealthActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton btnReturnHome;

    long daysQuit;
    Button btngun;
    TextView tvGun;

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



        btngun=findViewById(R.id.btnCalculeteGun);  //aşağısı komple deneme
        tvGun=findViewById(R.id.tvDeneme);
        btngun.setOnClickListener(v -> {



//            daysQuit = cl.calculateDays("07-03-1999","29-05-1999");
//            String newText = Long.toString(cl.calculateDays("29-03-1999","01-04-1999"));
//            long money = Calculations.moneySaved(3,20,17,20);
//            tvGun.setText(Long.toString(money));



        });

    }
}