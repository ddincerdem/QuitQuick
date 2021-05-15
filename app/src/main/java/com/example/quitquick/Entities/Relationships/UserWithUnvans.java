package com.example.quitquick.Entities.Relationships;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.quitquick.Entities.Unvan;
import com.example.quitquick.Entities.User;
import com.example.quitquick.Entities.UserUnvan;

import java.util.List;

public class UserWithUnvans {
 @Embedded public User user;
 @Relation(
         parentColumn = "UserID",
         entityColumn = "UnvanID",
         associateBy = @Junction(UserUnvan.class)
 )
    public List<Unvan> unvans;

    public UserWithUnvans(User user, List<Unvan> unvans) {
        this.user = user;
        this.unvans = unvans;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Unvan> getUnvans() {
        return unvans;
    }

    public void setUnvans(List<Unvan> unvans) {
        this.unvans = unvans;
    }
}
