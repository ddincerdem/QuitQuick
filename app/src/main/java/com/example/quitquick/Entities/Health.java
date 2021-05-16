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
    int HealthDataID;

    @NonNull
    @ColumnInfo(name = "Duration")
    int duration;

    @ColumnInfo(name = "Description")
    String description;

}
