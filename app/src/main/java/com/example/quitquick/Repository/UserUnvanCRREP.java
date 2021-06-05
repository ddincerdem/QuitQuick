package com.example.quitquick.Repository;

import android.app.Application;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.UserAchievementCR;
import com.example.quitquick.Entities.UserUnvanCR;
import com.example.quitquick.RoomDB.QuitQuickDB;

public class UserUnvanCRREP {

    private qqDAO dao;

    public UserUnvanCRREP(Application application){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();
    }

    public void insertUserUnvan(UserUnvanCR userUnvanCR){dao.insertUserUnvan(userUnvanCR);};


}
