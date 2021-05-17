package com.example.quitquick.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class UserAchREP {
    private qqDAO dao;
    private LiveData<List<Achievement>> liveDataUsersAchievements;

    public UserAchREP(Application application,int userID){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();
        liveDataUsersAchievements =dao.getUserAchievements(userID);
    }

    @Query("Select AchId,AchDesc,AchName,AchUnvanId from ACHIEVEMENT where AchId=(Select AchId from UserAch where UserID=:uid)")
    public LiveData<List<Achievement>> getUsersAchievements(){return liveDataUsersAchievements;}

}
