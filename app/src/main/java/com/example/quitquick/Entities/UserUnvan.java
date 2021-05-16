package com.example.quitquick.Entities;

import androidx.room.Entity;

@Entity(primaryKeys = {"UnvanID","UserID"})
public class UserUnvan {
    public int UserID;
    public int UnvanID;

    public UserUnvan(int UserID, int UnvanID) {
        this.UserID = UserID;
        this.UnvanID = UnvanID;
    }


}
