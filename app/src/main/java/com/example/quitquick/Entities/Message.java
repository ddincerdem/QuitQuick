package com.example.quitquick.Entities;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "COMMUNITY")
public class Message {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    int MessageID;

    @NonNull
    @ColumnInfo(name = "SenderID")
    public int SenderId;

    @ColumnInfo(name = "Message")
    LiveData<String> Message;

    @NonNull
    @ColumnInfo(name = "SendDate")
    String SendDate;

    public Message(int senderId, LiveData<String> message, @NonNull String sendDate) {
        SenderId = senderId;
        Message = message;
        SendDate = sendDate;
    }

    public int getMessageID() {
        return MessageID;
    }

    public void setMessageID(int messageID) {
        MessageID = messageID;
    }

    public int getSenderId() {
        return SenderId;
    }

    public void setSenderId(int senderId) {
        SenderId = senderId;
    }

    public LiveData<String> getMessage() {
        return Message;
    }

    public void setMessage(LiveData<String> message) {
        Message = message;
    }

    @NonNull
    public String getSendDate() {
        return SendDate;
    }

    public void setSendDate(@NonNull String sendDate) {
        SendDate = sendDate;
    }
}
