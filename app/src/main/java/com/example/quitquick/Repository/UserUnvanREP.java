package com.example.quitquick.Repository;

import android.app.Application;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.Relationships.UserWithUnvans;
import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class UserUnvanREP {
    private qqDAO qqDao;
    private List<UserWithUnvans> liveDataUserUnvans;


    public UserUnvanREP(Application application)
    {
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        qqDao = db.getDao();
    }

    public List<UserWithUnvans> getUserWithUnvans(int id){
        liveDataUserUnvans = qqDao.getUserWithUnvans(id);
        return liveDataUserUnvans;
    }

    public  void insertUserAnotherUnvan(Unvan unvan){
        qqDao.insertUserAnotherUnvan(unvan);
    }


 }
