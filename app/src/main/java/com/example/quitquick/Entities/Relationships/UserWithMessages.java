package com.example.quitquick.Entities.Relationships;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.quitquick.Entities.Message;
import com.example.quitquick.Entities.User;

import java.util.List;

public class UserWithMessages {
    @Embedded
    public User user;
    @Relation(
            parentColumn = "UserID",
            entityColumn = "SenderID"
    )
    public List<Message> messages;

    public UserWithMessages(User user, List<Message> messages) {
        this.user = user;
        this.messages = messages;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
