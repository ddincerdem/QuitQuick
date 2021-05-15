package com.example.quitquick.Entities.Relationships;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Entities.Unvan;

//Achievement ve Unvan arasinda 1-1 iliski
public class AchivementWithUnvan {
    @Embedded public Unvan unvan;
    @Relation(
            parentColumn = "UnvanID",
            entityColumn = "achUnvanId"
    )
    public Achievement achievement;

    public AchivementWithUnvan(Unvan unvan, Achievement achievement) {
        this.unvan = unvan;
        this.achievement = achievement;
    }

    public Unvan getUnvan() {
        return unvan;
    }

    public void setUnvan(Unvan unvan) {
        this.unvan = unvan;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }
}
