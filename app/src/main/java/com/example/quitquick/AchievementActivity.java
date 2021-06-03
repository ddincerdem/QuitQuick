package com.example.quitquick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.ViewModels.AchievementVM;

import java.util.List;

public class AchievementActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton btnReturnHome;
    List<Achievement> achievementList;
    ListView achievements;
    private AchievementVM achievementVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        toolbar = findViewById(R.id.actionBarReturnHome);
        btnReturnHome=findViewById(R.id.btnAppBarReturnHome);
        setSupportActionBar(toolbar);
        achievementVM = new ViewModelProvider(this).get(com.example.quitquick.ViewModels.AchievementVM.class);


          btnReturnHome.setOnClickListener(v -> {
                this.finish();

           });

        achievementList=achievementVM.getAllAchievements();
        AchievementAdapter adapter = new AchievementAdapter(AchievementActivity.this,R.layout.achievement_template,achievementList);
        achievements = findViewById(R.id.lvAchievements);
        achievements.setAdapter(adapter);

    }
}