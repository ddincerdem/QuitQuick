package com.example.quitquick.Entities;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "HEALTH" )
public class Health {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int HealthDataID;

    @NonNull
    @ColumnInfo(name = "Duration")
    public int duration;

    @ColumnInfo(name = "Description")
    public String description;

    public int getHealthDataID() {
        return HealthDataID;
    }

    public void setHealthDataID(int healthDataID) {
        HealthDataID = healthDataID;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
