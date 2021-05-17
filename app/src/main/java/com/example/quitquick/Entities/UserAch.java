package com.example.quitquick.Entities;

import androidx.room.Entity;

@Entity(primaryKeys = {"UserID","AchId"})
public class UserAch {

    public int UserID;
    public int AchId;


}
