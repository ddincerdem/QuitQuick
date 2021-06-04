package com.example.quitquick;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;
import android.se.omapi.Session;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Models.User;
import com.example.quitquick.ViewModels.AchievementVM;
import com.example.quitquick.ViewModels.UnvanVM;
import com.example.quitquick.ViewModels.UserVM;

import java.text.ParseException;
import java.util.List;

public class AchievementActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton btnReturnHome;
    Button btnUnlock;
    List<Achievement> achievementList;
    ListView achievements;
    int userID;
    private SessionManagament sessionManagament;
    private AchievementVM achievementVM;
    private UserVM userVM;
    public UnvanVM unvanVM;
    public com.example.quitquick.Entities.User user;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        toolbar = findViewById(R.id.actionBarReturnHome);
        btnReturnHome=findViewById(R.id.btnAppBarReturnHome);
        btnUnlock = findViewById(R.id.btnUnlockTitle);
        setSupportActionBar(toolbar);

        achievementVM = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.AchievementVM.class);
        userVM = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.UserVM.class);
        unvanVM = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.UnvanVM.class);
        sessionManagament = new SessionManagament(this);
        userID = sessionManagament.getSession();
        user = userVM.findUserById(userID);



          btnReturnHome.setOnClickListener(v -> {
                this.finish();

           });

        achievementList=achievementVM.getAllAchievements();
        AchievementAdapter adapter = new AchievementAdapter(AchievementActivity.this,R.layout.achievement_template,achievementList);
        achievements = findViewById(R.id.lvAchievements);
        achievements.setAdapter(adapter);

        try {
            checkForAchievements();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void checkForAchievements() throws ParseException {

        long cigsNotSmoked = Long.parseLong(Calculations.cigsNotSmoked(user.getCigPerDay(),user.getStartDate()));
        double moneyEarned = Double.parseDouble(Calculations.EarnedMoney(user.getHowManyCigInPack(),user.getPricePerPack(),user.getCigPerDay(),user.getStartDate()));
        long daysNotSmoked = Calculations.daysNotSmoked(user.getStartDate());
        int messagesSent;

        if (cigsNotSmoked>1){}
        if (cigsNotSmoked>100){}
        if (cigsNotSmoked>1000){}

        if (moneyEarned>10){}
        if (moneyEarned>100){}
        if (moneyEarned>1000){}

        if (daysNotSmoked>1){}
        if (daysNotSmoked>10){}
        if (daysNotSmoked>100){}
        if (daysNotSmoked>1000){}









    }
}