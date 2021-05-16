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


}
