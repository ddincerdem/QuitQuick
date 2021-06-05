package com.example.quitquick.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.quitquick.Entities.UserAchievementCR;
import com.example.quitquick.Entities.UserUnvanCR;
import com.example.quitquick.Repository.UserAchievementCRREP;
import com.example.quitquick.Repository.UserUnvanCRREP;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserUnvanCRVM extends AndroidViewModel {

    private UserUnvanCRREP userUnvanCRREP;


    public UserUnvanCRVM(@NonNull @NotNull Application application) {
        super(application);
        userUnvanCRREP = new UserUnvanCRREP(application);
    }

    public List<Integer> getUserUnvansLast(int id){return userUnvanCRREP.getUsersUnvansLast(id);};

    public void insertUserUnvanCR(UserUnvanCR userUnvanCR){userUnvanCRREP.insertUserUnvan(userUnvanCR);}
    public UserUnvanCR checkIfUserHasUnvan(int userid,int unvanid){return userUnvanCRREP.checkIfUserHasUnvan(userid,unvanid);};

}
