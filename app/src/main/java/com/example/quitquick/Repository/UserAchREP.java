package com.example.quitquick.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Entities.Relationships.UserWithAchivements;
import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class UserAchREP {
    private qqDAO dao;
    private LiveData<List<UserWithAchivements>> liveDataUsersAchievements;

    public UserAchREP(Application application,int userID){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();
        liveDataUsersAchievements =dao.getUserAchievements(userID);
    }

    @Query("Select * FROM USER WHERE UserID=:uid")
    public LiveData<List<UserWithAchivements>> getUsersAchievements(int uid){return liveDataUsersAchievements;}

}
