package com.example.quitquick.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.Health;
import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class HealthREP {

    private qqDAO dao;
    private LiveData<List<Health>> liveDataHealth;

    public HealthREP(Application application){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();
        liveDataHealth =dao.getAllHealth();
    }

    @Query("Select * from HEALTH")
    public LiveData<List<Health>>getAllHealth(){return liveDataHealth;}
}
