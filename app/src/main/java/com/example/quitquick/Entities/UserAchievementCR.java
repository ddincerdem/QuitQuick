package com.example.quitquick.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserAchievementCR")
public class UserAchievementCR {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int ID;

    @NonNull
    @ColumnInfo(name = "UserID")
    public int UserID;

    @NonNull
    @ColumnInfo(name = "AchievementID")
    public int AchievementID;

}
