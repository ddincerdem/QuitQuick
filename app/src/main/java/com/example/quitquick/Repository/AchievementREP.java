package com.example.quitquick.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.DAO.DAO;
import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class AchievementREP {
    private DAO dao;
    private LiveData<List<Achievement>> liveDataAchievements;

    public AchievementREP(Application application){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();
        liveDataAchievements =dao.getAllAchievements();
    }

    @Query("Select * from ACHIEVEMENT")
    public LiveData<List<Achievement>>getAllAchievements(){return liveDataAchievements;}


}
