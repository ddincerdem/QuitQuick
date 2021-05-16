package com.example.quitquick.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.DAO.DAO;
import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Entities.Message;
import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class MessageREP {
    private DAO dao;
    private LiveData<List<Message>> liveDataMessages;

    public MessageREP(Application application){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();
        liveDataMessages =dao.getAllMessages();
    }

    @Query("Select * from COMMUNITY")
    public LiveData<List<Message>>getAllMessages(){return liveDataMessages;}

    public void insertMessage(Message msg){
    QuitQuickDB.dbWriteExecutor.execute(()->{
        dao.insertMessage(msg);

    });

    }

    public void deleteMessage(int messageId){
        QuitQuickDB.dbWriteExecutor.execute(()->{
            dao.deleteMessage(messageId);

        });

    }

}
