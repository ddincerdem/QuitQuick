package com.example.quitquick.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class UnvanREP {
    private qqDAO dao;
    private List<Unvan> liveDataUnvan;

    public UnvanREP(Application application){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();
        liveDataUnvan =dao.getAllUnvan();
    }

    public List<Unvan> getAllUnvan(){return dao.getAllUnvan();}
    public void insertUnvan(Unvan unvan){dao.insertUnvan(unvan);};

}
