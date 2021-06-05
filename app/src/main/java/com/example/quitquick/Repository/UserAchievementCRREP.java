package com.example.quitquick.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.Entities.User;
import com.example.quitquick.Entities.UserAchievementCR;
import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class UserAchievementCRREP {
    private qqDAO dao;

    public UserAchievementCRREP(Application application){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();
    }

    public void insertUserAch(UserAchievementCR userAchievementCR){dao.insertUserAch(userAchievementCR);};
}
