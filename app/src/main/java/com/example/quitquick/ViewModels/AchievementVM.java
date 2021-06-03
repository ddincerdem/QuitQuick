package com.example.quitquick.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Repository.AchievementREP;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AchievementVM extends AndroidViewModel {

    private AchievementREP achievementRep;
    private List<Achievement> liveAchievements;
    public AchievementVM(@NonNull @NotNull Application application) {
        super(application);
        achievementRep = new AchievementREP(application);
    }

    @Query("Select * from ACHIEVEMENT")
    public List<Achievement>getAllAchievements(){return achievementRep.getAllAchievements();}
    void insertAchievement(Achievement achievement){
        achievementRep.insertAchievement(achievement);
    }

}
