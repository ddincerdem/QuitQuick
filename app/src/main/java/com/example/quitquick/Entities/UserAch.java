package com.example.quitquick.Entities;

import androidx.room.Entity;

@Entity(primaryKeys = {"UserID","AchId"})
public class UserAch {

    public int UserID;
    public int AchId;

    public UserAch(int UserID, int AchId) {
        this.UserID = UserID;
        this.AchId = AchId;
    }


}
