package com.example.quitquick.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.quitquick.Entities.Message;
import com.example.quitquick.Repository.MessageREP;
import com.example.quitquick.RoomDB.QuitQuickDB;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MessageVM extends AndroidViewModel {
    private MessageREP messageRep ;
    private LiveData<List<Message>> liveDataMessage;
    public MessageVM(@NonNull @NotNull Application application) {
        super(application);
        messageRep = new MessageREP(application);
        liveDataMessage = messageRep.getAllMessages();
    }

    @Query("Select * from COMMUNITY")
    public LiveData<List<Message>>getAllMessages(){return liveDataMessage;}

    public void insertMessage(Message msg){
        messageRep.insertMessage(msg);
        }
        public void deleteMessage(Message msg){
        messageRep.deleteMessage(msg);
        }
}
