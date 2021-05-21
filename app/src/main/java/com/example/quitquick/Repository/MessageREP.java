package com.example.quitquick.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.DAO.qqDAO;
import com.example.quitquick.Entities.Message;
import com.example.quitquick.Entities.Relationships.UserWithMessages;
import com.example.quitquick.RoomDB.QuitQuickDB;

import java.util.List;

public class MessageREP {
    private qqDAO dao;
    private LiveData<List<Message>> liveDataMessages;
    private LiveData<UserWithMessages> messageSender;

    public MessageREP(Application application){
        QuitQuickDB db = QuitQuickDB.getDB(application.getApplicationContext());
        dao = db.getDao();
        liveDataMessages =dao.getAllMessages();
    }

    public LiveData<List<Message>> getAllMessages(){return liveDataMessages;}

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

    public LiveData<UserWithMessages> GetMessageSender(int ID){
        QuitQuickDB.dbWriteExecutor.execute(()->{
            messageSender=dao.getMessageWithSender(ID);
        });
        return messageSender;
    }

}
