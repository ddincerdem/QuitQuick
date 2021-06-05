package com.example.quitquick.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserUnvanCR")
public class UserUnvanCR {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int ID;

    @NonNull
    @ColumnInfo(name = "UserID")
    public int UserID;

    @NonNull
    @ColumnInfo(name = "UnvanID")
    public int UnvanID;

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
