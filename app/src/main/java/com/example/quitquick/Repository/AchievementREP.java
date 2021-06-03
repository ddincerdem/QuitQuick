package com.example.quitquick.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class AchievementREP {
    private qqDAO dao;
    private List<Achievement> liveDataAchievements;

    public AchievementREP(Application application){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();

    }

    @Query("Select * from ACHIEVEMENT")
    public List<Achievement>getAllAchievements(){return dao.getAllAchievements();}

    @Insert
    public void insertAchievement(Achievement achievement) {
        dao.insertAchievement(achievement);
    }

}
