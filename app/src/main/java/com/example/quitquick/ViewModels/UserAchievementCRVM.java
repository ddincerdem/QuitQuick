package com.example.quitquick.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.room.Query;

import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.Entities.UserAchievementCR;
import com.example.quitquick.Repository.UnvanREP;
import com.example.quitquick.Repository.UserAchievementCRREP;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserAchievementCRVM extends AndroidViewModel {
    private UserAchievementCRREP userAchievementCRREP;


    public UserAchievementCRVM(@NonNull @NotNull Application application) {
        super(application);
        userAchievementCRREP = new UserAchievementCRREP(application);
    }


    public void insertUserAchievementCR(UserAchievementCR userAchievementCR){userAchievementCRREP.insertUserAch(userAchievementCR);}

}
