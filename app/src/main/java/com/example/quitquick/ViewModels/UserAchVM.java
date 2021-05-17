package com.example.quitquick.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Repository.UserAchREP;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserAchVM extends AndroidViewModel {
    private UserAchREP userAchRep;
    private LiveData<List<Achievement>> liveDataUsersAchievements;
    public UserAchVM(@NonNull @NotNull Application application,int uid) {
        super(application);
        userAchRep = new UserAchREP(application,uid);
        liveDataUsersAchievements = userAchRep.getUsersAchievements();
    }
    
}
