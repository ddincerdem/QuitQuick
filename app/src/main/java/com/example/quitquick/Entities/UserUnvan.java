package com.example.quitquick.Entities;

import androidx.room.Entity;

@Entity(primaryKeys = {"UnvanID","UserID"})
public class UserUnvan {
    public int UserID;
    public int UnvanID;

    public UserUnvan(int userID, int unvanID) {
        UserID = userID;
        UnvanID = unvanID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getUnvanID() {
        return UnvanID;
    }

    public void setUnvanID(int unvanID) {
        UnvanID = unvanID;
    }
}
