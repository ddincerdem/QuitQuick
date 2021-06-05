package com.example.quitquick.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.Message;

import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class MessageREP {
    private qqDAO dao;
    private List<Message> liveDataMessages;


    public MessageREP(Application application){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();
        liveDataMessages =dao.getAllMessages();
    }

    public List<Message> getAllMessages(){return liveDataMessages;}

    public void insertMessage(Message msg){
    QuitQuickDB.dbWriteExecutor.execute(()->{
        dao.insertMessage(msg);

    });

    }

    public void deleteMessage(Message Message){
        QuitQuickDB.dbWriteExecutor.execute(()->{
            dao.deleteMessage(Message);

        });

    }
    public List<Message> getUsersMessagesById(int id){ return dao.getUsersMessagesById(id);}




}
