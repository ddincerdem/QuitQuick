package com.example.quitquick.Entities.Relationships;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.Entities.User;

import java.util.List;

public class UserWithUnvans {
 @Embedded public User user;
 @Relation(
         parentColumn = "UserID",
         entityColumn = "UnvanID",
         associateBy = @Junction(UserUnvan.class)
 )
    public List<Unvan> unvans;
}
