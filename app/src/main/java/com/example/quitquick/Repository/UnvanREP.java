package com.example.quitquick.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.DAO.DAO;
import com.example.quitquick.Entities.Health;
import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class UnvanREP {
    private DAO dao;
    private LiveData<List<Unvan>> liveDataUnvan;

    public UnvanREP(Application application){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();
        liveDataUnvan =dao.getAllUnvan();
    }

    @Query("Select * from UNVAN")
    public LiveData<List<Unvan>> getAllUnvan(){return liveDataUnvan;}


}
