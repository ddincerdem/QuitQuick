package com.example.quitquick.Entities.Relationships;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.quitquick.Entities.Achievement;
import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.Entities.User;
import com.example.quitquick.Entities.UserAch;

import java.util.List;

public class UserWithAchivements {
    @Embedded public User user;
    @Relation(
            parentColumn = "UserID",
            entityColumn = "AchId",
            associateBy = @Junction(UserAch.class)
    )
    public List<Achievement>achievement;



}
