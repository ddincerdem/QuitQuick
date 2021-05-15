package com.example.quitquick.Entities;

import androidx.room.Entity;

@Entity(primaryKeys = {"UserID","AchId"})
public class UserAch {

    public int UserID;
    public int AchId;

    public UserAch(int userID, int achID) {
        UserID = userID;
        AchId = achID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getAchID() {
        return AchId;
    }

    public void setAchID(int achID) {
        AchId = achID;
    }
}
