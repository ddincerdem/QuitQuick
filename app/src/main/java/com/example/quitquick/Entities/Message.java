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
    public int MessageID;

    @NonNull
    @ColumnInfo(name = "SenderID")
    public int SenderId;

    @ColumnInfo(name = "Message")
    public String Message;

    @NonNull
    @ColumnInfo(name = "SendDate")
    public String SendDate;

    public Message(int SenderId, String Message, @NonNull String SendDate) {
        this.SenderId = SenderId;
        this.Message = Message;
        this.SendDate = SendDate;
    }

    public Message() {

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

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
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
