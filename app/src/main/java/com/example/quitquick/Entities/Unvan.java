package com.example.quitquick.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UNVAN")
public class Unvan {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int UnvanID;

    @NonNull
    @ColumnInfo(name = "UnvanName")
    String UnvanName;

    public Unvan(int unvanID, @NonNull String unvanName) {
        UnvanID = unvanID;
        UnvanName = unvanName;
    }

    public int getUnvanID() {
        return UnvanID;
    }

    public void setUnvanID(int unvanID) {
        UnvanID = unvanID;
    }

    @NonNull
    public String getUnvanName() {
        return UnvanName;
    }

    public void setUnvanName(@NonNull String unvanName) {
        UnvanName = unvanName;
    }
}
