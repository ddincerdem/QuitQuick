package com.example.quitquick;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quitquick.Entities.User;
import com.example.quitquick.ViewModels.UserVM;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton btnAppBarAchievement,btnAppBarHealth;
    android.view.View ProfilLayout;
    android.view.View CommunityLayout;
    TextView txtcig;
    TextView txtmon;
    TextView txttime;
    public User user;
    int UserID;
    UserVM userVM;
    SessionManagament sessionManagament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar=findViewById(R.id.customActionBar);
        setSupportActionBar(toolbar);

        sessionManagament = new SessionManagament(this);
        btnAppBarAchievement=findViewById(R.id.btnappBarAchievement);
        btnAppBarHealth=findViewById(R.id.btnAppBarHealth);
        txtcig = findViewById(R.id.txtCig);
        txtmon = findViewById(R.id.txtMoney);
        txttime = findViewById(R.id.txtTime);
        ProfilLayout = (android.view.View)findViewById(R.id.lytProfile);
        CommunityLayout = (android.view.View)findViewById(R.id.lytCommunity);
        UserID = sessionManagament.getSession();
        userVM = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.UserVM.class);
        user = userVM.findUserById(UserID);

        ProfilLayout.setOnClickListener(v -> {
            Intent Profile = new Intent(this,ProfileActivity.class);
            startActivity(Profile);
        });

        CommunityLayout.setOnClickListener(v -> {
            Intent Community = new Intent(this,CommunityActivity.class);
            startActivity(Community);
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onStart() {
        super.onStart();

        try {
            setAllVariables();
        } catch (ParseException e) {


        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setAllVariables() throws ParseException {
        txttime.setText(NotSmokedTime()+" Gun");
        txtcig.setText(CigNotSmoked());
        txtmon.setText(EarnedMoney()+" TL");

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String NotSmokedTime() throws ParseException {
        String DateStart = user.getStartDate();
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = formatter1.parse(DateStart);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        String nowDate = dtf.format(localDate);
        Date nowwDate = formatter1.parse(nowDate);

        long differenceInTime = nowwDate.getTime() - startDate.getTime();
        long differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;

        String a =String.valueOf(differenceInDays);
        return a;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String EarnedMoney() throws ParseException {

        int pakettekiSigara = user.getHowManyCigInPack();
        double paketFiyati = user.getPricePerPack();
        int gunlukIcilenSigara = user.getCigPerDay();
        double taneFiyati = paketFiyati / pakettekiSigara;
        double kazanilanPara;

        String DateStart = user.getStartDate();
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = formatter1.parse(DateStart);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        String nowDate = dtf.format(localDate);
        Date nowwDate = formatter1.parse(nowDate);

        long differenceInTime = nowwDate.getTime() - startDate.getTime();
        long differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;

        kazanilanPara = taneFiyati *differenceInDays* gunlukIcilenSigara;
        String Para = String.valueOf(kazanilanPara);

        return Para;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String CigNotSmoked() throws ParseException {


        int gunlukIcilenSigara = user.getCigPerDay();
        long sigaraAdet;

        String DateStart = user.getStartDate();
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = formatter1.parse(DateStart);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        String nowDate = dtf.format(localDate);
        Date nowwDate = formatter1.parse(nowDate);

        long differenceInTime = nowwDate.getTime() - startDate.getTime();
        long differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;

        sigaraAdet = differenceInDays * gunlukIcilenSigara;
        String adet = String.valueOf(sigaraAdet);

        return adet;
    }
}