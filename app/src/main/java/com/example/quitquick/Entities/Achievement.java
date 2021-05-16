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

    public Achievement(int AchId, @NonNull String AchName, @NonNull String AchDesc, int AchUnvanId) {
        this.AchId = AchId;
        this.AchName = AchName;
        this.AchDesc = AchDesc;
        this.AchUnvanId = AchUnvanId;
    }

}
