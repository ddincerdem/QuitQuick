package com.example.quitquick.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ACHIEVEMENT")
public class Achievement {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int AchId;

    @NonNull
    @ColumnInfo(name = "AchName")
    public String AchName;

    @NonNull
    @ColumnInfo(name = "AchDesc")
    public String AchDesc;

    @NonNull
    @ColumnInfo(name = "AchUnvanId")
    public int AchUnvanId;

    @NonNull
    @ColumnInfo(name = "AchievementObjective")
    public int AchievementObjective;

    public int getAchievementObjective() {
        return AchievementObjective;
    }

    public void setAchievementObjective(int achievementObjective) {
        AchievementObjective = achievementObjective;
    }

    public int getAchId() {
        return AchId;
    }

    public void setAchId(int achId) {
        AchId = achId;
    }

    @NonNull
    public String getAchName() {
        return AchName;
    }

    public void setAchName(@NonNull String achName) {
        AchName = achName;
    }

    @NonNull
    public String getAchDesc() {
        return AchDesc;
    }

    public void setAchDesc(@NonNull String achDesc) {
        AchDesc = achDesc;
    }

    public int getAchUnvanId() {
        return AchUnvanId;
    }

    public void setAchUnvanId(int achUnvanId) {
        AchUnvanId = achUnvanId;
    }
}
