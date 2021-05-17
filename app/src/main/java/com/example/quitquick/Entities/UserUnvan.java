package com.example.quitquick.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"UnvanID","UserID"})
public class UserUnvan {
    @ColumnInfo(name = "UserID",index = true)
    public int UserID;
    public int UnvanID;

    public UserUnvan(int UserID, int UnvanID) {
        this.UserID = UserID;
        this.UnvanID = UnvanID;
    }


}
