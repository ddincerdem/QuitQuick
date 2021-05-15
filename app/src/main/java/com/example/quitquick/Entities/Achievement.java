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
    String AchName;

    @NonNull
    @ColumnInfo(name = "AchDesc")
    String AchDesc;

    @NonNull
    @ColumnInfo(name = "AchUnvanId")
    int AchUnvanId;

    public Achievement(int achId, @NonNull String achName, @NonNull String achDesc, int achUnvanId) {
        AchId = achId;
        AchName = achName;
        AchDesc = achDesc;
        AchUnvanId = achUnvanId;
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
